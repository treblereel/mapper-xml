package org.treblereel.gwt.jackson.api.deser.array.cast;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * <p>JsStringArrayReader class.</p>
 * @author vegegoku
 * @version $Id: $Id
 */
public class JsStringArrayReader implements JacksonContext.StringArrayReader {

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] readArray(XMLReader reader) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }
}
