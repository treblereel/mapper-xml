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
 *         &lt;sequence minOccurs="0"&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}Decisions" minOccurs="0"/&gt;
 *           &lt;group ref="{http://www.dmg.org/PMML-4_4}EXPRESSION"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}Value" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="optype" type="{http://www.dmg.org/PMML-4_4}OPTYPE" /&gt;
 *       &lt;attribute name="dataType" use="required" type="{http://www.dmg.org/PMML-4_4}DATATYPE" /&gt;
 *       &lt;attribute name="targetField" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="feature" type="{http://www.dmg.org/PMML-4_4}RESULT-FEATURE" default="predictedValue" /&gt;
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ruleFeature" type="{http://www.dmg.org/PMML-4_4}RULE-FEATURE" default="consequent" /&gt;
 *       &lt;attribute name="algorithm" default="exclusiveRecommendation"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="recommendation"/&gt;
 *             &lt;enumeration value="exclusiveRecommendation"/&gt;
 *             &lt;enumeration value="ruleAssociation"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="rank" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" default="1" /&gt;
 *       &lt;attribute name="rankBasis" default="confidence"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="confidence"/&gt;
 *             &lt;enumeration value="support"/&gt;
 *             &lt;enumeration value="lift"/&gt;
 *             &lt;enumeration value="leverage"/&gt;
 *             &lt;enumeration value="affinity"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="rankOrder" default="descending"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="descending"/&gt;
 *             &lt;enumeration value="ascending"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="isMultiValued" type="{http://www.w3.org/2001/XMLSchema}string" default="0" /&gt;
 *       &lt;attribute name="segmentId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="isFinalResult" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "decisions", "expression", "valueAttribute"})
@XmlRootElement(name = "OutputField")
@JsType
public class OutputField {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "Decisions")
  protected Decisions decisions;

  @XmlElementRefs({
    @XmlElementRef(
        name = "Constant",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Constant.class,
        required = false),
    @XmlElementRef(
        name = "FieldRef",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = FieldRef.class,
        required = false),
    @XmlElementRef(
        name = "NormContinuous",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NormContinuous.class,
        required = false),
    @XmlElementRef(
        name = "NormDiscrete",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NormDiscrete.class,
        required = false),
    @XmlElementRef(
        name = "Discretize",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Discretize.class,
        required = false),
    @XmlElementRef(
        name = "MapValues",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = MapValues.class,
        required = false),
    @XmlElementRef(
        name = "TextIndex",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TextIndex.class,
        required = false),
    @XmlElementRef(
        name = "Apply",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Apply.class,
        required = false),
    @XmlElementRef(
        name = "Aggregate",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Aggregate.class,
        required = false),
    @XmlElementRef(
        name = "Lag",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Lag.class,
        required = false)
  })
  protected IApply expression;

  @XmlElement(name = "Value")
  protected List<Value> valueAttribute;

  @XmlAttribute(name = "name", required = true)
  protected String name;

  @XmlAttribute(name = "displayName")
  protected String displayName;

  @XmlAttribute(name = "optype")
  protected OPTYPE optype;

  @XmlAttribute(name = "dataType", required = true)
  protected DATATYPE dataType;

  @XmlAttribute(name = "targetField")
  protected String targetField;

  @XmlAttribute(name = "feature")
  protected RESULTFEATURE feature;

  @XmlAttribute(name = "value")
  protected String value;

  @XmlAttribute(name = "ruleFeature")
  protected RULEFEATURE ruleFeature;

  @XmlAttribute(name = "algorithm")
  protected String algorithm;

  @XmlAttribute(name = "rank")
  protected BigInteger rank;

  @XmlAttribute(name = "rankBasis")
  protected String rankBasis;

  @XmlAttribute(name = "rankOrder")
  protected String rankOrder;

  @XmlAttribute(name = "isMultiValued")
  protected String isMultiValued;

  @XmlAttribute(name = "segmentId")
  protected String segmentId;

  @XmlAttribute(name = "isFinalResult")
  protected Boolean isFinalResult;

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
   * Gets the value of the decisions property.
   *
   * @return possible object is {@link Decisions }
   */
  public Decisions getDecisions() {
    return decisions;
  }

  /**
   * Sets the value of the decisions property.
   *
   * @param value allowed object is {@link Decisions }
   */
  public void setDecisions(Decisions value) {
    this.decisions = value;
  }

  /**
   * Gets the value of the expression property.
   *
   * @return possible object is {@link Constant } {@link FieldRef } {@link NormContinuous } {@link
   *     NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link Apply }
   *     {@link Aggregate } {@link Lag }
   */
  public IApply getExpression() {
    return expression;
  }

  /**
   * Sets the value of the expression property.
   *
   * @param value allowed object is {@link Constant } {@link FieldRef } {@link NormContinuous }
   *     {@link NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link
   *     Apply } {@link Aggregate } {@link Lag }
   */
  public void setExpression(IApply value) {
    this.expression = value;
  }

  /**
   * Gets the value of the valueAttribute property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the valueAttribute property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getValueAttribute().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Value }
   */
  public List<Value> getValueAttribute() {
    if (valueAttribute == null) {
      valueAttribute = new ArrayList<Value>();
    }
    return this.valueAttribute;
  }

  /**
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets the value of the displayName property.
   *
   * @return possible object is {@link String }
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Sets the value of the displayName property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDisplayName(String value) {
    this.displayName = value;
  }

  /**
   * Gets the value of the optype property.
   *
   * @return possible object is {@link OPTYPE }
   */
  public OPTYPE getOptype() {
    return optype;
  }

  /**
   * Sets the value of the optype property.
   *
   * @param value allowed object is {@link OPTYPE }
   */
  public void setOptype(OPTYPE value) {
    this.optype = value;
  }

  /**
   * Gets the value of the dataType property.
   *
   * @return possible object is {@link DATATYPE }
   */
  public DATATYPE getDataType() {
    return dataType;
  }

  /**
   * Sets the value of the dataType property.
   *
   * @param value allowed object is {@link DATATYPE }
   */
  public void setDataType(DATATYPE value) {
    this.dataType = value;
  }

  /**
   * Gets the value of the targetField property.
   *
   * @return possible object is {@link String }
   */
  public String getTargetField() {
    return targetField;
  }

  /**
   * Sets the value of the targetField property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTargetField(String value) {
    this.targetField = value;
  }

  /**
   * Gets the value of the feature property.
   *
   * @return possible object is {@link RESULTFEATURE }
   */
  public RESULTFEATURE getFeature() {
    if (feature == null) {
      return RESULTFEATURE.PREDICTED_VALUE;
    } else {
      return feature;
    }
  }

  /**
   * Sets the value of the feature property.
   *
   * @param value allowed object is {@link RESULTFEATURE }
   */
  public void setFeature(RESULTFEATURE value) {
    this.feature = value;
  }

  /**
   * Gets the value of the value property.
   *
   * @return possible object is {@link String }
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value of the value property.
   *
   * @param value allowed object is {@link String }
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Gets the value of the ruleFeature property.
   *
   * @return possible object is {@link RULEFEATURE }
   */
  public RULEFEATURE getRuleFeature() {
    if (ruleFeature == null) {
      return RULEFEATURE.CONSEQUENT;
    } else {
      return ruleFeature;
    }
  }

  /**
   * Sets the value of the ruleFeature property.
   *
   * @param value allowed object is {@link RULEFEATURE }
   */
  public void setRuleFeature(RULEFEATURE value) {
    this.ruleFeature = value;
  }

  /**
   * Gets the value of the algorithm property.
   *
   * @return possible object is {@link String }
   */
  public String getAlgorithm() {
    if (algorithm == null) {
      return "exclusiveRecommendation";
    } else {
      return algorithm;
    }
  }

  /**
   * Sets the value of the algorithm property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAlgorithm(String value) {
    this.algorithm = value;
  }

  /**
   * Gets the value of the rank property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getRank() {
    if (rank == null) {
      return new BigInteger("1");
    } else {
      return rank;
    }
  }

  /**
   * Sets the value of the rank property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setRank(BigInteger value) {
    this.rank = value;
  }

  /**
   * Gets the value of the rankBasis property.
   *
   * @return possible object is {@link String }
   */
  public String getRankBasis() {
    if (rankBasis == null) {
      return "confidence";
    } else {
      return rankBasis;
    }
  }

  /**
   * Sets the value of the rankBasis property.
   *
   * @param value allowed object is {@link String }
   */
  public void setRankBasis(String value) {
    this.rankBasis = value;
  }

  /**
   * Gets the value of the rankOrder property.
   *
   * @return possible object is {@link String }
   */
  public String getRankOrder() {
    if (rankOrder == null) {
      return "descending";
    } else {
      return rankOrder;
    }
  }

  /**
   * Sets the value of the rankOrder property.
   *
   * @param value allowed object is {@link String }
   */
  public void setRankOrder(String value) {
    this.rankOrder = value;
  }

  /**
   * Gets the value of the isMultiValued property.
   *
   * @return possible object is {@link String }
   */
  public String getIsMultiValued() {
    if (isMultiValued == null) {
      return "0";
    } else {
      return isMultiValued;
    }
  }

  /**
   * Sets the value of the isMultiValued property.
   *
   * @param value allowed object is {@link String }
   */
  public void setIsMultiValued(String value) {
    this.isMultiValued = value;
  }

  /**
   * Gets the value of the segmentId property.
   *
   * @return possible object is {@link String }
   */
  public String getSegmentId() {
    return segmentId;
  }

  /**
   * Sets the value of the segmentId property.
   *
   * @param value allowed object is {@link String }
   */
  public void setSegmentId(String value) {
    this.segmentId = value;
  }

  /**
   * Gets the value of the isFinalResult property.
   *
   * @return possible object is {@link Boolean }
   */
  public boolean isIsFinalResult() {
    if (isFinalResult == null) {
      return true;
    } else {
      return isFinalResult;
    }
  }

  /**
   * Sets the value of the isFinalResult property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setIsFinalResult(Boolean value) {
    this.isFinalResult = value;
  }
}
