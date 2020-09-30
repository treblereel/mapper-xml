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

import com.google.auto.common.MoreTypes;
import java.util.HashMap;
import java.util.Map;
import javax.lang.model.element.ElementKind;
import javax.lang.model.type.TypeMirror;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.context.GenerationContext;

/** @author Dmitrii Tikhomirov Created by treblereel 4/1/20 */
public class FieldDefinitionFactory {

  private final GenerationContext context;
  private final TypeUtils typeUtils;
  private final Map<TypeMirror, FieldDefinition> holder = new HashMap<>();

  FieldDefinitionFactory(GenerationContext context) {
    this.context = context;
    this.typeUtils = context.getTypeUtils();
  }

  FieldDefinition getFieldDefinition(PropertyDefinition propertyDefinition) {
    if (propertyDefinition.getProperty().getAnnotation(XmlJavaTypeAdapter.class) != null) {
      return new XmlJavaTypeAdapterFieldDefinition(propertyDefinition, context);
    }
    return getFieldDefinition(propertyDefinition.getBean());
  }

  FieldDefinition getFieldDefinition(TypeMirror type) {
    TypeMirror property = context.getTypeUtils().removeOuterWildCards(type);
    FieldDefinition result;
    if (holder.containsKey(property)) {
      result = holder.get(property);
    } else if (typeUtils.isSimpleType(property)) {
      result = new BasicTypeFieldDefinition(property, context);
    } else if (context.getTypeUtils().isIterable(property)) {
      return new IterableBeanFieldDefinition(type, context);
    } else if (context.getTypeUtils().isMap(property)) {
      return new MapBeanFieldDefinition(type, context);
    } else if (TypeUtils.isArray(property)) {
      return new ArrayBeanFieldDefinition(type, context);
    } else if (MoreTypes.asElement(property).getKind().equals(ElementKind.ENUM)) {
      result = new EnumBeanFieldDefinition(property, context);
    } else {
      result = new DefaultBeanFieldDefinition(property, context);
    }
    holder.put(property, result);
    return result;
  }
}
