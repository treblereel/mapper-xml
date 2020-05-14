package org.treblereel.gwt.jackson.definition;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.xml.bind.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.XmlCData;
import javax.xml.bind.annotation.XmlSchema;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
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
        TypeMirror bean = maybeInterface(context);
        FieldDefinition fieldDefinition = propertyDefinitionFactory.getFieldDefinition(bean != null ? bean : getBean());
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

    public boolean isAttribute() {
        TypeMirror type = context.getTypeUtils().removeOuterWildCards(property.asType());

        return property.getAnnotation(JacksonXmlProperty.class) != null &&
                property.getAnnotation(JacksonXmlProperty.class).isAttribute() &&
                (context.getTypeUtils().isBasicType(type)
                        || MoreTypes.asElement(type).getKind().equals(ElementKind.ENUM));
    }

    public Expression getFieldSerializer(CompilationUnit cu, GenerationContext context) {
        TypeMirror bean = maybeInterface(context);
        FieldDefinition fieldDefinition = propertyDefinitionFactory.getFieldDefinition(bean != null ? bean : getBean());
        return fieldDefinition.getFieldSerializer(getPropertyName(), cu);
    }

    private TypeMirror maybeInterface(GenerationContext context) {
        if (!getBean().getKind().equals(TypeKind.ARRAY) &&
                !getBean().getKind().isPrimitive() &&
                MoreTypes.isType(getBean())) {
            if (MoreTypes.asElement(getBean()).getKind().isInterface() ||
                    (MoreTypes.asElement(getBean()).getKind().isClass() &&
                            MoreTypes.asElement(getBean()).getModifiers().contains(Modifier.ABSTRACT))) {
                return context.getBeans().stream().filter(v -> v.getElement().equals(MoreTypes.asTypeElement(getBean()))).findFirst().map(v -> v.getBean()).orElse(null);
            }
        }
        return null;
    }

    public String getPropertyName() {
        if (property.getAnnotation(JacksonXmlProperty.class) != null &&
                !property.getAnnotation(JacksonXmlProperty.class).localName().isEmpty()) {
            return property.getAnnotation(JacksonXmlProperty.class).localName();
        }
        return property.getSimpleName().toString();
    }

    public String getNamespace() {
        if (property.getAnnotation(JacksonXmlProperty.class) != null &&
                !property.getAnnotation(JacksonXmlProperty.class).namespace().equals("")
                && !property.getAnnotation(JacksonXmlProperty.class).isAttribute()) {
            return property.getAnnotation(JacksonXmlProperty.class).namespace();
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

    public VariableElement getProperty() {
        return property;
    }
}
