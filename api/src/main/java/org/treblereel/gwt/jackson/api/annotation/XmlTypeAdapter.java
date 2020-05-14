package org.treblereel.gwt.jackson.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/20/20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlTypeAdapter {

    Class<?> deserializer() default Void.class;

    Class<?> serializer() default Void.class;

    boolean isAttribute() default false;

    boolean isList() default false;

    boolean isMap() default false;
}
