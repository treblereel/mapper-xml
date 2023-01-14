//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Java class for COMPARE-FUNCTION.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="COMPARE-FUNCTION"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="absDiff"/&gt;
 *     &lt;enumeration value="gaussSim"/&gt;
 *     &lt;enumeration value="delta"/&gt;
 *     &lt;enumeration value="equal"/&gt;
 *     &lt;enumeration value="table"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "COMPARE-FUNCTION")
@XmlEnum
public enum COMPAREFUNCTION {
  @XmlEnumValue("absDiff")
  ABS_DIFF("absDiff"),
  @XmlEnumValue("gaussSim")
  GAUSS_SIM("gaussSim"),
  @XmlEnumValue("delta")
  DELTA("delta"),
  @XmlEnumValue("equal")
  EQUAL("equal"),
  @XmlEnumValue("table")
  TABLE("table");
  private final String value;

  COMPAREFUNCTION(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static COMPAREFUNCTION fromValue(String v) {
    for (COMPAREFUNCTION c : COMPAREFUNCTION.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
