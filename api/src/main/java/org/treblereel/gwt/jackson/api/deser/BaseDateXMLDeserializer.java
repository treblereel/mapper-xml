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

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import org.treblereel.gwt.jackson.api.JacksonContextProvider;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

/**
 * Base implementation of {@link XMLDeserializer} for dates.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class BaseDateXMLDeserializer<D extends Date> extends XMLDeserializer<D> {

    /**
     * Default implementation of {@link BaseDateXMLDeserializer} for {@link Date}
     */
    public static final class DateXMLDeserializer extends BaseDateXMLDeserializer<Date> {

        private static final DateXMLDeserializer INSTANCE = new DateXMLDeserializer();

        /**
         * @return an instance of {@link DateXMLDeserializer}
         */
        public static DateXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private DateXMLDeserializer() {
        }

        @Override
        protected Date deserializeNumber(long millis, XMLDeserializerParameters params) {
            return new Date(millis);
        }

        @Override
        protected Date deserializeString(String date, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return JacksonContextProvider.get().dateFormat().parse(ctx.isUseBrowserTimezone(), params.getPattern(), null, date);
        }
    }

    /**
     * Default implementation of {@link BaseDateXMLDeserializer} for {@link java.sql.Date}
     */
    public static final class SqlDateXMLDeserializer extends BaseDateXMLDeserializer<java.sql.Date> {

        private static final SqlDateXMLDeserializer INSTANCE = new SqlDateXMLDeserializer();

        private static final String SQL_DATE_FORMAT = "yyyy-MM-dd";

        /**
         * @return an instance of {@link SqlDateXMLDeserializer}
         */
        public static SqlDateXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private SqlDateXMLDeserializer() {
        }

        @Override
        protected java.sql.Date deserializeNumber(long millis, XMLDeserializerParameters params) {
            return new java.sql.Date(millis);
        }

        @Override
        protected java.sql.Date deserializeString(String date, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return new java.sql.Date(JacksonContextProvider.get().dateFormat().parse(ctx.isUseBrowserTimezone(), SQL_DATE_FORMAT, false, date).getTime());
        }
    }

    /**
     * Default implementation of {@link BaseDateXMLDeserializer} for {@link Time}
     */
    public static final class SqlTimeXMLDeserializer extends BaseDateXMLDeserializer<Time> {

        private static final SqlTimeXMLDeserializer INSTANCE = new SqlTimeXMLDeserializer();

        /**
         * @return an instance of {@link SqlTimeXMLDeserializer}
         */
        public static SqlTimeXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private SqlTimeXMLDeserializer() {
        }

        @Override
        protected Time deserializeNumber(long millis, XMLDeserializerParameters params) {
            return new Time(millis);
        }

        @Override
        protected Time deserializeString(String date, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return Time.valueOf(date);
        }
    }

    /**
     * Default implementation of {@link BaseDateXMLDeserializer} for {@link Timestamp}
     */
    public static final class SqlTimestampXMLDeserializer extends BaseDateXMLDeserializer<Timestamp> {

        private static final SqlTimestampXMLDeserializer INSTANCE = new SqlTimestampXMLDeserializer();

        /**
         * @return an instance of {@link SqlTimestampXMLDeserializer}
         */
        public static SqlTimestampXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private SqlTimestampXMLDeserializer() {
        }

        @Override
        protected Timestamp deserializeNumber(long millis, XMLDeserializerParameters params) {
            return new Timestamp(millis);
        }

        @Override
        protected Timestamp deserializeString(String date, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return new Timestamp(JacksonContextProvider.get().dateFormat().parse(ctx.isUseBrowserTimezone(), params.getPattern(), null, date).getTime());
        }
    }

    /** {@inheritDoc} */
    @Override
    public D doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
        if (XMLToken.NUMBER.equals(reader.peek())) {
            return deserializeNumber(reader.nextLong(), params);
        } else {
            return deserializeString(reader.nextString(), ctx, params);
        }
    }

    /**
     * <p>deserializeNumber</p>
     *
     * @param millis a long.
     * @param params a {@link XMLDeserializerParameters} object.
     * @return a D object.
     */
    protected abstract D deserializeNumber(long millis, XMLDeserializerParameters params);

    /**
     * <p>deserializeString</p>
     *
     * @param date   a {@link java.lang.String} object.
     * @param ctx    a {@link XMLDeserializationContext} object.
     * @param params a {@link XMLDeserializerParameters} object.
     * @return a D object.
     */
    protected abstract D deserializeString(String date, XMLDeserializationContext ctx, XMLDeserializerParameters params);
}
