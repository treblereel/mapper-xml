package org.treblereel.gwt.jackson.context;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/11/20
 */
public class GenerationContext {

    private final RoundEnvironment roundEnvironment;
    private final ProcessingEnvironment processingEnv;

    public GenerationContext(RoundEnvironment roundEnvironment,
                             ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        this.roundEnvironment = roundEnvironment;
    }
}