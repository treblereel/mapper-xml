/*
 * Copyright © 2021 Treblereel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jsinterop.annotations.JsType;

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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"realarray"})
@XmlRootElement(name = "Trend_ExpoSmooth")
@JsType
public class TrendExpoSmooth {

  @XmlElement(name = "REAL-ARRAY")
  protected REALARRAY realarray;

  @XmlAttribute(name = "trend")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String trend;

  @XmlAttribute(name = "gamma")
  protected Double gamma;

  @XmlAttribute(name = "phi")
  protected Double phi;

  @XmlAttribute(name = "smoothedValue")
  protected Double smoothedValue;

  /**
   * Gets the value of the realarray property.
   *
   * @return possible object is {@link REALARRAY }
   */
  public REALARRAY getREALARRAY() {
    return realarray;
  }

  /**
   * Sets the value of the realarray property.
   *
   * @param value allowed object is {@link REALARRAY }
   */
  public void setREALARRAY(REALARRAY value) {
    this.realarray = value;
  }

  /**
   * Gets the value of the trend property.
   *
   * @return possible object is {@link String }
   */
  public String getTrend() {
    if (trend == null) {
      return "additive";
    } else {
      return trend;
    }
  }

  /**
   * Sets the value of the trend property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTrend(String value) {
    this.trend = value;
  }

  /**
   * Gets the value of the gamma property.
   *
   * @return possible object is {@link Double }
   */
  public Double getGamma() {
    return gamma;
  }

  /**
   * Sets the value of the gamma property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setGamma(Double value) {
    this.gamma = value;
  }

  /**
   * Gets the value of the phi property.
   *
   * @return possible object is {@link Double }
   */
  public double getPhi() {
    if (phi == null) {
      return 1.0D;
    } else {
      return phi;
    }
  }

  /**
   * Sets the value of the phi property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setPhi(Double value) {
    this.phi = value;
  }

  /**
   * Gets the value of the smoothedValue property.
   *
   * @return possible object is {@link Double }
   */
  public Double getSmoothedValue() {
    return smoothedValue;
  }

  /**
   * Sets the value of the smoothedValue property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setSmoothedValue(Double value) {
    this.smoothedValue = value;
  }
}
