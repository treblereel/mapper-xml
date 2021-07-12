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
 *       &lt;/sequence&gt;
 *       &lt;attribute name="minimumNumberOfItems" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="1" /&gt;
 *       &lt;attribute name="maximumNumberOfItems" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="minimumNumberOfAntecedentItems" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="1" /&gt;
 *       &lt;attribute name="maximumNumberOfAntecedentItems" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="minimumNumberOfConsequentItems" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" default="1" /&gt;
 *       &lt;attribute name="maximumNumberOfConsequentItems" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="minimumSupport" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="minimumConfidence" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="minimumLift" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="minimumTotalSequenceTime" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="maximumTotalSequenceTime" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="minimumItemsetSeparationTime" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="maximumItemsetSeparationTime" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="minimumAntConsSeparationTime" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="maximumAntConsSeparationTime" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension"})
@XmlRootElement(name = "Constraints")
@JsType
public class Constraints {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlAttribute(name = "minimumNumberOfItems")
  protected BigInteger minimumNumberOfItems;

  @XmlAttribute(name = "maximumNumberOfItems")
  protected BigInteger maximumNumberOfItems;

  @XmlAttribute(name = "minimumNumberOfAntecedentItems")
  protected BigInteger minimumNumberOfAntecedentItems;

  @XmlAttribute(name = "maximumNumberOfAntecedentItems")
  protected BigInteger maximumNumberOfAntecedentItems;

  @XmlAttribute(name = "minimumNumberOfConsequentItems")
  protected BigInteger minimumNumberOfConsequentItems;

  @XmlAttribute(name = "maximumNumberOfConsequentItems")
  protected BigInteger maximumNumberOfConsequentItems;

  @XmlAttribute(name = "minimumSupport")
  protected Double minimumSupport;

  @XmlAttribute(name = "minimumConfidence")
  protected Double minimumConfidence;

  @XmlAttribute(name = "minimumLift")
  protected Double minimumLift;

  @XmlAttribute(name = "minimumTotalSequenceTime")
  protected Double minimumTotalSequenceTime;

  @XmlAttribute(name = "maximumTotalSequenceTime")
  protected Double maximumTotalSequenceTime;

  @XmlAttribute(name = "minimumItemsetSeparationTime")
  protected Double minimumItemsetSeparationTime;

  @XmlAttribute(name = "maximumItemsetSeparationTime")
  protected Double maximumItemsetSeparationTime;

  @XmlAttribute(name = "minimumAntConsSeparationTime")
  protected Double minimumAntConsSeparationTime;

  @XmlAttribute(name = "maximumAntConsSeparationTime")
  protected Double maximumAntConsSeparationTime;

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
   * Gets the value of the minimumNumberOfItems property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMinimumNumberOfItems() {
    if (minimumNumberOfItems == null) {
      return new BigInteger("1");
    } else {
      return minimumNumberOfItems;
    }
  }

  /**
   * Sets the value of the minimumNumberOfItems property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMinimumNumberOfItems(BigInteger value) {
    this.minimumNumberOfItems = value;
  }

  /**
   * Gets the value of the maximumNumberOfItems property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaximumNumberOfItems() {
    return maximumNumberOfItems;
  }

  /**
   * Sets the value of the maximumNumberOfItems property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaximumNumberOfItems(BigInteger value) {
    this.maximumNumberOfItems = value;
  }

  /**
   * Gets the value of the minimumNumberOfAntecedentItems property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMinimumNumberOfAntecedentItems() {
    if (minimumNumberOfAntecedentItems == null) {
      return new BigInteger("1");
    } else {
      return minimumNumberOfAntecedentItems;
    }
  }

  /**
   * Sets the value of the minimumNumberOfAntecedentItems property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMinimumNumberOfAntecedentItems(BigInteger value) {
    this.minimumNumberOfAntecedentItems = value;
  }

  /**
   * Gets the value of the maximumNumberOfAntecedentItems property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaximumNumberOfAntecedentItems() {
    return maximumNumberOfAntecedentItems;
  }

  /**
   * Sets the value of the maximumNumberOfAntecedentItems property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaximumNumberOfAntecedentItems(BigInteger value) {
    this.maximumNumberOfAntecedentItems = value;
  }

  /**
   * Gets the value of the minimumNumberOfConsequentItems property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMinimumNumberOfConsequentItems() {
    if (minimumNumberOfConsequentItems == null) {
      return new BigInteger("1");
    } else {
      return minimumNumberOfConsequentItems;
    }
  }

  /**
   * Sets the value of the minimumNumberOfConsequentItems property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMinimumNumberOfConsequentItems(BigInteger value) {
    this.minimumNumberOfConsequentItems = value;
  }

  /**
   * Gets the value of the maximumNumberOfConsequentItems property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaximumNumberOfConsequentItems() {
    return maximumNumberOfConsequentItems;
  }

  /**
   * Sets the value of the maximumNumberOfConsequentItems property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaximumNumberOfConsequentItems(BigInteger value) {
    this.maximumNumberOfConsequentItems = value;
  }

  /**
   * Gets the value of the minimumSupport property.
   *
   * @return possible object is {@link Double }
   */
  public double getMinimumSupport() {
    if (minimumSupport == null) {
      return 0.0D;
    } else {
      return minimumSupport;
    }
  }

