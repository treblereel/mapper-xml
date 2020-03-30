package org.treblereel.gwt.jackson.api.deser.array.cast;

import javax.xml.stream.XMLStreamException;

import elemental2.core.JsArray;
import elemental2.core.JsNumber;
import jsinterop.base.Js;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

/**
 * <p>Abstract BaseJsNumberArrayReader class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public abstract class BaseJsNumberArrayReader {

    JsArray<JsNumber> readNumberArray(XMLReader reader) throws XMLStreamException {
/*        JsArray<JsNumber> jsArray = new JsArray<>();
        reader.beginArray();
        while (XMLToken.END_ARRAY != reader.peek()) {
            if (XMLToken.NULL == reader.peek()) {
                reader.skipValue();
                jsArray.push(null);
            } else {
                jsArray.push((JsNumber) Js.cast(reader.nextInt()));
            }
        }
        reader.endArray();

        return jsArray;*/
        throw new UnsupportedOperationException();
    }
}
