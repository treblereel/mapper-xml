package org.treblereel.gwt.jackson.api;

import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * <p>XMLDeserializationContext interface.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface XMLDeserializationContext extends XMLMappingContext {
    /**
     * <p>isFailOnUnknownProperties.</p>
     *
     * @return a boolean.
     */
    boolean isFailOnUnknownProperties();

    /**
     * <p>isUnwrapRootValue.</p>
     *
     * @return a boolean.
     */
    boolean isUnwrapRootValue();

    /**
     * <p>isAcceptSingleValueAsArray.</p>
     *
     * @return a boolean.
     */
    boolean isAcceptSingleValueAsArray();

    /**
     * <p>isUseSafeEval.</p>
     *
     * @return a boolean.
     */
    boolean isUseSafeEval();

    /**
     * <p>isReadUnknownEnumValuesAsNull.</p>
     *
     * @return a boolean.
     */
    boolean isReadUnknownEnumValuesAsNull();

    /**
     * <p>isUseBrowserTimezone.</p>
     *
     * @return a boolean.
     */
    boolean isUseBrowserTimezone();

    /**
     * <p>newXMLReader.</p>
     *
     * @param input a {@link String} object.
     * @return a {@link XMLReader} object.
     */
    XMLReader newXMLReader(String input);

    /**
     * <p>traceError.</p>
     *
     * @param message a {@link String} object.
     * @return a {@link XMLDeserializationException} object.
     */
    XMLDeserializationException traceError(String message);

    /**
     * <p>traceError.</p>
     *
     * @param message a {@link String} object.
     * @param reader a {@link XMLReader} object.
     * @return a {@link XMLDeserializationException} object.
     */
    XMLDeserializationException traceError(String message, XMLReader reader);

    /**
     * <p>traceError.</p>
     *
     * @param cause a {@link RuntimeException} object.
     * @return a {@link RuntimeException} object.
     */
    RuntimeException traceError(RuntimeException cause);

    /**
     * <p>traceError.</p>
     *
     * @param cause a {@link RuntimeException} object.
     * @param reader a {@link XMLReader} object.
     * @return a {@link RuntimeException} object.
     */
    RuntimeException traceError(RuntimeException cause, XMLReader reader);

    /**
     * <p>addObjectId.</p>
     *
     * @param id a {@link ObjectIdGenerator.IdKey} object.
     * @param instance a {@link Object} object.
     */
    void addObjectId(ObjectIdGenerator.IdKey id, Object instance);

    /**
     * <p>getObjectWithId.</p>
     *
     * @param id a {@link com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey} object.
     * @return a {@link Object} object.
     */
    Object getObjectWithId(ObjectIdGenerator.IdKey id);

    /**
     * <p>defaultParameters.</p>
     *
     * @return a {@link XMLDeserializerParameters} object.
     */
    XMLDeserializerParameters defaultParameters();
}
