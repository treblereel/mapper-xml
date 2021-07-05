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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}InstanceFields"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}TableLocator"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}InlineTable"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="isTransformed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="recordCount" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="fieldCount" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "instanceFields", "table"})
@XmlRootElement(name = "TrainingInstances")
@JsType
public class TrainingInstances {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "InstanceFields", required = true)
  protected InstanceFields instanceFields;

  @XmlElementRefs({
    @XmlElementRef(
        name = "TableLocator",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TableLocator.class,
        required = false),
    @XmlElementRef(
        name = "InlineTable",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = InlineTable.class,
        required = false)
  })
  protected IChildParent table;

  @XmlAttribute(name = "isTransformed")
  protected Boolean isTransformed;

  @XmlAttribute(name = "recordCount")
  protected BigInteger recordCount;

  @XmlAttribute(name = "fieldCount")
  protected BigInteger fieldCount;

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
   * Gets the value of the instanceFields property.
   *
   * @return possible object is {@link InstanceFields }
   */
  public InstanceFields getInstanceFields() {
    return instanceFields;
  }

  /**
   * Sets the value of the instanceFields property.
   *
   * @param value allowed object is {@link InstanceFields }
   */
  public void setInstanceFields(InstanceFields value) {
    this.instanceFields = value;
  }

  /**
   * Gets the value of the table property.
   *
   * @return possible object is {@link TableLocator } {@link InlineTable }
   */
  public IChildParent getTable() {
    return table;
  }

  /**
   * Sets the value of the table property.
   *
   * @param value allowed object is {@link TableLocator } {@link InlineTable }
   */
  public void setTable(IChildParent value) {
    this.table = value;
  }

  /**
   * Gets the value of the isTransformed property.
   *
   * @return possible object is {@link Boolean }
   */
  public boolean isIsTransformed() {
    if (isTransformed == null) {
      return false;
    } else {
      return isTransformed;
    }
  }

  /**
   * Sets the value of the isTransformed property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setIsTransformed(Boolean value) {
    this.isTransformed = value;
  }

  /**
   * Gets the value of the recordCount property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getRecordCount() {
    return recordCount;
  }

  /**
   * Sets the value of the recordCount property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setRecordCount(BigInteger value) {
    this.recordCount = value;
  }

  /**
   * Gets the value of the fieldCount property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getFieldCount() {
    return fieldCount;
  }

  /**
   * Sets the value of the fieldCount property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setFieldCount(BigInteger value) {
    this.fieldCount = value;
  }
}
