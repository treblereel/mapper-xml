/*
 * Copyright 2013 Nicolas Morel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.treblereel.gwt.jackson.api.deser;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Default {@link XMLDeserializer} implementation for {@link java.lang.String}.
 * @author Nicolas Morel
 * @version $Id: $
 */
public class StringXMLDeserializer extends XMLDeserializer<String> {

    private static final StringXMLDeserializer INSTANCE = new StringXMLDeserializer();

    private boolean cdata = false;

    private StringXMLDeserializer() {
    }

    /**
     * <p>getInstance</p>
     * @return an instance of {@link StringXMLDeserializer}
     */
    public static StringXMLDeserializer getInstance() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        if (cdata) {
            this.cdata = false;
            reader.next();
            return reader.nextValue();
        }

        return reader.nextString();
    }

    @Override
    public String deserialize(String value, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws
            XMLDeserializationException {
        return value;
    }

    public StringXMLDeserializer setCdata(boolean cdata) {
        this.cdata = cdata;
        return this;
    }
}
