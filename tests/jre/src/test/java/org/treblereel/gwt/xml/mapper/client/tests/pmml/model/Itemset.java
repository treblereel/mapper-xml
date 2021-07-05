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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ItemRef" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="support" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" /&gt;
 *       &lt;attribute name="numberOfItems" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "itemRef"})
@XmlRootElement(name = "Itemset")
@JsType
public class Itemset {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "ItemRef")
  protected List<ItemRef> itemRef;

  @XmlAttribute(name = "id", required = true)
  protected String id;

  @XmlAttribute(name = "support")
  protected Double support;

  @XmlAttribute(name = "numberOfItems")
  protected BigInteger numberOfItems;

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
   * Gets the value of the itemRef property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the itemRef property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getItemRef().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link ItemRef }
   */
  public List<ItemRef> getItemRef() {
    if (itemRef == null) {
      itemRef = new ArrayList<ItemRef>();
    }
    return this.itemRef;
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
   * Gets the value of the support property.
   *
   * @return possible object is {@link Double }
   */
  public Double getSupport() {
    return support;
  }

  /**
   * Sets the value of the support property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setSupport(Double value) {
    this.support = value;
  }

  /**
   * Gets the value of the numberOfItems property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNumberOfItems() {
    return numberOfItems;
  }

  /**
   * Sets the value of the numberOfItems property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNumberOfItems(BigInteger value) {
    this.numberOfItems = value;
  }
}
