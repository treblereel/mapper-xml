package org.treblereel.gwt.jackson.generator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.processing.FilerException;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.JavaFileObject;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.google.auto.common.MoreElements;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.context.GenerationContext;
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

    public void generate(TypeElement type) {
        logger.log(TreeLogger.INFO, "Generating " + type);
        cu = new CompilationUnit();
        cu.setPackageDeclaration(context.getTypeUtils().getPackage(type.asType()));
        declaration = cu.addClass(getMapperName(type));

        configureClassType(type);
        getType(type);
        init(type);
        write(type);


    }

    protected abstract String getMapperName(TypeElement type);

    protected abstract void configureClassType(TypeElement type);

    protected void getType(TypeElement type) {

    }

    protected List<VariableElement> getFields(TypeElement bean) {
        return bean.getEnclosedElements().stream()
                .filter(elm -> elm.getKind().isField())
                .map(MoreElements::asVariable)
                .filter(field -> !field.getModifiers().contains(Modifier.STATIC))
                .filter(field -> !field.getModifiers().contains(Modifier.FINAL))
                .filter(field -> !field.getModifiers().contains(Modifier.TRANSIENT))
                .collect(Collectors.toList());
    }

    protected abstract void init(TypeElement type);

    protected void write(TypeElement type) {
        logger.log(TreeLogger.INFO, "Writing " + type);

        try {
            build(MoreElements.getPackage(type) + "." + getMapperName(type), cu.toString());
        } catch (javax.annotation.processing.FilerException e1) {
            logger.log(TreeLogger.ERROR, e1.getMessage());
        } catch (IOException e1) {
            throw new GenerationException(e1);
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
