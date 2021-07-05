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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Interval" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}FrequenciesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="totalValuesSum" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="totalSquaresSum" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "interval", "numarray"})
@XmlRootElement(name = "ContStats")
@JsType
public class ContStats {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "Interval")
  protected List<Interval> interval;

  @XmlElement(name = "NUM-ARRAY")
  protected List<NUMARRAY> numarray;

  @XmlAttribute(name = "totalValuesSum")
  protected Double totalValuesSum;

  @XmlAttribute(name = "totalSquaresSum")
  protected Double totalSquaresSum;

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
   * Gets the value of the interval property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the interval property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getInterval().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Interval }
   */
  public List<Interval> getInterval() {
    if (interval == null) {
      interval = new ArrayList<Interval>();
    }
    return this.interval;
  }

  /**
   * Gets the value of the numarray property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the numarray property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getNUMARRAY().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link NUMARRAY }
   */
  public List<NUMARRAY> getNUMARRAY() {
    if (numarray == null) {
      numarray = new ArrayList<NUMARRAY>();
    }
    return this.numarray;
  }

  /**
   * Gets the value of the totalValuesSum property.
   *
   * @return possible object is {@link Double }
   */
  public Double getTotalValuesSum() {
    return totalValuesSum;
  }

  /**
   * Sets the value of the totalValuesSum property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setTotalValuesSum(Double value) {
    this.totalValuesSum = value;
  }

  /**
   * Gets the value of the totalSquaresSum property.
   *
   * @return possible object is {@link Double }
   */
  public Double getTotalSquaresSum() {
    return totalSquaresSum;
  }

  /**
   * Sets the value of the totalSquaresSum property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setTotalSquaresSum(Double value) {
    this.totalSquaresSum = value;
  }
}
