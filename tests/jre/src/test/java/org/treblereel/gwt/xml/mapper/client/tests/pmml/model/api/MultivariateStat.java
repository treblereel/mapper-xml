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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Extension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="exponent" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" default="1" /&gt;
 *       &lt;attribute name="isIntercept" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="importance" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" /&gt;
 *       &lt;attribute name="stdError" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="tValue" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="chiSquareValue" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="fStatistic" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="dF" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="pValueAlpha" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" /&gt;
 *       &lt;attribute name="pValueInitial" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" /&gt;
 *       &lt;attribute name="pValueFinal" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" /&gt;
 *       &lt;attribute name="confidenceLevel" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" default="0.95" /&gt;
 *       &lt;attribute name="confidenceLowerBound" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="confidenceUpperBound" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface MultivariateStat {

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
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  String getName();

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  void setName(String value);

  /**
   * Gets the value of the category property.
   *
   * @return possible object is {@link String }
   */
  String getCategory();

  /**
   * Sets the value of the category property.
   *
   * @param value allowed object is {@link String }
   */
  void setCategory(String value);

  /**
   * Gets the value of the exponent property.
   *
   * @return possible object is {@link BigInteger }
   */
  BigInteger getExponent();

  /**
   * Sets the value of the exponent property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  void setExponent(BigInteger value);

  /**
   * Gets the value of the isIntercept property.
   *
   * @return possible object is {@link Boolean }
   */
  boolean isIsIntercept();

  /**
   * Sets the value of the isIntercept property.
   *
   * @param value allowed object is {@link Boolean }
   */
  void setIsIntercept(Boolean value);

  /**
   * Gets the value of the importance property.
   *
   * @return possible object is {@link Double }
   */
  Double getImportance();

  /**
   * Sets the value of the importance property.
   *
   * @param value allowed object is {@link Double }
   */
  void setImportance(Double value);

  /**
   * Gets the value of the stdError property.
   *
   * @return possible object is {@link Double }
   */
  Double getStdError();

  /**
   * Sets the value of the stdError property.
   *
   * @param value allowed object is {@link Double }
   */
  void setStdError(Double value);

  /**
   * Gets the value of the tValue property.
   *
   * @return possible object is {@link Double }
   */
  Double getTValue();

  /**
   * Sets the value of the tValue property.
   *
   * @param value allowed object is {@link Double }
   */
  void setTValue(Double value);

  /**
   * Gets the value of the chiSquareValue property.
   *
   * @return possible object is {@link Double }
   */
  Double getChiSquareValue();

  /**
   * Sets the value of the chiSquareValue property.
   *
   * @param value allowed object is {@link Double }
   */
  void setChiSquareValue(Double value);

  /**
   * Gets the value of the fStatistic property.
   *
   * @return possible object is {@link Double }
   */
  Double getFStatistic();

  /**
   * Sets the value of the fStatistic property.
   *
   * @param value allowed object is {@link Double }
   */
  void setFStatistic(Double value);

  /**
   * Gets the value of the df property.
   *
   * @return possible object is {@link Double }
   */
  Double getDF();

  /**
   * Sets the value of the df property.
   *
   * @param value allowed object is {@link Double }
   */
  void setDF(Double value);

  /**
   * Gets the value of the pValueAlpha property.
   *
   * @return possible object is {@link Double }
   */
  Double getPValueAlpha();

  /**
   * Sets the value of the pValueAlpha property.
   *
   * @param value allowed object is {@link Double }
   */
  void setPValueAlpha(Double value);

  /**
   * Gets the value of the pValueInitial property.
   *
   * @return possible object is {@link Double }
   */
  Double getPValueInitial();

  /**
   * Sets the value of the pValueInitial property.
   *
   * @param value allowed object is {@link Double }
   */
  void setPValueInitial(Double value);

  /**
   * Gets the value of the pValueFinal property.
   *
   * @return possible object is {@link Double }
   */
  Double getPValueFinal();

  /**
   * Sets the value of the pValueFinal property.
   *
   * @param value allowed object is {@link Double }
   */
  void setPValueFinal(Double value);

  /**
   * Gets the value of the confidenceLevel property.
   *
   * @return possible object is {@link Double }
   */
  double getConfidenceLevel();

  /**
   * Sets the value of the confidenceLevel property.
   *
   * @param value allowed object is {@link Double }
   */
  void setConfidenceLevel(Double value);

  /**
   * Gets the value of the confidenceLowerBound property.
   *
   * @return possible object is {@link Double }
   */
  Double getConfidenceLowerBound();

  /**
   * Sets the value of the confidenceLowerBound property.
   *
   * @param value allowed object is {@link Double }
   */
  void setConfidenceLowerBound(Double value);

  /**
   * Gets the value of the confidenceUpperBound property.
   *
   * @return possible object is {@link Double }
   */
  Double getConfidenceUpperBound();

  /**
   * Sets the value of the confidenceUpperBound property.
   *
   * @param value allowed object is {@link Double }
   */
  void setConfidenceUpperBound(Double value);
}
