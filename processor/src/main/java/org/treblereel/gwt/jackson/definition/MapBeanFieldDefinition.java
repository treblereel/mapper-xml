package org.treblereel.gwt.jackson.definition;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.api.deser.map.MapXMLDeserializer;
import org.treblereel.gwt.jackson.api.ser.map.MapXMLSerializer;
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
        return new MethodCallExpr(
                new NameExpr(MapXMLDeserializer.class.getCanonicalName()), "newInstance")
                .addArgument(propertyDefinitionFactory.getFieldDefinition(declaredType.getTypeArguments().get(0))
                                     .getFieldDeserializer(cu))
                .addArgument(propertyDefinitionFactory.getFieldDefinition(declaredType.getTypeArguments().get(1))
                                     .getFieldDeserializer(cu));
    }

    @Override
    public Expression getFieldSerializer(String fieldName, CompilationUnit cu) {
        DeclaredType declaredType = MoreTypes.asDeclared(getBean());
        if (declaredType.getTypeArguments().size() != 2) {
            throw new GenerationException(declaredType.toString() + " must have type args [" + fieldName + "]");
        }
        return new MethodCallExpr(
                new NameExpr(MapXMLSerializer.class.getCanonicalName()), "newInstance")
                .addArgument(propertyDefinitionFactory.getFieldDefinition(declaredType.getTypeArguments().get(0))
                                     .getFieldSerializer(null, cu))
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