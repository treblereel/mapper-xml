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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ROCGraph"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="positiveTargetFieldValue" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="positiveTargetFieldDisplayValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="negativeTargetFieldValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="negativeTargetFieldDisplayValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "rocGraph"})
@XmlRootElement(name = "ROC")
@JsType
public class ROC {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "ROCGraph", required = true)
  protected ROCGraph rocGraph;

  @XmlAttribute(name = "positiveTargetFieldValue", required = true)
  protected String positiveTargetFieldValue;

  @XmlAttribute(name = "positiveTargetFieldDisplayValue")
  protected String positiveTargetFieldDisplayValue;

  @XmlAttribute(name = "negativeTargetFieldValue")
  protected String negativeTargetFieldValue;

  @XmlAttribute(name = "negativeTargetFieldDisplayValue")
  protected String negativeTargetFieldDisplayValue;

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
   * Gets the value of the rocGraph property.
   *
   * @return possible object is {@link ROCGraph }
   */
  public ROCGraph getROCGraph() {
    return rocGraph;
  }

  /**
   * Sets the value of the rocGraph property.
   *
   * @param value allowed object is {@link ROCGraph }
   */
  public void setROCGraph(ROCGraph value) {
    this.rocGraph = value;
  }

  /**
   * Gets the value of the positiveTargetFieldValue property.
   *
   * @return possible object is {@link String }
   */
  public String getPositiveTargetFieldValue() {
    return positiveTargetFieldValue;
  }

  /**
   * Sets the value of the positiveTargetFieldValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPositiveTargetFieldValue(String value) {
    this.positiveTargetFieldValue = value;
  }

  /**
   * Gets the value of the positiveTargetFieldDisplayValue property.
   *
   * @return possible object is {@link String }
   */
  public String getPositiveTargetFieldDisplayValue() {
    return positiveTargetFieldDisplayValue;
  }

  /**
   * Sets the value of the positiveTargetFieldDisplayValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPositiveTargetFieldDisplayValue(String value) {
    this.positiveTargetFieldDisplayValue = value;
  }

  /**
   * Gets the value of the negativeTargetFieldValue property.
   *
   * @return possible object is {@link String }
   */
  public String getNegativeTargetFieldValue() {
    return negativeTargetFieldValue;
  }

  /**
   * Sets the value of the negativeTargetFieldValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setNegativeTargetFieldValue(String value) {
    this.negativeTargetFieldValue = value;
  }

  /**
   * Gets the value of the negativeTargetFieldDisplayValue property.
   *
   * @return possible object is {@link String }
   */
  public String getNegativeTargetFieldDisplayValue() {
    return negativeTargetFieldDisplayValue;
  }

  /**
   * Sets the value of the negativeTargetFieldDisplayValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setNegativeTargetFieldDisplayValue(String value) {
    this.negativeTargetFieldDisplayValue = value;
  }
}
