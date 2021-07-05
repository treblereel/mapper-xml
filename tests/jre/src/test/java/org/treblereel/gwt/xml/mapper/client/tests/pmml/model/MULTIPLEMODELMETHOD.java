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
 * Java class for MULTIPLE-MODEL-METHOD.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="MULTIPLE-MODEL-METHOD"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="majorityVote"/&gt;
 *     &lt;enumeration value="weightedMajorityVote"/&gt;
 *     &lt;enumeration value="average"/&gt;
 *     &lt;enumeration value="weightedAverage"/&gt;
 *     &lt;enumeration value="median"/&gt;
 *     &lt;enumeration value="weightedMedian"/&gt;
 *     &lt;enumeration value="max"/&gt;
 *     &lt;enumeration value="sum"/&gt;
 *     &lt;enumeration value="weightedSum"/&gt;
 *     &lt;enumeration value="selectFirst"/&gt;
 *     &lt;enumeration value="selectAll"/&gt;
 *     &lt;enumeration value="modelChain"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "MULTIPLE-MODEL-METHOD")
@XmlEnum
@JsType
public enum MULTIPLEMODELMETHOD {
  @XmlEnumValue("majorityVote")
  MAJORITY_VOTE("majorityVote"),
  @XmlEnumValue("weightedMajorityVote")
  WEIGHTED_MAJORITY_VOTE("weightedMajorityVote"),
  @XmlEnumValue("average")
  AVERAGE("average"),
  @XmlEnumValue("weightedAverage")
  WEIGHTED_AVERAGE("weightedAverage"),
  @XmlEnumValue("median")
  MEDIAN("median"),
  @XmlEnumValue("weightedMedian")
  WEIGHTED_MEDIAN("weightedMedian"),
  @XmlEnumValue("max")
  MAX("max"),
  @XmlEnumValue("sum")
  SUM("sum"),
  @XmlEnumValue("weightedSum")
  WEIGHTED_SUM("weightedSum"),
  @XmlEnumValue("selectFirst")
  SELECT_FIRST("selectFirst"),
  @XmlEnumValue("selectAll")
  SELECT_ALL("selectAll"),
  @XmlEnumValue("modelChain")
  MODEL_CHAIN("modelChain");
  private final String value;

  MULTIPLEMODELMETHOD(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static MULTIPLEMODELMETHOD fromValue(String v) {
    for (MULTIPLEMODELMETHOD c : MULTIPLEMODELMETHOD.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
