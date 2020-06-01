package javax.xml.bind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/4/20
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface XmlTransient {

}
