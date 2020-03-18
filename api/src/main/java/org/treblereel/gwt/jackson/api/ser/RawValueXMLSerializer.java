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

package org.treblereel.gwt.jackson.api.ser;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Dummy {@link XMLSerializer} that will just output raw values by calling toString() on value to serialize.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public class RawValueXMLSerializer<T> extends XMLSerializer<T> {

    private static final RawValueXMLSerializer<?> INSTANCE = new RawValueXMLSerializer();

    /**
     * <p>getInstance</p>
     *
     * @param <T> a T object.
     * @return an instance of {@link RawValueXMLSerializer}
     */
    @SuppressWarnings("unchecked")
    public static <T> RawValueXMLSerializer<T> getInstance() {
        return (RawValueXMLSerializer<T>) INSTANCE;
    }

    private RawValueXMLSerializer() {
    }

    /** {@inheritDoc} */
    @Override
    protected void doSerialize(XMLWriter writer, Object value, XMLSerializationContext ctx, XMLSerializerParameters params) {
        writer.rawValue(value);
    }
}