  /**
   * Sets the value of the minimumSupport property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMinimumSupport(Double value) {
    this.minimumSupport = value;
  }

  /**
   * Gets the value of the minimumConfidence property.
   *
   * @return possible object is {@link Double }
   */
  public double getMinimumConfidence() {
    if (minimumConfidence == null) {
      return 0.0D;
    } else {
      return minimumConfidence;
    }
  }

  /**
   * Sets the value of the minimumConfidence property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMinimumConfidence(Double value) {
    this.minimumConfidence = value;
  }

  /**
   * Gets the value of the minimumLift property.
   *
   * @return possible object is {@link Double }
   */
  public double getMinimumLift() {
    if (minimumLift == null) {
      return 0.0D;
    } else {
      return minimumLift;
    }
  }

  /**
   * Sets the value of the minimumLift property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMinimumLift(Double value) {
    this.minimumLift = value;
  }

  /**
   * Gets the value of the minimumTotalSequenceTime property.
   *
   * @return possible object is {@link Double }
   */
  public double getMinimumTotalSequenceTime() {
    if (minimumTotalSequenceTime == null) {
      return 0.0D;
    } else {
      return minimumTotalSequenceTime;
    }
  }

  /**
   * Sets the value of the minimumTotalSequenceTime property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMinimumTotalSequenceTime(Double value) {
    this.minimumTotalSequenceTime = value;
  }

  /**
   * Gets the value of the maximumTotalSequenceTime property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMaximumTotalSequenceTime() {
    return maximumTotalSequenceTime;
  }

  /**
   * Sets the value of the maximumTotalSequenceTime property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMaximumTotalSequenceTime(Double value) {
    this.maximumTotalSequenceTime = value;
  }

  /**
   * Gets the value of the minimumItemsetSeparationTime property.
   *
   * @return possible object is {@link Double }
   */
  public double getMinimumItemsetSeparationTime() {
    if (minimumItemsetSeparationTime == null) {
      return 0.0D;
    } else {
      return minimumItemsetSeparationTime;
    }
  }

  /**
   * Sets the value of the minimumItemsetSeparationTime property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMinimumItemsetSeparationTime(Double value) {
    this.minimumItemsetSeparationTime = value;
  }

  /**
   * Gets the value of the maximumItemsetSeparationTime property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMaximumItemsetSeparationTime() {
    return maximumItemsetSeparationTime;
  }

  /**
   * Sets the value of the maximumItemsetSeparationTime property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMaximumItemsetSeparationTime(Double value) {
    this.maximumItemsetSeparationTime = value;
  }

  /**
   * Gets the value of the minimumAntConsSeparationTime property.
   *
   * @return possible object is {@link Double }
   */
  public double getMinimumAntConsSeparationTime() {
    if (minimumAntConsSeparationTime == null) {
      return 0.0D;
    } else {
      return minimumAntConsSeparationTime;
    }
  }

  /**
   * Sets the value of the minimumAntConsSeparationTime property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMinimumAntConsSeparationTime(Double value) {
    this.minimumAntConsSeparationTime = value;
  }

  /**
   * Gets the value of the maximumAntConsSeparationTime property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMaximumAntConsSeparationTime() {
    return maximumAntConsSeparationTime;
  }

  /**
   * Sets the value of the maximumAntConsSeparationTime property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMaximumAntConsSeparationTime(Double value) {
    this.maximumAntConsSeparationTime = value;
  }
}
