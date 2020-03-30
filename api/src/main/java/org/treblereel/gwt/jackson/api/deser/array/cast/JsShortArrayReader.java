package org.treblereel.gwt.jackson.api.deser.array.cast;

import javax.xml.stream.XMLStreamException;

import elemental2.core.JsArray;
import elemental2.core.JsNumber;
import jsinterop.base.Js;
import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * <p>JsShortArrayReader class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class JsShortArrayReader extends BaseJsNumberArrayReader implements JacksonContext.ShortArrayReader {
    /** {@inheritDoc} */
    @Override
    public short[] readArray(XMLReader reader) throws XMLStreamException {
        return reinterpretCast(super.readNumberArray(reader));
    }

    private static short[] reinterpretCast(JsArray<JsNumber> value) {
        JsNumber[] sliced = value.slice();
        return Js.uncheckedCast(sliced);
    }
}
