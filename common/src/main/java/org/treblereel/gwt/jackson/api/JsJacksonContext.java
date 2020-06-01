package org.treblereel.gwt.jackson.api;

import org.treblereel.gwt.jackson.api.utils.JsMapLike;
import org.treblereel.gwt.jackson.api.utils.JsDateFormat;

/**
 * <p>JsJacksonContext class.</p>
 * @author vegegoku
 * @version $Id: $Id
 */
public class JsJacksonContext implements JacksonContext {

    /**
     * {@inheritDoc}
     */
    @Override
    public DateFormat dateFormat() {
        return new JsDateFormat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MapLikeFactory mapLikeFactory() {
        return JsMapLike::new;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public XMLSerializerParameters defaultSerializerParameters() {
        return DefaultXMLSerializerParameters.DEFAULT;
    }

    @Override
    public XMLSerializerParameters newSerializerParameters() {
        return new DefaultXMLSerializerParameters();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public XMLDeserializerParameters defaultDeserializerParameters() {
        return DefaultXMLDeserializerParameters.DEFAULT;
    }

    @Override
    public XMLDeserializerParameters newDeserializerParameters() {
        return new DefaultXMLDeserializerParameters();
    }
}
