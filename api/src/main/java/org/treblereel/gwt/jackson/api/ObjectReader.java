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

import org.treblereel.gwt.jackson.api.deser.array.ArrayXMLDeserializer;
import org.treblereel.gwt.jackson.api.exception.XMLDeserializationException;

/**
 * Reads a XML input and return an object
 * <p>Example : </p>
 * <pre>
 * public class Person {
 *     public String firstName, lastName;
 * }
 *
 * public interface PersonReader extends ObjectReader&lt;Person&gt; {}
 *
 * PersonReader reader = new PersonReaderMapperImpl();
 * Person person = reader.read("{\"firstName\":\"Nicolas\",\"lastName\":\"Morel\"}"); //TODO
 *
 * person.firstName ==&gt; "Nicolas"
 * person.lastName  ==&gt; "Morel"
 * </pre>
 *
 * @param <T> Type of the read object
 * @author Nicolas Morel
 * @version $Id: $
 */
public interface ObjectReader<T> {

    /**
     * Reads a XML input into an object.
     *
     * @param input XML input to read
     * @return the read object
     * @throws XMLDeserializationException if an exception occurs while reading the input
     */
    T read(String input) throws XMLDeserializationException;

    /**
     * Reads a XML input into an object.
     *
     * @param input XML input to read
     * @param ctx   Context for the full reading process
     * @return the read object
     * @throws XMLDeserializationException if an exception occurs while reading the input
     */
    T read(String input, XMLDeserializationContext ctx) throws XMLDeserializationException;

    /**
     * Reads a XML input into an array object.
     *
     * @param input        XML input to read
     * @param arrayCreator Creator for initializing new instance of an array of specific length
     * @return the read array object
     * @throws XMLDeserializationException if an exception occurs while reading the input
     */
    T[] readArray(String input, ArrayXMLDeserializer.ArrayCreator<T> arrayCreator) throws XMLDeserializationException;

    /**
     * Reads a XML input into an array object.
     *
     * @param input        XML input to read
     * @param ctx          Context for the full reading process
     * @param arrayCreator Creator for initializing new instance of an array of specific length
     * @return the read array object
     * @throws XMLDeserializationException if an exception occurs while reading the input
     */
    T[] readArray(String input, XMLDeserializationContext ctx, ArrayXMLDeserializer.ArrayCreator<T> arrayCreator) throws XMLDeserializationException;


    /**
     * <p>getDeserializer.</p>
     *
     * @return a {@link XMLDeserializer} object.
     */
    XMLDeserializer<T> getDeserializer();
}
