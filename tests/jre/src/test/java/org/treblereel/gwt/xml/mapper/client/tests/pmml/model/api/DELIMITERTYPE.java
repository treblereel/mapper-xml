//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for DELIMITER-TYPE.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="DELIMITER-TYPE"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="sameTimeWindow"/&gt;
 *     &lt;enumeration value="acrossTimeWindows"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "DELIMITER-TYPE")
@XmlEnum
public enum DELIMITERTYPE {
  @XmlEnumValue("sameTimeWindow")
  SAME_TIME_WINDOW("sameTimeWindow"),
  @XmlEnumValue("acrossTimeWindows")
  ACROSS_TIME_WINDOWS("acrossTimeWindows");
  private final String value;

  DELIMITERTYPE(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static DELIMITERTYPE fromValue(String v) {
    for (DELIMITERTYPE c : DELIMITERTYPE.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}