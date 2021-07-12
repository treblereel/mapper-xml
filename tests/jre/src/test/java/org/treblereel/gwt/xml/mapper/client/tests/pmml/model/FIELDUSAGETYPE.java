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
 * Java class for FIELD-USAGE-TYPE.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="FIELD-USAGE-TYPE"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="active"/&gt;
 *     &lt;enumeration value="predicted"/&gt;
 *     &lt;enumeration value="target"/&gt;
 *     &lt;enumeration value="supplementary"/&gt;
 *     &lt;enumeration value="group"/&gt;
 *     &lt;enumeration value="order"/&gt;
 *     &lt;enumeration value="frequencyWeight"/&gt;
 *     &lt;enumeration value="analysisWeight"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "FIELD-USAGE-TYPE")
@XmlEnum
@JsType
public enum FIELDUSAGETYPE {
  @XmlEnumValue("active")
  ACTIVE("active"),
  @XmlEnumValue("predicted")
  PREDICTED("predicted"),
  @XmlEnumValue("target")
  TARGET("target"),
  @XmlEnumValue("supplementary")
  SUPPLEMENTARY("supplementary"),
  @XmlEnumValue("group")
  GROUP("group"),
  @XmlEnumValue("order")
  ORDER("order"),
  @XmlEnumValue("frequencyWeight")
  FREQUENCY_WEIGHT("frequencyWeight"),
  @XmlEnumValue("analysisWeight")
  ANALYSIS_WEIGHT("analysisWeight");
  private final String value;

  FIELDUSAGETYPE(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static FIELDUSAGETYPE fromValue(String v) {
    for (FIELDUSAGETYPE c : FIELDUSAGETYPE.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
