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
 *       &lt;attribute name="coord1" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="coord2" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="coord3" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension"})
@XmlRootElement(name = "KohonenMap")
@JsType
public class KohonenMap {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlAttribute(name = "coord1")
  protected Double coord1;

  @XmlAttribute(name = "coord2")
  protected Double coord2;

  @XmlAttribute(name = "coord3")
  protected Double coord3;

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
   * Gets the value of the coord1 property.
   *
   * @return possible object is {@link Double }
   */
  public Double getCoord1() {
    return coord1;
  }

  /**
   * Sets the value of the coord1 property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setCoord1(Double value) {
    this.coord1 = value;
  }

  /**
   * Gets the value of the coord2 property.
   *
   * @return possible object is {@link Double }
   */
  public Double getCoord2() {
    return coord2;
  }

  /**
   * Sets the value of the coord2 property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setCoord2(Double value) {
    this.coord2 = value;
  }

  /**
   * Gets the value of the coord3 property.
   *
   * @return possible object is {@link Double }
   */
  public Double getCoord3() {
    return coord3;
  }

  /**
   * Sets the value of the coord3 property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setCoord3(Double value) {
    this.coord3 = value;
  }
}
