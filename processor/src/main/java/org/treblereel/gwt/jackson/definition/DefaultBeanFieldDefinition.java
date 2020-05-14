package org.treblereel.gwt.jackson.definition;

import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public class DefaultBeanFieldDefinition extends FieldDefinition {

    private final TypeUtils typeUtils;

    protected DefaultBeanFieldDefinition(TypeMirror property, GenerationContext context) {
        super(property, context);
        this.typeUtils = context.getTypeUtils();
    }

    @Override
    public Expression getFieldDeserializer(CompilationUnit cu) {
        return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                        .setName(typeUtils.canonicalDeserializerName(bean)));
    }

    @Override
    public Expression getFieldSerializer(String fieldName, CompilationUnit cu) {
        return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                        .setName(typeUtils.canonicalSerializerName(getBean())));
    }

    @Override
    public String toString() {
        return "DefaultBeanFieldDefinition{" +
                "bean=" + bean +
                '}';
    }
}
