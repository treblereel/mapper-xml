package org.treblereel.gwt.jackson.context;

import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.util.ElementFilter;

import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.api.custom.CustomXMLDeserializer;
import org.treblereel.gwt.jackson.api.custom.CustomXMLSerializer;
import org.treblereel.gwt.jackson.api.annotation.XmlTypeAdapter;
import org.treblereel.gwt.jackson.exception.GenerationException;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/19/20
 */
public class CustomHandlerProcessor {

    private GenerationContext context;

    CustomHandlerProcessor(GenerationContext context) {
        this.context = context;
    }

    void process(Set<? extends Element> elements) {
        elements.stream()
                .filter(elm -> elm.getKind().equals(ElementKind.CLASS))
                .map(MoreElements::asType)
                .forEach(this::process);
    }

    private void process(TypeElement element) {
        checkClass(element);
        checkConstructor(element);

        XmlTypeAdapter xmlTypeAdapter = element.getAnnotation(XmlTypeAdapter.class);
        TypeElement ser = getSerializer(xmlTypeAdapter);
        TypeElement deser = getDeserializer(xmlTypeAdapter);

        checkExtends(element, ser, deser);

        if (ser != null) {
            context.getTypeRegistry()
                    .registerSerializer(element.getQualifiedName().toString(),
                                        ser);
        }
        if (deser != null) {
            context.getTypeRegistry()
                    .registerDeserializer(element.getQualifiedName().toString(),
                                          deser);
        }
    }

    private void checkClass(TypeElement type) {
        if (!type.getModifiers().contains(Modifier.PUBLIC)) {
            throw new GenerationException(type + " must be PUBLIC");
        }
        if (type.getModifiers().contains(Modifier.STATIC)) {
            throw new GenerationException(type + " must not be STATIC");
        }
        if (type.getModifiers().contains(Modifier.ABSTRACT)) {
            throw new GenerationException(type + " must not be ABSTRACT");
        }
    }

    private void checkConstructor(TypeElement type) {
        List<ExecutableElement> constructors = ElementFilter.constructorsIn(type.getEnclosedElements());
        if (!constructors.isEmpty()) {
            long nonArgConstructorCount = constructors.stream()
                    .filter(constr -> constr.getModifiers().contains(Modifier.PUBLIC))
                    .filter(constr -> constr.getParameters().isEmpty()).count();
            if (nonArgConstructorCount != 1) {
                throw new GenerationException(
                        "A @XMLMapper bean [" + type + "] must have a non-private non-arg constructor");
            }
        }
    }

    private TypeElement getSerializer(XmlTypeAdapter xmlTypeAdapter) {
        try {
            xmlTypeAdapter.serializer();
        } catch (MirroredTypeException e) {
            return MoreTypes.asTypeElement(e.getTypeMirror());
        }
        return null;
    }

    private TypeElement getDeserializer(XmlTypeAdapter xmlTypeAdapter) {
        try {
            xmlTypeAdapter.deserializer();
        } catch (MirroredTypeException e) {
            return MoreTypes.asTypeElement(e.getTypeMirror());
        }
        return null;
    }

    private void checkExtends(TypeElement handler, TypeElement ser, TypeElement deser) {
        if (ser != null) {
            if (!context.getTypeUtils().isAssignableFrom(ser, CustomXMLSerializer.class)) {
                throw new GenerationException(handler + " must extends " + CustomXMLSerializer.class.getCanonicalName());
            }
        }

        if (deser != null) {
            if (!context.getTypeUtils().isAssignableFrom(deser, CustomXMLDeserializer.class)) {
                throw new GenerationException(handler + " must extends " + CustomXMLDeserializer.class.getCanonicalName());
            }
        }
    }
}
