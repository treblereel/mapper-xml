package org.treblereel.gwt.jackson.generator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.processing.FilerException;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.google.auto.common.MoreElements;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.definition.BeanDefinition;
import org.treblereel.gwt.jackson.exception.GenerationException;
import org.treblereel.gwt.jackson.logger.TreeLogger;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/19/20
 */
public abstract class AbstractGenerator {

    protected final GenerationContext context;
    protected final TypeUtils typeUtils;
    protected final TreeLogger logger;
    protected CompilationUnit cu;
    protected ClassOrInterfaceDeclaration declaration;

    public AbstractGenerator(GenerationContext context, TreeLogger logger) {
        this.context = context;
        this.logger = logger;
        this.typeUtils = context.getTypeUtils();
    }

    public void generate(BeanDefinition type) {
        cu = new CompilationUnit();
        cu.setPackageDeclaration(context.getTypeUtils().getPackage(type.getBean()));
        declaration = cu.addClass(getMapperName(type.getElement()));
        configureClassType(type);
        addTypeParam(type, declaration);
        getType(type);
        init(type);
        write(type.getElement());
    }

    protected abstract String getMapperName(TypeElement type);

    protected abstract void configureClassType(BeanDefinition type);

    protected void addTypeParam(BeanDefinition type, ClassOrInterfaceDeclaration declaration) {

    }

    protected void getType(BeanDefinition type) {

    }

    protected abstract void init(BeanDefinition type);

    protected void write(TypeElement type) {
        logger.branch(TreeLogger.INFO, "Writing " + getMapperName(type));
        TypeMirror property = context.getTypeUtils().removeOuterWildCards(type.asType());
        if (!context.getTypeRegistry().containsDeserializer(property)) {
            try {
                build(MoreElements.getPackage(type) + "." + getMapperName(type), cu.toString());
            } catch (javax.annotation.processing.FilerException e1) {
                logger.log(TreeLogger.ERROR, e1.getMessage());
            } catch (IOException e1) {
                throw new GenerationException(e1);
            }
        }
    }

    private void build(String fileName, String source) throws IOException {
        JavaFileObject builderFile = context.getProcessingEnv().getFiler()
                .createSourceFile(fileName);

        try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
            out.append(source);
        } catch (FilerException e) {
            throw new GenerationException(e);
        }
    }
}
