package org.treblereel.gwt.jackson.definition;

import java.util.function.Function;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypesException;
import javax.lang.model.type.TypeMirror;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.TypeParameter;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public abstract class FieldDefinition extends Definition {

    protected FieldDefinition(TypeMirror property, GenerationContext context) {
        super(property, context);
    }

    public abstract Expression getFieldDeserializer(String fieldName, CompilationUnit cu);

    protected Expression generateXMLDeserializerFactory(TypeMirror type, String typeArg, CompilationUnit cu) {
        TypeUtils typeUtils = context.getTypeUtils();

        cu.addImport(Function.class);
        NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();

        NodeList<Type> typeArguments = new NodeList<>();
        typeArguments.add(new ClassOrInterfaceType().setName("String"));
        typeArguments.add(new ClassOrInterfaceType().setName("XMLDeserializer").setTypeArguments(new TypeParameter().setName(typeArg)));

        ClassOrInterfaceType iface = new ClassOrInterfaceType().setName("Function");
        iface.setTypeArguments(typeArguments);

        ObjectCreationExpr func = new ObjectCreationExpr().setType(iface);
        func.setAnonymousClassBody(anonymousClassBody);

        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PUBLIC);
        method.addAnnotation(Override.class);
        method.setName("apply");
        method.setType(new ClassOrInterfaceType().setName("XMLDeserializer"));
        method.addParameter("String", "value");

        for (TypeElement typeElement : getXmlSeeAlso(type)) {
            method.getBody().ifPresent(body -> body.addAndGetStatement(
                    new IfStmt().setCondition(new MethodCallExpr(new StringLiteralExpr(context.getBeanDefinition(typeElement.asType()).getXmlRootElement()), "equals")
                                                      .addArgument(new NameExpr("value"))))
                    .setThenStmt(new ReturnStmt(
                            new ObjectCreationExpr().setType(
                                    new ClassOrInterfaceType().setName(typeUtils.canonicalDeserializerName(typeElement.asType()))))));
        }
        anonymousClassBody.add(method);
        Expression expression = propertyDefinitionFactory.getFieldDefinition(type)
                .getFieldDeserializer(null, cu);

        method.getBody().ifPresent(body -> body.addAndGetStatement(
                new ReturnStmt(expression)));
        return func;
    }

    protected Expression generateXMLSerializerFactory(TypeMirror type, String typeArg, CompilationUnit cu) {
        cu.addImport(Function.class);

        TypeUtils typeUtils = context.getTypeUtils();
        Expression expression = propertyDefinitionFactory.getFieldDefinition(type)
                .getFieldSerializer(null, cu);
        NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();

        NodeList<Type> typeArguments = new NodeList<>();
        typeArguments.add(new ClassOrInterfaceType().setName("Class"));
        typeArguments.add(new ClassOrInterfaceType().setName("XMLSerializer").setTypeArguments(new TypeParameter().setName(typeArg)));

        ClassOrInterfaceType iface = new ClassOrInterfaceType().setName("Function");
        iface.setTypeArguments(typeArguments);

        ObjectCreationExpr func = new ObjectCreationExpr().setType(iface);
        func.setAnonymousClassBody(anonymousClassBody);

        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(Modifier.Keyword.PUBLIC);
        method.addAnnotation(Override.class);
        method.setName("apply");
        method.setType(new ClassOrInterfaceType().setName("XMLSerializer"));
        method.addParameter("Class", "value");

        addXMLSerializerSeeAlso(type, typeUtils, method);
        anonymousClassBody.add(method);
        method.getBody().ifPresent(body -> body.addAndGetStatement(
                new ReturnStmt(expression)));

        return func;
    }

    public abstract Expression getFieldSerializer(String fieldName, CompilationUnit cu);

    private void addXMLSerializerSeeAlso(TypeMirror type, TypeUtils typeUtils, MethodDeclaration method) {
        if (MoreTypes.asTypeElement(type).getAnnotation(XmlSeeAlso.class) != null) {

            for (TypeElement typeElement : getXmlSeeAlso(type)) {
                method.getBody().ifPresent(body -> body.addAndGetStatement(
                        new IfStmt().setCondition(new MethodCallExpr(new NameExpr("value"), "equals")
                                                          .addArgument(new FieldAccessExpr(
                                                                  new NameExpr(typeElement.getQualifiedName().toString()), "class"))))
                        .setThenStmt(new ReturnStmt(
                                new MethodCallExpr(new MethodCallExpr(
                                        new ObjectCreationExpr().setType(
                                                new ClassOrInterfaceType().setName(typeUtils.canonicalSerializerName(typeElement.asType()))), "addXsiType")
                                                           .addArgument(new StringLiteralExpr(context.getBeanDefinition(typeElement.asType()).getXmlRootElement())),
                                                   "addNamespace")
                                        .addArgument(new StringLiteralExpr("xsi"))
                                        .addArgument(new StringLiteralExpr("http://www.w3.org/2001/XMLSchema-instance")))));
            }
        }
    }

    private TypeElement[] getXmlSeeAlso(TypeMirror type) {
        XmlSeeAlso xmlSeeAlso = MoreTypes.asTypeElement(type).getAnnotation(XmlSeeAlso.class);
        if (xmlSeeAlso != null) {
            try {
                xmlSeeAlso.value();
            } catch (MirroredTypesException e) {
                TypeElement[] result = new TypeElement[e.getTypeMirrors().size()];
                for (int i = 0; i < e.getTypeMirrors().size(); i++) {
                    result[i] = MoreTypes.asTypeElement(e.getTypeMirrors().get(i));
                }
                return result;
            }
        }
        return new TypeElement[0];
    }
}