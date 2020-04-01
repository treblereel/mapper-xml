package org.treblereel.gwt.jackson.api.deser.array.cast;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.GwtIncompatible;
import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * <p>DefaultStringArrayReader class.</p>
 * @author vegegoku
 * @version $Id: $Id
 */
@GwtIncompatible
public class DefaultStringArrayReader implements JacksonContext.StringArrayReader {

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] readArray(XMLReader reader) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }
}
