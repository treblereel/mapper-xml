package org.treblereel.gwt.jackson.definition;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlTransient;

import com.google.auto.common.MoreElements;
import org.treblereel.gwt.jackson.api.annotation.TargetNamespace;
import org.treblereel.gwt.jackson.api.utils.Pair;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public class BeanDefinition extends Definition {

    private final TypeElement element;
    private final XmlRootElement xmlRootElement;
    private final XmlSchema xmlSchema;
    private Set<PropertyDefinition> properties;

    public BeanDefinition(TypeElement element, GenerationContext context) {
        super(element.asType(), context);
        this.element = element;

        xmlRootElement = getElement().getAnnotation(XmlRootElement.class);
        xmlSchema = MoreElements.getPackage(element).getAnnotation(XmlSchema.class);

        loadProperties();
    }

    public TypeElement getElement() {
        return element;
    }

    private void loadProperties() {
        properties = context.getTypeUtils().getAllFieldsIn(element)
                .stream()
                .filter(field -> !field.getModifiers().contains(Modifier.STATIC))
                .filter(field -> !field.getModifiers().contains(Modifier.FINAL))
                .filter(field -> !field.getModifiers().contains(Modifier.TRANSIENT))
                .filter(field -> field.getAnnotation(XmlTransient.class) == null)
                .map(field -> new PropertyDefinition(field, context))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<PropertyDefinition> getFields() {
        if (properties == null) {
            getFields();
        }
        return properties;
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BeanDefinition)) {
            return false;
        }
        BeanDefinition that = (BeanDefinition) o;
        return Objects.equals(element, that.element);
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "element=" + element +
                '}';
    }

    public String getXmlRootElement() {
        if (xmlRootElement != null && !xmlRootElement.name().equals("##default")) {
            return xmlRootElement.name();
        }
        return getElement().getSimpleName().toString();
    }

    public List<Pair<String, String>> getXmlNs() {
        List<Pair<String, String>> result = new ArrayList<>();

        if (xmlRootElement != null && !xmlRootElement.namespace().equals("##default")) {
            result.add(new Pair<>(null, xmlRootElement.namespace()));
        } else if (xmlSchema != null && !xmlSchema.namespace().isEmpty()) {
            result.add(new Pair<>(null, xmlSchema.namespace()));
        }

        if (xmlSchema != null && xmlSchema.xmlns().length > 0) {
            for (XmlNs xmln : xmlSchema.xmlns()) {
                System.out.println("XmlNs " + xmln);
                result.add(new Pair<>(xmln.prefix(), xmln.namespaceURI()));
            }
        }

        return result;
    }

    public String getNamespace() {
        if (xmlSchema != null && !xmlSchema.namespace().isEmpty()) {
            return xmlSchema.namespace();
        }

        if (xmlRootElement != null && !xmlRootElement.namespace().equals("##default")) {
            return xmlRootElement.namespace();
        }

        return null;
    }

    public String getSchemaLocation() {
        if (xmlSchema != null && !xmlSchema.location().equals("##generate")) {
            return xmlSchema.location();
        }
        return null;
    }

    public String getSimpleName() {
        return getElement().getSimpleName().toString();
    }

    public String getQualifiedName() {
        return getElement().getQualifiedName().toString();
    }

    public Pair<String, String> getTargetNamespace() {
        TargetNamespace targetNamespace = getElement().getAnnotation(TargetNamespace.class);
        if (targetNamespace != null) {
            return new Pair<>(targetNamespace.prefix(), targetNamespace.namespace());
        }
        return null;
    }
}
