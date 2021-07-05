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
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}TableLocator"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}InlineTable"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="inField" type="{http://www.w3.org/2001/XMLSchema}string" default="string" /&gt;
 *       &lt;attribute name="outField" type="{http://www.w3.org/2001/XMLSchema}string" default="stem" /&gt;
 *       &lt;attribute name="regexField" type="{http://www.w3.org/2001/XMLSchema}string" default="regex" /&gt;
 *       &lt;attribute name="recursive" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="isCaseSensitive" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="maxLevenshteinDistance" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="wordSeparatorCharacterRE" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="tokenize" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "table"})
@XmlRootElement(name = "TextIndexNormalization")
@JsType
public class TextIndexNormalization {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

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

  @XmlAttribute(name = "inField")
  protected String inField;

  @XmlAttribute(name = "outField")
  protected String outField;

  @XmlAttribute(name = "regexField")
  protected String regexField;

  @XmlAttribute(name = "recursive")
  protected Boolean recursive;

  @XmlAttribute(name = "isCaseSensitive")
  protected Boolean isCaseSensitive;

  @XmlAttribute(name = "maxLevenshteinDistance")
  protected BigInteger maxLevenshteinDistance;

  @XmlAttribute(name = "wordSeparatorCharacterRE")
  protected String wordSeparatorCharacterRE;

  @XmlAttribute(name = "tokenize")
  protected Boolean tokenize;

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
   * Gets the value of the inField property.
   *
   * @return possible object is {@link String }
   */
  public String getInField() {
    if (inField == null) {
      return "string";
    } else {
      return inField;
    }
  }

  /**
   * Sets the value of the inField property.
   *
   * @param value allowed object is {@link String }
   */
  public void setInField(String value) {
    this.inField = value;
  }

  /**
   * Gets the value of the outField property.
   *
   * @return possible object is {@link String }
   */
  public String getOutField() {
    if (outField == null) {
      return "stem";
    } else {
      return outField;
    }
  }

  /**
   * Sets the value of the outField property.
   *
   * @param value allowed object is {@link String }
   */
  public void setOutField(String value) {
    this.outField = value;
  }

  /**
   * Gets the value of the regexField property.
   *
   * @return possible object is {@link String }
   */
  public String getRegexField() {
    if (regexField == null) {
      return "regex";
    } else {
      return regexField;
    }
  }

  /**
   * Sets the value of the regexField property.
   *
   * @param value allowed object is {@link String }
   */
  public void setRegexField(String value) {
    this.regexField = value;
  }

  /**
   * Gets the value of the recursive property.
   *
   * @return possible object is {@link Boolean }
   */
  public boolean isRecursive() {
    if (recursive == null) {
      return false;
    } else {
      return recursive;
    }
  }

  /**
   * Sets the value of the recursive property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setRecursive(Boolean value) {
    this.recursive = value;
  }

  /**
   * Gets the value of the isCaseSensitive property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isIsCaseSensitive() {
    return isCaseSensitive;
  }

  /**
   * Sets the value of the isCaseSensitive property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setIsCaseSensitive(Boolean value) {
    this.isCaseSensitive = value;
  }

  /**
   * Gets the value of the maxLevenshteinDistance property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaxLevenshteinDistance() {
    return maxLevenshteinDistance;
  }

  /**
   * Sets the value of the maxLevenshteinDistance property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaxLevenshteinDistance(BigInteger value) {
    this.maxLevenshteinDistance = value;
  }

  /**
   * Gets the value of the wordSeparatorCharacterRE property.
   *
   * @return possible object is {@link String }
   */
  public String getWordSeparatorCharacterRE() {
    return wordSeparatorCharacterRE;
  }

  /**
   * Sets the value of the wordSeparatorCharacterRE property.
   *
   * @param value allowed object is {@link String }
   */
  public void setWordSeparatorCharacterRE(String value) {
    this.wordSeparatorCharacterRE = value;
  }

  /**
   * Gets the value of the tokenize property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isTokenize() {
    return tokenize;
  }

  /**
   * Sets the value of the tokenize property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setTokenize(Boolean value) {
    this.tokenize = value;
  }
}
