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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Numerator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Denominator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}RegressorValues" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="field" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="transformation" default="none"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="none"/&gt;
 *             &lt;enumeration value="logarithmic"/&gt;
 *             &lt;enumeration value="squareroot"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="delay" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" default="0" /&gt;
 *       &lt;attribute name="futureValuesMethod" default="constant"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="constant"/&gt;
 *             &lt;enumeration value="trend"/&gt;
 *             &lt;enumeration value="stored"/&gt;
 *             &lt;enumeration value="otherModel"/&gt;
 *             &lt;enumeration value="userSupplied"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="targetField" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface DynamicRegressor {

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
   * Gets the value of the numerator property.
   *
   * @return possible object is {@link Numerator }
   */
  Numerator getNumerator();

  /**
   * Sets the value of the numerator property.
   *
   * @param value allowed object is {@link Numerator }
   */
  void setNumerator(Numerator value);

  /**
   * Gets the value of the denominator property.
   *
   * @return possible object is {@link Denominator }
   */
  Denominator getDenominator();

  /**
   * Sets the value of the denominator property.
   *
   * @param value allowed object is {@link Denominator }
   */
  void setDenominator(Denominator value);

  /**
   * Gets the value of the regressorValues property.
   *
   * @return possible object is {@link RegressorValues }
   */
  RegressorValues getRegressorValues();

  /**
   * Sets the value of the regressorValues property.
   *
   * @param value allowed object is {@link RegressorValues }
   */
  void setRegressorValues(RegressorValues value);

  /**
   * Gets the value of the field property.
   *
   * @return possible object is {@link String }
   */
  String getField();

  /**
   * Sets the value of the field property.
   *
   * @param value allowed object is {@link String }
   */
  void setField(String value);

  /**
   * Gets the value of the transformation property.
   *
   * @return possible object is {@link String }
   */
  String getTransformation();

  /**
   * Sets the value of the transformation property.
   *
   * @param value allowed object is {@link String }
   */
  void setTransformation(String value);

  /**
   * Gets the value of the delay property.
   *
   * @return possible object is {@link BigInteger }
   */
  BigInteger getDelay();

  /**
   * Sets the value of the delay property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  void setDelay(BigInteger value);

  /**
   * Gets the value of the futureValuesMethod property.
   *
   * @return possible object is {@link String }
   */
  String getFutureValuesMethod();

  /**
   * Sets the value of the futureValuesMethod property.
   *
   * @param value allowed object is {@link String }
   */
  void setFutureValuesMethod(String value);

  /**
   * Gets the value of the targetField property.
   *
   * @return possible object is {@link String }
   */
  String getTargetField();

  /**
   * Sets the value of the targetField property.
   *
   * @param value allowed object is {@link String }
   */
  void setTargetField(String value);
}
