package org.treblereel.gwt.jackson.definition;

import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlCData;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchema;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.api.annotation.XmlTypeAdapter;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.exception.GenerationException;

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
        FieldDefinition fieldDefinition = propertyDefinitionFactory.getFieldDefinition(getBean());
        Expression result = fieldDefinition.getFieldDeserializer(this, cu);
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

    public Expression getFieldSerializer(CompilationUnit cu, GenerationContext context) {
        FieldDefinition fieldDefinition = propertyDefinitionFactory.getFieldDefinition(bean != null ? bean : getBean());
        return fieldDefinition.getFieldSerializer(this, cu);
    }

    public String getPropertyName() {
        if (property.getAnnotation(XmlElement.class) != null &&
                !property.getAnnotation(XmlElement.class).name().equals("##default")) {
            return property.getAnnotation(XmlElement.class).name();
        }

        if (property.getAnnotation(XmlAttribute.class) != null &&
                !property.getAnnotation(XmlAttribute.class).name().equals("##default")) {
            return property.getAnnotation(XmlAttribute.class).name();
        }

        return property.getSimpleName().toString();
    }

    public String getNamespace() {
        if (property.getAnnotation(XmlElement.class) != null &&
                !property.getAnnotation(XmlElement.class).namespace().equals("##default")) {
            return property.getAnnotation(XmlElement.class).namespace();
        }

        if (property.getAnnotation(XmlAttribute.class) != null &&
                !property.getAnnotation(XmlAttribute.class).namespace().equals("##default")) {
            return property.getAnnotation(XmlAttribute.class).namespace();
        }

        XmlSchema schema = null;
        if (!context.getTypeUtils().isSimpleType(property.asType()) && !property.asType().getKind().equals(TypeKind.ARRAY)) {
            schema = MoreElements.getPackage(MoreTypes.asTypeElement(property.asType())).getAnnotation(XmlSchema.class);
        }
        if (schema != null && !schema.namespace().isEmpty()) {
            return schema.namespace();
        }
        return null;
    }

    public boolean isAttribute() {
        if (getBean().getKind().equals(TypeKind.DECLARED)
                && MoreTypes.asElement(getBean()).getAnnotation(XmlTypeAdapter.class) != null) {
            return MoreTypes.asElement(getBean()).getAnnotation(XmlTypeAdapter.class).isAttribute();
        }

        if (property.getAnnotation(XmlElement.class) != null
                && property.getAnnotation(XmlAttribute.class) != null) {
            throw new GenerationException("The property [" + property.getSimpleName() + "] " +
                                                  "at [" + property.getEnclosingElement() + "] annotated with @XmlElement and @XmlAttribute, it's only possible to use one of them.");
        }

        return property.getAnnotation(XmlAttribute.class) != null;
    }

    public boolean isWrapped() {
        return property.getAnnotation(XmlElementWrapper.class) != null;
    }

    public String getWrapped() {
        return !property.getAnnotation(XmlElementWrapper.class).name().equals("##default")
                ? property.getAnnotation(XmlElementWrapper.class).name() :
                property.getSimpleName().toString();
    }

    public VariableElement getProperty() {
        return property;
    }

    @Override
    public String toString() {
        return "PropertyDefinition{" +
                "property=" + property +
                '}';
    }
}
