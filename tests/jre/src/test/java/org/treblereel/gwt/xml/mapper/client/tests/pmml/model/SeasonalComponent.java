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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}AR" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}MA" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="P" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" /&gt;
 *       &lt;attribute name="D" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" /&gt;
 *       &lt;attribute name="Q" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="0" /&gt;
 *       &lt;attribute name="period" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "ar", "ma"})
@XmlRootElement(name = "SeasonalComponent")
@JsType
public class SeasonalComponent {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "AR")
  protected AR ar;

  @XmlElement(name = "MA")
  protected MA ma;

  @XmlAttribute(name = "P")
  protected BigInteger p;

  @XmlAttribute(name = "D")
  protected BigInteger d;

  @XmlAttribute(name = "Q")
  protected BigInteger q;

  @XmlAttribute(name = "period", required = true)
  protected BigInteger period;

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
   * Gets the value of the p property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getP() {
    if (p == null) {
      return new BigInteger("0");
    } else {
      return p;
    }
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
   * Gets the value of the d property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getD() {
    if (d == null) {
      return new BigInteger("0");
    } else {
      return d;
    }
  }

  /**
   * Sets the value of the d property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setD(BigInteger value) {
    this.d = value;
  }

  /**
   * Gets the value of the q property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getQ() {
    if (q == null) {
      return new BigInteger("0");
    } else {
      return q;
    }
  }

  /**
   * Sets the value of the q property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setQ(BigInteger value) {
    this.q = value;
  }

  /**
   * Gets the value of the period property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getPeriod() {
    return period;
  }

  /**
   * Sets the value of the period property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setPeriod(BigInteger value) {
    this.period = value;
  }
}
