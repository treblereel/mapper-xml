package org.treblereel.gwt.jackson.generator;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.expr.CastExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.TypeParameter;
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

        setExtendedType(type);
    }

    private void setExtendedType(BeanDefinition type) {
        declaration.getExtendedTypes()
                .add(new ClassOrInterfaceType()
                             .setName(AbstractObjectMapper.class.getSimpleName())
                             .setTypeArguments(new ClassOrInterfaceType()
                                                       .setName(getTypeMapperName(type))));
    }

    private String getTypeMapperName(BeanDefinition type) {
        return type.getElement().getKind().isClass() ? type.getSimpleName() : "T";
    }

    @Override
    protected void init(BeanDefinition type) {
        if (type.getElement().getKind().isClass()) {
            serializerGenerator.generate(type);
            deserializerGenerator.generate(type);
        }
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
        ClassOrInterfaceType returnType = new ClassOrInterfaceType()
                .setName(XMLSerializer.class.getSimpleName())
                .setTypeArguments(new ClassOrInterfaceType().setName(getTypeMapperName(type)));

        declaration.addMethod("newSerializer", Modifier.Keyword.PROTECTED)
                .addAnnotation(Override.class)
                .setType(returnType)
                .getBody().ifPresent(body -> body.addStatement(new ReturnStmt(addObjectCreationExpr(type,
                                                                                                    returnType,
                                                                                                    new ObjectCreationExpr()
                                                                                                            .setType(context.getTypeUtils()
                                                                                                                             .serializerName(getTypeName(type)))))));
    }

    private void addNewDeserializer(BeanDefinition type) {
        ClassOrInterfaceType returnType = new ClassOrInterfaceType()
                .setName(XMLDeserializer.class.getSimpleName())
                .setTypeArguments(new ClassOrInterfaceType().setName(getTypeMapperName(type)));
        declaration.addMethod("newDeserializer", Modifier.Keyword.PROTECTED)
                .addAnnotation(Override.class)
                .setType(returnType)
                .getBody().ifPresent(body -> body.addStatement(new ReturnStmt(addObjectCreationExpr(type,
                                                                                                    returnType,
                                                                                                    new ObjectCreationExpr()
                                                                                                            .setType(context.getTypeUtils()
                                                                                                                             .deserializerName(getTypeName(type)))))));
    }

    @Override
    protected String getMapperName(TypeElement type) {
        return (type.getEnclosingElement().getKind().equals(ElementKind.PACKAGE) ? "" :
                MoreElements.asType(type.getEnclosingElement()).getSimpleName().toString() + "_")
                + type.getSimpleName() + MAPPER_IMPL;
    }

    private Expression addObjectCreationExpr(BeanDefinition type, ClassOrInterfaceType returnType, ObjectCreationExpr creationExpr) {
        if (type.getElement().getKind().isClass()) {
            return creationExpr;
        }
        return new CastExpr().setType(returnType).setExpression(creationExpr);
    }

    private TypeMirror getTypeName(BeanDefinition type) {
        return type.getBean();
    }

    @Override
    protected void addTypeParam(BeanDefinition type, ClassOrInterfaceDeclaration declaration) {
        if (!type.getElement().getKind().isClass()) {
            declaration.getTypeParameters().add(new TypeParameter().setName(new SimpleName("T extends " + type.getElement().getSimpleName())));
        }
    }
}
