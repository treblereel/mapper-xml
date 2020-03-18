package org.treblereel.gwt.jackson.api.deser.map.key;

import java.util.Date;

/**
 * <p>DateKeyParser interface.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface DateKeyParser<D extends Date> {
    /**
     * <p>parse.</p>
     *
     * @param keyValue a {@link java.lang.String} object.
     * @param deserializer a {@link DateDeserializer} object.
     * @return a D object.
     */
    D parse(String keyValue, DateDeserializer<D> deserializer);
}
