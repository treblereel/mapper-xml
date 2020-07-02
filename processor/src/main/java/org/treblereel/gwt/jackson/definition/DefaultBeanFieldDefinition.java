package org.treblereel.gwt.jackson.definition;

import java.util.function.Function;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NullLiteralExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
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
        if (context.getBeanDefinition(getBean()).getXmlSeeAlso() != null) {
            cu.addImport(Function.class);
            NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();

            NodeList<Type> typeArguments = new NodeList<>();
            typeArguments.add(new ClassOrInterfaceType().setName("Class"));
            typeArguments.add(new ClassOrInterfaceType().setName("XMLSerializer<?>"));

            ClassOrInterfaceType iface = new ClassOrInterfaceType().setName("Function");
            iface.setTypeArguments(typeArguments);

            ObjectCreationExpr func = new ObjectCreationExpr().setType(iface);
            func.setAnonymousClassBody(anonymousClassBody);

            MethodDeclaration method = new MethodDeclaration();
            method.setModifiers(Modifier.Keyword.PUBLIC);
            method.addAnnotation(Override.class);
            method.setName("apply");
            method.setType(new ClassOrInterfaceType().setName("XMLSerializer<?>"));
            method.addParameter("Class", "value");

            for (TypeElement typeElement : context.getBeanDefinition(getBean()).getXmlSeeAlso()) {
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
            anonymousClassBody.add(method);
            method.getBody().ifPresent(body -> body.addAndGetStatement(
                    new ReturnStmt(new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                                            .setName(typeUtils.canonicalSerializerName(getBean()))))));

            return new MethodCallExpr(func, "apply").addArgument("value");
        }

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
