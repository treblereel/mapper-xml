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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Indices" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}REAL-Entries" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="n" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="defaultValue" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"indices", "realEntries"})
@XmlRootElement(name = "REAL-SparseArray")
@JsType
public class REALSparseArray implements IVectorInstance {

  @XmlElement(name = "Indices", type = Integer.class)
  protected List<Integer> indices;

  @XmlElement(name = "REAL-Entries", type = Double.class)
  protected List<Double> realEntries;

  @XmlAttribute(name = "n")
  protected BigInteger n;

  @XmlAttribute(name = "defaultValue")
  protected Double defaultValue;

  /**
   * Gets the value of the indices property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the indices property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getIndices().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Integer }
   */
  public List<Integer> getIndices() {
    if (indices == null) {
      indices = new ArrayList<Integer>();
    }
    return this.indices;
  }

  /**
   * Gets the value of the realEntries property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the realEntries property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getREALEntries().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Double }
   */
  public List<Double> getREALEntries() {
    if (realEntries == null) {
      realEntries = new ArrayList<Double>();
    }
    return this.realEntries;
  }

  /**
   * Gets the value of the n property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getN() {
    return n;
  }

  /**
   * Sets the value of the n property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setN(BigInteger value) {
    this.n = value;
  }

  /**
   * Gets the value of the defaultValue property.
   *
   * @return possible object is {@link Double }
   */
  public double getDefaultValue() {
    if (defaultValue == null) {
      return 0.0D;
    } else {
      return defaultValue;
    }
  }

  /**
   * Sets the value of the defaultValue property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setDefaultValue(Double value) {
    this.defaultValue = value;
  }
}
