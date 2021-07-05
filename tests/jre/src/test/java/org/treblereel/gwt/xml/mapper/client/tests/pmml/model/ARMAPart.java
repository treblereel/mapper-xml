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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}AR"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}MA"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="constant" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="p" use="required" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="q" use="required" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "ar", "ma"})
@XmlRootElement(name = "ARMAPart")
@JsType
public class ARMAPart {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "AR", required = true)
  protected AR ar;

  @XmlElement(name = "MA", required = true)
  protected MA ma;

  @XmlAttribute(name = "constant")
  protected Double constant;

  @XmlAttribute(name = "p", required = true)
  protected BigInteger p;

  @XmlAttribute(name = "q", required = true)
  protected BigInteger q;

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
   * Gets the value of the ar property.
   *
   * @return possible object is {@link AR }
   */
  public AR getAR() {
    return ar;
  }

  /**
   * Sets the value of the ar property.
   *
   * @param value allowed object is {@link AR }
   */
  public void setAR(AR value) {
    this.ar = value;
  }

  /**
   * Gets the value of the ma property.
   *
   * @return possible object is {@link MA }
   */
  public MA getMA() {
    return ma;
  }

  /**
   * Sets the value of the ma property.
   *
   * @param value allowed object is {@link MA }
   */
  public void setMA(MA value) {
    this.ma = value;
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
   * Gets the value of the p property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getP() {
    return p;
  }

  /**
   * Sets the value of the p property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setP(BigInteger value) {
    this.p = value;
  }

  /**
   * Gets the value of the q property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getQ() {
    return q;
  }

  /**
   * Sets the value of the q property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setQ(BigInteger value) {
    this.q = value;
  }
}
