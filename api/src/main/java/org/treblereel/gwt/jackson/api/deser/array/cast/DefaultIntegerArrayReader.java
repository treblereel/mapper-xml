package org.treblereel.gwt.jackson.api.deser.array.cast;

import java.util.Stack;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.GwtIncompatible;
import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

/**
 * <p>DefaultIntegerArrayReader class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
@GwtIncompatible
public class DefaultIntegerArrayReader implements JacksonContext.IntegerArrayReader {
    /** {@inheritDoc} */
    @Override
    public int[] readArray(XMLReader reader) throws XMLStreamException {
/*        Stack<Integer> intStack = new Stack<>();
        reader.beginArray();
        while (XMLToken.END_ARRAY != reader.peek()) {
            if (XMLToken.NULL == reader.peek()) {
                reader.skipValue();
                intStack.push(null);
            } else {
                intStack.push(reader.nextInt());
            }
        }
        reader.endArray();
        return intStack.stream().mapToInt(Integer::intValue).toArray();*/
        throw new UnsupportedOperationException();
    }
}
