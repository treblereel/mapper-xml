package org.treblereel.gwt.jackson;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import com.google.auto.service.AutoService;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.api.annotation.XmlSubtypes;
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
        return supportedAnnotations().stream()
                .map(Class::getCanonicalName).collect(Collectors.toSet());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        if (!annotations.isEmpty()) {
            GenerationContext context = new GenerationContext(roundEnvironment, processingEnv);
            processXMLMapper(roundEnvironment.getElementsAnnotatedWith(XMLMapper.class)
                                     .stream());

            processXmlSeeAlso(roundEnvironment.getElementsAnnotatedWith(XmlSeeAlso.class)
                                      .stream());
            new BeanProcessor(context, logger, beans).process();
        }
        return false;
    }

    private void processXMLMapper(Stream<? extends Element> stream) {
        stream.map(MoreElements::asType)
                .map(this::asTypeElement)
                .forEach(beans::add);
    }

    private void processXmlSeeAlso(Stream<? extends Element> stream) {
        stream.forEach(elm -> processXmlSeeAlso(elm));
    }

    private TypeElement asTypeElement(TypeElement elm) {
        if (elm.getAnnotation(XmlSubtypes.class) != null) {
            if (elm.getAnnotation(XmlSubtypes.class).value().length > 1) {
                throw new GenerationException("It's only possible to have only one child of " + elm + " via XmlSubtypes at this moment, it ll be fixed.");
            }
            XmlSubtypes.Type subtype = elm.getAnnotation(XmlSubtypes.class).value()[0];
            beans.add(elm);
            return getXmlSubtypesType(subtype);
        }
        return elm;
    }

    private void processXmlSeeAlso(Element elm) {
        try {
            elm.getAnnotation(XmlSeeAlso.class).value();
        } catch (MirroredTypesException e) {
            e.getTypeMirrors().forEach(type -> {
                if(MoreTypes.asTypeElement(type).getAnnotation(XmlRootElement.class) == null) {
                    throw new GenerationException(type + " must be annotated with @XmlRootElement because it's declared in @XmlSeeAlso at " + elm);
                } else {
                    beans.add(MoreTypes.asTypeElement(type));
                }
            });
        }
    }

    private TypeElement getXmlSubtypesType(XmlSubtypes.Type subtype) {
        try {
            subtype.value();
        } catch (MirroredTypeException e) {
            return MoreTypes.asTypeElement(e.getTypeMirror());
        }
        return null;
    }

    private List<Class<?>> supportedAnnotations() {
        return Arrays.asList(XMLMapper.class);
    }
}