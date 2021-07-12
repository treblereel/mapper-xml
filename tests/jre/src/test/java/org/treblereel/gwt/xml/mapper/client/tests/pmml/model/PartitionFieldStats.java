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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Counts" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}NumericInfo" minOccurs="0"/&gt;
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}FrequenciesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="field" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="weighted" default="0"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="0"/&gt;
 *             &lt;enumeration value="1"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "counts", "numericInfo", "numarray"})
@XmlRootElement(name = "PartitionFieldStats")
@JsType
public class PartitionFieldStats {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "Counts")
  protected Counts counts;

  @XmlElement(name = "NumericInfo")
  protected NumericInfo numericInfo;

  @XmlElement(name = "NUM-ARRAY")
  protected List<NUMARRAY> numarray;

  @XmlAttribute(name = "field", required = true)
  protected String field;

  @XmlAttribute(name = "weighted")
  protected String weighted;

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
   * Gets the value of the counts property.
   *
   * @return possible object is {@link Counts }
   */
  public Counts getCounts() {
    return counts;
  }

  /**
   * Sets the value of the counts property.
   *
   * @param value allowed object is {@link Counts }
   */
  public void setCounts(Counts value) {
    this.counts = value;
  }

  /**
   * Gets the value of the numericInfo property.
   *
   * @return possible object is {@link NumericInfo }
   */
  public NumericInfo getNumericInfo() {
    return numericInfo;
  }

  /**
   * Sets the value of the numericInfo property.
   *
   * @param value allowed object is {@link NumericInfo }
   */
  public void setNumericInfo(NumericInfo value) {
    this.numericInfo = value;
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
   * Gets the value of the weighted property.
   *
   * @return possible object is {@link String }
   */
  public String getWeighted() {
    if (weighted == null) {
      return "0";
    } else {
      return weighted;
    }
  }

  /**
   * Sets the value of the weighted property.
   *
   * @param value allowed object is {@link String }
   */
  public void setWeighted(String value) {
    this.weighted = value;
  }
}
