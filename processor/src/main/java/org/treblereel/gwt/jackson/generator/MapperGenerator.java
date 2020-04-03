package org.treblereel.gwt.jackson.generator;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.google.auto.common.MoreElements;
import org.treblereel.gwt.jackson.api.AbstractObjectMapper;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.definition.BeanDefinition;
import org.treblereel.gwt.jackson.deserializer.DeserializerGenerator;
import org.treblereel.gwt.jackson.logger.TreeLogger;
import org.treblereel.gwt.jackson.serializer.SerializerGenerator;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/20/20
 */
public class MapperGenerator extends AbstractGenerator {

    private static final String MAPPER_IMPL = "_MapperImpl";

    private final DeserializerGenerator deserializerGenerator;
    private final SerializerGenerator serializerGenerator;

    public MapperGenerator(GenerationContext context, TreeLogger logger) {
        super(context, logger);
        this.deserializerGenerator = new DeserializerGenerator(context, logger);
        this.serializerGenerator = new SerializerGenerator(context, logger);
    }

    @Override
    protected void configureClassType(BeanDefinition type) {
        cu.addImport(AbstractObjectMapper.class);
        cu.addImport(XMLDeserializer.class);
        cu.addImport(XMLSerializer.class);

        if (!type.getBean().getKind().equals(TypeKind.PACKAGE)) {
            cu.addImport(type.getQualifiedName());
        }

        declaration.getExtendedTypes()
                .add(new ClassOrInterfaceType()
                             .setName(AbstractObjectMapper.class.getSimpleName())
                             .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName())));
    }

    @Override
    protected void init(BeanDefinition type) {
        serializerGenerator.generate(type);
        deserializerGenerator.generate(type);

        declaration.addFieldWithInitializer(new ClassOrInterfaceType().setName(getMapperName(type.getElement())), "INSTANCE",
                                            new ObjectCreationExpr().setType(new ClassOrInterfaceType().setName(getMapperName(type.getElement()))),
                                            Modifier.Keyword.FINAL,
                                            Modifier.Keyword.PUBLIC,
                                            Modifier.Keyword.STATIC);
        declaration.addConstructor()
                .setModifiers(Modifier.Keyword.PUBLIC)
                .getBody()
                .addStatement(new MethodCallExpr("super").addArgument(
                        new StringLiteralExpr(type.getXmlRootElement())));

        addNewDeserializer(type);
        newSerializer(type);
    }

    private void newSerializer(BeanDefinition type) {
        declaration.addMethod("newSerializer", Modifier.Keyword.PROTECTED)
                .addAnnotation(Override.class)
                .setType(new ClassOrInterfaceType()
                                 .setName(XMLSerializer.class.getSimpleName())
                                 .setTypeArguments(new ClassOrInterfaceType().setName("?")))
                .getBody().ifPresent(body -> body.addStatement(new ReturnStmt(
                new ObjectCreationExpr()
                        .setType(context.getTypeUtils().serializerName(type.getBean())))));
    }

    private void addNewDeserializer(BeanDefinition type) {
        declaration.addMethod("newDeserializer", Modifier.Keyword.PROTECTED)
                .addAnnotation(Override.class)
                .setType(new ClassOrInterfaceType()
                                 .setName(XMLDeserializer.class.getSimpleName())
                                 .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName())))
                .getBody().ifPresent(body -> body.addStatement(new ReturnStmt(
                new ObjectCreationExpr()
                        .setType(context.getTypeUtils().deserializerName(type.getBean())))));
    }

    @Override
    protected String getMapperName(TypeElement type) {
        return (type.getEnclosingElement().getKind().equals(ElementKind.PACKAGE) ? "" :
                MoreElements.asType(type.getEnclosingElement()).getSimpleName().toString() + "_")
                + type.getSimpleName() + MAPPER_IMPL;
    }
}
