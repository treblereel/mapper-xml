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
 * Java class for DATATYPE.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="DATATYPE"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="string"/&gt;
 *     &lt;enumeration value="integer"/&gt;
 *     &lt;enumeration value="float"/&gt;
 *     &lt;enumeration value="double"/&gt;
 *     &lt;enumeration value="boolean"/&gt;
 *     &lt;enumeration value="date"/&gt;
 *     &lt;enumeration value="time"/&gt;
 *     &lt;enumeration value="dateTime"/&gt;
 *     &lt;enumeration value="dateDaysSince[0]"/&gt;
 *     &lt;enumeration value="dateDaysSince[1960]"/&gt;
 *     &lt;enumeration value="dateDaysSince[1970]"/&gt;
 *     &lt;enumeration value="dateDaysSince[1980]"/&gt;
 *     &lt;enumeration value="timeSeconds"/&gt;
 *     &lt;enumeration value="dateTimeSecondsSince[0]"/&gt;
 *     &lt;enumeration value="dateTimeSecondsSince[1960]"/&gt;
 *     &lt;enumeration value="dateTimeSecondsSince[1970]"/&gt;
 *     &lt;enumeration value="dateTimeSecondsSince[1980]"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "DATATYPE")
@XmlEnum
@JsType
public enum DATATYPE {
  @XmlEnumValue("string")
  STRING("string"),
  @XmlEnumValue("integer")
  INTEGER("integer"),
  @XmlEnumValue("float")
  FLOAT("float"),
  @XmlEnumValue("double")
  DOUBLE("double"),
  @XmlEnumValue("boolean")
  BOOLEAN("boolean"),
  @XmlEnumValue("date")
  DATE("date"),
  @XmlEnumValue("time")
  TIME("time"),
  @XmlEnumValue("dateTime")
  DATE_TIME("dateTime"),
  @XmlEnumValue("dateDaysSince[0]")
  DATE_DAYS_SINCE_0("dateDaysSince[0]"),
  @XmlEnumValue("dateDaysSince[1960]")
  DATE_DAYS_SINCE_1960("dateDaysSince[1960]"),
  @XmlEnumValue("dateDaysSince[1970]")
  DATE_DAYS_SINCE_1970("dateDaysSince[1970]"),
  @XmlEnumValue("dateDaysSince[1980]")
  DATE_DAYS_SINCE_1980("dateDaysSince[1980]"),
  @XmlEnumValue("timeSeconds")
  TIME_SECONDS("timeSeconds"),
  @XmlEnumValue("dateTimeSecondsSince[0]")
  DATE_TIME_SECONDS_SINCE_0("dateTimeSecondsSince[0]"),
  @XmlEnumValue("dateTimeSecondsSince[1960]")
  DATE_TIME_SECONDS_SINCE_1960("dateTimeSecondsSince[1960]"),
  @XmlEnumValue("dateTimeSecondsSince[1970]")
  DATE_TIME_SECONDS_SINCE_1970("dateTimeSecondsSince[1970]"),
  @XmlEnumValue("dateTimeSecondsSince[1980]")
  DATE_TIME_SECONDS_SINCE_1980("dateTimeSecondsSince[1980]");
  private final String value;

  DATATYPE(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static DATATYPE fromValue(String v) {
    for (DATATYPE c : DATATYPE.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
