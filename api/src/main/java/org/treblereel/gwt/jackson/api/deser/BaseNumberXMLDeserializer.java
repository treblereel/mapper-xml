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

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLReader;
import org.treblereel.gwt.jackson.api.stream.XMLToken;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Base implementation of {@link XMLDeserializer} for {@link java.lang.Number}.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class BaseNumberXMLDeserializer<N extends Number> extends XMLDeserializer<N> {

    /**
     * Default implementation of {@link BaseNumberXMLDeserializer} for {@link BigDecimal}
     */
    public static final class BigDecimalXMLDeserializer extends BaseNumberXMLDeserializer<BigDecimal> {

        private static final BigDecimalXMLDeserializer INSTANCE = new BigDecimalXMLDeserializer();

        /**
         * @return an instance of {@link BigDecimalXMLDeserializer}
         */
        public static BigDecimalXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private BigDecimalXMLDeserializer() {
        }

        @Override
        protected BigDecimal doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return new BigDecimal(reader.nextString());
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLDeserializer} for {@link BigInteger}
     */
    public static final class BigIntegerXMLDeserializer extends BaseNumberXMLDeserializer<BigInteger> {

        private static final BigIntegerXMLDeserializer INSTANCE = new BigIntegerXMLDeserializer();

        /**
         * @return an instance of {@link BigIntegerXMLDeserializer}
         */
        public static BigIntegerXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private BigIntegerXMLDeserializer() {
        }

        @Override
        protected BigInteger doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return new BigInteger(reader.nextString());
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLDeserializer} for {@link Byte}
     */
    public static final class ByteXMLDeserializer extends BaseNumberXMLDeserializer<Byte> {

        private static final ByteXMLDeserializer INSTANCE = new ByteXMLDeserializer();

        /**
         * @return an instance of {@link ByteXMLDeserializer}
         */
        public static ByteXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private ByteXMLDeserializer() {
        }

        @Override
        protected Byte doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return (byte) reader.nextInt();
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLDeserializer} for {@link Double}
     */
    public static final class DoubleXMLDeserializer extends BaseNumberXMLDeserializer<Double> {

        private static final DoubleXMLDeserializer INSTANCE = new DoubleXMLDeserializer();

        /**
         * @return an instance of {@link DoubleXMLDeserializer}
         */
        public static DoubleXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private DoubleXMLDeserializer() {
        }

        @Override
        protected Double doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return reader.nextDouble();
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLDeserializer} for {@link Float}
     */
    public static final class FloatXMLDeserializer extends BaseNumberXMLDeserializer<Float> {

        private static final FloatXMLDeserializer INSTANCE = new FloatXMLDeserializer();

        /**
         * @return an instance of {@link FloatXMLDeserializer}
         */
        public static FloatXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private FloatXMLDeserializer() {
        }

        @Override
        protected Float doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return Float.parseFloat(reader.nextString());
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLDeserializer} for {@link Integer}
     */
    public static final class IntegerXMLDeserializer extends BaseNumberXMLDeserializer<Integer> {

        private static final IntegerXMLDeserializer INSTANCE = new IntegerXMLDeserializer();

        /**
         * @return an instance of {@link IntegerXMLDeserializer}
         */
        public static IntegerXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private IntegerXMLDeserializer() {
        }

        @Override
        protected Integer doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            if (XMLToken.NUMBER.equals(reader.peek())) {
                return reader.nextInt();
            } else {
                return Integer.parseInt(reader.nextString());
            }
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLDeserializer} for {@link Long}
     */
    public static final class LongXMLDeserializer extends BaseNumberXMLDeserializer<Long> {

        private static final LongXMLDeserializer INSTANCE = new LongXMLDeserializer();

        /**
         * @return an instance of {@link LongXMLDeserializer}
         */
        public static LongXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private LongXMLDeserializer() {
        }

        @Override
        protected Long doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return reader.nextLong();
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLDeserializer} for {@link Short}
     */
    public static final class ShortXMLDeserializer extends BaseNumberXMLDeserializer<Short> {

        private static final ShortXMLDeserializer INSTANCE = new ShortXMLDeserializer();

        /**
         * @return an instance of {@link ShortXMLDeserializer}
         */
        public static ShortXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private ShortXMLDeserializer() {
        }

        @Override
        protected Short doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            if (XMLToken.NUMBER.equals(reader.peek())) {
                return (short) reader.nextInt();
            } else {
                return Short.parseShort(reader.nextString());
            }
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLDeserializer} for {@link Number}
     */
    public static final class NumberXMLDeserializer extends BaseNumberXMLDeserializer<Number> {

        private static final NumberXMLDeserializer INSTANCE = new NumberXMLDeserializer();

        /**
         * @return an instance of {@link NumberXMLDeserializer}
         */
        public static NumberXMLDeserializer getInstance() {
            return INSTANCE;
        }

        private NumberXMLDeserializer() {
        }

        @Override
        public Number doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) {
            return reader.nextNumber();
        }
    }

}
