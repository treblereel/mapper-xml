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
 * Java class for BN-TYPE.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="BN-TYPE"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="General"/&gt;
 *     &lt;enumeration value="TAN"/&gt;
 *     &lt;enumeration value="Markov-blanket"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "BN-TYPE")
@XmlEnum
public enum BNTYPE {
  @XmlEnumValue("General")
  GENERAL("General"),
  TAN("TAN"),
  @XmlEnumValue("Markov-blanket")
  MARKOV_BLANKET("Markov-blanket");
  private final String value;

  BNTYPE(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static BNTYPE fromValue(String v) {
    for (BNTYPE c : BNTYPE.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}