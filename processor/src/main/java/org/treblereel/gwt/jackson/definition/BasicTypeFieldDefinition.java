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
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import org.treblereel.gwt.jackson.api.annotation.XmlUnwrappedCollection;
import org.treblereel.gwt.jackson.context.GenerationContext;

/** @author Dmitrii Tikhomirov Created by treblereel 4/1/20 */
public class BasicTypeFieldDefinition extends FieldDefinition {

  protected BasicTypeFieldDefinition(TypeMirror property, GenerationContext context) {
    super(property, context);
  }

  @Override
  public Expression getFieldDeserializer(PropertyDefinition field, CompilationUnit cu) {
    MethodCallExpr method =
        new MethodCallExpr(
            new NameExpr(context.getTypeRegistry().getDeserializer(bean).toString()),
            "getInstance");
    if (getBean().getKind().equals(TypeKind.ARRAY)) {
      if (field.getProperty() != null
          && field.getProperty().getAnnotation(XmlUnwrappedCollection.class) != null) {
        method = new MethodCallExpr(method, "setUnWrapCollections");
      }
    }
    return method;
  }

  @Override
  public Expression getFieldSerializer(PropertyDefinition field, CompilationUnit cu) {
    MethodCallExpr method =
        new MethodCallExpr(
            new NameExpr(
                context
                    .getTypeRegistry()
                    .getSerializer(context.getProcessingEnv().getTypeUtils().erasure(getBean()))
                    .toString()),
            "getInstance");
    if (getBean().getKind().equals(TypeKind.ARRAY)) {
      method.addArgument(new StringLiteralExpr(field.getPropertyName()));
      if (field.getProperty() != null
          && field.getProperty().getAnnotation(XmlUnwrappedCollection.class) != null) {
        method = new MethodCallExpr(method, "setUnWrapCollections");
      }
    }
    return method;
  }

  @Override
  public String toString() {
    return "BasicTypeFieldDefinition{" + "bean=" + bean + '}';
  }
}
