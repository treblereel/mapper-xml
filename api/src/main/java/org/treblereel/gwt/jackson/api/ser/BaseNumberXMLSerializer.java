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

import java.math.BigDecimal;
import java.math.BigInteger;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializer;
import org.treblereel.gwt.jackson.api.XMLSerializerParameters;
import org.treblereel.gwt.jackson.api.stream.XMLWriter;

/**
 * Base implementation of {@link XMLSerializer} for {@link Number}.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class BaseNumberXMLSerializer<N extends Number> extends XMLSerializer<N> {

    /**
     * Default implementation of {@link BaseNumberXMLSerializer} for {@link BigDecimal}
     */
    public static final class BigDecimalXMLSerializer extends BaseNumberXMLSerializer<BigDecimal> {

        private static final BigDecimalXMLSerializer INSTANCE = new BigDecimalXMLSerializer();

        /**
         * @return an instance of {@link BigDecimalXMLSerializer}
         */
        public static BigDecimalXMLSerializer getInstance() {
            return INSTANCE;
        }

        private BigDecimalXMLSerializer() {
        }

        @Override
        protected boolean isDefault(BigDecimal value) {
            return null == value || BigDecimal.ZERO.compareTo(value) == 0;
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLSerializer} for {@link BigInteger}
     */
    public static final class BigIntegerXMLSerializer extends BaseNumberXMLSerializer<BigInteger> {

        private static final BigIntegerXMLSerializer INSTANCE = new BigIntegerXMLSerializer();

        /**
         * @return an instance of {@link BigIntegerXMLSerializer}
         */
        public static BigIntegerXMLSerializer getInstance() {
            return INSTANCE;
        }

        private BigIntegerXMLSerializer() {
        }

        @Override
        protected boolean isDefault(BigInteger value) {
            return null == value || BigInteger.ZERO.compareTo(value) == 0;
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLSerializer} for {@link Byte}
     */
    public static final class ByteXMLSerializer extends BaseNumberXMLSerializer<Byte> {

        private static final ByteXMLSerializer INSTANCE = new ByteXMLSerializer();

        /**
         * @return an instance of {@link ByteXMLSerializer}
         */
        public static ByteXMLSerializer getInstance() {
            return INSTANCE;
        }

        private static byte defaultValue;

        private ByteXMLSerializer() {
        }

        @Override
        protected boolean isDefault(Byte value) {
            return null == value || defaultValue == value;
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLSerializer} for {@link Double}
     */
    public static final class DoubleXMLSerializer extends BaseNumberXMLSerializer<Double> {

        private static final DoubleXMLSerializer INSTANCE = new DoubleXMLSerializer();

        /**
         * @return an instance of {@link DoubleXMLSerializer}
         */
        public static DoubleXMLSerializer getInstance() {
            return INSTANCE;
        }

        private DoubleXMLSerializer() {
        }

        @Override
        protected boolean isDefault(Double value) {
            return null == value || value == 0d;
        }

        @Override
        public void doSerialize(XMLWriter writer, Double value, XMLSerializationContext ctx, XMLSerializerParameters params) {
            // writer has a special method to write double, let's use instead of default Number method.
            writer.value(value.doubleValue());
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLSerializer} for {@link Float}
     */
    public static final class FloatXMLSerializer extends BaseNumberXMLSerializer<Float> {

        private static final FloatXMLSerializer INSTANCE = new FloatXMLSerializer();

        /**
         * @return an instance of {@link FloatXMLSerializer}
         */
        public static FloatXMLSerializer getInstance() {
            return INSTANCE;
        }

        private FloatXMLSerializer() {
        }

        @Override
        protected boolean isDefault(Float value) {
            return null == value || value == 0f;
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLSerializer} for {@link Integer}
     */
    public static final class IntegerXMLSerializer extends BaseNumberXMLSerializer<Integer> {

        private static final IntegerXMLSerializer INSTANCE = new IntegerXMLSerializer();

        /**
         * @return an instance of {@link IntegerXMLSerializer}
         */
        public static IntegerXMLSerializer getInstance() {
            return INSTANCE;
        }

        private IntegerXMLSerializer() {
        }

        @Override
        protected boolean isDefault(Integer value) {
            return null == value || value == 0;
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLSerializer} for {@link Long}
     */
    public static final class LongXMLSerializer extends BaseNumberXMLSerializer<Long> {

        private static final LongXMLSerializer INSTANCE = new LongXMLSerializer();

        /**
         * @return an instance of {@link LongXMLSerializer}
         */
        public static LongXMLSerializer getInstance() {
            return INSTANCE;
        }

        private LongXMLSerializer() {
        }

        @Override
        protected boolean isDefault(Long value) {
            return null == value || value == 0l;
        }

        @Override
        public void doSerialize(XMLWriter writer, Long value, XMLSerializationContext ctx, XMLSerializerParameters params) {
            // writer has a special method to write long, let's use instead of default Number method.
            writer.value(value.longValue());
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLSerializer} for {@link Short}
     */
    public static final class ShortXMLSerializer extends BaseNumberXMLSerializer<Short> {

        private static final ShortXMLSerializer INSTANCE = new ShortXMLSerializer();

        /**
         * @return an instance of {@link ShortXMLSerializer}
         */
        public static ShortXMLSerializer getInstance() {
            return INSTANCE;
        }

        private static short defaultValue;

        private ShortXMLSerializer() {
        }

        @Override
        protected boolean isDefault(Short value) {
            return null == value || defaultValue == value;
        }
    }

    /**
     * Default implementation of {@link BaseNumberXMLSerializer} for {@link Number}
     */
    public static final class NumberXMLSerializer extends BaseNumberXMLSerializer<Number> {

        private static final NumberXMLSerializer INSTANCE = new NumberXMLSerializer();

        /**
         * @return an instance of {@link NumberXMLSerializer}
         */
        public static NumberXMLSerializer getInstance() {
            return INSTANCE;
        }

        private NumberXMLSerializer() {
        }

        @Override
        protected boolean isDefault(Number value) {
            return null == value || value.intValue() == 0;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void doSerialize(XMLWriter writer, N value, XMLSerializationContext ctx, XMLSerializerParameters params) {
        writer.value(value);
    }
}
