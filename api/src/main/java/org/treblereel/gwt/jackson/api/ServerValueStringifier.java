package org.treblereel.gwt.jackson.api;

import org.treblereel.gwt.jackson.api.stream.impl.DefaultXMLWriter;

/**
 * <p>ServerValueStringifier class.</p>
 *
 * @author vegegoku
 * @version $Id: $Id
 */
@GwtIncompatible
public class ServerValueStringifier implements JacksonContext.ValueStringifier{
    /** {@inheritDoc} */
    @Override
    public String stringify(String value) {
        StringBuilder out=new StringBuilder();
        out.append("\"");
        DefaultXMLWriter.encodeString(value, out);
        out.append("\"");
        return out.toString();
    }
}
