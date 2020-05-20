package org.treblereel.gwt.jackson.api.custom;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/20/20
 */
public abstract class CustomXMLDeserializer<T> extends XMLDeserializer<T> {

    public abstract T deserialize(String value, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws
            XMLDeserializationException;
}
