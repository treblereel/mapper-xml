//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:18 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.impl.v4_4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for TIME-ANCHOR-TYPE.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="TIME-ANCHOR-TYPE"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="dateTimeMillisecondsSince[0]"/&gt;
 *     &lt;enumeration value="dateTimeMillisecondsSince[1960]"/&gt;
 *     &lt;enumeration value="dateTimeMillisecondsSince[1970]"/&gt;
 *     &lt;enumeration value="dateTimeMillisecondsSince[1980]"/&gt;
 *     &lt;enumeration value="dateTimeSecondsSince[0]"/&gt;
 *     &lt;enumeration value="dateTimeSecondsSince[1960]"/&gt;
 *     &lt;enumeration value="dateTimeSecondsSince[1970]"/&gt;
 *     &lt;enumeration value="dateTimeSecondsSince[1980]"/&gt;
 *     &lt;enumeration value="dateDaysSince[0]"/&gt;
 *     &lt;enumeration value="dateDaysSince[1960]"/&gt;
 *     &lt;enumeration value="dateDaysSince[1970]"/&gt;
 *     &lt;enumeration value="dateDaysSince[1980]"/&gt;
 *     &lt;enumeration value="dateMonthsSince[0]"/&gt;
 *     &lt;enumeration value="dateMonthsSince[1960]"/&gt;
 *     &lt;enumeration value="dateMonthsSince[1970]"/&gt;
 *     &lt;enumeration value="dateMonthsSince[1980]"/&gt;
 *     &lt;enumeration value="dateYearsSince[0]"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TIME-ANCHOR-TYPE")
@XmlEnum
public enum TIMEANCHORTYPE {
  @XmlEnumValue("dateTimeMillisecondsSince[0]")
  DATE_TIME_MILLISECONDS_SINCE_0("dateTimeMillisecondsSince[0]"),
  @XmlEnumValue("dateTimeMillisecondsSince[1960]")
  DATE_TIME_MILLISECONDS_SINCE_1960("dateTimeMillisecondsSince[1960]"),
  @XmlEnumValue("dateTimeMillisecondsSince[1970]")
  DATE_TIME_MILLISECONDS_SINCE_1970("dateTimeMillisecondsSince[1970]"),
  @XmlEnumValue("dateTimeMillisecondsSince[1980]")
  DATE_TIME_MILLISECONDS_SINCE_1980("dateTimeMillisecondsSince[1980]"),
  @XmlEnumValue("dateTimeSecondsSince[0]")
  DATE_TIME_SECONDS_SINCE_0("dateTimeSecondsSince[0]"),
  @XmlEnumValue("dateTimeSecondsSince[1960]")
  DATE_TIME_SECONDS_SINCE_1960("dateTimeSecondsSince[1960]"),
  @XmlEnumValue("dateTimeSecondsSince[1970]")
  DATE_TIME_SECONDS_SINCE_1970("dateTimeSecondsSince[1970]"),
  @XmlEnumValue("dateTimeSecondsSince[1980]")
  DATE_TIME_SECONDS_SINCE_1980("dateTimeSecondsSince[1980]"),
  @XmlEnumValue("dateDaysSince[0]")
  DATE_DAYS_SINCE_0("dateDaysSince[0]"),
  @XmlEnumValue("dateDaysSince[1960]")
  DATE_DAYS_SINCE_1960("dateDaysSince[1960]"),
  @XmlEnumValue("dateDaysSince[1970]")
  DATE_DAYS_SINCE_1970("dateDaysSince[1970]"),
  @XmlEnumValue("dateDaysSince[1980]")
  DATE_DAYS_SINCE_1980("dateDaysSince[1980]"),
  @XmlEnumValue("dateMonthsSince[0]")
  DATE_MONTHS_SINCE_0("dateMonthsSince[0]"),
  @XmlEnumValue("dateMonthsSince[1960]")
  DATE_MONTHS_SINCE_1960("dateMonthsSince[1960]"),
  @XmlEnumValue("dateMonthsSince[1970]")
  DATE_MONTHS_SINCE_1970("dateMonthsSince[1970]"),
  @XmlEnumValue("dateMonthsSince[1980]")
  DATE_MONTHS_SINCE_1980("dateMonthsSince[1980]"),
  @XmlEnumValue("dateYearsSince[0]")
  DATE_YEARS_SINCE_0("dateYearsSince[0]");
  private final String value;

  TIMEANCHORTYPE(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static TIMEANCHORTYPE fromValue(String v) {
    for (TIMEANCHORTYPE c : TIMEANCHORTYPE.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}