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
 * Java class for INTERPOLATION-METHOD.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="INTERPOLATION-METHOD"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="none"/&gt;
 *     &lt;enumeration value="linear"/&gt;
 *     &lt;enumeration value="exponentialSpline"/&gt;
 *     &lt;enumeration value="cubicSpline"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "INTERPOLATION-METHOD")
@XmlEnum
@JsType
public enum INTERPOLATIONMETHOD {
  @XmlEnumValue("none")
  NONE("none"),
  @XmlEnumValue("linear")
  LINEAR("linear"),
  @XmlEnumValue("exponentialSpline")
  EXPONENTIAL_SPLINE("exponentialSpline"),
  @XmlEnumValue("cubicSpline")
  CUBIC_SPLINE("cubicSpline");
  private final String value;

  INTERPOLATIONMETHOD(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static INTERPOLATIONMETHOD fromValue(String v) {
    for (INTERPOLATIONMETHOD c : INTERPOLATIONMETHOD.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
