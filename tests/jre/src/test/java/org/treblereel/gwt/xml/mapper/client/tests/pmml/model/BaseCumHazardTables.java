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
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}BaselineStratum" maxOccurs="unbounded"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}BaselineCell" maxOccurs="unbounded"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="maxTime" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "baseline"})
@XmlRootElement(name = "BaseCumHazardTables")
@JsType
public class BaseCumHazardTables {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElementRefs({
    @XmlElementRef(
        name = "BaselineStratum",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = BaselineStratum.class,
        required = false),
    @XmlElementRef(
        name = "BaselineCell",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = BaselineCell.class,
        required = false)
  })
  protected List<IBaseCumHazardTables> baseline;

  @XmlAttribute(name = "maxTime")
  protected Double maxTime;

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
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the baseline property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getBaseline().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link BaselineStratum } {@link
   * BaselineCell }
   */
  public List<IBaseCumHazardTables> getBaseline() {
    if (baseline == null) {
      baseline = new ArrayList<IBaseCumHazardTables>();
    }
    return this.baseline;
  }

  /**
   * Gets the value of the maxTime property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMaxTime() {
    return maxTime;
  }

  /**
   * Sets the value of the maxTime property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMaxTime(Double value) {
    this.maxTime = value;
  }
}
