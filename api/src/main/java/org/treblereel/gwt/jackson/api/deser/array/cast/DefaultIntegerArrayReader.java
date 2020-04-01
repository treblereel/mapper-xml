package org.treblereel.gwt.jackson.api.deser.array.cast;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.GwtIncompatible;
import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * <p>DefaultIntegerArrayReader class.</p>
 * @author vegegoku
 * @version $Id: $Id
 */
@GwtIncompatible
public class DefaultIntegerArrayReader implements JacksonContext.IntegerArrayReader {

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] readArray(XMLReader reader) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }
}
