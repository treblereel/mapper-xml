package org.treblereel.gwt.jackson.api;

import org.treblereel.gwt.jackson.api.deser.array.cast.JsDoubleArrayReader;
import org.treblereel.gwt.jackson.api.deser.array.cast.JsIntegerArrayReader;
import org.treblereel.gwt.jackson.api.deser.array.cast.JsShortArrayReader;
import org.treblereel.gwt.jackson.api.deser.array.cast.JsStringArrayReader;
import org.treblereel.gwt.jackson.api.deser.bean.JsMapLike;
import org.treblereel.gwt.jackson.api.stream.impl.JsIntegerStack;
import org.treblereel.gwt.jackson.api.utils.JsDateFormat;

import static elemental2.core.Global.JSON;

/**
 * <p>JsJacksonContext class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class JsJacksonContext implements JacksonContext{
    /** {@inheritDoc} */
    @Override
    public DateFormat dateFormat() {
        return new JsDateFormat();
    }

    /** {@inheritDoc} */
    @Override
    public IntegerStackFactory integerStackFactory() {
        return JsIntegerStack::new;
    }

    /** {@inheritDoc} */
    @Override
    public MapLikeFactory mapLikeFactory() {
        return JsMapLike::new;
    }

    /** {@inheritDoc} */
    @Override
    public ValueStringifier stringifier() {
        return JSON::stringify;
    }

    /** {@inheritDoc} */
    @Override
    public StringArrayReader stringArrayReader() {
        return new JsStringArrayReader();
    }

    /** {@inheritDoc} */
    @Override
    public ShortArrayReader shortArrayReader() {
        return new JsShortArrayReader();
    }

    /** {@inheritDoc} */
    @Override
    public IntegerArrayReader integerArrayReader() {
        return new JsIntegerArrayReader();
    }

    /** {@inheritDoc} */
    @Override
    public DoubleArrayReader doubleArrayReader() {
        return new JsDoubleArrayReader();
    }

    /** {@inheritDoc} */
    @Override
    public XMLSerializerParameters defaultSerializerParameters() {
        return GwtJacksonXMLSerializerParameters.DEFAULT;
    }

    /** {@inheritDoc} */
    @Override
    public XMLDeserializerParameters defaultDeserializerParameters() {
        return GwtJacksonXMLDeserializerParameters.DEFAULT;
    }

    @Override
    public XMLSerializerParameters newSerializerParameters() {
        return new GwtJacksonXMLSerializerParameters();
    }

    @Override
    public XMLDeserializerParameters newDeserializerParameters() {
        return new GwtJacksonXMLDeserializerParameters();
    }
}
