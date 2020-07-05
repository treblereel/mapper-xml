package org.treblereel.gwt.jackson.definition;

import java.util.function.Function;

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

    private DeclaredType declaredType;

    protected MapBeanFieldDefinition(TypeMirror property, GenerationContext context) {
        super(property, context);
        declaredType = MoreTypes.asDeclared(property);
    }

    @Override
    public Expression getFieldDeserializer(String propertyName, CompilationUnit cu) {
        if (declaredType.getTypeArguments().size() != 2) {
            throw new GenerationException(declaredType.toString() + " must have type args [" + bean + "]");
        }
        return new MethodCallExpr(
                new NameExpr(MapXMLDeserializer.class.getCanonicalName()), "newInstance")
                .addArgument(generateXMLDeserializerFactory(declaredType.getTypeArguments().get(0), declaredType.getTypeArguments().get(0).toString(), cu))
                .addArgument(generateXMLDeserializerFactory(declaredType.getTypeArguments().get(1), declaredType.getTypeArguments().get(1).toString(), cu));
    }

    @Override
    public Expression getFieldSerializer(String fieldName, CompilationUnit cu) {
        cu.addImport(Function.class);
        if (declaredType.getTypeArguments().size() != 2) {
            throw new GenerationException(declaredType.toString() + " must have type args [" + fieldName + "]");
        }
        return new MethodCallExpr(
                new NameExpr(MapXMLSerializer.class.getCanonicalName()), "newInstance")
                .addArgument(generateXMLSerializerFactory(declaredType.getTypeArguments().get(0), "?", cu))
                .addArgument(generateXMLSerializerFactory(declaredType.getTypeArguments().get(1), "?", cu))
                .addArgument(new StringLiteralExpr(fieldName));
    }

    @Override
    public String toString() {
        return "MapBeanFieldDefinition{" +
                "bean=" + bean +
                '}';
    }
}