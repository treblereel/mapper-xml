package org.treblereel.gwt.jackson.api;

import java.util.Set;

import org.treblereel.gwt.jackson.api.ser.bean.TypeSerializationInfo;

/**
 * <p>XMLSerializerParameters interface.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface XMLSerializerParameters {
    /**
     * <p>getPattern.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    String getPattern();



    /**
     * <p>setPattern.</p>
     *
     * @param pattern a {@link java.lang.String} object.
     * @return a {@link XMLSerializerParameters} object.
     */
    XMLSerializerParameters setPattern(String pattern);

    /**
     * <p>getLocale.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    String getLocale();

    /**
     * <p>setLocale.</p>
     *
     * @param locale a {@link java.lang.String} object.
     * @return a {@link XMLSerializerParameters} object.
     */
    XMLSerializerParameters setLocale(String locale);

    /**
     * <p>getTimezone.</p>
     *
     * @return a {@link java.lang.Object} object.
     */
    Object getTimezone();

    /**
     * <p>setTimezone.</p>
     *
     * @param timezone a {@link java.lang.Object} object.
     * @return a {@link XMLSerializerParameters} object.
     */
    XMLSerializerParameters setTimezone(Object timezone);

    /**
     * <p>getIgnoredProperties.</p>
     *
     * @return a {@link java.util.Set} object.
     */
    Set<String> getIgnoredProperties();

    /**
     * <p>addIgnoredProperty.</p>
     *
     * @param ignoredProperty a {@link java.lang.String} object.
     * @return a {@link XMLSerializerParameters} object.
     */
    XMLSerializerParameters addIgnoredProperty(String ignoredProperty);

    /**
     * <p>getTypeInfo.</p>
     *
     * @return a {@link TypeSerializationInfo} object.
     */
    TypeSerializationInfo getTypeInfo();

    /**
     * <p>setTypeInfo.</p>
     *
     * @param typeInfo a {@link TypeSerializationInfo} object.
     * @return a {@link XMLSerializerParameters} object.
     */
    XMLSerializerParameters setTypeInfo(TypeSerializationInfo typeInfo);

    /**
     * <p>isUnwrapped.</p>
     *
     * @return a boolean.
     */
    boolean isUnwrapped();

    /**
     * <p>setUnwrapped.</p>
     *
     * @param unwrapped a boolean.
     * @return a {@link XMLSerializerParameters} object.
     */
    XMLSerializerParameters setUnwrapped(boolean unwrapped);
}
