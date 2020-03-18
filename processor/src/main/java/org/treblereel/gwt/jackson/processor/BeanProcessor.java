package org.treblereel.gwt.jackson.processor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;

import org.treblereel.gwt.jackson.context.GenerationContext;
import org.treblereel.gwt.jackson.exception.GenerationException;
import org.treblereel.gwt.jackson.logger.TreeLogger;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/11/20
 */
public class BeanProcessor {

    private final GenerationContext context;
    private final TreeLogger logger;
    private final Set<TypeElement> annotatedBeans;
    private final Set<TypeElement> beans = new HashSet<>();

    public BeanProcessor(GenerationContext context, TreeLogger logger, Set<TypeElement> annotatedBeans) {
        this.context = context;
        this.logger = logger;
        this.annotatedBeans = annotatedBeans;
    }

    public void process() {
        annotatedBeans.forEach(bean -> {
            System.out.println("BEAN " + bean);
            if (!beans.contains(bean)) {
                beans.add(checkBean(bean));
            }
        });
    }

    private TypeElement checkBean(TypeElement type) {
        if (type.getModifiers().contains(Modifier.STATIC)) {
            throw new GenerationException(
                    "A @XMLMapper bean [" + type + "] must not be static");
        }

        if (!type.getModifiers().contains(Modifier.PUBLIC)) {
            throw new GenerationException(
                    "A @XMLMapper bean [" + type + "] must be public");
        }

        List<ExecutableElement> constructors = ElementFilter.constructorsIn(type.getEnclosedElements());
        if (constructors.size() > 0) {
            long nonArgConstructorCount = constructors.stream()
                    .filter(constr -> constr.getModifiers().contains(Modifier.PUBLIC))
                    .filter(constr -> constr.getParameters().isEmpty()).count();
            if (nonArgConstructorCount != 1) {
                throw new GenerationException(
                        "A @XMLMapper bean [" + type + "] must contains public non-arg constructor");
            }
        }
        return type;
    }
}
