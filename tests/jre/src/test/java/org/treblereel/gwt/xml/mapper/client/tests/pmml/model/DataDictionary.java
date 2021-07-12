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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Extension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}DataField" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Taxonomy" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="numberOfFields" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "dataField", "taxonomy"})
@XmlRootElement(name = "DataDictionary")
@JsType
public class DataDictionary {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "DataField", required = true)
  protected List<DataField> dataField;

  @XmlElement(name = "Taxonomy")
  protected List<Taxonomy> taxonomy;

  @XmlAttribute(name = "numberOfFields")
  protected BigInteger numberOfFields;

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
   * Gets the value of the dataField property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the dataField property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getDataField().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link DataField }
   */
  public List<DataField> getDataField() {
    if (dataField == null) {
      dataField = new ArrayList<DataField>();
    }
    return this.dataField;
  }

  /**
   * Gets the value of the taxonomy property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the taxonomy property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getTaxonomy().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Taxonomy }
   */
  public List<Taxonomy> getTaxonomy() {
    if (taxonomy == null) {
      taxonomy = new ArrayList<Taxonomy>();
    }
    return this.taxonomy;
  }

  /**
   * Gets the value of the numberOfFields property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNumberOfFields() {
    return numberOfFields;
  }

  /**
   * Sets the value of the numberOfFields property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNumberOfFields(BigInteger value) {
    this.numberOfFields = value;
  }
}
