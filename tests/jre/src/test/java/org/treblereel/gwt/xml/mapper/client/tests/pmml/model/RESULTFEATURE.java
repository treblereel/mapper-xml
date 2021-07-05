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
 * Java class for RESULT-FEATURE.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="RESULT-FEATURE"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="predictedValue"/&gt;
 *     &lt;enumeration value="predictedDisplayValue"/&gt;
 *     &lt;enumeration value="transformedValue"/&gt;
 *     &lt;enumeration value="decision"/&gt;
 *     &lt;enumeration value="probability"/&gt;
 *     &lt;enumeration value="affinity"/&gt;
 *     &lt;enumeration value="residual"/&gt;
 *     &lt;enumeration value="standardError"/&gt;
 *     &lt;enumeration value="standardDeviation"/&gt;
 *     &lt;enumeration value="clusterId"/&gt;
 *     &lt;enumeration value="clusterAffinity"/&gt;
 *     &lt;enumeration value="entityId"/&gt;
 *     &lt;enumeration value="entityAffinity"/&gt;
 *     &lt;enumeration value="warning"/&gt;
 *     &lt;enumeration value="ruleValue"/&gt;
 *     &lt;enumeration value="reasonCode"/&gt;
 *     &lt;enumeration value="antecedent"/&gt;
 *     &lt;enumeration value="consequent"/&gt;
 *     &lt;enumeration value="rule"/&gt;
 *     &lt;enumeration value="ruleId"/&gt;
 *     &lt;enumeration value="confidence"/&gt;
 *     &lt;enumeration value="support"/&gt;
 *     &lt;enumeration value="lift"/&gt;
 *     &lt;enumeration value="leverage"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "RESULT-FEATURE")
@XmlEnum
@JsType
public enum RESULTFEATURE {
  @XmlEnumValue("predictedValue")
  PREDICTED_VALUE("predictedValue"),
  @XmlEnumValue("predictedDisplayValue")
  PREDICTED_DISPLAY_VALUE("predictedDisplayValue"),
  @XmlEnumValue("transformedValue")
  TRANSFORMED_VALUE("transformedValue"),
  @XmlEnumValue("decision")
  DECISION("decision"),
  @XmlEnumValue("probability")
  PROBABILITY("probability"),
  @XmlEnumValue("affinity")
  AFFINITY("affinity"),
  @XmlEnumValue("residual")
  RESIDUAL("residual"),
  @XmlEnumValue("standardError")
  STANDARD_ERROR("standardError"),
  @XmlEnumValue("standardDeviation")
  STANDARD_DEVIATION("standardDeviation"),
  @XmlEnumValue("clusterId")
  CLUSTER_ID("clusterId"),
  @XmlEnumValue("clusterAffinity")
  CLUSTER_AFFINITY("clusterAffinity"),
  @XmlEnumValue("entityId")
  ENTITY_ID("entityId"),
  @XmlEnumValue("entityAffinity")
  ENTITY_AFFINITY("entityAffinity"),
  @XmlEnumValue("warning")
  WARNING("warning"),
  @XmlEnumValue("ruleValue")
  RULE_VALUE("ruleValue"),
  @XmlEnumValue("reasonCode")
  REASON_CODE("reasonCode"),
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
  LEVERAGE("leverage");
  private final String value;

  RESULTFEATURE(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static RESULTFEATURE fromValue(String v) {
    for (RESULTFEATURE c : RESULTFEATURE.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
