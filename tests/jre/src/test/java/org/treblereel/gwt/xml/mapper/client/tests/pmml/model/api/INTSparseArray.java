//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

import java.math.BigInteger;
import java.util.List;

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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Indices" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}INT-Entries" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="n" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="defaultValue" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" default="0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface INTSparseArray {

  /**
   * Gets the value of the indices property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the indices property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getIndices().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Integer }
   */
  List<Integer> getIndices();

  /**
   * Gets the value of the intEntries property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the intEntries property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getINTEntries().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Integer }
   */
  List<Integer> getINTEntries();

  /**
   * Gets the value of the n property.
   *
   * @return possible object is {@link BigInteger }
   */
  BigInteger getN();

  /**
   * Sets the value of the n property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  void setN(BigInteger value);

  /**
   * Gets the value of the defaultValue property.
   *
   * @return possible object is {@link BigInteger }
   */
  BigInteger getDefaultValue();

  /**
   * Sets the value of the defaultValue property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  void setDefaultValue(BigInteger value);
}
