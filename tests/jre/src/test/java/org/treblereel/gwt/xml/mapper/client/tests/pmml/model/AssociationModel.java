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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}MiningSchema"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Output" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelStats" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}LocalTransformations" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Item" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Itemset" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}AssociationRule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelVerification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-4_4}MINING-FUNCTION" /&gt;
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="numberOfTransactions" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="maxNumberOfItemsPerTA" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="avgNumberOfItemsPerTA" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="minimumSupport" use="required" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" /&gt;
 *       &lt;attribute name="minimumConfidence" use="required" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" /&gt;
 *       &lt;attribute name="lengthLimit" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="numberOfItems" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="numberOfItemsets" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="numberOfRules" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="isScorable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {
      "extension",
      "miningSchema",
      "output",
      "modelStats",
      "localTransformations",
      "item",
      "itemset",
      "associationRule",
      "modelVerification"
    })
@XmlRootElement(name = "AssociationModel")
@JsType
public class AssociationModel implements IPMML {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "MiningSchema", required = true)
  protected MiningSchema miningSchema;

  @XmlElement(name = "Output")
  protected Output output;

  @XmlElement(name = "ModelStats")
  protected ModelStats modelStats;

  @XmlElement(name = "LocalTransformations")
  protected LocalTransformations localTransformations;

  @XmlElement(name = "Item")
  protected List<Item> item;

  @XmlElement(name = "Itemset")
  protected List<Itemset> itemset;

  @XmlElement(name = "AssociationRule")
  protected List<AssociationRule> associationRule;

  @XmlElement(name = "ModelVerification")
  protected ModelVerification modelVerification;

  @XmlAttribute(name = "modelName")
  protected String modelName;

  @XmlAttribute(name = "functionName", required = true)
  protected MININGFUNCTION functionName;

  @XmlAttribute(name = "algorithmName")
  protected String algorithmName;

  @XmlAttribute(name = "numberOfTransactions", required = true)
  protected BigInteger numberOfTransactions;

  @XmlAttribute(name = "maxNumberOfItemsPerTA")
  protected BigInteger maxNumberOfItemsPerTA;

  @XmlAttribute(name = "avgNumberOfItemsPerTA")
  protected Double avgNumberOfItemsPerTA;

  @XmlAttribute(name = "minimumSupport", required = true)
  protected double minimumSupport;

  @XmlAttribute(name = "minimumConfidence", required = true)
  protected double minimumConfidence;

  @XmlAttribute(name = "lengthLimit")
  protected BigInteger lengthLimit;

  @XmlAttribute(name = "numberOfItems", required = true)
  protected BigInteger numberOfItems;

  @XmlAttribute(name = "numberOfItemsets", required = true)
  protected BigInteger numberOfItemsets;

  @XmlAttribute(name = "numberOfRules", required = true)
  protected BigInteger numberOfRules;

  @XmlAttribute(name = "isScorable")
  protected Boolean isScorable;

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
   * Gets the value of the miningSchema property.
   *
   * @return possible object is {@link MiningSchema }
   */
  public MiningSchema getMiningSchema() {
    return miningSchema;
  }

  /**
   * Sets the value of the miningSchema property.
   *
   * @param value allowed object is {@link MiningSchema }
   */
  public void setMiningSchema(MiningSchema value) {
    this.miningSchema = value;
  }

  /**
   * Gets the value of the output property.
   *
   * @return possible object is {@link Output }
   */
  public Output getOutput() {
    return output;
  }

  /**
   * Sets the value of the output property.
   *
   * @param value allowed object is {@link Output }
   */
  public void setOutput(Output value) {
    this.output = value;
  }

  /**
   * Gets the value of the modelStats property.
   *
   * @return possible object is {@link ModelStats }
   */
  public ModelStats getModelStats() {
    return modelStats;
  }

  /**
   * Sets the value of the modelStats property.
   *
   * @param value allowed object is {@link ModelStats }
   */
  public void setModelStats(ModelStats value) {
    this.modelStats = value;
  }

  /**
   * Gets the value of the localTransformations property.
   *
   * @return possible object is {@link LocalTransformations }
   */
  public LocalTransformations getLocalTransformations() {
    return localTransformations;
  }

  /**
   * Sets the value of the localTransformations property.
   *
   * @param value allowed object is {@link LocalTransformations }
   */
  public void setLocalTransformations(LocalTransformations value) {
    this.localTransformations = value;
  }

  /**
   * Gets the value of the item property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the item property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getItem().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Item }
   */
  public List<Item> getItem() {
    if (item == null) {
      item = new ArrayList<Item>();
    }
    return this.item;
  }

  /**
   * Gets the value of the itemset property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the itemset property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getItemset().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Itemset }
   */
  public List<Itemset> getItemset() {
    if (itemset == null) {
      itemset = new ArrayList<Itemset>();
    }
    return this.itemset;
  }

  /**
   * Gets the value of the associationRule property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the associationRule property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getAssociationRule().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link AssociationRule }
   */
  public List<AssociationRule> getAssociationRule() {
    if (associationRule == null) {
      associationRule = new ArrayList<AssociationRule>();
    }
    return this.associationRule;
  }

  /**
   * Gets the value of the modelVerification property.
   *
   * @return possible object is {@link ModelVerification }
   */
  public ModelVerification getModelVerification() {
    return modelVerification;
  }

  /**
   * Sets the value of the modelVerification property.
   *
   * @param value allowed object is {@link ModelVerification }
   */
  public void setModelVerification(ModelVerification value) {
    this.modelVerification = value;
  }

  /**
   * Gets the value of the modelName property.
   *
   * @return possible object is {@link String }
   */
  public String getModelName() {
    return modelName;
  }

  /**
   * Sets the value of the modelName property.
   *
   * @param value allowed object is {@link String }
   */
  public void setModelName(String value) {
    this.modelName = value;
  }

  /**
   * Gets the value of the functionName property.
   *
   * @return possible object is {@link MININGFUNCTION }
   */
  public MININGFUNCTION getFunctionName() {
    return functionName;
  }

  /**
   * Sets the value of the functionName property.
   *
   * @param value allowed object is {@link MININGFUNCTION }
   */
  public void setFunctionName(MININGFUNCTION value) {
    this.functionName = value;
  }

  /**
   * Gets the value of the algorithmName property.
   *
   * @return possible object is {@link String }
   */
  public String getAlgorithmName() {
    return algorithmName;
  }

  /**
   * Sets the value of the algorithmName property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAlgorithmName(String value) {
    this.algorithmName = value;
  }

  /**
   * Gets the value of the numberOfTransactions property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNumberOfTransactions() {
    return numberOfTransactions;
  }

  /**
   * Sets the value of the numberOfTransactions property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNumberOfTransactions(BigInteger value) {
    this.numberOfTransactions = value;
  }

  /**
   * Gets the value of the maxNumberOfItemsPerTA property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaxNumberOfItemsPerTA() {
    return maxNumberOfItemsPerTA;
  }

  /**
   * Sets the value of the maxNumberOfItemsPerTA property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaxNumberOfItemsPerTA(BigInteger value) {
    this.maxNumberOfItemsPerTA = value;
  }

  /**
   * Gets the value of the avgNumberOfItemsPerTA property.
   *
   * @return possible object is {@link Double }
   */
  public Double getAvgNumberOfItemsPerTA() {
    return avgNumberOfItemsPerTA;
  }

  /**
   * Sets the value of the avgNumberOfItemsPerTA property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAvgNumberOfItemsPerTA(Double value) {
    this.avgNumberOfItemsPerTA = value;
  }

  /** Gets the value of the minimumSupport property. */
  public double getMinimumSupport() {
    return minimumSupport;
  }

  /** Sets the value of the minimumSupport property. */
  public void setMinimumSupport(double value) {
    this.minimumSupport = value;
  }

  /** Gets the value of the minimumConfidence property. */
  public double getMinimumConfidence() {
    return minimumConfidence;
  }

  /** Sets the value of the minimumConfidence property. */
  public void setMinimumConfidence(double value) {
    this.minimumConfidence = value;
  }

  /**
   * Gets the value of the lengthLimit property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getLengthLimit() {
    return lengthLimit;
  }

  /**
   * Sets the value of the lengthLimit property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setLengthLimit(BigInteger value) {
    this.lengthLimit = value;
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

  /**
   * Gets the value of the numberOfItemsets property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNumberOfItemsets() {
    return numberOfItemsets;
  }

  /**
   * Sets the value of the numberOfItemsets property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNumberOfItemsets(BigInteger value) {
    this.numberOfItemsets = value;
  }

  /**
   * Gets the value of the numberOfRules property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNumberOfRules() {
    return numberOfRules;
  }

  /**
   * Sets the value of the numberOfRules property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNumberOfRules(BigInteger value) {
    this.numberOfRules = value;
  }

  /**
   * Gets the value of the isScorable property.
   *
   * @return possible object is {@link Boolean }
   */
  public boolean isIsScorable() {
    if (isScorable == null) {
      return true;
    } else {
      return isScorable;
    }
  }

  /**
   * Sets the value of the isScorable property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setIsScorable(Boolean value) {
    this.isScorable = value;
  }
}
