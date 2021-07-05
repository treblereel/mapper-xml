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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Extension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ResidualSquareCoefficients"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}VarianceCoefficients"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="constant" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="gp" use="required" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="gq" use="required" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "residualSquareCoefficients", "varianceCoefficients"})
@XmlRootElement(name = "GARCHPart")
@JsType
public class GARCHPart {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "ResidualSquareCoefficients", required = true)
  protected ResidualSquareCoefficients residualSquareCoefficients;

  @XmlElement(name = "VarianceCoefficients", required = true)
  protected VarianceCoefficients varianceCoefficients;

  @XmlAttribute(name = "constant")
  protected Double constant;

  @XmlAttribute(name = "gp", required = true)
  protected BigInteger gp;

  @XmlAttribute(name = "gq", required = true)
  protected BigInteger gq;

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
  public List<Extension> getExtension() {
    if (extension == null) {
      extension = new ArrayList<Extension>();
    }
    return this.extension;
  }

  /**
   * Gets the value of the residualSquareCoefficients property.
   *
   * @return possible object is {@link ResidualSquareCoefficients }
   */
  public ResidualSquareCoefficients getResidualSquareCoefficients() {
    return residualSquareCoefficients;
  }

  /**
   * Sets the value of the residualSquareCoefficients property.
   *
   * @param value allowed object is {@link ResidualSquareCoefficients }
   */
  public void setResidualSquareCoefficients(ResidualSquareCoefficients value) {
    this.residualSquareCoefficients = value;
  }

  /**
   * Gets the value of the varianceCoefficients property.
   *
   * @return possible object is {@link VarianceCoefficients }
   */
  public VarianceCoefficients getVarianceCoefficients() {
    return varianceCoefficients;
  }

  /**
   * Sets the value of the varianceCoefficients property.
   *
   * @param value allowed object is {@link VarianceCoefficients }
   */
  public void setVarianceCoefficients(VarianceCoefficients value) {
    this.varianceCoefficients = value;
  }

  /**
   * Gets the value of the constant property.
   *
   * @return possible object is {@link Double }
   */
  public double getConstant() {
    if (constant == null) {
      return 0.0D;
    } else {
      return constant;
    }
  }

  /**
   * Sets the value of the constant property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setConstant(Double value) {
    this.constant = value;
  }

  /**
   * Gets the value of the gp property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getGp() {
    return gp;
  }

  /**
   * Sets the value of the gp property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setGp(BigInteger value) {
    this.gp = value;
  }

  /**
   * Gets the value of the gq property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getGq() {
    return gq;
  }

  /**
   * Sets the value of the gq property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setGq(BigInteger value) {
    this.gq = value;
  }
}
