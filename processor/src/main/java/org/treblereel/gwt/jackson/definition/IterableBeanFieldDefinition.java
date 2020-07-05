package org.treblereel.gwt.jackson.definition;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public class IterableBeanFieldDefinition extends FieldDefinition {

    protected IterableBeanFieldDefinition(TypeMirror property, GenerationContext context) {
        super(property, context);
    }

    @Override
    public Expression getFieldDeserializer(String propertyName, CompilationUnit cu) {
        TypeElement serializer = context.getTypeRegistry()
                .getDeserializer(context.getProcessingEnv().getTypeUtils().erasure(bean));

        cu.addImport(serializer.getQualifiedName().toString());

        MethodCallExpr method = new MethodCallExpr(
                new NameExpr(serializer.getSimpleName().toString()), "newInstance");
        MoreTypes.asDeclared(bean)
                .getTypeArguments()
                .forEach(param -> method.addArgument(propertyDefinitionFactory.getFieldDefinition(param)
                                                             .getFieldDeserializer(propertyName, cu)));
        return method;
    }

    @Override
    public Expression getFieldSerializer(String fieldName, CompilationUnit cu) {
        TypeElement serializer = context.getTypeRegistry()
                .getSerializer(context.getProcessingEnv().getTypeUtils().erasure(getBean()));

        MethodCallExpr method = new MethodCallExpr(
                new NameExpr(serializer.getQualifiedName().toString()), "newInstance");
        for (TypeMirror param : MoreTypes.asDeclared(getBean()).getTypeArguments()) {
            method.addArgument(generateXMLSerializerFactory(param, "?", cu));
        }
        method.addArgument(new StringLiteralExpr(fieldName));
        return method;
    }

    @Override
    public String toString() {
        return "IterableBeanFieldDefinition{" +
                "bean=" + bean +
                '}';
    }
}