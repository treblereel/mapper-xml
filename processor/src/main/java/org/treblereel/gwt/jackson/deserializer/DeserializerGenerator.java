/*
 * Copyright © 2020 Treblereel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.treblereel.gwt.jackson.deserializer;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
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
import com.google.auto.common.MoreTypes;
import java.util.Map;
import javax.lang.model.element.TypeElement;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.api.JacksonContextProvider;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.deser.XmlElementWrapperDeserializer;
import org.treblereel.gwt.jackson.api.deser.bean.AbstractBeanXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.bean.BeanPropertyDeserializer;
import org.treblereel.gwt.jackson.api.deser.bean.HasDeserializerAndParameters;
import org.treblereel.gwt.jackson.api.deser.bean.Instance;
import org.treblereel.gwt.jackson.api.deser.bean.InstanceBuilder;
import org.treblereel.gwt.jackson.api.deser.bean.MapLike;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.definition.BeanDefinition;
import org.treblereel.gwt.jackson.definition.PropertyDefinition;
import org.treblereel.gwt.jackson.generator.AbstractGenerator;
import org.treblereel.gwt.jackson.logger.TreeLogger;

/** @author Dmitrii Tikhomirov Created by treblereel 3/18/20 */
public class DeserializerGenerator extends AbstractGenerator {

  public DeserializerGenerator(GenerationContext context, TreeLogger logger) {
    super(context, logger.branch(TreeLogger.INFO, "Deserializers generation started"));
  }

  @Override
  protected String getMapperName(TypeElement type) {
    return context.getTypeUtils().deserializerName(type.asType());
  }

