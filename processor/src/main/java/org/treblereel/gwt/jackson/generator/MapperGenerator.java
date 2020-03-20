package org.treblereel.gwt.jackson.generator;

import javax.lang.model.element.TypeElement;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import org.treblereel.gwt.jackson.api.AbstractObjectMapper;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.logger.TreeLogger;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/20/20
 */
public class MapperGenerator extends AbstractGenerator {

    private final static String MAPPER_IMPL = "_MapperImpl";

    public MapperGenerator(GenerationContext context, TreeLogger logger) {
        super(context, logger);
    }

    @Override
    protected void configureClassType(TypeElement type) {
        cu.addImport(AbstractObjectMapper.class);
        cu.addImport(XMLDeserializer.class);
        cu.addImport(XMLSerializer.class);

        declaration.getExtendedTypes()
                .add(new ClassOrInterfaceType()
                             .setName(AbstractObjectMapper.class.getSimpleName())
                             .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName().toString())));
    }

    @Override
    protected void init(TypeElement type) {
        declaration.addFieldWithInitializer(new ClassOrInterfaceType().setName(getMapperName(type)), "INSTANCE",
                                            new ObjectCreationExpr().setType(new ClassOrInterfaceType().setName(getMapperName(type))),
                                            Modifier.Keyword.FINAL,
                                            Modifier.Keyword.PUBLIC,
                                            Modifier.Keyword.STATIC);
        declaration.addConstructor()
                .setModifiers(Modifier.Keyword.PUBLIC)
                .getBody()
                .addStatement(new MethodCallExpr("super").addArgument(
                        new StringLiteralExpr(type.getSimpleName().toString())));

        addNewDeserializer(type);
        newSerializer(type);
    }

    private void newSerializer(TypeElement type) {
        declaration.addMethod("newSerializer", Modifier.Keyword.PROTECTED)
                .addAnnotation(Override.class)
                .setType(new ClassOrInterfaceType()
                                 .setName(XMLSerializer.class.getSimpleName())
                                 .setTypeArguments(new ClassOrInterfaceType().setName("?")))
                .getBody().ifPresent(body -> {
            body.addStatement(new ReturnStmt(
                    new ObjectCreationExpr()
                            .setType(context.getTypeUtils().serializerName(type.asType()))));
        });
    }

    private void addNewDeserializer(TypeElement type) {
        declaration.addMethod("newDeserializer", Modifier.Keyword.PROTECTED)
                .addAnnotation(Override.class)
                .setType(new ClassOrInterfaceType()
                                 .setName(XMLDeserializer.class.getSimpleName())
                                 .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName().toString())))
                .getBody().ifPresent(body -> {
            body.addStatement(new ReturnStmt(
                    new ObjectCreationExpr()
                            .setType(context.getTypeUtils().deserializerName(type.asType()))));
        });
    }

    @Override
    protected String getMapperName(TypeElement type) {
        return type.getSimpleName() + MAPPER_IMPL;
    }
}
