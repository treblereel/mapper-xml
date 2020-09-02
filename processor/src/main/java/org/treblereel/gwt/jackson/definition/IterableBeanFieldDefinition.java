/*
 * Copyright © 2020 Treblereel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.treblereel.gwt.jackson.definition;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.google.auto.common.MoreTypes;
import java.util.Map;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.xml.bind.annotation.XmlElementRefs;
import org.treblereel.gwt.jackson.api.Inheritance;
import org.treblereel.gwt.jackson.api.annotation.XmlUnwrappedCollection;
import org.treblereel.gwt.jackson.api.utils.Pair;
import org.treblereel.gwt.jackson.context.GenerationContext;

/** @author Dmitrii Tikhomirov Created by treblereel 4/1/20 */
public class IterableBeanFieldDefinition extends FieldDefinition {

  protected IterableBeanFieldDefinition(TypeMirror property, GenerationContext context) {
    super(property, context);
  }

  @Override
  public Expression getFieldDeserializer(PropertyDefinition field, CompilationUnit cu) {
    TypeElement serializer =
        context
            .getTypeRegistry()
            .getDeserializer(context.getProcessingEnv().getTypeUtils().erasure(bean));

    cu.addImport(serializer.getQualifiedName().toString());

    MethodCallExpr method =
        new MethodCallExpr(new NameExpr(serializer.getSimpleName().toString()), "newInstance");

    Pair<Class, Map<String, TypeMirror>> maybePolymorphicType = maybePolymorphicType(field, bean);
    String inheritance =
        maybePolymorphicType.key.equals(XmlElementRefs.class)
            ? "Inheritance.TAG"
            : "Inheritance.XSI";
    TypeMirror type = MoreTypes.asDeclared(bean).getTypeArguments().get(0);

    if (!maybePolymorphicType.value.isEmpty()) {
      cu.addImport(Inheritance.class);
      method.addArgument(
          generateXMLDeserializerFactory(field, type, type.toString(), cu, maybePolymorphicType));
      method = new MethodCallExpr(method, "setInheritanceType").addArgument(inheritance);
    } else {
      method.addArgument(generateXMLDeserializerFactory(field, type, type.toString(), cu));
    }
    if (field.getProperty().getAnnotation(XmlUnwrappedCollection.class) != null) {
      return new MethodCallExpr(method, "setUnWrapCollections");
    }
    return method;
  }

  @Override
  public Expression getFieldSerializer(PropertyDefinition field, CompilationUnit cu) {
    TypeElement serializer =
        context
            .getTypeRegistry()
            .getSerializer(context.getProcessingEnv().getTypeUtils().erasure(getBean()));

    MethodCallExpr method =
        new MethodCallExpr(new NameExpr(serializer.getQualifiedName().toString()), "newInstance");
    for (TypeMirror param : MoreTypes.asDeclared(getBean()).getTypeArguments()) {
      method.addArgument(generateXMLSerializerFactory(field, param, "?", cu));
    }
    method.addArgument(new StringLiteralExpr(field.getPropertyName()));
    if (field.getProperty().getAnnotation(XmlUnwrappedCollection.class) != null) {
      return new MethodCallExpr(method, "setUnWrapCollections");
    }
    return method;
  }

  @Override
  public String toString() {
    return "IterableBeanFieldDefinition{" + "bean=" + bean + '}';
  }
}
