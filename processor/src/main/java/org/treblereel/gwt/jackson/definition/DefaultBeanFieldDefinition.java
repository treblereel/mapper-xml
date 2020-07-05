package org.treblereel.gwt.jackson.definition;

import java.util.function.Function;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.google.auto.common.MoreTypes;
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
        if (context.getBeanDefinition(getBean()).getXmlSeeAlso() != null) {
            cu.addImport(Function.class);
            NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();

            NodeList<Type> typeArguments = new NodeList<>();
            typeArguments.add(new ClassOrInterfaceType().setName("String"));
            typeArguments.add(new ClassOrInterfaceType().setName("XMLDeserializer<?>"));

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

            for (TypeElement typeElement : context.getBeanDefinition(getBean()).getXmlSeeAlso()) {
                method.getBody().ifPresent(body -> body.addAndGetStatement(
                        new IfStmt().setCondition(new MethodCallExpr(new StringLiteralExpr(context.getBeanDefinition(typeElement.asType()).getXmlRootElement()), "equals")
                                                          .addArgument(new NameExpr("value"))))
                        .setThenStmt(new ReturnStmt(
                                new ObjectCreationExpr().setType(
                                        new ClassOrInterfaceType().setName(typeUtils.canonicalDeserializerName(typeElement.asType()))))));
            }
            anonymousClassBody.add(method);
            method.getBody().ifPresent(body -> body.addAndGetStatement(
                    new ReturnStmt(new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                                            .setName(typeUtils.canonicalDeserializerName(getBean()))))));

            return new MethodCallExpr(func, "apply").addArgument(new MethodCallExpr("getXsiType").addArgument("reader"));
        }

        return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                        .setName(typeUtils.canonicalDeserializerName(bean)));
    }

    @Override
    public Expression getFieldSerializer(String fieldName, CompilationUnit cu) {
        if (context.getBeanDefinition(getBean()).getXmlSeeAlso() != null && fieldName != null) {
            return new MethodCallExpr(generateXMLSerializerFactory(bean, bean.toString(), cu), "apply").addArgument("value");
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
