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
 * Java class for OUTLIER-TREATMENT-METHOD.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="OUTLIER-TREATMENT-METHOD"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="asIs"/&gt;
 *     &lt;enumeration value="asMissingValues"/&gt;
 *     &lt;enumeration value="asExtremeValues"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "OUTLIER-TREATMENT-METHOD")
@XmlEnum
@JsType
public enum OUTLIERTREATMENTMETHOD {
  @XmlEnumValue("asIs")
  AS_IS("asIs"),
  @XmlEnumValue("asMissingValues")
  AS_MISSING_VALUES("asMissingValues"),
  @XmlEnumValue("asExtremeValues")
  AS_EXTREME_VALUES("asExtremeValues");
  private final String value;

  OUTLIERTREATMENTMETHOD(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static OUTLIERTREATMENTMETHOD fromValue(String v) {
    for (OUTLIERTREATMENTMETHOD c : OUTLIERTREATMENTMETHOD.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
