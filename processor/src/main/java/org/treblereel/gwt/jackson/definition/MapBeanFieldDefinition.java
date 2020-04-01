package org.treblereel.gwt.jackson.definition;

import javax.lang.model.element.ElementKind;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.api.deser.map.MapXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.map.key.EnumKeyDeserializer;
import org.treblereel.gwt.jackson.api.ser.map.MapXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.map.key.EnumKeySerializer;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.exception.GenerationException;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public class MapBeanFieldDefinition extends FieldDefinition {

    protected MapBeanFieldDefinition(TypeMirror property, GenerationContext context) {
        super(property, context);
    }

    @Override
    public Expression getFieldDeserializer(CompilationUnit cu) {
        DeclaredType declaredType = MoreTypes.asDeclared(bean);
        if (declaredType.getTypeArguments().size() != 2) {
            throw new GenerationException(declaredType.toString() + " must have type args [" + bean + "]");
        }
        MethodCallExpr deserializer;
        if (MoreTypes.asElement(declaredType.getTypeArguments().get(0)).getKind().equals(ElementKind.ENUM)) {
            cu.addImport(EnumKeyDeserializer.class);
            deserializer = new MethodCallExpr(
                    new NameExpr(EnumKeyDeserializer.class.getSimpleName()), "getInstance")
                    .addArgument(declaredType.getTypeArguments().get(0).toString() + ".class");
        } else {
            deserializer = new MethodCallExpr(
                    new NameExpr(context.getTypeRegistry()
                                         .getKeyDeserializer(declaredType.getTypeArguments().get(0).toString())
                                         .getQualifiedName().toString()), "getInstance");
        }
        return new MethodCallExpr(
                new NameExpr(MapXMLDeserializer.class.getCanonicalName()), "newInstance")
                .addArgument(deserializer)
                .addArgument(propertyDefinitionFactory.getFieldDefinition(declaredType.getTypeArguments().get(1))
                                     .getFieldDeserializer(cu));
    }

    @Override
    public Expression getFieldSerializer(String fieldName, CompilationUnit cu) {
        DeclaredType declaredType = MoreTypes.asDeclared(getBean());
        if (declaredType.getTypeArguments().size() != 2) {
            throw new GenerationException(declaredType.toString() + " must have type args [" + fieldName + "]");
        }
        String keySerializer;

        if (MoreTypes.asElement(declaredType.getTypeArguments().get(0)).getKind().equals(ElementKind.ENUM)) {
            cu.addImport(EnumKeySerializer.class);
            keySerializer = EnumKeySerializer.class.getSimpleName();
        } else {
            keySerializer = context.getTypeRegistry()
                    .getKeySerializer(declaredType.getTypeArguments().get(0).toString()).
                            getQualifiedName().toString();
        }

        return new MethodCallExpr(
                new NameExpr(MapXMLSerializer.class.getCanonicalName()), "newInstance")
                .addArgument(new MethodCallExpr(
                        new NameExpr(keySerializer), "getInstance"))
                .addArgument(propertyDefinitionFactory.getFieldDefinition(declaredType.getTypeArguments().get(1))
                                     .getFieldSerializer(null, cu))
                .addArgument(new StringLiteralExpr(fieldName));
    }

    @Override
    public String toString() {
        return "MapBeanFieldDefinition{" +
                "bean=" + bean +
                '}';
    }
}