package org.treblereel.gwt.jackson.api.deser.array.cast;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.GwtIncompatible;
import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * <p>DefaultShortArrayReader class.</p>
 * @author vegegoku
 * @version $Id: $Id
 */
@GwtIncompatible
public class DefaultShortArrayReader implements JacksonContext.ShortArrayReader {

    /**
     * {@inheritDoc}
     */
    @Override
    public short[] readArray(XMLReader reader) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }
}
