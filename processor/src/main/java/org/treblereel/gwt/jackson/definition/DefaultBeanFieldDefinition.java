package org.treblereel.gwt.jackson.definition;

import java.util.Map;
import java.util.function.Function;

import javax.lang.model.type.TypeMirror;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.api.Inheritance;
import org.treblereel.gwt.jackson.api.utils.Pair;
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
    public Expression getFieldDeserializer(PropertyDefinition field, CompilationUnit cu) {
        if (field != null && (context.getBeanDefinition(getBean()).getXmlSeeAlso() != null
                || field.getProperty().getAnnotation(XmlElements.class) != null
                || field.getProperty().getAnnotation(XmlElementRefs.class) != null)) {
            Pair<Class, Map<String, TypeMirror>> pair = maybePolymorphicType(field, bean);
            String inheritance = pair.key.equals(XmlElementRefs.class) ? "xsiTagChooser" : "xsiTypeChooser";

            return new MethodCallExpr(generateXMLDeserializerFactory(field, bean, bean.toString(), cu, pair), "apply")
                    .addArgument(new MethodCallExpr(new NameExpr(inheritance), "apply").addArgument("reader"));
        }
        return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                        .setName(typeUtils.canonicalDeserializerName(getBean())));


/*
        if (context.getBeanDefinition(getBean()).getXmlSeeAlso() != null && field != null && field.getPropertyName() != null) {
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

            if (context.getBeanDefinition(field.getBean()).getXmlSeeAlso() != null && field != null && field.getPropertyName() != null) {

                for (TypeElement typeElement : context.getBeanDefinition(getBean()).getXmlSeeAlso()) {
                    method.getBody().ifPresent(body -> body.addAndGetStatement(
                            new IfStmt().setCondition(new MethodCallExpr(new StringLiteralExpr(context.getBeanDefinition(typeElement.asType()).getXmlRootElement()), "equals")
                                                              .addArgument(new NameExpr("value"))))
                            .setThenStmt(new ReturnStmt(
                                    new ObjectCreationExpr().setType(
                                            new ClassOrInterfaceType().setName(typeUtils.canonicalDeserializerName(typeElement.asType()))))));
                }
            }
            anonymousClassBody.add(method);
            method.getBody().ifPresent(body -> body.addAndGetStatement(
                    new ReturnStmt(new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                                            .setName(typeUtils.canonicalDeserializerName(getBean()))))));

            return new MethodCallExpr(func, "apply").addArgument(new MethodCallExpr(new NameExpr("typeChooser"), "apply").addArgument("reader"));









        }

        return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                        .setName(typeUtils.canonicalDeserializerName(bean)));*/
    }

    @Override
    public Expression getFieldSerializer(PropertyDefinition field, CompilationUnit cu) {
        if (isPolymorphic(field)) {
            cu.addImport(Inheritance.class);
            cu.addImport(Function.class);

            return new MethodCallExpr(generateXMLSerializerFactory(field, bean, bean.toString(), cu), "apply").addArgument("value");
        }
        return new ObjectCreationExpr().setType(new ClassOrInterfaceType()
                                                        .setName(typeUtils.canonicalSerializerName(getBean())));
    }

    private boolean isPolymorphic(PropertyDefinition field) {
        return field != null && (context.getBeanDefinition(getBean()).getXmlSeeAlso() != null
                || field.getProperty().getAnnotation(XmlElements.class) != null
                || field.getProperty().getAnnotation(XmlElementRefs.class) != null);
    }

    @Override
    public String toString() {
        return "DefaultBeanFieldDefinition{" +
                "bean=" + bean +
                '}';
    }
}
