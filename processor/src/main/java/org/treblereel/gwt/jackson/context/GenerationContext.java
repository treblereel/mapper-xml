package org.treblereel.gwt.jackson.context;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

import org.treblereel.gwt.jackson.TypeRegistry;
import org.treblereel.gwt.jackson.TypeUtils;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/11/20
 */
public class GenerationContext {

    private final RoundEnvironment roundEnvironment;
    private final ProcessingEnvironment processingEnv;
    private final TypeRegistry typeRegistry;
    private final TypeUtils typeUtils;

    public GenerationContext(RoundEnvironment roundEnvironment,
                             ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        this.roundEnvironment = roundEnvironment;
        this.typeRegistry = new TypeRegistry(this);
        this.typeUtils = new TypeUtils(this);
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
}