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

package org.treblereel.gwt.jackson.context;

import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/** @author Dmitrii Tikhomirov Created by treblereel 9/29/20 */
public class XmlJavaTypeAdapterProcessor {

  private GenerationContext context;

  XmlJavaTypeAdapterProcessor(GenerationContext context) {
    this.context = context;
  }

  void process(Set<? extends Element> elements) {
    elements.stream()
        .filter(elm -> elm.getKind().equals(ElementKind.FIELD))
        .map(MoreElements::asVariable)
        .forEach(this::process);
  }

  private void process(VariableElement typeElement) {
    ExecutableElement decl = getUnmarshal(typeElement.getAnnotation(XmlJavaTypeAdapter.class));
    VariableElement parameterElement = decl.getParameters().get(0);
    context.addBeanDefinition(MoreTypes.asTypeElement(parameterElement.asType()));
  }

  private ExecutableElement getUnmarshal(XmlJavaTypeAdapter typeAdapter) {
    return ElementFilter.methodsIn(
            MoreTypes.asTypeElement(getAnnotation(typeAdapter)).getEnclosedElements())
        .stream()
        .filter(field -> field.getSimpleName().toString().equals("unmarshal"))
        .findFirst()
        .get();
  }

  private TypeMirror getAnnotation(XmlJavaTypeAdapter typeAdapter) {
    try {
      typeAdapter.value();
    } catch (MirroredTypeException e) {
      return e.getTypeMirror();
    }
    return null;
  }
}
