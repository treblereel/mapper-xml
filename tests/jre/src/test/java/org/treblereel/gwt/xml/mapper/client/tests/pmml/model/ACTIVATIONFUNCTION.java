/*
 * Copyright © 2021 Treblereel
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

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import jsinterop.annotations.JsType;

/**
 * Java class for ACTIVATION-FUNCTION.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="ACTIVATION-FUNCTION"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="threshold"/&gt;
 *     &lt;enumeration value="logistic"/&gt;
 *     &lt;enumeration value="tanh"/&gt;
 *     &lt;enumeration value="identity"/&gt;
 *     &lt;enumeration value="exponential"/&gt;
 *     &lt;enumeration value="reciprocal"/&gt;
 *     &lt;enumeration value="square"/&gt;
 *     &lt;enumeration value="Gauss"/&gt;
 *     &lt;enumeration value="sine"/&gt;
 *     &lt;enumeration value="cosine"/&gt;
 *     &lt;enumeration value="Elliott"/&gt;
 *     &lt;enumeration value="arctan"/&gt;
 *     &lt;enumeration value="rectifier"/&gt;
 *     &lt;enumeration value="radialBasis"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ACTIVATION-FUNCTION")
@XmlEnum
@JsType
public enum ACTIVATIONFUNCTION {
  @XmlEnumValue("threshold")
  THRESHOLD("threshold"),
  @XmlEnumValue("logistic")
  LOGISTIC("logistic"),
  @XmlEnumValue("tanh")
  TANH("tanh"),
  @XmlEnumValue("identity")
  IDENTITY("identity"),
  @XmlEnumValue("exponential")
  EXPONENTIAL("exponential"),
  @XmlEnumValue("reciprocal")
  RECIPROCAL("reciprocal"),
  @XmlEnumValue("square")
  SQUARE("square"),
  @XmlEnumValue("Gauss")
  GAUSS("Gauss"),
  @XmlEnumValue("sine")
  SINE("sine"),
  @XmlEnumValue("cosine")
  COSINE("cosine"),
  @XmlEnumValue("Elliott")
  ELLIOTT("Elliott"),
  @XmlEnumValue("arctan")
  ARCTAN("arctan"),
  @XmlEnumValue("rectifier")
  RECTIFIER("rectifier"),
  @XmlEnumValue("radialBasis")
  RADIAL_BASIS("radialBasis");
  private final String value;

  ACTIVATIONFUNCTION(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static ACTIVATIONFUNCTION fromValue(String v) {
    for (ACTIVATIONFUNCTION c : ACTIVATIONFUNCTION.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
