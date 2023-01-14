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
