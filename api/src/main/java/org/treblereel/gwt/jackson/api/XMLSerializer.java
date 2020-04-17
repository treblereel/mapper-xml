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

import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.exception.XMLSerializationException;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;
import org.treblereel.gwt.jackson.api.utils.Pair;

/**
 * Base class for all the serializer. It handles null values and exceptions. The rest is delegated to implementations.
 * @author Nicolas Morel
 * @version $Id: $Id
 */
public abstract class XMLSerializer<T> {

    protected String propertyName;

    protected boolean cdata = false;

    protected boolean isAttribute = false;

    protected List<Pair<String, String>> parentNs;

    protected String namespace;

    protected String prefix;

    protected String defaultNamespace;

    public XMLSerializer<T> setPropertyName(String propertyName) {
        this.propertyName = propertyName;
        return this;
    }

    public XMLSerializer<T> setCdata(boolean cdata) {
        this.cdata = cdata;
        return this;
    }

    public XMLSerializer<T> isAttribute(boolean isAttribute) {
        this.isAttribute = isAttribute;
        return this;
    }

    public XMLSerializer<T> setNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public XMLSerializer<T> setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public XMLSerializer<T> setParentNS(List<Pair<String, String>> parentNs) {
        this.parentNs = parentNs;
        return this;
    }

    /**
     * Serializes an object into XML output.
     * @param writer {@link XMLWriter} used to write the serialized XML
     * @param value Object to serialize
     * @param ctx Context for the full serialization process
     * @throws XMLSerializationException if an error occurs during the serialization
     */
    public void serialize(XMLWriter writer, T value, XMLSerializationContext ctx) throws XMLSerializationException, XMLStreamException {
        serialize(writer, value, ctx, ctx.defaultParameters());
    }

    /**
     * Serializes an object into XML output.
     * @param writer {@link XMLWriter} used to write the serialized XML
     * @param value Object to serialize
     * @param ctx Context for the full serialization process
     * @param params Parameters for this serialization
     * @throws XMLSerializationException if an error occurs during the serialization
     */
    public void serialize(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters params) throws
            XMLSerializationException, XMLStreamException {
        serialize(writer, value, ctx, params, false);
    }

    /**
     * Serializes an object into XML output.
     * @param writer {@link XMLWriter} used to write the serialized XML
     * @param value Object to serialize
     * @param ctx Context for the full serialization process
     * @param params Parameters for this serialization
     * @param isMapValue indicate if you're serializing a Map value
     * @throws XMLSerializationException if an error occurs during the serialization
     */
    public void serialize(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters params, boolean isMapValue) throws
            XMLSerializationException, XMLStreamException {
        if (null == value && !isAttribute) {
            if (ctx.isSerializeNulls() || (isMapValue && ctx.isWriteNullMapValues())) {
                serializeNullValue(writer, ctx, params);
            } else {
                writer.nullValue();
            }
        } else {
            doSerialize(writer, value, ctx, params);
        }
    }

    protected void writeNamespace(XMLWriter writer) throws XMLStreamException {
        if (!getXmlNs().isEmpty()) {
            for (Pair<String, String> pair : getXmlNs()) {
                if (pair.key == null) {
                    this.defaultNamespace = pair.value;
                    writer.writeDefaultNamespace(defaultNamespace);
                } else {
                    writer.writeNamespace(pair.key, pair.value);
                }
            }
        }
        if (prefix == null && namespace != null) {
            writer.writeAttrNamespace(namespace);
        }

        writeSchemaLocation(writer);
        writeTargetNamespace(writer);
        writer.endNs();
    }

    private void writeSchemaLocation(XMLWriter writer) throws XMLStreamException {
        if (getSchemaLocation() != null) {
            writer.writeSchemaLocation("xsi:schemaLocation", getSchemaLocation());
        }
    }

    private void writeTargetNamespace(XMLWriter writer) throws XMLStreamException {
        if (getTargetNamespace() != null) {
            writer.writeTargetNamespace(getTargetNamespace().value);
        }
    }

    protected String getXmlRootElement() {
        return null;
    }

    protected List<Pair<String, String>> getXmlNs() {
        return null;
    }

    protected String getSchemaLocation() {
        return null;
    }

    protected Pair<String, String> getTargetNamespace() {
        return null;
    }

    /**
     * Serialize the null value. This method allows children to override the default behaviour.
     * @param writer {@link XMLWriter} used to write the serialized XML
     * @param ctx Context for the full serialization process
     * @param params Parameters for this serialization
     */
    protected void serializeNullValue(XMLWriter writer, XMLSerializationContext ctx, XMLSerializerParameters params) throws XMLStreamException {
        writer.nullValue();
    }

    /**
     * Serializes a non-null object into XML output.
     * @param writer {@link XMLWriter} used to write the serialized XML
     * @param value Object to serialize
     * @param ctx Context for the full serialization process
     * @param params Parameters for this serialization
     */
    protected abstract void doSerialize(XMLWriter writer, T value, XMLSerializationContext ctx, XMLSerializerParameters
            params) throws XMLStreamException;

    /**
     * <p>isEmpty.</p>
     * @param value the value
     * @return true if the value is empty
     */
    protected boolean isEmpty(T value) {
        return null == value;
    }
}
