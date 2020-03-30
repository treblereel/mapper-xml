package org.treblereel.gwt.jackson.api.deser.array.cast;

import java.util.Stack;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.GwtIncompatible;
import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

/**
 * <p>DefaultShortArrayReader class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
@GwtIncompatible
public class DefaultShortArrayReader implements JacksonContext.ShortArrayReader {
    /** {@inheritDoc} */
    @Override
    public short[] readArray(XMLReader reader) throws XMLStreamException {
/*        Stack<Short> shortStack = new Stack<>();
        reader.beginArray();
        while (XMLToken.END_ARRAY != reader.peek()) {
            if (XMLToken.NULL == reader.peek()) {
                reader.skipValue();
                shortStack.push(null);
            } else {
                shortStack.push(new Integer(reader.nextInt()).shortValue());
            }
        }
        reader.endArray();
        short[] shorts = new short[shortStack.size()];
        for (int i = 0; i < shortStack.size(); i++) {
            shorts[i] = shortStack.get(i);
        }
        return shorts;*/
        throw new UnsupportedOperationException();
    }

}
