package org.treblereel.gwt.jackson.serializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ArrayAccessExpr;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NullLiteralExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.AbstractBeanXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.BeanPropertySerializer;
import org.treblereel.gwt.jackson.api.utils.Pair;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.definition.BeanDefinition;
import org.treblereel.gwt.jackson.definition.PropertyDefinition;
import org.treblereel.gwt.jackson.generator.AbstractGenerator;
import org.treblereel.gwt.jackson.logger.TreeLogger;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/18/20
 */
public class SerializerGenerator extends AbstractGenerator {

    public SerializerGenerator(GenerationContext context, TreeLogger logger) {
        super(context, logger.branch(TreeLogger.INFO, "Serializers generation started"));
    }

    @Override
    protected String getMapperName(TypeElement type) {
        return context.getTypeUtils().serializerName(type.asType());
    }

    @Override
    protected void configureClassType(BeanDefinition type) {
        cu.addImport(XMLSerializationContext.class);
        cu.addImport(XMLSerializer.class);
        cu.addImport(AbstractBeanXMLSerializer.class);
        cu.addImport(Pair.class);
        cu.addImport(List.class);
        cu.addImport(BeanPropertySerializer.class);
        cu.addImport(XMLSerializer.class);
        cu.addImport(type.getQualifiedName());

        declaration.getExtendedTypes().add(new ClassOrInterfaceType()
                                                   .setName(AbstractBeanXMLSerializer.class.getSimpleName())
                                                   .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName())));
    }

    @Override
    protected void getType(BeanDefinition type) {
        getSerializedType(type);
        getXmlRootElement(type);
        getXmlNs(type);
        getSchemaLocation(type);
        getDefaultNamespace(type);
        getTargetNamespace(type);
        getXsiType(type);
    }

    private void getSerializedType(BeanDefinition type) {
        declaration.addMethod("getSerializedType", Modifier.Keyword.PUBLIC)
                .addAnnotation(Override.class)
                .setType(Class.class)
                .getBody().ifPresent(body -> body.addStatement(new ReturnStmt(
                new FieldAccessExpr(
                        new NameExpr(type.getSimpleName()), "class"))));
    }

    private void getXmlRootElement(BeanDefinition type) {
        if (type.getXmlRootElement() != null) {
            declaration.addMethod("getXmlRootElement", Modifier.Keyword.PROTECTED)
                    .addAnnotation(Override.class)
                    .setType(String.class)
                    .getBody().ifPresent(body -> body.addStatement(new ReturnStmt(
                    new StringLiteralExpr(type.getXmlRootElement()))));
        }
    }

    private void getXmlNs(BeanDefinition beanDefinition) {
        declaration.addMethod("getXmlNs", Modifier.Keyword.PROTECTED)
                .addAnnotation(Override.class)
                .setType(new ClassOrInterfaceType().setName(List.class.getSimpleName())
                                 .setTypeArguments(new ClassOrInterfaceType().setName(Pair.class.getSimpleName()).setTypeArguments(
                                         new ClassOrInterfaceType().setName(
                                                 String.class.getSimpleName()),
                                         new ClassOrInterfaceType().setName(
                                                 String.class.getSimpleName()))))
                .getBody()
                .ifPresent(body -> getXmlNsStatement(beanDefinition, body));
    }

    private void getSchemaLocation(BeanDefinition type) {
        if (type.getSchemaLocation() != null) {
            declaration.addMethod("getSchemaLocation", Modifier.Keyword.PUBLIC)
                    .addAnnotation(Override.class)
                    .setType(String.class)
                    .getBody().ifPresent(body -> body.addStatement(
                    new ReturnStmt(new StringLiteralExpr(type.getSchemaLocation())))
            );
        }
    }

    private void getDefaultNamespace(BeanDefinition type) {
        String namespace = type.getNamespace();
        if (namespace != null) {
            declaration.addMethod("getNamespace", Modifier.Keyword.PROTECTED)
                    .addAnnotation(Override.class)
                    .setType(String.class)
                    .getBody().ifPresent(body -> body.addStatement(new ReturnStmt(
                    new StringLiteralExpr(namespace))));
        }
    }

    //TODO
    private void getTargetNamespace(BeanDefinition type) {
        cu.addImport(Pair.class);
        Pair<String, String> targetNamespace = type.getTargetNamespace();
        Expression result;
        ClassOrInterfaceType pair = new ClassOrInterfaceType()
                .setName("Pair")
                .setTypeArguments(new ClassOrInterfaceType().setName("String"),
                                  new ClassOrInterfaceType().setName("String"));
        if (targetNamespace == null) {
            result = new NullLiteralExpr();
        } else {
            result = new ObjectCreationExpr().setType(pair)
                    .addArgument(new StringLiteralExpr(targetNamespace.key))
                    .addArgument(new StringLiteralExpr(targetNamespace.value));
        }
        declaration.addMethod("getTargetNamespace", Modifier.Keyword.PROTECTED)
                .addAnnotation(Override.class)
                .setType(pair)
                .getBody().ifPresent(body -> body.addStatement(
                new ReturnStmt(result)));
    }

    private void getXsiType(BeanDefinition type) {
        if (type.getXsiType() != null) {
            declaration.addMethod("getXmlXsiType", Modifier.Keyword.PUBLIC)
                    .addAnnotation(Override.class)
                    .setType(String.class)
                    .getBody().ifPresent(body -> body.addStatement(
                    new ReturnStmt(new StringLiteralExpr(type.getXsiType())))
            );
        }
    }

    private void getXmlNsStatement(BeanDefinition beanDefinition, BlockStmt body) {
        if (beanDefinition.getXmlNs().isEmpty()) {
            cu.addImport(Collections.class);
            body.addStatement(new ReturnStmt(new MethodCallExpr(new NameExpr("Collections"), "emptyList")));
        } else {
            cu.addImport(ArrayList.class);
            body.addAndGetStatement(new AssignExpr().setTarget(new VariableDeclarationExpr(
                    new ClassOrInterfaceType()
                            .setName("List<Pair<String, String>>"),
                    "result")).setValue(new NameExpr("new ArrayList<>()")));
            beanDefinition.getXmlNs().forEach(pair -> {
                body.addStatement(new MethodCallExpr(new NameExpr("result"), "add")
                                          .addArgument(new ObjectCreationExpr().setType(
                                                  new ClassOrInterfaceType().setName("Pair")
                                                          .setTypeArguments(new ClassOrInterfaceType().setName("String"),
                                                                            new ClassOrInterfaceType().setName("String")))
                                                               .addArgument(pair.key != null ? new StringLiteralExpr(pair.key)
                                                                                    : new NullLiteralExpr())
                                                               .addArgument(new StringLiteralExpr(pair.value))));
            });

            body.addAndGetStatement(new ReturnStmt(new NameExpr().setName("result")));
        }
    }

    @Override
    protected void init(BeanDefinition beanDefinition) {
        logger.log(TreeLogger.INFO, "Generating " + context.getTypeUtils().serializerName(beanDefinition.getBean()));
        MethodDeclaration initSerializers = declaration.addMethod("initSerializers", Modifier.Keyword.PROTECTED);
        initSerializers.addAnnotation(Override.class)
                .setType(BeanPropertySerializer[].class)
                .getBody().ifPresent(body -> processInitSerializersMethodBody(body, beanDefinition));
    }

    private void processInitSerializersMethodBody(BlockStmt body, BeanDefinition beanDefinition) {

        List<PropertyDefinition> fields = beanDefinition.getFields().stream().collect(Collectors.toList());
        addBeanPropertySerializerDeclaration(body, fields);

        for (int i = 0; i < fields.size(); i++) {
            addBeanPropertySerializer(body, beanDefinition, fields.get(i), i);
        }

        body.addStatement(new ReturnStmt(new NameExpr("result")));
    }

    private void addBeanPropertySerializerDeclaration(BlockStmt body, List<PropertyDefinition> fields) {
        VariableDeclarator result = new VariableDeclarator();
        result.setType("BeanPropertySerializer[]");
        result.setName("result");
        result.setInitializer("new BeanPropertySerializer[" + fields.size() + "]");
        ExpressionStmt expressionStmt = new ExpressionStmt();
        VariableDeclarationExpr variableDeclarationExpr = new VariableDeclarationExpr();

        expressionStmt.setExpression(variableDeclarationExpr);
        variableDeclarationExpr.getVariables().add(result);
        body.addStatement(variableDeclarationExpr);
    }

    private void addBeanPropertySerializer(BlockStmt body, BeanDefinition beanDefinition, PropertyDefinition variableElement, int i) {
        ObjectCreationExpr beanProperty = new ObjectCreationExpr();
        ClassOrInterfaceType beanType = new ClassOrInterfaceType()
                .setName(BeanPropertySerializer.class.getSimpleName());

        beanProperty.setType(beanType);
        beanProperty.addArgument(new StringLiteralExpr(variableElement.getPropertyName()));
        if (variableElement.isCData()) {
            beanProperty.addArgument(new BooleanLiteralExpr(true));
        }
        setTypeParams(beanDefinition, variableElement, beanType);

        body.addStatement(new AssignExpr().setTarget(
                new ArrayAccessExpr(new NameExpr("result"),
                                    new IntegerLiteralExpr(i))).setValue(
                beanProperty));

        addMethods(beanProperty, beanDefinition, variableElement);
    }

    private void setTypeParams(BeanDefinition beanDefinition, PropertyDefinition variableElement, ClassOrInterfaceType beanType) {
        NodeList<Type> typeArguments = new NodeList<>();
        typeArguments.add(new ClassOrInterfaceType().setName(beanDefinition.getSimpleName()));

        String fieldType;
        if (variableElement.getBean().getKind().isPrimitive()) {
            fieldType = TypeUtils.wrapperType(variableElement.getBean());
        } else if (variableElement.getBean().getKind().equals(TypeKind.ARRAY)) {
            ArrayType arrayType = (ArrayType) variableElement.getBean();
            fieldType = arrayType.toString();
        } else {
            fieldType = typeUtils.toTypeElement(variableElement.getBean()).toString();
        }

        ClassOrInterfaceType interfaceType = new ClassOrInterfaceType();
        interfaceType.setName(fieldType);

        addTypeArguments(variableElement.getBean(), interfaceType);
        typeArguments.add(interfaceType);
        beanType.setTypeArguments(typeArguments);
    }

    private void addMethods(ObjectCreationExpr beanProperty, BeanDefinition beanDefinition, PropertyDefinition propertyDefinition) {
        NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();
        beanProperty.setAnonymousClassBody(anonymousClassBody);

        newSerializer(anonymousClassBody, propertyDefinition);
        getValue(anonymousClassBody, beanDefinition, propertyDefinition);
        isAttribute(anonymousClassBody, propertyDefinition);
        getNamespace(anonymousClassBody, propertyDefinition);
        getPrefix(anonymousClassBody, beanDefinition, propertyDefinition);
    }

    private void addTypeArguments(TypeMirror type, ClassOrInterfaceType interfaceType) {
        if (type instanceof DeclaredType) {
            if (!((DeclaredType) type).getTypeArguments().isEmpty()) {
                NodeList<Type> types = new NodeList<>();
                ((DeclaredType) type).getTypeArguments()
                        .forEach(param -> types.add(new ClassOrInterfaceType().setName(param.toString())));
                interfaceType.setTypeArguments(types);
            }
        }
    }

    private void newSerializer(NodeList<BodyDeclaration<?>> anonymousClassBody, PropertyDefinition field) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PROTECTED);
        method.addAnnotation(Override.class);
        method.setName("newSerializer");

        method.setType(new ClassOrInterfaceType().setName("XMLSerializer<?>"));

        method.getBody().ifPresent(body -> body.addAndGetStatement(
                new ReturnStmt().setExpression(field.getFieldSerializer(cu, context))));
        anonymousClassBody.add(method);
    }

    private void getValue(NodeList<BodyDeclaration<?>> anonymousClassBody, BeanDefinition bean, PropertyDefinition field) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PUBLIC);
        method.addAnnotation(Override.class);
        method.setName("getValue");
        method.addParameter(new ClassOrInterfaceType().setName(bean.getSimpleName()), "bean");
        method.addParameter(XMLSerializationContext.class.getSimpleName(), "ctx");

        ClassOrInterfaceType interfaceType = new ClassOrInterfaceType().setName(TypeUtils.wrapperType(field.getBean()));
        addTypeArguments(field.getBean(), interfaceType);

        method.setType(interfaceType);
        method.getBody().ifPresent(body -> body.addAndGetStatement(
                new ReturnStmt(getFieldAccessor(field))));
        anonymousClassBody.add(method);
    }

    private void isAttribute(NodeList<BodyDeclaration<?>> anonymousClassBody, PropertyDefinition propertyDefinition) {
        if (propertyDefinition.isAttribute()) {
            MethodDeclaration method = new MethodDeclaration();
            method.setModifiers(Modifier.Keyword.PROTECTED);
            method.addAnnotation(Override.class);
            method.setName("isAttribute");
            method.setType(new ClassOrInterfaceType().setName("boolean"));

            method.getBody().ifPresent(body -> body.addAndGetStatement(
                    new ReturnStmt().setExpression(new BooleanLiteralExpr(true))));
            anonymousClassBody.add(method);
        }
    }

    private void getNamespace(NodeList<BodyDeclaration<?>> anonymousClassBody, PropertyDefinition field) {
        if (field.getNamespace() != null) {
            MethodDeclaration method = new MethodDeclaration();
            method.setModifiers(Modifier.Keyword.PROTECTED);
            method.addAnnotation(Override.class);
            method.setName("getNamespace");
            method.setType(new ClassOrInterfaceType().setName("String"));

            method.getBody().ifPresent(body -> body.addAndGetStatement(
                    new ReturnStmt().setExpression(new StringLiteralExpr(field.getNamespace()))));
            anonymousClassBody.add(method);
        }
    }

    private void getPrefix(NodeList<BodyDeclaration<?>> anonymousClassBody, BeanDefinition beanDefinition, PropertyDefinition propertyDefinition) {
        String prefix = null;
        if (propertyDefinition.getNamespace() != null) {
            for (Pair<String, String> xmlN : beanDefinition.getXmlNs()) {
                if (xmlN.value.equals(propertyDefinition.getNamespace()) && xmlN.key != null) {
                    prefix = xmlN.key;
                    break;
                }
            }
            if (prefix == null) {
                if (beanDefinition.getTargetNamespace() != null &&
                        beanDefinition.getTargetNamespace().value.equals(propertyDefinition.getNamespace())) {
                    prefix = beanDefinition.getTargetNamespace().key;
                }
            }
        }

        if (prefix != null) {
            MethodDeclaration method = new MethodDeclaration();
            method.setModifiers(Modifier.Keyword.PROTECTED);
            method.addAnnotation(Override.class);
            method.setName("getPrefix");
            method.setType(new ClassOrInterfaceType().setName("String"));

            String finalPrefix = prefix;
            method.getBody().ifPresent(body -> body.addAndGetStatement(
                    new ReturnStmt().setExpression(new StringLiteralExpr(finalPrefix))));
            anonymousClassBody.add(method);
        }
    }

    private Expression getFieldAccessor(PropertyDefinition field) {
        if (typeUtils.hasGetter(field.getProperty())) {
            return new MethodCallExpr(
                    new NameExpr("bean"), typeUtils.getGetter(field.getProperty()).getSimpleName().toString());
        } else {
            return new FieldAccessExpr(new NameExpr("bean"), field.getProperty().getSimpleName().toString());
        }
    }
}
