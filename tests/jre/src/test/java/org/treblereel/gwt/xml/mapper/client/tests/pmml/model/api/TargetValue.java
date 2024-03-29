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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Partition" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="displayValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="priorProbability" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" /&gt;
 *       &lt;attribute name="defaultValue" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface TargetValue {

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
   * Gets the value of the partition property.
   *
   * @return possible object is {@link Partition }
   */
  Partition getPartition();

  /**
   * Sets the value of the partition property.
   *
   * @param value allowed object is {@link Partition }
   */
  void setPartition(Partition value);

  /**
   * Gets the value of the value property.
   *
   * @return possible object is {@link String }
   */
  String getValue();

  /**
   * Sets the value of the value property.
   *
   * @param value allowed object is {@link String }
   */
  void setValue(String value);

  /**
   * Gets the value of the displayValue property.
   *
   * @return possible object is {@link String }
   */
  String getDisplayValue();

  /**
   * Sets the value of the displayValue property.
   *
   * @param value allowed object is {@link String }
   */
  void setDisplayValue(String value);

  /**
   * Gets the value of the priorProbability property.
   *
   * @return possible object is {@link Double }
   */
  Double getPriorProbability();

  /**
   * Sets the value of the priorProbability property.
   *
   * @param value allowed object is {@link Double }
   */
  void setPriorProbability(Double value);

  /**
   * Gets the value of the defaultValue property.
   *
   * @return possible object is {@link Double }
   */
  Double getDefaultValue();

  /**
   * Sets the value of the defaultValue property.
   *
   * @param value allowed object is {@link Double }
   */
  void setDefaultValue(Double value);
}
