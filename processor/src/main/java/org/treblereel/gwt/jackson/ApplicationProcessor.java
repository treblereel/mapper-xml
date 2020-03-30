package org.treblereel.gwt.jackson;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import com.google.auto.common.MoreElements;
import com.google.auto.service.AutoService;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.logger.PrintWriterTreeLogger;
import org.treblereel.gwt.jackson.logger.TreeLogger;
import org.treblereel.gwt.jackson.processor.BeanProcessor;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ApplicationProcessor extends AbstractProcessor {

    private final TreeLogger logger = new PrintWriterTreeLogger();

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return supportedAnnotations().stream()
                .map(Class::getCanonicalName).collect(Collectors.toSet());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        if (!annotations.isEmpty()) {

            GenerationContext context = new GenerationContext(roundEnvironment, processingEnv);

            Set<TypeElement> beans = roundEnvironment.getElementsAnnotatedWith(XMLMapper.class)
                    .stream()
                    .filter(elm -> elm.getKind().isClass())
                    .map(MoreElements::asType)
                    .collect(Collectors.toSet());

            new BeanProcessor(context, logger, beans).process();
        }
        return false;
    }

    private List<Class<?>> supportedAnnotations() {
        return Arrays.asList(XMLMapper.class);
    }
}