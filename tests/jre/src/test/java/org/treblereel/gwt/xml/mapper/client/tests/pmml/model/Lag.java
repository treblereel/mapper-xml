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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}BlockIndicator" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="field" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="n" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="1" /&gt;
 *       &lt;attribute name="aggregate" default="none"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="none"/&gt;
 *             &lt;enumeration value="avg"/&gt;
 *             &lt;enumeration value="max"/&gt;
 *             &lt;enumeration value="median"/&gt;
 *             &lt;enumeration value="min"/&gt;
 *             &lt;enumeration value="product"/&gt;
 *             &lt;enumeration value="sum"/&gt;
 *             &lt;enumeration value="stddev"/&gt;
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
    propOrder = {"extension", "blockIndicator"})
@XmlRootElement(name = "Lag")
@JsType
public class Lag implements IApply {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "BlockIndicator")
  protected List<BlockIndicator> blockIndicator;

  @XmlAttribute(name = "field", required = true)
  protected String field;

  @XmlAttribute(name = "n")
  protected BigInteger n;

  @XmlAttribute(name = "aggregate")
  protected String aggregate;

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
   * Gets the value of the blockIndicator property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the blockIndicator property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getBlockIndicator().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link BlockIndicator }
   */
  public List<BlockIndicator> getBlockIndicator() {
    if (blockIndicator == null) {
      blockIndicator = new ArrayList<BlockIndicator>();
    }
    return this.blockIndicator;
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
   * Gets the value of the n property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getN() {
    if (n == null) {
      return new BigInteger("1");
    } else {
      return n;
    }
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
   * Gets the value of the aggregate property.
   *
   * @return possible object is {@link String }
   */
  public String getAggregate() {
    if (aggregate == null) {
      return "none";
    } else {
      return aggregate;
    }
  }

  /**
   * Sets the value of the aggregate property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAggregate(String value) {
    this.aggregate = value;
  }
}
