package org.treblereel.gwt.jackson.definition;

import java.util.Map;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.xml.bind.annotation.XmlElementRefs;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.api.Inheritance;
import org.treblereel.gwt.jackson.api.utils.Pair;
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
    public Expression getFieldDeserializer(PropertyDefinition field, CompilationUnit cu) {
        TypeElement serializer = context.getTypeRegistry()
                .getDeserializer(context.getProcessingEnv().getTypeUtils().erasure(bean));

        cu.addImport(serializer.getQualifiedName().toString());

        MethodCallExpr method = new MethodCallExpr(
                new NameExpr(serializer.getSimpleName().toString()), "newInstance");

        Pair<Class, Map<String, TypeMirror>> maybePolymorphicType = maybePolymorphicType(field, bean);
        String inheritance = maybePolymorphicType.key.equals(XmlElementRefs.class) ? "Inheritance.TAG" : "Inheritance.XSI";
        TypeMirror type = MoreTypes.asDeclared(bean).getTypeArguments().get(0);

        if(!maybePolymorphicType.value.isEmpty()) {
            cu.addImport(Inheritance.class);
            method.addArgument(generateXMLDeserializerFactory(field, type, type.toString(), cu, maybePolymorphicType));
            method = new MethodCallExpr(method, "setInheritanceType").addArgument(inheritance);
        } else {
            method.addArgument(generateXMLDeserializerFactory(field, type, type.toString(), cu));
        }
        return method;
    }

    @Override
    public Expression getFieldSerializer(PropertyDefinition field, CompilationUnit cu) {
        TypeElement serializer = context.getTypeRegistry()
                .getSerializer(context.getProcessingEnv().getTypeUtils().erasure(getBean()));

        MethodCallExpr method = new MethodCallExpr(
                new NameExpr(serializer.getQualifiedName().toString()), "newInstance");
        for (TypeMirror param : MoreTypes.asDeclared(getBean()).getTypeArguments()) {
            method.addArgument(generateXMLSerializerFactory(field, param, "?", cu));
        }
        method.addArgument(new StringLiteralExpr(field.getPropertyName()));
        return method;
    }

    @Override
    public String toString() {
        return "IterableBeanFieldDefinition{" +
                "bean=" + bean +
                '}';
    }
}