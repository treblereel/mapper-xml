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
 * Java class for MISSING-VALUE-STRATEGY.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="MISSING-VALUE-STRATEGY"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="lastPrediction"/&gt;
 *     &lt;enumeration value="nullPrediction"/&gt;
 *     &lt;enumeration value="defaultChild"/&gt;
 *     &lt;enumeration value="weightedConfidence"/&gt;
 *     &lt;enumeration value="aggregateNodes"/&gt;
 *     &lt;enumeration value="none"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "MISSING-VALUE-STRATEGY")
@XmlEnum
@JsType
public enum MISSINGVALUESTRATEGY {
  @XmlEnumValue("lastPrediction")
  LAST_PREDICTION("lastPrediction"),
  @XmlEnumValue("nullPrediction")
  NULL_PREDICTION("nullPrediction"),
  @XmlEnumValue("defaultChild")
  DEFAULT_CHILD("defaultChild"),
  @XmlEnumValue("weightedConfidence")
  WEIGHTED_CONFIDENCE("weightedConfidence"),
  @XmlEnumValue("aggregateNodes")
  AGGREGATE_NODES("aggregateNodes"),
  @XmlEnumValue("none")
  NONE("none");
  private final String value;

  MISSINGVALUESTRATEGY(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static MISSINGVALUESTRATEGY fromValue(String v) {
    for (MISSINGVALUESTRATEGY c : MISSINGVALUESTRATEGY.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
