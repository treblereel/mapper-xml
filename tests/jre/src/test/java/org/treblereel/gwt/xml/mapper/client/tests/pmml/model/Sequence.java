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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}SetReference"/&gt;
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;group ref="{http://www.dmg.org/PMML-4_4}FOLLOW-SET"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Time" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.dmg.org/PMML-4_4}ELEMENT-ID" /&gt;
 *       &lt;attribute name="numberOfSets" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="occurrence" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="support" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "setReference", "extensionAndDelimiterAndTime", "time"})
@XmlRootElement(name = "Sequence")
@JsType
public class Sequence {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "SetReference", required = true)
  protected SetReference setReference;

  @XmlElementRefs({
    @XmlElementRef(
        name = "Extension",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Extension.class,
        required = false),
    @XmlElementRef(
        name = "Delimiter",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Delimiter.class,
        required = false),
    @XmlElementRef(
        name = "Time",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Time.class,
        required = false),
    @XmlElementRef(
        name = "SetReference",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SetReference.class,
        required = false)
  })
  protected List<ISequence> extensionAndDelimiterAndTime;

  @XmlElement(name = "Time")
  protected Time time;

  @XmlAttribute(name = "id", required = true)
  protected String id;

  @XmlAttribute(name = "numberOfSets")
  protected BigInteger numberOfSets;

  @XmlAttribute(name = "occurrence")
  protected BigInteger occurrence;

  @XmlAttribute(name = "support")
  protected Double support;

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
   * Gets the value of the setReference property.
   *
   * @return possible object is {@link SetReference }
   */
  public SetReference getSetReference() {
    return setReference;
  }

  /**
   * Sets the value of the setReference property.
   *
   * @param value allowed object is {@link SetReference }
   */
  public void setSetReference(SetReference value) {
    this.setReference = value;
  }

  /**
   * Gets the value of the extensionAndDelimiterAndTime property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the extensionAndDelimiterAndTime property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getExtensionAndDelimiterAndTime().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Extension } {@link Delimiter
   * } {@link Time } {@link SetReference }
   */
  public List<ISequence> getExtensionAndDelimiterAndTime() {
    if (extensionAndDelimiterAndTime == null) {
      extensionAndDelimiterAndTime = new ArrayList<ISequence>();
    }
    return this.extensionAndDelimiterAndTime;
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

  /**
   * Gets the value of the support property.
   *
   * @return possible object is {@link Double }
   */
  public Double getSupport() {
    return support;
  }

  /**
   * Sets the value of the support property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setSupport(Double value) {
    this.support = value;
  }
}
