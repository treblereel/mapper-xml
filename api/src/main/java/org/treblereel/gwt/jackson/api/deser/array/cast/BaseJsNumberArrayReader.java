package org.treblereel.gwt.jackson.api.deser.array.cast;

import javax.xml.stream.XMLStreamException;

import elemental2.core.JsArray;
import elemental2.core.JsNumber;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * <p>Abstract BaseJsNumberArrayReader class.</p>
 * @author vegegoku
 * @version $Id: $Id
 */
public abstract class BaseJsNumberArrayReader {

    JsArray<JsNumber> readNumberArray(XMLReader reader) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }
}
