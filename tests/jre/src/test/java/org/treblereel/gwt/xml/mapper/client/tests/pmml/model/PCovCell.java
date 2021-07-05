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
 *       &lt;attribute name="pRow" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="pCol" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="tRow" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="tCol" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="value" use="required" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="targetCategory" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension"})
@XmlRootElement(name = "PCovCell")
@JsType
public class PCovCell {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlAttribute(name = "pRow", required = true)
  protected String pRow;

  @XmlAttribute(name = "pCol", required = true)
  protected String pCol;

  @XmlAttribute(name = "tRow")
  protected String tRow;

  @XmlAttribute(name = "tCol")
  protected String tCol;

  @XmlAttribute(name = "value", required = true)
  protected double value;

  @XmlAttribute(name = "targetCategory")
  protected String targetCategory;

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
   * Gets the value of the pRow property.
   *
   * @return possible object is {@link String }
   */
  public String getPRow() {
    return pRow;
  }

  /**
   * Sets the value of the pRow property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPRow(String value) {
    this.pRow = value;
  }

  /**
   * Gets the value of the pCol property.
   *
   * @return possible object is {@link String }
   */
  public String getPCol() {
    return pCol;
  }

  /**
   * Sets the value of the pCol property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPCol(String value) {
    this.pCol = value;
  }

  /**
   * Gets the value of the tRow property.
   *
   * @return possible object is {@link String }
   */
  public String getTRow() {
    return tRow;
  }

  /**
   * Sets the value of the tRow property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTRow(String value) {
    this.tRow = value;
  }

  /**
   * Gets the value of the tCol property.
   *
   * @return possible object is {@link String }
   */
  public String getTCol() {
    return tCol;
  }

  /**
   * Sets the value of the tCol property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTCol(String value) {
    this.tCol = value;
  }

  /** Gets the value of the value property. */
  public double getValue() {
    return value;
  }

  /** Sets the value of the value property. */
  public void setValue(double value) {
    this.value = value;
  }

  /**
   * Gets the value of the targetCategory property.
   *
   * @return possible object is {@link String }
   */
  public String getTargetCategory() {
    return targetCategory;
  }

  /**
   * Sets the value of the targetCategory property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTargetCategory(String value) {
    this.targetCategory = value;
  }
}
