package org.treblereel.gwt.jackson.processor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;

import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.exception.GenerationException;
import org.treblereel.gwt.jackson.generator.MapperGenerator;
import org.treblereel.gwt.jackson.logger.TreeLogger;

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
    private final MapperGenerator mapperGenerator;

    public BeanProcessor(GenerationContext context, TreeLogger logger, Set<TypeElement> annotatedBeans) {
        this.context = context;
        this.logger = logger;
        this.annotatedBeans = annotatedBeans;
        this.typeUtils = context.getTypeUtils();
        this.mapperGenerator = new MapperGenerator(context, logger);
    }

    public void process() {
        annotatedBeans.forEach(this::processBean);
        beans.forEach(context::addBeanDefinition);
        context.getBeans().forEach(mapperGenerator::generate);
    }

    private void processBean(TypeElement bean) {
        if (!beans.contains(bean)) {
            beans.add(checkBean(bean));

            bean.getEnclosedElements().stream()
                    .filter(elm -> context.getTypeUtils().isXMLMapper(bean.asType()))
                    .filter(elm -> elm.getKind().isField())
                    .map(MoreElements::asVariable)
                    .forEach(this::processField);
        }
    }

    private void processField(VariableElement field) {
        checkField(field);
        checkTypeAndAdd(field.asType());
    }

    private void checkTypeAndAdd(TypeMirror type) {
        if (context.getTypeRegistry().get(context.getProcessingEnv()
                                                  .getTypeUtils().erasure(type).toString()) == null) {
            if (type.getKind().equals(TypeKind.ARRAY)) {
                ArrayType arrayType = (ArrayType) type;

                if (!context.getTypeUtils().isSimpleType(arrayType.getComponentType())) {
                    processBean(typeUtils.toTypeElement(arrayType.getComponentType()));
                }
            } else if (MoreTypes.isType(type)) {
                if (!MoreTypes.asElement(type).getKind().equals(ElementKind.ENUM)) {
                    processBean(typeUtils.toTypeElement(type));
                }
            }
        }

        if (context.getTypeUtils().isCollection(type)) {
            DeclaredType collection = (DeclaredType) type;
            collection.getTypeArguments().forEach(this::checkTypeAndAdd);
        }
    }

    private boolean checkField(VariableElement field) {
        if (field.getModifiers().contains(Modifier.STATIC) ||
                field.getModifiers().contains(Modifier.TRANSIENT) ||
                field.getModifiers().contains(Modifier.FINAL)) {
            return false;
        }
        return typeUtils.hasGetter(field) && typeUtils.hasSetter(field);
    }

    private TypeElement checkBean(TypeElement type) {
        if (!type.getModifiers().contains(Modifier.PUBLIC)) {
            throw new GenerationException(
                    "A @XMLMapper bean [" + type + "] must be public");
        }

        List<ExecutableElement> constructors = ElementFilter.constructorsIn(type.getEnclosedElements());
        if (!constructors.isEmpty()) {
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
