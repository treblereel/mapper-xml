package org.treblereel.gwt.jackson.definition;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.api.deser.EnumXMLDeserializer;
import org.treblereel.gwt.jackson.api.ser.EnumXMLSerializer;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public class EnumBeanFieldDefinition extends FieldDefinition {

    protected EnumBeanFieldDefinition(TypeMirror property, GenerationContext context) {
        super(property, context);
    }

    @Override
    public Expression getFieldDeserializer(CompilationUnit cu) {
        cu.addImport(EnumXMLDeserializer.class);
        cu.addImport(MoreTypes.asTypeElement(bean).getQualifiedName().toString());

        MethodCallExpr expr = new MethodCallExpr(new NameExpr(EnumXMLDeserializer.class.getSimpleName()), "newInstance")
                .addArgument(MoreTypes.asTypeElement(bean).getSimpleName().toString() + ".class");

        for (Element enumConstant : MoreTypes.asTypeElement(bean).getEnclosedElements()) {
            if (enumConstant.getKind().equals(ElementKind.ENUM_CONSTANT)) {
                expr.addArgument(bean.toString() + "." + enumConstant);
            }
        }

        return expr;
    }

    @Override
    public Expression getFieldSerializer(String fieldName, CompilationUnit cu) {
        cu.addImport(EnumXMLSerializer.class);
        return new MethodCallExpr(
                new NameExpr(EnumXMLSerializer.class.getSimpleName()), "getInstance");
    }

    @Override
    public String toString() {
        return "EnumBeanFieldDefinition{" +
                "bean=" + bean +
                '}';
    }
}
