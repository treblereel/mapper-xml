/*
 * Copyright 2014 Nicolas Morel
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

package org.treblereel.gwt.jackson.api.deser.bean;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.deser.BaseNumberXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.BooleanXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.StringXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.collection.ArrayListXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.map.LinkedHashMapXMLDeserializer;
import org.treblereel.gwt.jackson.api.deser.map.key.StringKeyDeserializer;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * <p>Abstract AbstractObjectBeanXMLDeserializer class.</p>
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
@SuppressWarnings("UnusedDeclaration")
public abstract class AbstractObjectBeanXMLDeserializer extends AbstractBeanXMLDeserializer<Object> {

    private ArrayListXMLDeserializer<Object> listXMLDeserializer;

    private LinkedHashMapXMLDeserializer<String, Object> mapXMLDeserializer;

    /** {@inheritDoc} */
    @Override
    protected boolean canDeserialize() {
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public Object deserializeWrapped(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params,
                                     IdentityDeserializationInfo identityInfo, TypeDeserializationInfo typeInfo, String typeInformation) {
        switch (reader.peek()) {
            case NUMBER:
                return BaseNumberXMLDeserializer.NumberXMLDeserializer.getInstance().doDeserialize(reader, ctx, params);
            case STRING:
                return StringXMLDeserializer.getInstance().doDeserialize(reader, ctx, params);
            case BOOLEAN:
                return BooleanXMLDeserializer.getInstance().doDeserialize(reader, ctx, params);
            case BEGIN_ARRAY:
                if (null == listXMLDeserializer) {
                    listXMLDeserializer = ArrayListXMLDeserializer.newInstance(this);
                }
                return listXMLDeserializer.doDeserialize(reader, ctx, params);
            case BEGIN_OBJECT:
                if (null == mapXMLDeserializer) {
                    mapXMLDeserializer = LinkedHashMapXMLDeserializer.newInstance(StringKeyDeserializer.getInstance(), this);
                }
                return mapXMLDeserializer.doDeserialize(reader, ctx, params);
            case NULL:
                reader.nextNull();
                return null;
            default:
                throw ctx.traceError("Unexpected token " + reader.peek() + " for java.lang.Object deserialization", reader);
        }
    }

}