  @Override
  protected void configureClassType(BeanDefinition type) {
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
    cu.addImport(XMLReader.class);
    cu.addImport(type.getQualifiedName());

    declaration
        .getExtendedTypes()
        .add(
            new ClassOrInterfaceType()
                .setName(AbstractBeanXMLDeserializer.class.getSimpleName())
                .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName())));
  }

  @Override
  protected void getType(BeanDefinition type) {
    declaration
        .addMethod("getDeserializedType", Modifier.Keyword.PUBLIC)
        .addAnnotation(Override.class)
        .setType(Class.class)
        .getBody()
        .ifPresent(
            body ->
                body.addStatement(
                    new ReturnStmt(
                        new FieldAccessExpr(new NameExpr(type.getSimpleName()), "class"))));

    declaration
        .addMethod("getXmlRootElement", Modifier.Keyword.PROTECTED)
        .addAnnotation(Override.class)
        .setType(String.class)
        .getBody()
        .ifPresent(
            body ->
                body.addStatement(new ReturnStmt(new StringLiteralExpr(type.getXmlRootElement()))));
  }

  @Override
  protected void init(BeanDefinition beanDefinition) {
    logger.log(
        TreeLogger.INFO,
        "Generating " + context.getTypeUtils().deserializerName(beanDefinition.getBean()));
    initDeserializers(beanDefinition);
    initInstanceBuilder(beanDefinition);
  }

  private void initDeserializers(BeanDefinition beanDefinition) {
    MethodDeclaration initSerializers =
        declaration.addMethod("initDeserializers", Modifier.Keyword.PROTECTED);

    initSerializers
        .addAnnotation(Override.class)
        .setType(
            new ClassOrInterfaceType()
                .setName(MapLike.class.getSimpleName())
                .setTypeArguments(
                    new ClassOrInterfaceType()
                        .setName(BeanPropertyDeserializer.class.getSimpleName())
                        .setTypeArguments(
                            new ClassOrInterfaceType()
                                .setName(beanDefinition.getElement().getSimpleName().toString()),
                            new ClassOrInterfaceType().setName("?"))));
    ClassOrInterfaceType varType =
        new ClassOrInterfaceType()
            .setName("MapLike")
            .setTypeArguments(
                new ClassOrInterfaceType()
                    .setName("BeanPropertyDeserializer")
                    .setTypeArguments(
                        new ClassOrInterfaceType()
                            .setName(beanDefinition.getElement().getSimpleName().toString()),
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

    initSerializers
        .getBody()
        .ifPresent(
            body -> {
              body.addStatement(expressionStmt);
              beanDefinition
                  .getFields()
                  .forEach(
                      field ->
                          addBeanPropertyDeserializer(body, beanDefinition.getElement(), field));
              body.addStatement(new ReturnStmt("map"));
            });
  }

  private void initInstanceBuilder(BeanDefinition type) {
    MethodDeclaration initInstanceBuilder =
        declaration.addMethod("initInstanceBuilder", Modifier.Keyword.PROTECTED);
    initInstanceBuilder
        .addAnnotation(Override.class)
        .setType(
            new ClassOrInterfaceType()
                .setName(InstanceBuilder.class.getSimpleName())
                .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName())));
    VariableDeclarator deserializers = new VariableDeclarator();
    deserializers.setType("MapLike<HasDeserializerAndParameters>");
    deserializers.setName("deserializers");
    deserializers.setInitializer("null");

    ExpressionStmt expressionStmt = new ExpressionStmt();
    VariableDeclarationExpr variableDeclarationExpr = new VariableDeclarationExpr();
    variableDeclarationExpr.setModifiers(Modifier.Keyword.FINAL);
    expressionStmt.setExpression(variableDeclarationExpr);
    variableDeclarationExpr.getVariables().add(deserializers);

    initInstanceBuilder
        .getBody()
        .ifPresent(
            body -> {
              body.addStatement(variableDeclarationExpr);
              addInstanceBuilder(type, body);
            });
  }

  private void addBeanPropertyDeserializer(
      BlockStmt body, TypeElement type, PropertyDefinition field) {
    NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();

    ClassOrInterfaceType typeArg = getWrappedType(field);
    ClassOrInterfaceType beanPropertyDeserializer =
        new ClassOrInterfaceType().setName(BeanPropertyDeserializer.class.getSimpleName());
    beanPropertyDeserializer.setTypeArguments(
        new ClassOrInterfaceType().setName(type.getSimpleName().toString()), typeArg);

    body.addStatement(
        new MethodCallExpr(new NameExpr("map"), "put")
            .addArgument(
                new StringLiteralExpr(
                    field.isWrapped() ? field.getWrapped() : field.getPropertyName()))
            .addArgument(
                new ObjectCreationExpr()
                    .setType(beanPropertyDeserializer)
                    .setAnonymousClassBody(anonymousClassBody)));
    addNewDeserializer(field, anonymousClassBody);
    setValue(type, typeArg, field, anonymousClassBody);
    isAttribute(anonymousClassBody, field);
  }

  private void addInstanceBuilder(BeanDefinition type, BlockStmt body) {
    ObjectCreationExpr instanceBuilder = new ObjectCreationExpr();
    ClassOrInterfaceType instanceBuilderType =
        new ClassOrInterfaceType()
            .setName(InstanceBuilder.class.getSimpleName())
            .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName()));

    instanceBuilder.setType(instanceBuilderType);
    NodeList<BodyDeclaration<?>> anonymousClassBody = new NodeList<>();
    instanceBuilder.setAnonymousClassBody(anonymousClassBody);

    newInstance(type, anonymousClassBody);
    getParametersDeserializer(anonymousClassBody);
    create(type, anonymousClassBody);

    body.addStatement(new ReturnStmt(instanceBuilder));
  }

  private ClassOrInterfaceType getWrappedType(PropertyDefinition field) {
    return new ClassOrInterfaceType().setName(TypeUtils.wrapperType(field.getBean()));
  }

  private void addNewDeserializer(
      PropertyDefinition field, NodeList<BodyDeclaration<?>> anonymousClassBody) {
    MethodDeclaration method = new MethodDeclaration();
    method.setModifiers(Modifier.Keyword.PROTECTED);
    method.addAnnotation(Override.class);
    method.setName("newDeserializer");
    method.addParameter(XMLReader.class.getCanonicalName(), "reader");
    method.setType(new ClassOrInterfaceType().setName("XMLDeserializer<?>"));
    method
        .getBody()
        .ifPresent(
            body ->
                body.addAndGetStatement(
                    new ReturnStmt().setExpression(createFieldDeserializerExpr(field))));
    anonymousClassBody.add(method);
  }

  private void setValue(
      TypeElement type,
      ClassOrInterfaceType fieldType,
      PropertyDefinition field,
      NodeList<BodyDeclaration<?>> anonymousClassBody) {
    MethodDeclaration method = new MethodDeclaration();
    method.setModifiers(Modifier.Keyword.PUBLIC);
    method.addAnnotation(Override.class);
    method.setName("setValue");
    method.setType("void");
    method.addParameter(type.getSimpleName().toString(), "bean");
    method.addParameter(fieldType, "value");
    method.addParameter(XMLDeserializationContext.class.getSimpleName(), "ctx");

    method.getBody().ifPresent(body -> body.addAndGetStatement(getFieldAccessor(field)));
    anonymousClassBody.add(method);
  }

  private void isAttribute(
      NodeList<BodyDeclaration<?>> anonymousClassBody, PropertyDefinition propertyDefinition) {
    if (propertyDefinition.isAttribute()) {
      MethodDeclaration method = new MethodDeclaration();
      method.setModifiers(Modifier.Keyword.PROTECTED);
      method.addAnnotation(Override.class);
      method.setName("isAttribute");
      method.setType(new ClassOrInterfaceType().setName("boolean"));

      method
          .getBody()
          .ifPresent(
              body ->
                  body.addAndGetStatement(
                      new ReturnStmt().setExpression(new BooleanLiteralExpr(true))));
      anonymousClassBody.add(method);
    }
  }

  private void newInstance(BeanDefinition type, NodeList<BodyDeclaration<?>> anonymousClassBody) {
    MethodDeclaration method = new MethodDeclaration();
    method.setModifiers(Modifier.Keyword.PUBLIC);
    method.addAnnotation(Override.class);
    method.setName("newInstance");
    method.setType(
        new ClassOrInterfaceType()
            .setName("Instance")
            .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName())));
    addParameter(method, "XMLReader", "reader");
    addParameter(method, "XMLDeserializationContext", "ctx");
    addParameter(method, "XMLDeserializerParameters", "params");
    addParameter(method, "Map<String, String>", "bufferedProperties");
    addParameter(method, "Map<String, Object>", "bufferedPropertiesValues");

    ObjectCreationExpr instanceBuilder = new ObjectCreationExpr();
    ClassOrInterfaceType instanceBuilderType =
        new ClassOrInterfaceType()
            .setName(Instance.class.getSimpleName())
            .setTypeArguments(new ClassOrInterfaceType().setName(type.getSimpleName()));

    instanceBuilder.setType(instanceBuilderType);
    instanceBuilder.addArgument(new MethodCallExpr("create"));
    instanceBuilder.addArgument("bufferedProperties");

    method
        .getBody()
        .ifPresent(
            body -> body.addAndGetStatement(new ReturnStmt().setExpression(instanceBuilder)));
    anonymousClassBody.add(method);
  }

  private void getParametersDeserializer(NodeList<BodyDeclaration<?>> anonymousClassBody) {
    MethodDeclaration method = new MethodDeclaration();
    method.setModifiers(Modifier.Keyword.PUBLIC);
    method.addAnnotation(Override.class);
    method.setName("getParametersDeserializer");
    method.setType(
        new ClassOrInterfaceType()
            .setName("MapLike")
            .setTypeArguments(new ClassOrInterfaceType().setName("HasDeserializerAndParameters")));
    method
        .getBody()
        .ifPresent(
            body ->
                body.addAndGetStatement(
                    new ReturnStmt().setExpression(new NameExpr("deserializers"))));
    anonymousClassBody.add(method);
  }

  private void create(BeanDefinition type, NodeList<BodyDeclaration<?>> anonymousClassBody) {
    MethodDeclaration method = new MethodDeclaration();
    method.setModifiers(Modifier.Keyword.PRIVATE);
    method.setName("create");
    method.setType(new ClassOrInterfaceType().setName(type.getSimpleName()));

    ObjectCreationExpr instanceBuilder = new ObjectCreationExpr();
    ClassOrInterfaceType instanceBuilderType =
        new ClassOrInterfaceType().setName(type.getSimpleName());
    instanceBuilder.setType(instanceBuilderType);

    if (type.getXmlSeeAlso() != null
        && MoreTypes.asTypeElement(type.getBean())
            .getModifiers()
            .contains(javax.lang.model.element.Modifier.ABSTRACT)) {
      method
          .getBody()
          .ifPresent(
              body ->
                  body.addAndGetStatement(new ReturnStmt().setExpression(new NullLiteralExpr())));
    } else {
      method
          .getBody()
          .ifPresent(
              body -> body.addAndGetStatement(new ReturnStmt().setExpression(instanceBuilder)));
    }

    anonymousClassBody.add(method);
  }

  private Expression createFieldDeserializerExpr(PropertyDefinition field) {
    Expression expr = field.getFieldDeserializer(cu);
    if (field.isWrapped()) {
      ClassOrInterfaceType wrapper =
          new ClassOrInterfaceType()
              .setName(XmlElementWrapperDeserializer.class.getCanonicalName());
      ObjectCreationExpr beanProperty = new ObjectCreationExpr();
      beanProperty.setType(wrapper);
      expr =
          beanProperty
              .addArgument(expr)
              .addArgument(new StringLiteralExpr(field.getPropertyName()));
    }
    return expr;
  }

  private Expression getFieldAccessor(PropertyDefinition field) {
    if (typeUtils.hasSetter(field.getProperty())) {
      return new MethodCallExpr(
              new NameExpr("bean"),
              typeUtils.getSetter(field.getProperty()).getSimpleName().toString())
          .addArgument("value");
    } else {
      return new AssignExpr()
          .setTarget(
              new FieldAccessExpr(
                  new NameExpr("bean"), field.getProperty().getSimpleName().toString()))
          .setValue(new NameExpr("value"));
    }
  }

  private void addParameter(MethodDeclaration method, String type, String name) {
    method.addParameter(new ClassOrInterfaceType().setName(type), name);
  }
}
