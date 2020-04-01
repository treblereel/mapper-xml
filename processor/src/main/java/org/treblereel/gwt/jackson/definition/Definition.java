package org.treblereel.gwt.jackson.definition;

import javax.lang.model.type.TypeMirror;

import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public abstract class Definition {

    protected final TypeMirror bean;
    protected final GenerationContext context;
    protected final FieldDefinitionFactory propertyDefinitionFactory;

    protected Definition(TypeMirror bean, GenerationContext context) {
        this.propertyDefinitionFactory = new FieldDefinitionFactory(context);
        this.bean = bean;
        this.context = context;
    }

    public TypeMirror getBean() {
        return bean;
    }
}
