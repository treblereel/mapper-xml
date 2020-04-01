package org.treblereel.gwt.jackson.serializer;

import java.util.List;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
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
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
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
import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.ser.EnumXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.array.ArrayXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.array.dd.Array2dXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.AbstractBeanXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.bean.BeanPropertySerializer;
import org.treblereel.gwt.jackson.api.ser.map.MapXMLSerializer;
import org.treblereel.gwt.jackson.api.ser.map.key.EnumKeySerializer;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.exception.GenerationException;
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
    protected void configureClassType(TypeElement type) {
        cu.addImport(XMLSerializationContext.class);
        cu.addImport(XMLSerializer.class);
        cu.addImport(AbstractBeanXMLSerializer.class);
        cu.addImport(BeanPropertySerializer.class);
        cu.addImport(XMLSerializer.class);
        cu.addImport(type.getQualifiedName().toString());

        declaration.getExtendedTypes().add(new ClassOrInterfaceType()
                                                   .setName(AbstractBeanXMLSerializer.class.getSimpleName())
                                                   .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName().toString())));
    }

    @Override
    protected void getType(TypeElement type) {
        declaration.addMethod("getSerializedType", Modifier.Keyword.PUBLIC)
                .addAnnotation(Override.class)
                .setType(Class.class)
                .getBody().ifPresent(body -> body.addStatement(new ReturnStmt(
                new FieldAccessExpr(
                        new NameExpr(type.getSimpleName().toString()), "class"))));
    }

    @Override
    protected void init(TypeElement type) {
        List<VariableElement> fields = getFields(type);
        MethodDeclaration initSerializers = declaration.addMethod("initSerializers", Modifier.Keyword.PROTECTED);
        initSerializers.addAnnotation(Override.class)
                .setType(BeanPropertySerializer[].class)
                .getBody().ifPresent(body -> processInitSerializersMethodBody(body, type, fields));
    }

    private void processInitSerializersMethodBody(BlockStmt body, TypeElement type, List<VariableElement> fields) {
        addBeanPropertySerializerDeclaration(body, fields);
        for (int i = 0; i < fields.size(); i++) {
            addBeanPropertySerializer(body, type, fields.get(i), i);
        }

        body.addStatement(new ReturnStmt(new NameExpr("result")));
    }

    private void addBeanPropertySerializerDeclaration(BlockStmt body, List<VariableElement> fields) {
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

    private void addBeanPropertySerializer(BlockStmt body, TypeElement type, VariableElement variableElement, int i) {
        ObjectCreationExpr beanProperty = new ObjectCreationExpr();
        ClassOrInterfaceType beanType = new ClassOrInterfaceType()
                .setName(BeanPropertySerializer.class.getSimpleName());

        beanProperty.setType(beanType);
        beanProperty.addArgument(new StringLiteralExpr(variableElement.getSimpleName().toString()));
        setTypeParams(type, variableElement, beanType);

        body.addStatement(new AssignExpr().setTarget(
                new ArrayAccessExpr(new NameExpr("result"),
                                    new IntegerLiteralExpr(i))).setValue(
                beanProperty));

        addMethods(beanProperty, type, variableElement);
    }

    private void setTypeParams(TypeElement type, VariableElement variableElement, ClassOrInterfaceType beanType) {
        NodeList<Type> typeArguments = new NodeList<>();
        typeArguments.add(new ClassOrInterfaceType().setName(type.getSimpleName().toString()));

        String fieldType;
        if (variableElement.asType().getKind().isPrimitive()) {
            fieldType = TypeUtils.wrapperType(variableElement.asType());
        } else if (variableElement.asType().getKind().equals(TypeKind.ARRAY)) {
            ArrayType arrayType = (ArrayType) variableElement.asType();
            fieldType = arrayType.toString();
        } else {
            fieldType = typeUtils.toTypeElement(variableElement.asType()).toString();
        }

        ClassOrInterfaceType interfaceType = new ClassOrInterfaceType();
        interfaceType.setName(fieldType);

        addTypeArguments(variableElement.asType(), interfaceType);
        typeArguments.add(interfaceType);
        beanType.setTypeArguments(typeArguments);
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

    private void addMethods(ObjectCreationExpr beanProperty, TypeElement bean, VariableElement field) {
        NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();
        beanProperty.setAnonymousClassBody(anonymousClassBody);

        newSerializer(anonymousClassBody, field);
        getValue(anonymousClassBody, bean, field);
    }

    private void newSerializer(NodeList<BodyDeclaration<?>> anonymousClassBody, VariableElement field) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PROTECTED);
        method.addAnnotation(Override.class);
        method.setName("newSerializer");
        method.setType(new ClassOrInterfaceType().setName("XMLSerializer<?>"));

        method.getBody().ifPresent(body -> body.addAndGetStatement(
                new ReturnStmt().setExpression(getSerializerExpression(field.asType(), field.getSimpleName().toString()))));
        anonymousClassBody.add(method);
    }

    private void getValue(NodeList<BodyDeclaration<?>> anonymousClassBody, TypeElement bean, VariableElement field) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PUBLIC);
        method.addAnnotation(Override.class);
        method.setName("getValue");
        method.addParameter(new ClassOrInterfaceType().setName(bean.getSimpleName().toString()), "bean");
        method.addParameter(XMLSerializationContext.class.getSimpleName(), "ctx");

        ClassOrInterfaceType interfaceType = new ClassOrInterfaceType().setName(TypeUtils.wrapperType(field.asType()));
        addTypeArguments(field.asType(), interfaceType);

        method.setType(interfaceType);
        method.getBody().ifPresent(body -> body.addAndGetStatement(
                new ReturnStmt(
                        new MethodCallExpr(
                                new NameExpr("bean"), typeUtils.getGetter(field).getSimpleName().toString()))));
        anonymousClassBody.add(method);
    }

    private Expression getFieldSerializer(TypeMirror typeMirror, String fieldName) {
        typeMirror = context.getTypeUtils().removeOuterWildCards(typeMirror);

        if (typeUtils.isBasicType(typeMirror)) {
            return getBasicOrCustomSerializer(typeMirror, fieldName);
        }
        if (context.getTypeUtils().isIterable(typeMirror)) {
            return getIterableSerializer(typeMirror, fieldName);
        }
        if (context.getTypeUtils().isMap(typeMirror)) {
            return getMapSerializer(typeMirror, fieldName);
        }
        if (context.getTypeUtils().isArray(typeMirror)) {
            return getArraySerializer(typeMirror, fieldName);
        }
        if (!typeMirror.getKind().isPrimitive() &&
                MoreTypes.asElement(typeMirror).getKind().equals(ElementKind.ENUM)) {
            return getEnumSerializer(typeMirror);
        }

        return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                        .setName(typeUtils.canonicalSerializerName(typeUtils.getPackage(typeMirror), typeMirror)));
    }

    private Expression getIterableSerializer(TypeMirror typeMirror, String fieldName) {
        TypeElement serializer = context.getTypeRegistry().getSerializer(context.getProcessingEnv().getTypeUtils().erasure(typeMirror));

        MethodCallExpr method = new MethodCallExpr(
                new NameExpr(serializer.getQualifiedName().toString()), "newInstance");
        for (TypeMirror param : MoreTypes.asDeclared(typeMirror).getTypeArguments()) {
            method.addArgument(getSerializerExpression(param, null));
        }
        method.addArgument(new StringLiteralExpr(fieldName));
        return method;
    }

    private Expression getMapSerializer(TypeMirror typeMirror, String fieldName) {
        DeclaredType declaredType = MoreTypes.asDeclared(typeMirror);
        if (declaredType.getTypeArguments().size() != 2) {
            throw new GenerationException(declaredType.toString() + " must have type args [" + fieldName + "]");
        }
        String keySerializer = null;

        if (MoreTypes.asElement(declaredType.getTypeArguments().get(0)).getKind().equals(ElementKind.ENUM)) {
            keySerializer = EnumKeySerializer.class.getCanonicalName();
        } else {
            keySerializer = context.getTypeRegistry()
                    .getKeySerializer(declaredType.getTypeArguments().get(0).toString()).getQualifiedName().toString();
        }

        return new MethodCallExpr(
                new NameExpr(MapXMLSerializer.class.getCanonicalName()), "newInstance")
                .addArgument(new MethodCallExpr(
                        new NameExpr(keySerializer), "getInstance"))
                .addArgument(getSerializerExpression(declaredType.getTypeArguments().get(1), null))
                .addArgument(new StringLiteralExpr(fieldName));
    }

    private Expression getArraySerializer(TypeMirror typeMirror, String fieldName) {
        ArrayType array = (ArrayType) typeMirror;
        String serializer = null;
        Expression expression = null;
        if (array.getComponentType().getKind().equals(TypeKind.ARRAY)) {
            serializer = Array2dXMLSerializer.class.getCanonicalName();
            ArrayType array2d = (ArrayType) array.getComponentType();

            expression = getSerializerExpression(array2d.getComponentType(), null);
        } else {
            serializer = ArrayXMLSerializer.class.getCanonicalName();
            expression = getSerializerExpression(array.getComponentType(), null);
        }
        return new MethodCallExpr(
                new NameExpr(serializer), "getInstance")
                .addArgument(expression)
                .addArgument(new StringLiteralExpr(fieldName));
    }

    private Expression getEnumSerializer(TypeMirror typeMirror) {
        return new MethodCallExpr(
                new NameExpr(EnumXMLSerializer.class.getCanonicalName()), "getInstance");
    }

    private Expression getBasicOrCustomSerializer(TypeMirror typeMirror, String fieldName) {
        if (typeUtils.isBasicType(typeMirror)) {
            MethodCallExpr method = new MethodCallExpr(
                    new NameExpr(context.getTypeRegistry()
                                         .getSerializer(context.getProcessingEnv().getTypeUtils().erasure(typeMirror)).toString()), "getInstance");
            if (typeMirror.getKind().equals(TypeKind.ARRAY)) {
                method.addArgument(new StringLiteralExpr(fieldName));
            }
            return method;

        } else {
            return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                            .setName(typeUtils.canonicalSerializerName(typeUtils.getPackage(typeMirror), typeMirror)));
        }
    }

    private Expression getSerializerExpression(TypeMirror field, String fieldName) {

        if(true) {
            return getFieldSerializer(field, fieldName);
        }

        if (typeUtils.isBasicType(field)) {
            MethodCallExpr method = new MethodCallExpr(
                    new NameExpr(context.getTypeRegistry()
                                         .getSerializer(context.getProcessingEnv().getTypeUtils().erasure(field)).toString()), "getInstance");
            if (field.getKind().equals(TypeKind.ARRAY)) {
                method.addArgument(new StringLiteralExpr(fieldName));
            }
            return method;
        } else if (field.getKind().equals(TypeKind.ARRAY)) {
            ArrayType array = (ArrayType) field;
            String serializer = null;
            Expression expression = null;
            if (array.getComponentType().getKind().equals(TypeKind.ARRAY)) {
                serializer = Array2dXMLSerializer.class.getCanonicalName();
                ArrayType array2d = (ArrayType) array.getComponentType();

                expression = getSerializerExpression(array2d.getComponentType(), null);
            } else {
                serializer = ArrayXMLSerializer.class.getCanonicalName();
                expression = getSerializerExpression(array.getComponentType(), null);
            }
            return new MethodCallExpr(
                    new NameExpr(serializer), "getInstance")
                    .addArgument(expression)
                    .addArgument(new StringLiteralExpr(fieldName));
        } else if (context.getTypeUtils().isMap(field)) {
            DeclaredType declaredType = MoreTypes.asDeclared(field);
            if (declaredType.getTypeArguments().size() != 2) {
                throw new GenerationException(declaredType.toString() + " must have type args [" + fieldName + "]");
            }
            String keySerializer = null;

            if (MoreTypes.asElement(declaredType.getTypeArguments().get(0)).getKind().equals(ElementKind.ENUM)) {
                keySerializer = EnumKeySerializer.class.getCanonicalName();
            } else {
                keySerializer = context.getTypeRegistry()
                        .getKeySerializer(declaredType.getTypeArguments().get(0).toString()).getQualifiedName().toString();
            }

            return new MethodCallExpr(
                    new NameExpr(MapXMLSerializer.class.getCanonicalName()), "newInstance")
                    .addArgument(new MethodCallExpr(
                            new NameExpr(keySerializer), "getInstance"))
                    .addArgument(getSerializerExpression(declaredType.getTypeArguments().get(1), null))
                    .addArgument(new StringLiteralExpr(fieldName));
        } else {
            if (context.getTypeRegistry().get(context.getProcessingEnv()
                                                      .getTypeUtils().erasure(field).toString()) == null) {

                if (MoreTypes.asElement(field).getKind().equals(ElementKind.ENUM)) {
                    return new MethodCallExpr(new NameExpr(EnumXMLSerializer.class.getCanonicalName()), "getInstance");
                }
                return new ObjectCreationExpr().setType(new ClassOrInterfaceType()

                                                                .setName(typeUtils.canonicalSerializerName(typeUtils.getPackage(field), field)));
            } else {
                TypeElement serializer = context.getTypeRegistry().getSerializer(context.getProcessingEnv().getTypeUtils().erasure(field));

                MethodCallExpr method = null;
                if (typeUtils.isCollection(field)) {
                    method = new MethodCallExpr(
                            new NameExpr(serializer.getQualifiedName().toString()), "newInstance");
                    for (TypeMirror param : MoreTypes.asDeclared(field).getTypeArguments()) {
                        method.addArgument(getSerializerExpression(param, null));
                    }
                }

                if (fieldName != null && method != null) {
                    method.addArgument(new StringLiteralExpr(fieldName));
                }

                return method;
            }
        }
    }
}
