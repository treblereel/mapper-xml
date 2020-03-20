package org.treblereel.gwt.jackson.processor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;

import com.google.auto.common.MoreElements;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.deserializer.DeserializerGenerator;
import org.treblereel.gwt.jackson.exception.GenerationException;
import org.treblereel.gwt.jackson.generator.MapperGenerator;
import org.treblereel.gwt.jackson.logger.TreeLogger;
import org.treblereel.gwt.jackson.serializer.SerializerGenerator;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/11/20
 */
public class BeanProcessor {

    private final GenerationContext context;
    private final TreeLogger logger;
    private final Set<TypeElement> annotatedBeans;
    private final Set<TypeElement> beans = new HashSet<>();
    private final TypeUtils typeUtils;
    private final DeserializerGenerator deserializerGenerator;
    private final SerializerGenerator serializerGenerator;
    private final MapperGenerator mapperGenerator;

    public BeanProcessor(GenerationContext context, TreeLogger logger, Set<TypeElement> annotatedBeans) {
        this.context = context;
        this.logger = logger;
        this.annotatedBeans = annotatedBeans;
        this.typeUtils = context.getTypeUtils();
        this.deserializerGenerator = new DeserializerGenerator(context, logger);
        this.serializerGenerator = new SerializerGenerator(context, logger);
        this.mapperGenerator = new MapperGenerator(context, logger);
    }

    public void process() {
        annotatedBeans.forEach(bean -> {
            processBean(bean);
        });

        beans.forEach(b -> {
            serializerGenerator.generate(b);
        });

        beans.forEach(b -> {
            deserializerGenerator.generate(b);
        });

        //TODO call generators from mapperGenerator
        beans.forEach(b -> {
            mapperGenerator.generate(b);
        });
    }

    private void processBean(TypeElement bean) {
        if (!beans.contains(bean)) {
            beans.add(checkBean(bean));

            bean.getEnclosedElements().stream()
                    .filter(elm -> context.getTypeUtils().isXMLMapper(bean.asType()))
                    .filter(elm -> elm.getKind().isField())
                    .map(field -> MoreElements.asVariable(field))
                    .forEach(field -> processField(field));
        }
    }

    private void processField(VariableElement field) {
        checkField(field);
        if (context.getTypeRegistry().get(context.getProcessingEnv()
                                                  .getTypeUtils().erasure(field.asType()).toString()) == null) {
            processBean(typeUtils.toTypeElement(field.asType()));
        }
    }

    private boolean checkField(VariableElement field) {
        return typeUtils.hasGetter(field) && typeUtils.hasSetter(field);
    }

    private TypeElement checkBean(TypeElement type) {
        if (type.getModifiers().contains(Modifier.STATIC)) {
            throw new GenerationException(
                    "A @XMLMapper bean [" + type + "] must not be static");
        }

        if (!type.getModifiers().contains(Modifier.PUBLIC)) {
            throw new GenerationException(
                    "A @XMLMapper bean [" + type + "] must be public");
        }

        List<ExecutableElement> constructors = ElementFilter.constructorsIn(type.getEnclosedElements());
        if (constructors.size() > 0) {
            long nonArgConstructorCount = constructors.stream()
                    .filter(constr -> constr.getModifiers().contains(Modifier.PUBLIC))
                    .filter(constr -> constr.getParameters().isEmpty()).count();
            if (nonArgConstructorCount != 1) {
                throw new GenerationException(
                        "A @XMLMapper bean [" + type + "] must contains public non-arg constructor");
            }
        }
        return type;
    }
}
