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

package org.treblereel.gwt.jackson.api.deser.collection;

import java.util.Collection;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * Base {@link XMLDeserializer} implementation for {@link java.util.Collection}.
 * @param <C> {@link java.util.Collection} type
 * @param <T> Type of the elements inside the {@link java.util.Collection}
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class BaseCollectionXMLDeserializer<C extends Collection<T>, T> extends BaseIterableXMLDeserializer<C, T> {

    /**
     * <p>Constructor for BaseCollectionXMLDeserializer.</p>
     * @param deserializer {@link XMLDeserializer} used to map the objects inside the {@link java.util.Collection}.
     */
    public BaseCollectionXMLDeserializer(XMLDeserializer<T> deserializer) {
        super(deserializer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        //reader.next();
        Scanner scanner = (Scanner<C>) (reader1, ctx1, instance) -> {
            T element = deserializer.deserialize(reader1, ctx1, params);
            System.out.println("element " + element.toString());

            if (element != null) {
                instance.add(element);
            }
            //reader.next();
            return null;
        };

        //doDeserializeCollection(reader, deserializer, ctx, params);

        return (C) doDeserializeCollection(reader, (Collection<C>) newCollection(),scanner,  ctx, params);
    }

    /**
     * Instantiates a new collection for deserialization process.
     * @return the new collection
     */
    protected abstract C newCollection();

    /**
     * <p>isNullValueAllowed</p>
     * @return true if the collection accepts null value
     */
    protected boolean isNullValueAllowed() {
        return true;
    }
}
