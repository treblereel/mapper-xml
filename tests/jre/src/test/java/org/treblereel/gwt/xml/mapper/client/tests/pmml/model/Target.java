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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}TargetValue" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="field" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="optype" type="{http://www.dmg.org/PMML-4_4}OPTYPE" /&gt;
 *       &lt;attribute name="castInteger"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="round"/&gt;
 *             &lt;enumeration value="ceiling"/&gt;
 *             &lt;enumeration value="floor"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="min" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="rescaleConstant" type="{http://www.w3.org/2001/XMLSchema}double" default="0" /&gt;
 *       &lt;attribute name="rescaleFactor" type="{http://www.w3.org/2001/XMLSchema}double" default="1" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "targetValue"})
@XmlRootElement(name = "Target")
@JsType
public class Target {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "TargetValue")
  protected List<TargetValue> targetValue;

  @XmlAttribute(name = "field")
  protected String field;

  @XmlAttribute(name = "optype")
  protected OPTYPE optype;

  @XmlAttribute(name = "castInteger")
  protected String castInteger;

  @XmlAttribute(name = "min")
  protected Double min;

  @XmlAttribute(name = "max")
  protected Double max;

  @XmlAttribute(name = "rescaleConstant")
  protected Double rescaleConstant;

  @XmlAttribute(name = "rescaleFactor")
  protected Double rescaleFactor;

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
   * Gets the value of the targetValue property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the targetValue property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getTargetValue().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link TargetValue }
   */
  public List<TargetValue> getTargetValue() {
    if (targetValue == null) {
      targetValue = new ArrayList<TargetValue>();
    }
    return this.targetValue;
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
   * Gets the value of the optype property.
   *
   * @return possible object is {@link OPTYPE }
   */
  public OPTYPE getOptype() {
    return optype;
  }

  /**
   * Sets the value of the optype property.
   *
   * @param value allowed object is {@link OPTYPE }
   */
  public void setOptype(OPTYPE value) {
    this.optype = value;
  }

  /**
   * Gets the value of the castInteger property.
   *
   * @return possible object is {@link String }
   */
  public String getCastInteger() {
    return castInteger;
  }

  /**
   * Sets the value of the castInteger property.
   *
   * @param value allowed object is {@link String }
   */
  public void setCastInteger(String value) {
    this.castInteger = value;
  }

  /**
   * Gets the value of the min property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMin() {
    return min;
  }

  /**
   * Sets the value of the min property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMin(Double value) {
    this.min = value;
  }

  /**
   * Gets the value of the max property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMax() {
    return max;
  }

  /**
   * Sets the value of the max property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMax(Double value) {
    this.max = value;
  }

  /**
   * Gets the value of the rescaleConstant property.
   *
   * @return possible object is {@link Double }
   */
  public double getRescaleConstant() {
    if (rescaleConstant == null) {
      return 0.0D;
    } else {
      return rescaleConstant;
    }
  }

  /**
   * Sets the value of the rescaleConstant property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setRescaleConstant(Double value) {
    this.rescaleConstant = value;
  }

  /**
   * Gets the value of the rescaleFactor property.
   *
   * @return possible object is {@link Double }
   */
  public double getRescaleFactor() {
    if (rescaleFactor == null) {
      return 1.0D;
    } else {
      return rescaleFactor;
    }
  }

  /**
   * Sets the value of the rescaleFactor property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setRescaleFactor(Double value) {
    this.rescaleFactor = value;
  }
}
