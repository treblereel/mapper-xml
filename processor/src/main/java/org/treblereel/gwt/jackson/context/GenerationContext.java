package org.treblereel.gwt.jackson.context;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.TypeRegistry;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.api.annotation.XmlTypeAdapter;
import org.treblereel.gwt.jackson.definition.BeanDefinition;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/11/20
 */
public class GenerationContext {

    private final RoundEnvironment roundEnvironment;
    private final ProcessingEnvironment processingEnv;
    private final TypeRegistry typeRegistry;
    private final TypeUtils typeUtils;
    private final Map<TypeMirror, BeanDefinition> beans = new HashMap<>();

    public GenerationContext(RoundEnvironment roundEnvironment,
                             ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        this.roundEnvironment = roundEnvironment;
        this.typeRegistry = new TypeRegistry(this);
        this.typeUtils = new TypeUtils(this);
        new CustomHandlerProcessor(this).process(roundEnvironment
                                                         .getElementsAnnotatedWith(XmlTypeAdapter.class));
    }

    public RoundEnvironment getRoundEnvironment() {
        return roundEnvironment;
    }

    public ProcessingEnvironment getProcessingEnv() {
        return processingEnv;
    }

    public TypeRegistry getTypeRegistry() {
        return typeRegistry;
    }

    public TypeUtils getTypeUtils() {
        return typeUtils;
    }

    public BeanDefinition getBeanDefinition(TypeMirror type) {
        if (beans.containsKey(type)) {
            return beans.get(type);
        } else {
            BeanDefinition beanDefinition = new BeanDefinition(MoreTypes.asTypeElement(type), this);
            beans.put(type, beanDefinition);
            return beanDefinition;
        }
    }

    public void addBeanDefinition(TypeElement type) {
        if (!beans.containsKey(type.asType())) {
            BeanDefinition beanDefinition = new BeanDefinition(type, this);
            beans.put(type.asType(), beanDefinition);
        }
    }

    public Collection<BeanDefinition> getBeans() {
        return beans.values();
    }
}