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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Con" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.dmg.org/PMML-4_4}NN-NEURON-ID" /&gt;
 *       &lt;attribute name="bias" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="width" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="altitude" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "con"})
@XmlRootElement(name = "Neuron")
@JsType
public class Neuron {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "Con", required = true)
  protected List<Con> con;

  @XmlAttribute(name = "id", required = true)
  protected String id;

  @XmlAttribute(name = "bias")
  protected Double bias;

  @XmlAttribute(name = "width")
  protected Double width;

  @XmlAttribute(name = "altitude")
  protected Double altitude;

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
   * Gets the value of the con property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the con property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getCon().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Con }
   */
  public List<Con> getCon() {
    if (con == null) {
      con = new ArrayList<Con>();
    }
    return this.con;
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
   * Gets the value of the bias property.
   *
   * @return possible object is {@link Double }
   */
  public Double getBias() {
    return bias;
  }

  /**
   * Sets the value of the bias property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setBias(Double value) {
    this.bias = value;
  }

  /**
   * Gets the value of the width property.
   *
   * @return possible object is {@link Double }
   */
  public Double getWidth() {
    return width;
  }

  /**
   * Sets the value of the width property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setWidth(Double value) {
    this.width = value;
  }

  /**
   * Gets the value of the altitude property.
   *
   * @return possible object is {@link Double }
   */
  public Double getAltitude() {
    return altitude;
  }

  /**
   * Sets the value of the altitude property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAltitude(Double value) {
    this.altitude = value;
  }
}
