package org.treblereel.gwt.jackson.definition;

import javax.lang.model.element.VariableElement;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public class PropertyDefinition extends Definition {

    private final VariableElement property;

    protected PropertyDefinition(VariableElement property, GenerationContext context) {
        super(property.asType(), context);
        this.property = property;
    }

    public Expression getFieldDeserializer(CompilationUnit cu) {
        FieldDefinition fieldDefinition = propertyDefinitionFactory.getFieldDefinition(bean);
        return fieldDefinition.getFieldDeserializer(cu);

    }

    public Expression getFieldSerializer(CompilationUnit cu) {
        FieldDefinition fieldDefinition = propertyDefinitionFactory.getFieldDefinition(bean);
        return fieldDefinition.getFieldSerializer(property.getSimpleName().toString(), cu);

    }

    public VariableElement getProperty() {
        return property;
    }

    public String getSimpleName() {
        return property.getSimpleName().toString();
    }
}
