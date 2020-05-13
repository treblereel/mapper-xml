package org.treblereel.gwt.jackson.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>GwtIncompatible class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
@Retention(RetentionPolicy.CLASS)
@Target({
        ElementType.TYPE, ElementType.METHOD,
        ElementType.CONSTRUCTOR, ElementType.FIELD })
@Documented
public @interface GwtIncompatible {
    String value() default "";
}
