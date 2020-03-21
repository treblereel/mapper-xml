package org.treblereel.gwt.jackson.deserializer;

import java.util.Map;

import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.api.JacksonContextProvider;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.deser.bean.AbstractBeanXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.bean.BeanPropertyDeserializer;
import org.treblereel.gwt.jackson.api.deser.bean.HasDeserializerAndParameters;
import org.treblereel.gwt.jackson.api.deser.bean.Instance;
import org.treblereel.gwt.jackson.api.deser.bean.InstanceBuilder;
import org.treblereel.gwt.jackson.api.deser.bean.MapLike;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.generator.AbstractGenerator;
import org.treblereel.gwt.jackson.logger.TreeLogger;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/18/20
 */
public class DeserializerGenerator extends AbstractGenerator {

    public DeserializerGenerator(GenerationContext context, TreeLogger logger) {
        super(context, logger.branch(TreeLogger.INFO, "Deserializers generation started"));
    }

    @Override
    protected String getMapperName(TypeElement type) {
        return context.getTypeUtils().deserializerName(type.asType());
    }

    @Override
    protected void configureClassType(TypeElement type) {
        cu.addImport(JacksonContextProvider.class);
        cu.addImport(XMLDeserializationContext.class);
        cu.addImport(XMLDeserializer.class);
        cu.addImport(XMLDeserializerParameters.class);
        cu.addImport(AbstractBeanXMLDeserializer.class);
        cu.addImport(BeanPropertyDeserializer.class);
        cu.addImport(HasDeserializerAndParameters.class);
        cu.addImport(Instance.class);
        cu.addImport(Map.class);
        cu.addImport(MapLike.class);
        cu.addImport(InstanceBuilder.class);
        cu.addImport(XMLReader.class);
        cu.addImport(type.getQualifiedName().toString());

        declaration.getExtendedTypes().add(new ClassOrInterfaceType()
                                                   .setName(AbstractBeanXMLDeserializer.class.getSimpleName())
                                                   .setTypeArguments(new ClassOrInterfaceType()
                                                                             .setName(type.getSimpleName().toString())
                                                   ));
    }

    @Override
    protected void getType(TypeElement type) {
        declaration.addMethod("getDeserializedType", Modifier.Keyword.PUBLIC)
                .addAnnotation(Override.class)
                .setType(Class.class)
                .getBody().ifPresent(body -> body.addStatement(new ReturnStmt(
                new FieldAccessExpr(
                        new NameExpr(type.getSimpleName().toString()), "class"))));
    }

    @Override
    protected void init(TypeElement type) {
        initDeserializers(type);
        initInstanceBuilder(type);
    }

