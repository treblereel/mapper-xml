package org.treblereel.gwt.jackson.api.deser.map.key;

import java.util.Date;

import org.gwtproject.i18n.shared.DateTimeFormat;
import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;

import static org.gwtproject.i18n.shared.DateTimeFormat.getFormat;

/**
 * <p>JsDateKeyParser class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class JsDateKeyParser<D extends Date> implements DateKeyParser<D> {

    private static final DateTimeFormat ISO_8601_FORMAT = getFormat(DateTimeFormat.PredefinedFormat.ISO_8601);

    private static final DateTimeFormat RFC_2822_FORMAT = getFormat(DateTimeFormat.PredefinedFormat.RFC_2822);

    /** {@inheritDoc} */
    @Override
    public D parse(String keyValue, DateDeserializer<D> deserializer) {
        try {
            return deserializer.deserializeDate(ISO_8601_FORMAT.parse(keyValue));
        } catch (IllegalArgumentException e) {
            // can happen if it's not the correct format
        }

        // maybe it's in milliseconds
        try {
            return deserializer.deserializeMillis(Long.parseLong(keyValue));
        } catch (NumberFormatException e) {
            // can happen if the keyValue is string-based like an ISO-8601 format
        }

        // or in RFC-2822
        try {
            return deserializer.deserializeDate(RFC_2822_FORMAT.parse(keyValue));
        } catch (IllegalArgumentException e) {
            // can happen if it's not the correct format
        }

        throw new XMLDeserializationException("Cannot parse the keyValue '" + keyValue + "' as a date");
    }
}
