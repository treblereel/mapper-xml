//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:18 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.impl.v4_4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.IModel;

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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelStats" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}LocalTransformations" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Constraints" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Item" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Itemset" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}SetPredicate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Sequence" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}SequenceRule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-4_4}MINING-FUNCTION" /&gt;
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="numberOfTransactions" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="maxNumberOfItemsPerTransaction" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="avgNumberOfItemsPerTransaction" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="numberOfTransactionGroups" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="maxNumberOfTAsPerTAGroup" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="avgNumberOfTAsPerTAGroup" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
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
      "modelStats",
      "localTransformations",
      "constraints",
      "item",
      "itemset",
      "setPredicate",
      "sequence",
      "sequenceRule"
    })
@XmlRootElement(name = "SequenceModel")
public class SequenceModel implements IModel {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "MiningSchema", required = true)
  protected MiningSchema miningSchema;

  @XmlElement(name = "ModelStats")
  protected ModelStats modelStats;

  @XmlElement(name = "LocalTransformations")
  protected LocalTransformations localTransformations;

  @XmlElement(name = "Constraints")
  protected Constraints constraints;

  @XmlElement(name = "Item")
  protected List<Item> item;

  @XmlElement(name = "Itemset")
  protected List<Itemset> itemset;

  @XmlElement(name = "SetPredicate")
  protected List<SetPredicate> setPredicate;

  @XmlElement(name = "Sequence", required = true)
  protected List<Sequence> sequence;

  @XmlElement(name = "SequenceRule")
  protected List<SequenceRule> sequenceRule;

  @XmlAttribute(name = "modelName")
  protected String modelName;

  @XmlAttribute(name = "functionName", required = true)
  protected MININGFUNCTION functionName;

  @XmlAttribute(name = "algorithmName")
  protected String algorithmName;

  @XmlAttribute(name = "numberOfTransactions")
  @XmlSchemaType(name = "nonNegativeInteger")
  protected BigInteger numberOfTransactions;

  @XmlAttribute(name = "maxNumberOfItemsPerTransaction")
  @XmlSchemaType(name = "nonNegativeInteger")
  protected BigInteger maxNumberOfItemsPerTransaction;

  @XmlAttribute(name = "avgNumberOfItemsPerTransaction")
  protected Double avgNumberOfItemsPerTransaction;

  @XmlAttribute(name = "numberOfTransactionGroups")
  @XmlSchemaType(name = "nonNegativeInteger")
  protected BigInteger numberOfTransactionGroups;

  @XmlAttribute(name = "maxNumberOfTAsPerTAGroup")
  @XmlSchemaType(name = "nonNegativeInteger")
  protected BigInteger maxNumberOfTAsPerTAGroup;

  @XmlAttribute(name = "avgNumberOfTAsPerTAGroup")
  protected Double avgNumberOfTAsPerTAGroup;

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
   * Gets the value of the constraints property.
   *
   * @return possible object is {@link Constraints }
   */
  public Constraints getConstraints() {
    return constraints;
  }

  /**
   * Sets the value of the constraints property.
   *
   * @param value allowed object is {@link Constraints }
   */
  public void setConstraints(Constraints value) {
    this.constraints = value;
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
   * Gets the value of the setPredicate property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the setPredicate property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getSetPredicate().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link SetPredicate }
   */
  public List<SetPredicate> getSetPredicate() {
    if (setPredicate == null) {
      setPredicate = new ArrayList<SetPredicate>();
    }
    return this.setPredicate;
  }

  /**
   * Gets the value of the sequence property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the sequence property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getSequence().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Sequence }
   */
  public List<Sequence> getSequence() {
    if (sequence == null) {
      sequence = new ArrayList<Sequence>();
    }
    return this.sequence;
  }

  /**
   * Gets the value of the sequenceRule property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the sequenceRule property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getSequenceRule().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link SequenceRule }
   */
  public List<SequenceRule> getSequenceRule() {
    if (sequenceRule == null) {
      sequenceRule = new ArrayList<SequenceRule>();
    }
    return this.sequenceRule;
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
   * Gets the value of the maxNumberOfItemsPerTransaction property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaxNumberOfItemsPerTransaction() {
    return maxNumberOfItemsPerTransaction;
  }

  /**
   * Sets the value of the maxNumberOfItemsPerTransaction property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaxNumberOfItemsPerTransaction(BigInteger value) {
    this.maxNumberOfItemsPerTransaction = value;
  }

  /**
   * Gets the value of the avgNumberOfItemsPerTransaction property.
   *
   * @return possible object is {@link Double }
   */
  public Double getAvgNumberOfItemsPerTransaction() {
    return avgNumberOfItemsPerTransaction;
  }

  /**
   * Sets the value of the avgNumberOfItemsPerTransaction property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAvgNumberOfItemsPerTransaction(Double value) {
    this.avgNumberOfItemsPerTransaction = value;
  }

  /**
   * Gets the value of the numberOfTransactionGroups property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNumberOfTransactionGroups() {
    return numberOfTransactionGroups;
  }

  /**
   * Sets the value of the numberOfTransactionGroups property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNumberOfTransactionGroups(BigInteger value) {
    this.numberOfTransactionGroups = value;
  }

  /**
   * Gets the value of the maxNumberOfTAsPerTAGroup property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaxNumberOfTAsPerTAGroup() {
    return maxNumberOfTAsPerTAGroup;
  }

  /**
   * Sets the value of the maxNumberOfTAsPerTAGroup property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaxNumberOfTAsPerTAGroup(BigInteger value) {
    this.maxNumberOfTAsPerTAGroup = value;
  }

  /**
   * Gets the value of the avgNumberOfTAsPerTAGroup property.
   *
   * @return possible object is {@link Double }
   */
  public Double getAvgNumberOfTAsPerTAGroup() {
    return avgNumberOfTAsPerTAGroup;
  }

  /**
   * Sets the value of the avgNumberOfTAsPerTAGroup property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAvgNumberOfTAsPerTAGroup(Double value) {
    this.avgNumberOfTAsPerTAGroup = value;
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