    private void initDeserializers(TypeElement type) {
        MethodDeclaration initSerializers = declaration.addMethod("initDeserializers", Modifier.Keyword.PROTECTED);

        initSerializers.addAnnotation(Override.class)
                .setType(new ClassOrInterfaceType()
                                 .setName(MapLike.class.getSimpleName())
                                 .setTypeArguments(new ClassOrInterfaceType()
                                                           .setName(BeanPropertyDeserializer.class.getSimpleName())
                                                           .setTypeArguments(new ClassOrInterfaceType()
                                                                                     .setName(type.getSimpleName().toString()),
                                                                             new ClassOrInterfaceType()
                                                                                     .setName("?"))
                                 )
                );
        ClassOrInterfaceType varType = new ClassOrInterfaceType().setName("MapLike")
                .setTypeArguments(new ClassOrInterfaceType().setName("BeanPropertyDeserializer")
                .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName().toString()),
                                  new ClassOrInterfaceType().setName("?")));

        VariableDeclarator map = new VariableDeclarator();
        map.setType(varType);
        map.setName("map");
        map.setInitializer(new NameExpr("JacksonContextProvider.get().mapLikeFactory().make()"));

        ExpressionStmt expressionStmt = new ExpressionStmt();
        VariableDeclarationExpr variableDeclarationExpr = new VariableDeclarationExpr();
        variableDeclarationExpr.setModifiers(Modifier.Keyword.FINAL);
        expressionStmt.setExpression(variableDeclarationExpr);
        variableDeclarationExpr.getVariables().add(map);

        initSerializers.getBody().ifPresent(body -> {
            body.addStatement(expressionStmt);
            getFields(type).forEach(field -> addBeanPropertyDeserializer(body, type, field));
            body.addStatement(new ReturnStmt("map"));
        });
    }

    private void initInstanceBuilder(TypeElement type) {
        MethodDeclaration initInstanceBuilder = declaration.addMethod("initInstanceBuilder", Modifier.Keyword.PROTECTED);
        initInstanceBuilder.addAnnotation(Override.class)
                .setType(new ClassOrInterfaceType()
                                 .setName(InstanceBuilder.class.getSimpleName())
                                 .setTypeArguments(new ClassOrInterfaceType()
                                                           .setName(type.getSimpleName().toString())));
        VariableDeclarator deserializers = new VariableDeclarator();
        deserializers.setType("MapLike<HasDeserializerAndParameters>");
        deserializers.setName("deserializers");
        deserializers.setInitializer("null");

        ExpressionStmt expressionStmt = new ExpressionStmt();
        VariableDeclarationExpr variableDeclarationExpr = new VariableDeclarationExpr();
        variableDeclarationExpr.setModifiers(Modifier.Keyword.FINAL);
        expressionStmt.setExpression(variableDeclarationExpr);
        variableDeclarationExpr.getVariables().add(deserializers);

        initInstanceBuilder.getBody().ifPresent(body -> {
            body.addStatement(variableDeclarationExpr);
            addInstanceBuilder(type, body);
        });
    }

    private void addBeanPropertyDeserializer(BlockStmt body, TypeElement type, VariableElement field) {
        NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();

        ClassOrInterfaceType typeArg = getWrappedType(field);
        ClassOrInterfaceType beanPropertyDeserializer = new ClassOrInterfaceType()
                .setName(BeanPropertyDeserializer.class.getSimpleName());
        beanPropertyDeserializer.setTypeArguments(
                new ClassOrInterfaceType().setName(type.getSimpleName().toString()),
                typeArg);

        body.addStatement(new MethodCallExpr(new NameExpr("map"), "put")
                                  .addArgument(new StringLiteralExpr(field.getSimpleName().toString()))
                                  .addArgument(new ObjectCreationExpr()
                                                       .setType(beanPropertyDeserializer)
                                                       .setAnonymousClassBody(anonymousClassBody)
                                  ));
        addNewDeserializer(type, field, anonymousClassBody);
        setValue(type, typeArg, field, anonymousClassBody);
    }

    private void addInstanceBuilder(TypeElement type, BlockStmt body) {
        ObjectCreationExpr instanceBuilder = new ObjectCreationExpr();
        ClassOrInterfaceType instanceBuilderType = new ClassOrInterfaceType()
                .setName(InstanceBuilder.class.getSimpleName())
                .setTypeArguments(new ClassOrInterfaceType()
                                          .setName(type.getSimpleName().toString()));

        instanceBuilder.setType(instanceBuilderType);
        NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();
        instanceBuilder.setAnonymousClassBody(anonymousClassBody);

        newInstance(type, anonymousClassBody);
        getParametersDeserializer(anonymousClassBody);
        create(type, anonymousClassBody);

        body.addStatement(new ReturnStmt(instanceBuilder));
    }

    private ClassOrInterfaceType getWrappedType(VariableElement field) {
        ClassOrInterfaceType typeArg = new ClassOrInterfaceType().setName(typeUtils.wrapperType(field.asType()));
        if (field.asType() instanceof DeclaredType) {
            if (!((DeclaredType) field.asType()).getTypeArguments().isEmpty()) {
                NodeList<Type> types = new NodeList<>();
                ((DeclaredType) field.asType()).getTypeArguments().forEach(t -> {
                    types.add(new ClassOrInterfaceType().setName(typeUtils.wrapperType(t)));
                });
                typeArg.setTypeArguments(types);
            }
        }
        return typeArg;
    }

    private void addNewDeserializer(TypeElement type, VariableElement field, NodeList<BodyDeclaration<?>> anonymousClassBody) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PROTECTED);
        method.addAnnotation(Override.class);
        method.setName("newDeserializer");
        method.setType(new ClassOrInterfaceType().setName("XMLDeserializer<?>"));

        method.getBody().get().addAndGetStatement(new ReturnStmt().setExpression(getDeserializerExpression(field.asType())));
        anonymousClassBody.add(method);
    }

    private Expression getDeserializerExpression(TypeMirror type) {
        if (typeUtils.isBasicType(type)) {
            return new MethodCallExpr(
                    new NameExpr(context.getTypeRegistry()
                                         .getDeserializer(context.getProcessingEnv().getTypeUtils().erasure(type)).toString()), "getInstance");
        } else {
            if (context.getTypeRegistry().get(context.getProcessingEnv()
                                                      .getTypeUtils().erasure(type).toString()) == null) {
                return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                                .setName(typeUtils.canonicalDeserializerName(typeUtils.getPackage(type), type)));
            } else {
                TypeElement serializer = context.getTypeRegistry().getDeserializer(context.getProcessingEnv().getTypeUtils().erasure(type));

                MethodCallExpr method = new MethodCallExpr(
                        new NameExpr(serializer.getQualifiedName().toString()), "newInstance");
                if (typeUtils.isCollection(type)) {
                    MoreTypes.asDeclared(type).getTypeArguments().forEach(param -> {
                        method.addArgument(getDeserializerExpression(param));
                    });
                }
                return method;
            }
        }
    }

    private void setValue(TypeElement type, ClassOrInterfaceType fieldType, VariableElement field, NodeList<BodyDeclaration<?>> anonymousClassBody) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PUBLIC);
        method.addAnnotation(Override.class);
        method.setName("setValue");
        method.setType("void");
        method.addParameter(type.getSimpleName().toString(), "bean");
        method.addParameter(fieldType, "value");
        method.addParameter("XMLDeserializationContext", "ctx");

        method.getBody().get()
                .addAndGetStatement(new MethodCallExpr(
                        new NameExpr("bean"), typeUtils.getSetter(field).getSimpleName().toString()).addArgument("value"));
        anonymousClassBody.add(method);
    }

    private void newInstance(TypeElement type, NodeList<BodyDeclaration<?>> anonymousClassBody) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PUBLIC);
        method.addAnnotation(Override.class);
        method.setName("newInstance");
        method.setType(new ClassOrInterfaceType().setName("Instance")
                               .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName().toString())));
        addParameter(method, "XMLReader", "reader");
        addParameter(method, "XMLDeserializationContext", "ctx");
        addParameter(method, "XMLDeserializerParameters", "params");
        addParameter(method, "Map<String, String>", "bufferedProperties");
        addParameter(method, "Map<String, Object>", "bufferedPropertiesValues");

        ObjectCreationExpr instanceBuilder = new ObjectCreationExpr();
        ClassOrInterfaceType instanceBuilderType = new ClassOrInterfaceType()
                .setName(Instance.class.getSimpleName())
                .setTypeArguments(new ClassOrInterfaceType()
                                          .setName(type.getSimpleName().toString()));

        instanceBuilder.setType(instanceBuilderType);
        instanceBuilder.addArgument(new MethodCallExpr("create"));
        instanceBuilder.addArgument("bufferedProperties");

        method.getBody().get().addAndGetStatement(new ReturnStmt().setExpression(instanceBuilder));
        anonymousClassBody.add(method);
    }

    private void getParametersDeserializer(NodeList<BodyDeclaration<?>> anonymousClassBody) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PUBLIC);
        method.addAnnotation(Override.class);
        method.setName("getParametersDeserializer");
        method.setType(new ClassOrInterfaceType().setName("MapLike")
                               .setTypeArguments(new ClassOrInterfaceType()
                                                         .setName("HasDeserializerAndParameters")));
        method.getBody().get().addAndGetStatement(new ReturnStmt().setExpression(new NameExpr("deserializers")));
        anonymousClassBody.add(method);
    }

    private void create(TypeElement type, NodeList<BodyDeclaration<?>> anonymousClassBody) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PRIVATE);
        method.setName("create");
        method.setType(new ClassOrInterfaceType().setName(type.getSimpleName().toString()));

        ObjectCreationExpr instanceBuilder = new ObjectCreationExpr();
        ClassOrInterfaceType instanceBuilderType = new ClassOrInterfaceType()
                .setName(type.getSimpleName().toString());
        instanceBuilder.setType(instanceBuilderType);

        method.getBody().get().addAndGetStatement(new ReturnStmt().setExpression(instanceBuilder));
        anonymousClassBody.add(method);
    }

    private void addParameter(MethodDeclaration method, String type, String name) {
        method.addParameter(new ClassOrInterfaceType().setName(type), name);
    }
}
