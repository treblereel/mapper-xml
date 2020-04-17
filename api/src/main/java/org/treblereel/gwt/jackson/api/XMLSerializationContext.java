package org.treblereel.gwt.jackson.api;

import javax.xml.stream.XMLStreamException;

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
     * <p>isMapKeyAndValueCanonical.</p>
     *
     * @return a boolean.
     */
    boolean isMapKeyAndValueCanonical();

    /**
     * <p>isWrapCollections.</p>
     *
     * @return a boolean.
     */
    boolean isWrapCollections();

    /**
     * <p>newXMLWriter.</p>
     *
     * @return a {@link XMLWriter} object.
     */
    XMLWriter newXMLWriter() throws XMLStreamException;

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
     * <p>defaultParameters.</p>
     *
     * @return a {@link XMLSerializerParameters} object.
     */
    XMLSerializerParameters defaultParameters();
}
