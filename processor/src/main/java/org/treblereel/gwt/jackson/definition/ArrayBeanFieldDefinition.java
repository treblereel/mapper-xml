package org.treblereel.gwt.jackson.definition;

import java.util.function.Function;

import javax.lang.model.type.ArrayType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.CastExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import org.treblereel.gwt.jackson.api.deser.array.ArrayXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.array.dd.Array2dXMLDeserializer;
import org.treblereel.gwt.jackson.api.ser.array.ArrayXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.array.dd.Array2dXMLSerializer;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public class ArrayBeanFieldDefinition extends FieldDefinition {

    protected ArrayBeanFieldDefinition(TypeMirror property, GenerationContext context) {
        super(property, context);
    }

    @Override
    public Expression getFieldDeserializer(String propertyName, CompilationUnit cu) {
        cu.addImport(ArrayXMLDeserializer.ArrayCreator.class);
        cu.addImport(ArrayXMLDeserializer.class);

        ArrayType array = (ArrayType) bean;
        String arrayType = array.getComponentType().toString();
        if (array.getComponentType().getKind().isPrimitive()) {
            arrayType = context.getProcessingEnv().getTypeUtils()
                    .boxedClass((PrimitiveType) array.getComponentType()).getSimpleName().toString();
        } else if (array.getComponentType().getKind().equals(TypeKind.ARRAY)) {
            ArrayType array2d = (ArrayType) array.getComponentType();
            if (array2d.getComponentType().getKind().isPrimitive()) {
                arrayType = context.getProcessingEnv().getTypeUtils()
                        .boxedClass((PrimitiveType) array2d.getComponentType()).getSimpleName().toString() + "[]";
            } else {
                cu.addImport(Array2dXMLDeserializer.class);
                cu.addImport(Array2dXMLDeserializer.Array2dCreator.class);
                arrayType = array2d.getComponentType().toString();

                ClassOrInterfaceType typeOf = new ClassOrInterfaceType()
                        .setName(Array2dXMLDeserializer.Array2dCreator.class.getSimpleName())
                        .setTypeArguments(new ClassOrInterfaceType().setName(arrayType));

                return new MethodCallExpr(
                        new NameExpr(Array2dXMLDeserializer.class.getSimpleName()), "newInstance")
                        .addArgument(propertyDefinitionFactory.getFieldDefinition(array2d.getComponentType())
                                             .getFieldDeserializer(propertyName, cu))
                        .addArgument(new CastExpr().setType(typeOf).setExpression(
                                new NameExpr("(first, second) -> new " + arrayType + "[first][second]")));
            }
        }

        ClassOrInterfaceType typeOf = new ClassOrInterfaceType()
                .setName(ArrayXMLDeserializer.ArrayCreator.class.getSimpleName())
                .setTypeArguments(new ClassOrInterfaceType().setName(arrayType));

        return new MethodCallExpr(
                new NameExpr(ArrayXMLDeserializer.class.getSimpleName()), "newInstance")
                .addArgument(propertyDefinitionFactory.getFieldDefinition(array.getComponentType())
                                     .getFieldDeserializer(propertyName, cu))
                .addArgument(new CastExpr().setType(typeOf).setExpression(
                        new NameExpr(arrayType + "[]::new")));
    }

    @Override
    public Expression getFieldSerializer(String fieldName, CompilationUnit cu) {
        cu.addImport(ArrayXMLSerializer.class);
        cu.addImport(Array2dXMLSerializer.class);
        cu.addImport(Function.class);

        ArrayType array = (ArrayType) getBean();
        String serializer;
        TypeMirror type;
        if (array.getComponentType().getKind().equals(TypeKind.ARRAY)) {
            serializer = Array2dXMLSerializer.class.getSimpleName();
            ArrayType array2d = (ArrayType) array.getComponentType();
            type = array2d.getComponentType();
        } else {
            serializer = ArrayXMLSerializer.class.getSimpleName();
            type = array.getComponentType();
        }
        return new MethodCallExpr(
                new NameExpr(serializer), "getInstance")
                .addArgument(generateXMLSerializerFactory(type, type.toString(), cu))
                .addArgument(new StringLiteralExpr(fieldName));
    }

    @Override
    public String toString() {
        return "ArrayBeanFieldDefinition{" +
                "bean=" + bean +
                '}';
    }
}
