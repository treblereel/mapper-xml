package org.treblereel.gwt.jackson.definition;

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
    public Expression getFieldDeserializer(CompilationUnit cu) {
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
            }
        }

        ClassOrInterfaceType typeOf = new ClassOrInterfaceType()
                .setName(ArrayXMLDeserializer.ArrayCreator.class.getSimpleName())
                .setTypeArguments(new ClassOrInterfaceType().setName(arrayType));
        return new MethodCallExpr(
                new NameExpr(ArrayXMLDeserializer.class.getSimpleName()), "newInstance")
                .addArgument(propertyDefinitionFactory.getFieldDefinition(array.getComponentType())
                                     .getFieldDeserializer(cu))
                .addArgument(new CastExpr().setType(typeOf).setExpression(
                        new NameExpr(arrayType + "[]::new")));
    }

    @Override
    public Expression getFieldSerializer(String fieldName, CompilationUnit cu) {
        cu.addImport(ArrayXMLSerializer.class);
        cu.addImport(Array2dXMLSerializer.class);

        ArrayType array = (ArrayType) getBean();
        String serializer;
        Expression expression;
        if (array.getComponentType().getKind().equals(TypeKind.ARRAY)) {
            serializer = Array2dXMLSerializer.class.getSimpleName();
            ArrayType array2d = (ArrayType) array.getComponentType();

            expression = propertyDefinitionFactory.getFieldDefinition(array2d.getComponentType())
                    .getFieldSerializer(null, cu);
        } else {
            serializer = ArrayXMLSerializer.class.getSimpleName();
            expression = propertyDefinitionFactory.getFieldDefinition((array.getComponentType()))
                    .getFieldSerializer(null, cu);
        }
        return new MethodCallExpr(
                new NameExpr(serializer), "getInstance")
                .addArgument(expression)
                .addArgument(new StringLiteralExpr(fieldName));
    }

    @Override
    public String toString() {
        return "ArrayBeanFieldDefinition{" +
                "bean=" + bean +
                '}';
    }
}