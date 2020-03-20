package org.treblereel.gwt.jackson.deserializer;

import java.util.List;

import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
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
        List<VariableElement> fields = getFields(type);
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
        //.getBody().ifPresent(body -> processInitSerializersMethodBody(body, type, fields));
    }
}
