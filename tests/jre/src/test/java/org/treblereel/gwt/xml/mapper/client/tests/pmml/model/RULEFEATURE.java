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
 * Java class for RULE-FEATURE.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="RULE-FEATURE"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="antecedent"/&gt;
 *     &lt;enumeration value="consequent"/&gt;
 *     &lt;enumeration value="rule"/&gt;
 *     &lt;enumeration value="ruleId"/&gt;
 *     &lt;enumeration value="confidence"/&gt;
 *     &lt;enumeration value="support"/&gt;
 *     &lt;enumeration value="lift"/&gt;
 *     &lt;enumeration value="leverage"/&gt;
 *     &lt;enumeration value="affinity"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "RULE-FEATURE")
@XmlEnum
@JsType
public enum RULEFEATURE {
  @XmlEnumValue("antecedent")
  ANTECEDENT("antecedent"),
  @XmlEnumValue("consequent")
  CONSEQUENT("consequent"),
  @XmlEnumValue("rule")
  RULE("rule"),
  @XmlEnumValue("ruleId")
  RULE_ID("ruleId"),
  @XmlEnumValue("confidence")
  CONFIDENCE("confidence"),
  @XmlEnumValue("support")
  SUPPORT("support"),
  @XmlEnumValue("lift")
  LIFT("lift"),
  @XmlEnumValue("leverage")
  LEVERAGE("leverage"),
  @XmlEnumValue("affinity")
  AFFINITY("affinity");
  private final String value;

  RULEFEATURE(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static RULEFEATURE fromValue(String v) {
    for (RULEFEATURE c : RULEFEATURE.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
