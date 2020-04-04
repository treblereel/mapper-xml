package org.treblereel.gwt.jackson.definition;

import javax.lang.model.element.VariableElement;
import javax.xml.bind.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.XmlCData;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
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
        Expression result = fieldDefinition.getFieldDeserializer(cu);
        if (isCData()) {
            result = new MethodCallExpr(result, "setCdata").addArgument(new BooleanLiteralExpr(true));
        }
        return result;
    }

    public boolean isCData() {
        return property.asType().toString().equals(String.class.getCanonicalName()) &&
                property.getAnnotation(XmlCData.class) != null &&
                property.getAnnotation(XmlCData.class).value();
    }

    public Expression getFieldSerializer(CompilationUnit cu) {
        FieldDefinition fieldDefinition = propertyDefinitionFactory.getFieldDefinition(bean);
        return fieldDefinition.getFieldSerializer(property.getSimpleName().toString(), cu);
    }

    public VariableElement getProperty() {
        return property;
    }

    public String getPropertyName() {
        if (property.getAnnotation(JacksonXmlProperty.class) != null &&
                !property.getAnnotation(JacksonXmlProperty.class).localName().isEmpty()) {
            return property.getAnnotation(JacksonXmlProperty.class).localName();
        }
        return property.getSimpleName().toString();
    }
}
