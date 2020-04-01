package org.treblereel.gwt.jackson.definition;

import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public abstract class FieldDefinition extends Definition {

    protected FieldDefinition(TypeMirror property, GenerationContext context) {
        super(property, context);
    }

    public abstract Expression getFieldDeserializer(CompilationUnit cu);

    public abstract Expression getFieldSerializer(String fieldName, CompilationUnit cu);

}