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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Baseline"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Alternate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="field" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="testStatistic" use="required" type="{http://www.dmg.org/PMML-4_4}BASELINE-TEST-STATISTIC" /&gt;
 *       &lt;attribute name="resetValue" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0.0" /&gt;
 *       &lt;attribute name="windowSize" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" default="0" /&gt;
 *       &lt;attribute name="weightField" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="normalizationScheme" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "baseline", "alternate"})
@XmlRootElement(name = "TestDistributions")
@JsType
public class TestDistributions {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "Baseline", required = true)
  protected Baseline baseline;

  @XmlElement(name = "Alternate")
  protected Alternate alternate;

  @XmlAttribute(name = "field", required = true)
  protected String field;

  @XmlAttribute(name = "testStatistic", required = true)
  protected BASELINETESTSTATISTIC testStatistic;

  @XmlAttribute(name = "resetValue")
  protected Double resetValue;

  @XmlAttribute(name = "windowSize")
  protected BigInteger windowSize;

  @XmlAttribute(name = "weightField")
  protected String weightField;

  @XmlAttribute(name = "normalizationScheme")
  protected String normalizationScheme;

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
   * Gets the value of the baseline property.
   *
   * @return possible object is {@link Baseline }
   */
  public Baseline getBaseline() {
    return baseline;
  }

  /**
   * Sets the value of the baseline property.
   *
   * @param value allowed object is {@link Baseline }
   */
  public void setBaseline(Baseline value) {
    this.baseline = value;
  }

  /**
   * Gets the value of the alternate property.
   *
   * @return possible object is {@link Alternate }
   */
  public Alternate getAlternate() {
    return alternate;
  }

  /**
   * Sets the value of the alternate property.
   *
   * @param value allowed object is {@link Alternate }
   */
  public void setAlternate(Alternate value) {
    this.alternate = value;
  }

  /**
   * Gets the value of the field property.
   *
   * @return possible object is {@link String }
   */
  public String getField() {
    return field;
  }

  /**
   * Sets the value of the field property.
   *
   * @param value allowed object is {@link String }
   */
  public void setField(String value) {
    this.field = value;
  }

  /**
   * Gets the value of the testStatistic property.
   *
   * @return possible object is {@link BASELINETESTSTATISTIC }
   */
  public BASELINETESTSTATISTIC getTestStatistic() {
    return testStatistic;
  }

  /**
   * Sets the value of the testStatistic property.
   *
   * @param value allowed object is {@link BASELINETESTSTATISTIC }
   */
  public void setTestStatistic(BASELINETESTSTATISTIC value) {
    this.testStatistic = value;
  }

  /**
   * Gets the value of the resetValue property.
   *
   * @return possible object is {@link Double }
   */
  public double getResetValue() {
    if (resetValue == null) {
      return 0.0D;
    } else {
      return resetValue;
    }
  }

  /**
   * Sets the value of the resetValue property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setResetValue(Double value) {
    this.resetValue = value;
  }

  /**
   * Gets the value of the windowSize property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getWindowSize() {
    if (windowSize == null) {
      return new BigInteger("0");
    } else {
      return windowSize;
    }
  }

  /**
   * Sets the value of the windowSize property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setWindowSize(BigInteger value) {
    this.windowSize = value;
  }

  /**
   * Gets the value of the weightField property.
   *
   * @return possible object is {@link String }
   */
  public String getWeightField() {
    return weightField;
  }

  /**
   * Sets the value of the weightField property.
   *
   * @param value allowed object is {@link String }
   */
  public void setWeightField(String value) {
    this.weightField = value;
  }

  /**
   * Gets the value of the normalizationScheme property.
   *
   * @return possible object is {@link String }
   */
  public String getNormalizationScheme() {
    return normalizationScheme;
  }

  /**
   * Sets the value of the normalizationScheme property.
   *
   * @param value allowed object is {@link String }
   */
  public void setNormalizationScheme(String value) {
    this.normalizationScheme = value;
  }
}
