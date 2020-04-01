package org.treblereel.gwt.jackson.deserializer;

import java.util.Map;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.CastExpr;
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
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.api.JacksonContextProvider;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.deser.EnumXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.array.ArrayXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.bean.AbstractBeanXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.bean.BeanPropertyDeserializer;
import org.treblereel.gwt.jackson.api.deser.bean.HasDeserializerAndParameters;
import org.treblereel.gwt.jackson.api.deser.bean.Instance;
import org.treblereel.gwt.jackson.api.deser.bean.InstanceBuilder;
import org.treblereel.gwt.jackson.api.deser.bean.MapLike;
import org.treblereel.gwt.jackson.api.deser.map.MapXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.map.key.EnumKeyDeserializer;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.exception.GenerationException;
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
        addNewDeserializer(field, anonymousClassBody);
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
        ClassOrInterfaceType typeArg = new ClassOrInterfaceType().setName(TypeUtils.wrapperType(field.asType()));
        if (field.asType() instanceof DeclaredType) {
            if (!((DeclaredType) field.asType()).getTypeArguments().isEmpty()) {
                NodeList<Type> types = new NodeList<>();
                ((DeclaredType) field.asType()).getTypeArguments()
                        .forEach(t -> types.add(new ClassOrInterfaceType().setName(TypeUtils.wrapperType(t))));
                typeArg.setTypeArguments(types);
            }
        }
        return typeArg;
    }

    private void addNewDeserializer(VariableElement field, NodeList<BodyDeclaration<?>> anonymousClassBody) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PROTECTED);
        method.addAnnotation(Override.class);
        method.setName("newDeserializer");
        method.setType(new ClassOrInterfaceType().setName("XMLDeserializer<?>"));

        method.getBody().ifPresent(body -> body.addAndGetStatement(
                new ReturnStmt().setExpression(getFieldDeserializer(field.asType()))));
        anonymousClassBody.add(method);
    }

    private Expression getFieldDeserializer(TypeMirror typeMirror) {
        typeMirror = context.getTypeUtils().removeOuterWildCards(typeMirror);
        if (typeUtils.isBasicType(typeMirror)) {
            return getBasicOrCustomDeserializer(typeMirror);
        }
        if (context.getTypeUtils().isIterable(typeMirror)) {
            return getIterableDeserializer(typeMirror);
        }
        if (context.getTypeUtils().isMap(typeMirror)) {
            return getMapDeserializer(typeMirror);
        }
        if (context.getTypeUtils().isArray(typeMirror)) {
            return getArrayDeserializer(typeMirror);
        }
        if (!typeMirror.getKind().isPrimitive() &&
                MoreTypes.asElement(typeMirror).getKind().equals(ElementKind.ENUM)) {
            return getEnumDeserializer(typeMirror);
        }
        return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                        .setName(typeUtils.canonicalDeserializerName(typeUtils.getPackage(typeMirror), typeMirror)));

    }

    private Expression getBasicOrCustomDeserializer(TypeMirror typeMirror) {
            return new MethodCallExpr(
                    new NameExpr(context.getTypeRegistry()
                                         .getDeserializer(typeMirror).toString()), "getInstance");
    }

    private Expression getEnumDeserializer(TypeMirror typeMirror) {
        return new MethodCallExpr(new NameExpr(EnumXMLDeserializer.class.getCanonicalName()), "newInstance")
                .addArgument(MoreTypes.asTypeElement(typeMirror).getQualifiedName().toString() + ".class");
    }

    private Expression getArrayDeserializer(TypeMirror typeMirror) {
        cu.addImport(ArrayXMLDeserializer.ArrayCreator.class);
        cu.addImport(ArrayXMLDeserializer.class);

        ArrayType array = (ArrayType) typeMirror;
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
                .addArgument(getFieldDeserializer(array.getComponentType()))
                .addArgument(new CastExpr().setType(typeOf).setExpression(
                        new NameExpr(arrayType + "[]::new")));
    }

    private Expression getMapDeserializer(TypeMirror typeMirror) {
        DeclaredType declaredType = MoreTypes.asDeclared(typeMirror);
        if (declaredType.getTypeArguments().size() != 2) {
            throw new GenerationException(declaredType.toString() + " must have type args [" + typeMirror + "]");
        }
        MethodCallExpr deserializer;
        if (MoreTypes.asElement(declaredType.getTypeArguments().get(0)).getKind().equals(ElementKind.ENUM)) {
            deserializer = new MethodCallExpr(
                    new NameExpr(EnumKeyDeserializer.class.getCanonicalName()), "getInstance")
                    .addArgument(declaredType.getTypeArguments().get(0).toString() + ".class");
        } else {
            deserializer = new MethodCallExpr(
                    new NameExpr(context.getTypeRegistry()
                                         .getKeyDeserializer(declaredType.getTypeArguments().get(0).toString())
                                         .getQualifiedName().toString()), "getInstance");
        }
        return new MethodCallExpr(
                new NameExpr(MapXMLDeserializer.class.getCanonicalName()), "newInstance")
                .addArgument(deserializer)
                .addArgument(getFieldDeserializer(declaredType.getTypeArguments().get(1)));
    }

    private Expression getIterableDeserializer(TypeMirror typeMirror) {
        TypeElement serializer = context.getTypeRegistry().getDeserializer(context.getProcessingEnv().getTypeUtils().erasure(typeMirror));

        MethodCallExpr method = new MethodCallExpr(
                new NameExpr(serializer.getQualifiedName().toString()), "newInstance");
        MoreTypes.asDeclared(typeMirror)
                .getTypeArguments()
                .forEach(param ->
                                 method.addArgument(getFieldDeserializer(param)));
        return method;
    }

    private void setValue(TypeElement type, ClassOrInterfaceType fieldType, VariableElement field, NodeList<BodyDeclaration<?>> anonymousClassBody) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PUBLIC);
        method.addAnnotation(Override.class);
        method.setName("setValue");
        method.setType("void");
        method.addParameter(type.getSimpleName().toString(), "bean");
        method.addParameter(fieldType, "value");
        method.addParameter(XMLDeserializationContext.class.getSimpleName(), "ctx");

        method.getBody().ifPresent(body -> body.addAndGetStatement(
                new MethodCallExpr(
                        new NameExpr("bean"), typeUtils.getSetter(field).getSimpleName().toString()).addArgument("value")));
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

        method.getBody().ifPresent(body -> body.addAndGetStatement(new ReturnStmt().setExpression(instanceBuilder)));
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
        method.getBody().ifPresent(body -> body.addAndGetStatement(new ReturnStmt().setExpression(new NameExpr("deserializers"))));
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

        method.getBody().ifPresent(body -> body.addAndGetStatement(new ReturnStmt().setExpression(instanceBuilder)));
        anonymousClassBody.add(method);
    }

    private void addParameter(MethodDeclaration method, String type, String name) {
        method.addParameter(new ClassOrInterfaceType().setName(type), name);
    }
}
