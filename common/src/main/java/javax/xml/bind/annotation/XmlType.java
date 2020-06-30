//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface XmlType {
    String name() default "##default";

    String[] propOrder() default {""};

    String namespace() default "##default";

    Class factoryClass() default XmlType.DEFAULT.class;

    String factoryMethod() default "";

    public static final class DEFAULT {
        public DEFAULT() {
        }
    }
}
