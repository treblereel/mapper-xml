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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "numerator", "denominator", "regressorValues"})
@XmlRootElement(name = "DynamicRegressor")
@JsType
public class DynamicRegressor {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "Numerator")
  protected Numerator numerator;

  @XmlElement(name = "Denominator")
  protected Denominator denominator;

  @XmlElement(name = "RegressorValues")
  protected RegressorValues regressorValues;

  @XmlAttribute(name = "field", required = true)
  protected String field;

  @XmlAttribute(name = "transformation")
  protected String transformation;

  @XmlAttribute(name = "delay")
  protected BigInteger delay;

  @XmlAttribute(name = "futureValuesMethod")
  protected String futureValuesMethod;

  @XmlAttribute(name = "targetField")
  protected String targetField;

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
   * Gets the value of the numerator property.
   *
   * @return possible object is {@link Numerator }
   */
  public Numerator getNumerator() {
    return numerator;
  }

  /**
   * Sets the value of the numerator property.
   *
   * @param value allowed object is {@link Numerator }
   */
  public void setNumerator(Numerator value) {
    this.numerator = value;
  }

  /**
   * Gets the value of the denominator property.
   *
   * @return possible object is {@link Denominator }
   */
  public Denominator getDenominator() {
    return denominator;
  }

  /**
   * Sets the value of the denominator property.
   *
   * @param value allowed object is {@link Denominator }
   */
  public void setDenominator(Denominator value) {
    this.denominator = value;
  }

  /**
   * Gets the value of the regressorValues property.
   *
   * @return possible object is {@link RegressorValues }
   */
  public RegressorValues getRegressorValues() {
    return regressorValues;
  }

  /**
   * Sets the value of the regressorValues property.
   *
   * @param value allowed object is {@link RegressorValues }
   */
  public void setRegressorValues(RegressorValues value) {
    this.regressorValues = value;
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
   * Gets the value of the transformation property.
   *
   * @return possible object is {@link String }
   */
  public String getTransformation() {
    if (transformation == null) {
      return "none";
    } else {
      return transformation;
    }
  }

  /**
   * Sets the value of the transformation property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTransformation(String value) {
    this.transformation = value;
  }

  /**
   * Gets the value of the delay property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getDelay() {
    if (delay == null) {
      return new BigInteger("0");
    } else {
      return delay;
    }
  }

  /**
   * Sets the value of the delay property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setDelay(BigInteger value) {
    this.delay = value;
  }

  /**
   * Gets the value of the futureValuesMethod property.
   *
   * @return possible object is {@link String }
   */
  public String getFutureValuesMethod() {
    if (futureValuesMethod == null) {
      return "constant";
    } else {
      return futureValuesMethod;
    }
  }

  /**
   * Sets the value of the futureValuesMethod property.
   *
   * @param value allowed object is {@link String }
   */
  public void setFutureValuesMethod(String value) {
    this.futureValuesMethod = value;
  }

  /**
   * Gets the value of the targetField property.
   *
   * @return possible object is {@link String }
   */
  public String getTargetField() {
    return targetField;
  }

  /**
   * Sets the value of the targetField property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTargetField(String value) {
    this.targetField = value;
  }
}
