package org.treblereel.gwt.jackson.api.deser.array.cast;

import org.treblereel.gwt.jackson.api.GwtIncompatible;
import org.treblereel.gwt.jackson.api.JacksonContext;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

import java.util.Stack;

/**
 * <p>DefaultDoubleArrayReader class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
@GwtIncompatible
public class DefaultDoubleArrayReader implements JacksonContext.DoubleArrayReader {
    /** {@inheritDoc} */
    @Override
    public double[] readArray(XMLReader reader) {
        Stack<Double> doubleStack = new Stack<>();
        reader.beginArray();
        while (XMLToken.END_ARRAY != reader.peek()) {
            if (XMLToken.NULL == reader.peek()) {
                reader.skipValue();
                doubleStack.push(null);
            } else {
                doubleStack.push(reader.nextDouble());
            }
        }
        reader.endArray();
        return doubleStack.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
