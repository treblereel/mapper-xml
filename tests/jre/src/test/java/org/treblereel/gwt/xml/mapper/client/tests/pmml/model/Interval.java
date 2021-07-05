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
 *       &lt;attribute name="closure" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="openClosed"/&gt;
 *             &lt;enumeration value="openOpen"/&gt;
 *             &lt;enumeration value="closedOpen"/&gt;
 *             &lt;enumeration value="closedClosed"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="leftMargin" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="rightMargin" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension"})
@XmlRootElement(name = "Interval")
@JsType
public class Interval {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlAttribute(name = "closure", required = true)
  protected String closure;

  @XmlAttribute(name = "leftMargin")
  protected Double leftMargin;

  @XmlAttribute(name = "rightMargin")
  protected Double rightMargin;

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
   * Gets the value of the closure property.
   *
   * @return possible object is {@link String }
   */
  public String getClosure() {
    return closure;
  }

  /**
   * Sets the value of the closure property.
   *
   * @param value allowed object is {@link String }
   */
  public void setClosure(String value) {
    this.closure = value;
  }

  /**
   * Gets the value of the leftMargin property.
   *
   * @return possible object is {@link Double }
   */
  public Double getLeftMargin() {
    return leftMargin;
  }

  /**
   * Sets the value of the leftMargin property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setLeftMargin(Double value) {
    this.leftMargin = value;
  }

  /**
   * Gets the value of the rightMargin property.
   *
   * @return possible object is {@link Double }
   */
  public Double getRightMargin() {
    return rightMargin;
  }

  /**
   * Sets the value of the rightMargin property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setRightMargin(Double value) {
    this.rightMargin = value;
  }
}
