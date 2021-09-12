//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

import java.math.BigInteger;

/**
 * Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}INT-ARRAY"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" type="{http://www.dmg.org/PMML-4_4}TIME-EXCEPTION-TYPE" /&gt;
 *       &lt;attribute name="count" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface TimeException {

  /**
   * Gets the value of the intarray property.
   *
   * @return possible object is {@link INTARRAY }
   */
  INTARRAY getINTARRAY();

  /**
   * Sets the value of the intarray property.
   *
   * @param value allowed object is {@link INTARRAY }
   */
  void setINTARRAY(INTARRAY value);

  /**
   * Gets the value of the type property.
   *
   * @return possible object is {@link TIMEEXCEPTIONTYPE }
   */
  TIMEEXCEPTIONTYPE getType();

  /**
   * Sets the value of the type property.
   *
   * @param value allowed object is {@link TIMEEXCEPTIONTYPE }
   */
  void setType(TIMEEXCEPTIONTYPE value);

  /**
   * Gets the value of the count property.
   *
   * @return possible object is {@link BigInteger }
   */
  BigInteger getCount();

  /**
   * Sets the value of the count property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  void setCount(BigInteger value);
}