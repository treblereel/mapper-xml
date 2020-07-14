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
package org.treblereel.gwt.jackson;

import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import com.google.auto.service.AutoService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.MirroredTypesException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.exception.GenerationException;
import org.treblereel.gwt.jackson.logger.PrintWriterTreeLogger;
import org.treblereel.gwt.jackson.logger.TreeLogger;
import org.treblereel.gwt.jackson.processor.BeanProcessor;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ApplicationProcessor extends AbstractProcessor {

  private final TreeLogger logger = new PrintWriterTreeLogger();
  private final Set<TypeElement> beans = new HashSet<>();

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    return supportedAnnotations().stream().map(Class::getCanonicalName).collect(Collectors.toSet());
  }

  @Override
  public boolean process(
      Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
    if (!annotations.isEmpty()) {
      GenerationContext context = new GenerationContext(roundEnvironment, processingEnv);
      processXMLMapper(roundEnvironment.getElementsAnnotatedWith(XMLMapper.class).stream());

      processXmlSeeAlso(roundEnvironment.getElementsAnnotatedWith(XmlSeeAlso.class).stream());
      processXmlElements(roundEnvironment);
      new BeanProcessor(context, logger, beans).process();
    }
    return false;
  }

  private void processXMLMapper(Stream<? extends Element> stream) {
    stream.map(MoreElements::asType).map(this::asTypeElement).forEach(beans::add);
  }

  private void processXmlSeeAlso(Stream<? extends Element> stream) {
    stream.forEach(elm -> processXmlSeeAlso(elm));
  }

  private void processXmlElements(RoundEnvironment roundEnvironment) {
    Set<Element> elms = (Set<Element>) roundEnvironment.getElementsAnnotatedWith(XmlElements.class);
    for (Element elm : elms) {
      XmlElement[] elements = elm.getAnnotation(XmlElements.class).value();

      for (XmlElement element : elements) {
        try {
          elm.getAnnotation(XmlElements.class).value();
        } catch (MirroredTypeException e) {
          beans.add(MoreTypes.asTypeElement(e.getTypeMirror()));
        }
      }

      /*            try {
          elm.getAnnotation(XmlElements.class).value();
      } catch (MirroredTypesException e) {
          e.getTypeMirrors().forEach(type -> {
              if (MoreTypes.asTypeElement(type).getAnnotation(XmlElement.class) == null) {
                  throw new GenerationException(type + " must be annotated with @XmlRootElement because it's declared in @XmlSeeAlso at " + elm);
              } else {
                  beans.add(MoreTypes.asTypeElement(type));
              }
          });
      }*/
    }
  }

  private TypeElement asTypeElement(TypeElement elm) {
    return elm;
  }

  private void processXmlSeeAlso(Element elm) {
    try {
      elm.getAnnotation(XmlSeeAlso.class).value();
    } catch (MirroredTypesException e) {
      e.getTypeMirrors()
          .forEach(
              type -> {
                if (MoreTypes.asTypeElement(type).getAnnotation(XmlRootElement.class) == null) {
                  throw new GenerationException(
                      type
                          + " must be annotated with @XmlRootElement because it's declared in @XmlSeeAlso at "
                          + elm);
                } else {
                  beans.add(MoreTypes.asTypeElement(type));
                }
              });
    }
  }

  private List<Class<?>> supportedAnnotations() {
    return Arrays.asList(XMLMapper.class);
  }
}
