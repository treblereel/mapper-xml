package org.treblereel.gwt.jackson.api;

import org.treblereel.gwt.jackson.api.exception.XMLSerializationException;
import org.treblereel.gwt.jackson.api.ser.bean.ObjectIdSerializer;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * <p>XMLSerializationContext interface.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface XMLSerializationContext extends XMLMappingContext {
    /**
     * <p>isSerializeNulls.</p>
     *
     * @return a boolean.
     */
    boolean isSerializeNulls();

    /**
     * <p>isWriteDatesAsTimestamps.</p>
     *
     * @return a boolean.
     */
    boolean isWriteDatesAsTimestamps();

    /**
     * <p>isWriteDateKeysAsTimestamps.</p>
     *
     * @return a boolean.
     */
    boolean isWriteDateKeysAsTimestamps();

    /**
     * <p>isWrapRootValue.</p>
     *
     * @return a boolean.
     */
    boolean isWrapRootValue();

    /**
     * <p>isWriteCharArraysAsJsonArrays.</p>
     *
     * @return a boolean.
     */
    boolean isWriteCharArraysAsJsonArrays();

    /**
     * <p>isWriteNullMapValues.</p>
     *
     * @return a boolean.
     */
    boolean isWriteNullMapValues();

    /**
     * <p>isWriteEmptyXMLArrays.</p>
     *
     * @return a boolean.
     */
    boolean isWriteEmptyXMLArrays();

    /**
     * <p>isOrderMapEntriesByKeys.</p>
     *
     * @return a boolean.
     */
    boolean isOrderMapEntriesByKeys();

    /**
     * <p>isWriteSingleElemArraysUnwrapped.</p>
     *
     * @return a boolean.
     */
    boolean isWriteSingleElemArraysUnwrapped();

    /**
     * <p>newXMLWriter.</p>
     *
     * @return a {@link XMLWriter} object.
     */
    XMLWriter newXMLWriter();

    /**
     * <p>traceError.</p>
     *
     * @param value a {@link java.lang.Object} object.
     * @param message a {@link java.lang.String} object.
     * @return a {@link XMLSerializationException} object.
     */
    XMLSerializationException traceError(Object value, String message);

    /**
     * <p>traceError.</p>
     *
     * @param value a {@link java.lang.Object} object.
     * @param message a {@link java.lang.String} object.
     * @param writer a {@link XMLWriter} object.
     * @return a {@link XMLSerializationException} object.
     */
    XMLSerializationException traceError(Object value, String message, XMLWriter writer);

    /**
     * <p>traceError.</p>
     *
     * @param value a {@link java.lang.Object} object.
     * @param cause a {@link java.lang.RuntimeException} object.
     * @return a {@link java.lang.RuntimeException} object.
     */
    RuntimeException traceError(Object value, RuntimeException cause);

    /**
     * <p>traceError.</p>
     *
     * @param value a {@link java.lang.Object} object.
     * @param cause a {@link java.lang.RuntimeException} object.
     * @param writer a {@link XMLWriter} object.
     * @return a {@link java.lang.RuntimeException} object.
     */
    RuntimeException traceError(Object value, RuntimeException cause, XMLWriter writer);

    /**
     * <p>addObjectId.</p>
     *
     * @param object a {@link java.lang.Object} object.
     * @param id a {@link ObjectIdSerializer} object.
     */
    void addObjectId(Object object, ObjectIdSerializer<?> id);

    /**
     * <p>getObjectId.</p>
     *
     * @param object a {@link java.lang.Object} object.
     * @return a {@link ObjectIdSerializer} object.
     */
    ObjectIdSerializer<?> getObjectId(Object object);

    /**
     * <p>addGenerator.</p>
     *
     * @param generator a {@link ObjectIdGenerator} object.
     */
    @SuppressWarnings("UnusedDeclaration")
    void addGenerator(ObjectIdGenerator<?> generator);

    /**
     * <p>findObjectIdGenerator.</p>
     *
     * @param gen a {@link ObjectIdGenerator} object.
     * @param <T> a T object.
     * @return a {@link ObjectIdGenerator} object.
     */
    @SuppressWarnings({"UnusedDeclaration", "unchecked"})
    <T> ObjectIdGenerator<T> findObjectIdGenerator(ObjectIdGenerator<T> gen);


    /**
     * <p>defaultParameters.</p>
     *
     * @return a {@link XMLSerializerParameters} object.
     */
    XMLSerializerParameters defaultParameters();
}
