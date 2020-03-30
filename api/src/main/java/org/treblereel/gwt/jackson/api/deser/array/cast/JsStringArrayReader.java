package org.treblereel.gwt.jackson.api.deser.array.cast;

import javax.xml.stream.XMLStreamException;

import elemental2.core.JsArray;
import elemental2.core.JsString;
import jsinterop.base.Js;
import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

/**
 * <p>JsStringArrayReader class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class JsStringArrayReader implements JacksonContext.StringArrayReader {
    /** {@inheritDoc} */
    @Override
    public String[] readArray(XMLReader reader) throws XMLStreamException {



/*        JsArray<JsString> jsArray = new JsArray<>();
        reader.beginArray();
        while (XMLToken.END_ARRAY != reader.peek()) {
            if (XMLToken.NULL == reader.peek()) {
                reader.skipValue();
                jsArray.push(null);
            } else {
                jsArray.push((JsString) Js.cast(reader.nextString()));
            }
        }
        reader.endArray();

        return reinterpretCast(jsArray);*/
        throw new UnsupportedOperationException();
    }

}
