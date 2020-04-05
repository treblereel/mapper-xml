package org.treblereel.gwt.jackson.definition;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.ElementKind;
import javax.lang.model.type.TypeMirror;

import com.google.auto.common.MoreTypes;
import org.treblereel.gwt.jackson.TypeUtils;
import org.treblereel.gwt.jackson.context.GenerationContext;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/1/20
 */
public class FieldDefinitionFactory {

    private final GenerationContext context;
    private final TypeUtils typeUtils;
    private final Map<TypeMirror, FieldDefinition> holder = new HashMap<>();

    FieldDefinitionFactory(GenerationContext context) {
        this.context = context;
        this.typeUtils = context.getTypeUtils();
    }

    FieldDefinition getFieldDefinition(TypeMirror property) {
        property = context.getTypeUtils().removeOuterWildCards(property);
        FieldDefinition result;
        if (holder.containsKey(property)) {
            result = holder.get(property);
        } else if (typeUtils.isSimpleType(property)) {
            result = new BasicTypeFieldDefinition(property, context);
        } else if (context.getTypeUtils().isIterable(property)) {
            result = new IterableBeanFieldDefinition(property, context);
        } else if (context.getTypeUtils().isMap(property)) {
            result = new MapBeanFieldDefinition(property, context);
        } else if (TypeUtils.isArray(property)) {
            result = new ArrayBeanFieldDefinition(property, context);
        } else if (MoreTypes.asElement(property).getKind().equals(ElementKind.ENUM)) {
            result = new EnumBeanFieldDefinition(property, context);
        } else {
            result = new DefaultBeanFieldDefinition(property, context);
        }
        holder.put(property, result);
        return result;
    }
}
