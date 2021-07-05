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
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="usageType" type="{http://www.dmg.org/PMML-4_4}FIELD-USAGE-TYPE" default="active" /&gt;
 *       &lt;attribute name="optype" type="{http://www.dmg.org/PMML-4_4}OPTYPE" /&gt;
 *       &lt;attribute name="importance" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" /&gt;
 *       &lt;attribute name="outliers" type="{http://www.dmg.org/PMML-4_4}OUTLIER-TREATMENT-METHOD" default="asIs" /&gt;
 *       &lt;attribute name="lowValue" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="highValue" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="missingValueReplacement" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="missingValueTreatment" type="{http://www.dmg.org/PMML-4_4}MISSING-VALUE-TREATMENT-METHOD" /&gt;
 *       &lt;attribute name="invalidValueTreatment" type="{http://www.dmg.org/PMML-4_4}INVALID-VALUE-TREATMENT-METHOD" default="returnInvalid" /&gt;
 *       &lt;attribute name="invalidValueReplacement" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension"})
@XmlRootElement(name = "MiningField")
@JsType
public class MiningField {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlAttribute(name = "name", required = true)
  protected String name;

  @XmlAttribute(name = "usageType")
  protected FIELDUSAGETYPE usageType;

  @XmlAttribute(name = "optype")
  protected OPTYPE optype;

  @XmlAttribute(name = "importance")
  protected Double importance;

  @XmlAttribute(name = "outliers")
  protected OUTLIERTREATMENTMETHOD outliers;

  @XmlAttribute(name = "lowValue")
  protected Double lowValue;

  @XmlAttribute(name = "highValue")
  protected Double highValue;

  @XmlAttribute(name = "missingValueReplacement")
  protected String missingValueReplacement;

  @XmlAttribute(name = "missingValueTreatment")
  protected MISSINGVALUETREATMENTMETHOD missingValueTreatment;

  @XmlAttribute(name = "invalidValueTreatment")
  protected INVALIDVALUETREATMENTMETHOD invalidValueTreatment;

  @XmlAttribute(name = "invalidValueReplacement")
  protected String invalidValueReplacement;

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
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets the value of the usageType property.
   *
   * @return possible object is {@link FIELDUSAGETYPE }
   */
  public FIELDUSAGETYPE getUsageType() {
    if (usageType == null) {
      return FIELDUSAGETYPE.ACTIVE;
    } else {
      return usageType;
    }
  }

  /**
   * Sets the value of the usageType property.
   *
   * @param value allowed object is {@link FIELDUSAGETYPE }
   */
  public void setUsageType(FIELDUSAGETYPE value) {
    this.usageType = value;
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
   * Gets the value of the importance property.
   *
   * @return possible object is {@link Double }
   */
  public Double getImportance() {
    return importance;
  }

  /**
   * Sets the value of the importance property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setImportance(Double value) {
    this.importance = value;
  }

  /**
   * Gets the value of the outliers property.
   *
   * @return possible object is {@link OUTLIERTREATMENTMETHOD }
   */
  public OUTLIERTREATMENTMETHOD getOutliers() {
    if (outliers == null) {
      return OUTLIERTREATMENTMETHOD.AS_IS;
    } else {
      return outliers;
    }
  }

  /**
   * Sets the value of the outliers property.
   *
   * @param value allowed object is {@link OUTLIERTREATMENTMETHOD }
   */
  public void setOutliers(OUTLIERTREATMENTMETHOD value) {
    this.outliers = value;
  }

  /**
   * Gets the value of the lowValue property.
   *
   * @return possible object is {@link Double }
   */
  public Double getLowValue() {
    return lowValue;
  }

  /**
   * Sets the value of the lowValue property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setLowValue(Double value) {
    this.lowValue = value;
  }

  /**
   * Gets the value of the highValue property.
   *
   * @return possible object is {@link Double }
   */
  public Double getHighValue() {
    return highValue;
  }

  /**
   * Sets the value of the highValue property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setHighValue(Double value) {
    this.highValue = value;
  }

  /**
   * Gets the value of the missingValueReplacement property.
   *
   * @return possible object is {@link String }
   */
  public String getMissingValueReplacement() {
    return missingValueReplacement;
  }

  /**
   * Sets the value of the missingValueReplacement property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMissingValueReplacement(String value) {
    this.missingValueReplacement = value;
  }

  /**
   * Gets the value of the missingValueTreatment property.
   *
   * @return possible object is {@link MISSINGVALUETREATMENTMETHOD }
   */
  public MISSINGVALUETREATMENTMETHOD getMissingValueTreatment() {
    return missingValueTreatment;
  }

  /**
   * Sets the value of the missingValueTreatment property.
   *
   * @param value allowed object is {@link MISSINGVALUETREATMENTMETHOD }
   */
  public void setMissingValueTreatment(MISSINGVALUETREATMENTMETHOD value) {
    this.missingValueTreatment = value;
  }

  /**
   * Gets the value of the invalidValueTreatment property.
   *
   * @return possible object is {@link INVALIDVALUETREATMENTMETHOD }
   */
  public INVALIDVALUETREATMENTMETHOD getInvalidValueTreatment() {
    if (invalidValueTreatment == null) {
      return INVALIDVALUETREATMENTMETHOD.RETURN_INVALID;
    } else {
      return invalidValueTreatment;
    }
  }

  /**
   * Sets the value of the invalidValueTreatment property.
   *
   * @param value allowed object is {@link INVALIDVALUETREATMENTMETHOD }
   */
  public void setInvalidValueTreatment(INVALIDVALUETREATMENTMETHOD value) {
    this.invalidValueTreatment = value;
  }

  /**
   * Gets the value of the invalidValueReplacement property.
   *
   * @return possible object is {@link String }
   */
  public String getInvalidValueReplacement() {
    return invalidValueReplacement;
  }

  /**
   * Sets the value of the invalidValueReplacement property.
   *
   * @param value allowed object is {@link String }
   */
  public void setInvalidValueReplacement(String value) {
    this.invalidValueReplacement = value;
  }
}
