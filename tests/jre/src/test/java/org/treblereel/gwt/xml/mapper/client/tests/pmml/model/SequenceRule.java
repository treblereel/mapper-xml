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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}AntecedentSequence"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Delimiter"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Time" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ConsequentSequence"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.dmg.org/PMML-4_4}ELEMENT-ID" /&gt;
 *       &lt;attribute name="numberOfSets" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="occurrence" use="required" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="support" use="required" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="confidence" use="required" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="lift" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "antecedentSequence", "delimiter", "time", "consequentSequence"})
@XmlRootElement(name = "SequenceRule")
@JsType
public class SequenceRule {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "AntecedentSequence", required = true)
  protected AntecedentSequence antecedentSequence;

  @XmlElement(name = "Delimiter", required = true)
  protected Delimiter delimiter;

  @XmlElement(name = "Time")
  protected Time time;

  @XmlElement(name = "ConsequentSequence", required = true)
  protected ConsequentSequence consequentSequence;

  @XmlAttribute(name = "id", required = true)
  protected String id;

  @XmlAttribute(name = "numberOfSets", required = true)
  protected BigInteger numberOfSets;

  @XmlAttribute(name = "occurrence", required = true)
  protected BigInteger occurrence;

  @XmlAttribute(name = "support", required = true)
  protected double support;

  @XmlAttribute(name = "confidence", required = true)
  protected double confidence;

  @XmlAttribute(name = "lift")
  protected Double lift;

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
   * Gets the value of the antecedentSequence property.
   *
   * @return possible object is {@link AntecedentSequence }
   */
  public AntecedentSequence getAntecedentSequence() {
    return antecedentSequence;
  }

  /**
   * Sets the value of the antecedentSequence property.
   *
   * @param value allowed object is {@link AntecedentSequence }
   */
  public void setAntecedentSequence(AntecedentSequence value) {
    this.antecedentSequence = value;
  }

  /**
   * Gets the value of the delimiter property.
   *
   * @return possible object is {@link Delimiter }
   */
  public Delimiter getDelimiter() {
    return delimiter;
  }

  /**
   * Sets the value of the delimiter property.
   *
   * @param value allowed object is {@link Delimiter }
   */
  public void setDelimiter(Delimiter value) {
    this.delimiter = value;
  }

  /**
   * Gets the value of the time property.
   *
   * @return possible object is {@link Time }
   */
  public Time getTime() {
    return time;
  }

  /**
   * Sets the value of the time property.
   *
   * @param value allowed object is {@link Time }
   */
  public void setTime(Time value) {
    this.time = value;
  }

  /**
   * Gets the value of the consequentSequence property.
   *
   * @return possible object is {@link ConsequentSequence }
   */
  public ConsequentSequence getConsequentSequence() {
    return consequentSequence;
  }

  /**
   * Sets the value of the consequentSequence property.
   *
   * @param value allowed object is {@link ConsequentSequence }
   */
  public void setConsequentSequence(ConsequentSequence value) {
    this.consequentSequence = value;
  }

  /**
   * Gets the value of the id property.
   *
   * @return possible object is {@link String }
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value allowed object is {@link String }
   */
  public void setId(String value) {
    this.id = value;
  }

  /**
   * Gets the value of the numberOfSets property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNumberOfSets() {
    return numberOfSets;
  }

  /**
   * Sets the value of the numberOfSets property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNumberOfSets(BigInteger value) {
    this.numberOfSets = value;
  }

  /**
   * Gets the value of the occurrence property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getOccurrence() {
    return occurrence;
  }

  /**
   * Sets the value of the occurrence property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setOccurrence(BigInteger value) {
    this.occurrence = value;
  }

  /** Gets the value of the support property. */
  public double getSupport() {
    return support;
  }

  /** Sets the value of the support property. */
  public void setSupport(double value) {
    this.support = value;
  }

  /** Gets the value of the confidence property. */
  public double getConfidence() {
    return confidence;
  }

  /** Sets the value of the confidence property. */
  public void setConfidence(double value) {
    this.confidence = value;
  }

  /**
   * Gets the value of the lift property.
   *
   * @return possible object is {@link Double }
   */
  public Double getLift() {
    return lift;
  }

  /**
   * Sets the value of the lift property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setLift(Double value) {
    this.lift = value;
  }
}
