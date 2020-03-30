package org.treblereel.gwt.jackson.api.deser.array.cast;

import java.util.Stack;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.GwtIncompatible;
import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

/**
 * <p>DefaultStringArrayReader class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
@GwtIncompatible
public class DefaultStringArrayReader implements JacksonContext.StringArrayReader {
    /** {@inheritDoc} */
    @Override
    public String[] readArray(XMLReader reader) throws XMLStreamException {
/*        Stack<String> stringStack = new Stack<>();
        reader.beginArray();
        while (XMLToken.END_ARRAY != reader.peek()) {
            if (XMLToken.NULL == reader.peek()) {
                reader.skipValue();
                stringStack.push(null);
            } else {
                stringStack.push(reader.nextString());
            }
        }
        reader.endArray();

        return stringStack.toArray(new String[stringStack.size()]);*/
        throw new UnsupportedOperationException();
    }
}
