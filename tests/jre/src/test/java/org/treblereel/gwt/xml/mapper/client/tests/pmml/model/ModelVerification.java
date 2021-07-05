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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}VerificationFields"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}InlineTable"/&gt;
 *       &lt;/sequence&gt;
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
    propOrder = {"extension", "verificationFields", "inlineTable"})
@XmlRootElement(name = "ModelVerification")
@JsType
public class ModelVerification {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "VerificationFields", required = true)
  protected VerificationFields verificationFields;

  @XmlElement(name = "InlineTable", required = true)
  protected InlineTable inlineTable;

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
   * Gets the value of the verificationFields property.
   *
   * @return possible object is {@link VerificationFields }
   */
  public VerificationFields getVerificationFields() {
    return verificationFields;
  }

  /**
   * Sets the value of the verificationFields property.
   *
   * @param value allowed object is {@link VerificationFields }
   */
  public void setVerificationFields(VerificationFields value) {
    this.verificationFields = value;
  }

  /**
   * Gets the value of the inlineTable property.
   *
   * @return possible object is {@link InlineTable }
   */
  public InlineTable getInlineTable() {
    return inlineTable;
  }

  /**
   * Sets the value of the inlineTable property.
   *
   * @param value allowed object is {@link InlineTable }
   */
  public void setInlineTable(InlineTable value) {
    this.inlineTable = value;
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
