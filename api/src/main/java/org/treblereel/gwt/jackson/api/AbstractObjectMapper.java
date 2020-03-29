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

package org.treblereel.gwt.jackson.api;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.deser.array.ArrayXMLDeserializer;
import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;
import org.treblereel.gwt.jackson.api.exception.XMLSerializationException;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Base implementation of {@link ObjectMapper}. It delegates the serialization/deserialization to a serializer/deserializer.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class AbstractObjectMapper<T> implements ObjectMapper<T> {

    private final String rootName;

    private XMLDeserializer<T> deserializer;

    private XMLSerializer<T> serializer;

    /**
     * <p>Constructor for AbstractObjectMapper.</p>
     *
     * @param rootName a {@link java.lang.String} object.
     */
    protected AbstractObjectMapper(String rootName) {
        this.rootName = rootName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T read(String in) throws XMLDeserializationException {
        return read(in, DefaultXMLDeserializationContext.builder().build());
    }

    /**
     * {@inheritDoc}
     */
    public T read(String in, XMLDeserializationContext ctx) throws XMLDeserializationException {
        XMLReader reader = ctx.newXMLReader(in);

        try {

            if (ctx.isUnwrapRootValue()) {

                if (XMLToken.BEGIN_OBJECT != reader.peek()) {
                    throw ctx.traceError("Unwrap root value is enabled but the input is not a JSON Object", reader);
                }
                reader.beginObject();
                if (XMLToken.END_OBJECT == reader.peek()) {
                    throw ctx.traceError("Unwrap root value is enabled but the JSON Object is empty", reader);
                }
                String name = reader.nextName();
                if (!name.equals(rootName)) {
                    throw ctx.traceError("Unwrap root value is enabled but the name '" + name + "' don't match the expected rootName " +
                                                 "'" + rootName + "'", reader);
                }
                T result = getDeserializer().deserialize(reader, ctx);
                reader.endObject();
                return result;

            } else {

                return getDeserializer().deserialize(reader, ctx);

            }

        } catch (XMLDeserializationException e) {
            // already logged, we just throw it
            throw e;
        } catch (RuntimeException e) {
            throw ctx.traceError(e, reader);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T[] readArray(String input, ArrayXMLDeserializer.ArrayCreator<T> arrayCreator) throws XMLDeserializationException {
        return readArray(input, DefaultXMLDeserializationContext.builder().build(), arrayCreator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T[] readArray(String input, XMLDeserializationContext ctx, ArrayXMLDeserializer.ArrayCreator<T> arrayCreator) throws XMLDeserializationException {
        ArrayXMLDeserializer<T> jsonDeserializer = ArrayXMLDeserializer.newInstance(getDeserializer(), arrayCreator);
        return jsonDeserializer.deserialize(ctx.newXMLReader(input), ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>Getter for the field <code>deserializer</code>.</p>
     */
    @Override
    public XMLDeserializer<T> getDeserializer() {
        if (null == deserializer) {
            deserializer = newDeserializer();
        }
        return deserializer;
    }

    /**
     * Instantiates a new deserializer
     *
     * @return a new deserializer
     */
    protected abstract XMLDeserializer<T> newDeserializer();

    /**
     * {@inheritDoc}
     */
    @Override
    public String write(T value) throws XMLSerializationException, XMLStreamException {
        return write(value, DefaultXMLSerializationContext.builder().build());
    }

    /**
     * {@inheritDoc}
     */
    public String write(T value, XMLSerializationContext ctx) throws XMLSerializationException, XMLStreamException {
        XMLWriter writer = ctx.newXMLWriter();
        try {
            if (ctx.isWrapRootValue()) {
                writer.beginObject(rootName);
                writer.name(rootName);
                getSerializer().serialize(writer, value, ctx);
                writer.endObject();
                writer.close();
            } else {
                getSerializer().serialize(writer, value, ctx);
            }
            return writer.getOutput();
        } catch (XMLSerializationException e) {
            // already logged, we just throw it
            throw e;
        } catch (RuntimeException e) {
            throw ctx.traceError(value, e, writer);
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>Getter for the field <code>serializer</code>.</p>
     */
    @Override
    public XMLSerializer<T> getSerializer() {
        if (null == serializer) {
            serializer = (XMLSerializer<T>) newSerializer();
        }
        return serializer;
    }

    /**
     * Instantiates a new serializer
     *
     * @return a new serializer
     */
    protected abstract XMLSerializer<?> newSerializer();
}
