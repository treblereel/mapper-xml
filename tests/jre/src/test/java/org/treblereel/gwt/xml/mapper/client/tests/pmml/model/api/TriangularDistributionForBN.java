//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Extension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Mean"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Lower"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Upper"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface TriangularDistributionForBN {

  /**
   * Gets the value of the extension property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the extension property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getExtension().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Extension }
   */
  List<Extension> getExtension();

  /**
   * Gets the value of the mean property.
   *
   * @return possible object is {@link Mean }
   */
  Mean getMean();

  /**
   * Sets the value of the mean property.
   *
   * @param value allowed object is {@link Mean }
   */
  void setMean(Mean value);

  /**
   * Gets the value of the lower property.
   *
   * @return possible object is {@link Lower }
   */
  Lower getLower();

  /**
   * Sets the value of the lower property.
   *
   * @param value allowed object is {@link Lower }
   */
  void setLower(Lower value);

  /**
   * Gets the value of the upper property.
   *
   * @return possible object is {@link Upper }
   */
  Upper getUpper();

  /**
   * Sets the value of the upper property.
   *
   * @param value allowed object is {@link Upper }
   */
  void setUpper(Upper value);
}
