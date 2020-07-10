package org.treblereel.gwt.jackson.definition;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.MirroredTypesException;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
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
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.ThrowStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.TypeParameter;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.api.Inheritance;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.utils.Pair;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public abstract class FieldDefinition extends Definition {

    protected FieldDefinition(TypeMirror property, GenerationContext context) {
        super(property, context);
    }

    protected Expression generateXMLDeserializerFactory(PropertyDefinition field, TypeMirror type, String typeArg, CompilationUnit cu) {
        return generateXMLDeserializerFactory(field, type, typeArg, cu, maybePolymorphicType(field, type));
    }

    protected Expression generateXMLDeserializerFactory(PropertyDefinition field, TypeMirror type,
                                                        String typeArg, CompilationUnit cu,
                                                        Pair<Class, Map<String, TypeMirror>> maybePolymorphicType) {
        TypeUtils typeUtils = context.getTypeUtils();

        cu.addImport(Function.class);
        cu.addImport(XMLReader.class);
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
        for (Map.Entry<String, TypeMirror> typeElement : maybePolymorphicType.value.entrySet()) {
            method.getBody().ifPresent(body -> body.addAndGetStatement(
                    new IfStmt().setCondition(new MethodCallExpr(new StringLiteralExpr(typeElement.getKey()), "equals")
                                                      .addArgument(new NameExpr("value"))))
                    .setThenStmt(new ReturnStmt(
                            new ObjectCreationExpr().setType(
                                    new ClassOrInterfaceType().setName(typeUtils.canonicalDeserializerName(typeElement.getValue()))))));
        }
        anonymousClassBody.add(method);

        Statement expression;
        if (MoreTypes.asTypeElement(type).getModifiers().contains(javax.lang.model.element.Modifier.ABSTRACT)) {
            ClassOrInterfaceType instanceBuilderType = new ClassOrInterfaceType()
                    .setName(Error.class.getSimpleName());
            expression = new ThrowStmt().setExpression(new ObjectCreationExpr().setType(instanceBuilderType));
        } else {
            expression = new ReturnStmt(propertyDefinitionFactory.getFieldDefinition(type)
                                                .getFieldDeserializer(null, cu));
        }
        method.getBody().ifPresent(body -> body.addAndGetStatement(expression));
        return func;
    }

    protected Pair<Class, Map<String, TypeMirror>> maybePolymorphicType(PropertyDefinition field, TypeMirror type) {
        XmlElements xmlElements = field.getProperty().getAnnotation(XmlElements.class);
        if (xmlElements != null) {
            return new Pair<>(XmlElements.class, getXmlElements(field.getProperty(), XmlElements.class));
        }
        XmlElementRefs xmlElementRefs = field.getProperty().getAnnotation(XmlElementRefs.class);
        if (xmlElementRefs != null) {
            return new Pair<>(XmlElementRefs.class, getXmlElements(field.getProperty(), XmlElementRefs.class));
        }
        XmlSeeAlso xmlSeeAlso = MoreTypes.asTypeElement(type).getAnnotation(XmlSeeAlso.class);
        if (xmlSeeAlso != null) {
            Map<String, TypeMirror> result = new HashMap<>();
            for (TypeElement typeElement : getXmlSeeAlso(xmlSeeAlso)) {
                result.put(context.getBeanDefinition(typeElement.asType()).getXmlRootElement(), typeElement.asType());
            }

            return new Pair<>(XmlSeeAlso.class, result);
        }
        return new Pair<>(Class.class, Collections.emptyMap());
    }

    public abstract Expression getFieldDeserializer(PropertyDefinition field, CompilationUnit cu);

    private Map<String, TypeMirror> getXmlElements(VariableElement element, Class clazz) {
        Map<String, TypeMirror> result = new HashMap<>();
        context.getProcessingEnv().getElementUtils()
                .getAllAnnotationMirrors(element).
                stream().filter(elm -> elm.getAnnotationType().toString().equals(clazz.getCanonicalName()))
                .forEach(e -> e.getElementValues().forEach((a1, a2) -> new SimpleAnnotationValueVisitor8<AnnotationValue, Map<String, TypeMirror>>() {
                    @Override
                    public AnnotationValue visitArray(List<? extends AnnotationValue> z, Map<String, TypeMirror> map) {
                        for (AnnotationValue annotationValue : z) {
                            new SimpleAnnotationValueVisitor8<AnnotationValue, Map<String, TypeMirror>>() {
                                @Override
                                public AnnotationValue visitAnnotation(AnnotationMirror a, Map<String, TypeMirror> map) {
                                    String name = null;
                                    TypeMirror value = null;
                                    for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : a.getElementValues().entrySet()) {
                                        if (entry.getKey().getSimpleName().toString().equals("name")) {
                                            name = entry.getValue().getValue().toString();
                                        } else {
                                            value = (TypeMirror) entry.getValue().getValue();
                                        }
                                    }
                                    map.put(name, value);
                                    return null;
                                }
                            }.visit(annotationValue, map);
                        }
                        return z.get(1);
                    }
                }.visit(a2, result)));
        return result;
    }

    private TypeElement[] getXmlSeeAlso(XmlSeeAlso xmlSeeAlso) {
        try {
            xmlSeeAlso.value();
        } catch (MirroredTypesException e) {
            TypeElement[] result = new TypeElement[e.getTypeMirrors().size()];
            for (int i = 0; i < e.getTypeMirrors().size(); i++) {
                result[i] = MoreTypes.asTypeElement(e.getTypeMirrors().get(i));
            }
            return result;
        }
        return new TypeElement[0];
    }

    protected Expression generateXMLSerializerFactory(PropertyDefinition field, TypeMirror type, String typeArg, CompilationUnit cu) {
        TypeUtils typeUtils = context.getTypeUtils();
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

        maybeAddXMLSerializers(field, type, typeUtils, method, cu);
        anonymousClassBody.add(method);

        Statement defaultReturn;
        if (MoreTypes.asTypeElement(type).getModifiers().contains(javax.lang.model.element.Modifier.ABSTRACT)) {
            ClassOrInterfaceType instanceBuilderType = new ClassOrInterfaceType()
                    .setName(Error.class.getSimpleName());
            defaultReturn = new ThrowStmt().setExpression(new ObjectCreationExpr().setType(instanceBuilderType));
        } else {
            defaultReturn = new ReturnStmt(propertyDefinitionFactory.getFieldDefinition(type)
                                                   .getFieldSerializer(null, cu));
        }

        method.getBody().ifPresent(body -> body.addAndGetStatement(defaultReturn));

        return func;
    }

    private void maybeAddXMLSerializers(PropertyDefinition field, TypeMirror type, TypeUtils typeUtils, MethodDeclaration method, CompilationUnit cu) {
        cu.addImport(Function.class);
        cu.addImport(Inheritance.class);
        Pair<Class, Map<String, TypeMirror>> pair = maybePolymorphicType(field, type);
        String inheritance = pair.key.equals(XmlElementRefs.class) ? "Inheritance.TAG" : "Inheritance.XSI";
        for (Map.Entry<String, TypeMirror> typeElement : pair.value.entrySet()) {
            MethodCallExpr methodCallExpr =
                    new MethodCallExpr(
                            new ObjectCreationExpr().setType(
                                    new ClassOrInterfaceType().setName(typeUtils.canonicalSerializerName(typeElement.getValue()))), "setType")
                            .addArgument(new StringLiteralExpr(typeElement.getKey()))
                            .addArgument(new NameExpr(inheritance));
            //TODO
            if (inheritance.equals("Inheritance.XSI")) {

                methodCallExpr = new MethodCallExpr(methodCallExpr, "addNamespace")
                        .addArgument(new StringLiteralExpr("xsi"))
                        .addArgument(new StringLiteralExpr("http://www.w3.org/2001/XMLSchema-instance"));
            }

            ReturnStmt returnStmt = new ReturnStmt(methodCallExpr);
            method.getBody().ifPresent(body -> body.addAndGetStatement(

                    new IfStmt().setCondition(new MethodCallExpr(new NameExpr("value"), "equals")
                                                      .addArgument(new FieldAccessExpr(
                                                              new NameExpr(typeElement.getValue().toString()), "class"))))
                    .setThenStmt(returnStmt));
        }
    }

    public abstract Expression getFieldSerializer(PropertyDefinition field, CompilationUnit cu);
}