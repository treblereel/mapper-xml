//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}REAL-ARRAY" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="trend" default="additive"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="additive"/&gt;
 *             &lt;enumeration value="damped_additive"/&gt;
 *             &lt;enumeration value="multiplicative"/&gt;
 *             &lt;enumeration value="damped_multiplicative"/&gt;
 *             &lt;enumeration value="polynomial_exponential"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="gamma" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="phi" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="1" /&gt;
 *       &lt;attribute name="smoothedValue" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface TrendExpoSmooth {

  /**
   * Gets the value of the realarray property.
   *
   * @return possible object is {@link REALARRAY }
   */
  REALARRAY getREALARRAY();

  /**
   * Sets the value of the realarray property.
   *
   * @param value allowed object is {@link REALARRAY }
   */
  void setREALARRAY(REALARRAY value);

  /**
   * Gets the value of the trend property.
   *
   * @return possible object is {@link String }
   */
  String getTrend();

  /**
   * Sets the value of the trend property.
   *
   * @param value allowed object is {@link String }
   */
  void setTrend(String value);

  /**
   * Gets the value of the gamma property.
   *
   * @return possible object is {@link Double }
   */
  Double getGamma();

  /**
   * Sets the value of the gamma property.
   *
   * @param value allowed object is {@link Double }
   */
  void setGamma(Double value);

  /**
   * Gets the value of the phi property.
   *
   * @return possible object is {@link Double }
   */
  double getPhi();

  /**
   * Sets the value of the phi property.
   *
   * @param value allowed object is {@link Double }
   */
  void setPhi(Double value);

  /**
   * Gets the value of the smoothedValue property.
   *
   * @return possible object is {@link Double }
   */
  Double getSmoothedValue();

  /**
   * Sets the value of the smoothedValue property.
   *
   * @param value allowed object is {@link Double }
   */
  void setSmoothedValue(Double value);
}
