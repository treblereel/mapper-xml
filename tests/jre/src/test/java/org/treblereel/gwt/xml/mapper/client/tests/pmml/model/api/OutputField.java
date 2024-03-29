//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

import java.math.BigInteger;
import java.util.List;

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
 *       &lt;attribute name="feature" type="{http://www.dmg.org/PMML-4_4}RESULT-FEATURE" /&gt;
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ruleFeature" type="{http://www.dmg.org/PMML-4_4}RULE-FEATURE" /&gt;
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
public interface OutputField {

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
  List<Extension> getExtension();

  /**
   * Gets the value of the decisions property.
   *
   * @return possible object is {@link Decisions }
   */
  Decisions getDecisions();

  /**
   * Sets the value of the decisions property.
   *
   * @param value allowed object is {@link Decisions }
   */
  void setDecisions(Decisions value);

  /**
   * Gets the value of the expression property.
   *
   * @return possible object is {@link Constant } {@link FieldRef } {@link NormContinuous } {@link
   *     NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link Apply }
   *     {@link Aggregate } {@link Lag }
   */
  IExpression getExpression();

  /**
   * Sets the value of the expression property.
   *
   * @param value allowed object is {@link Constant } {@link FieldRef } {@link NormContinuous }
   *     {@link NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link
   *     Apply } {@link Aggregate } {@link Lag }
   */
  void setExpression(IExpression value);

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
  List<Value> getValueAttribute();

  /**
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  String getName();

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  void setName(String value);

  /**
   * Gets the value of the displayName property.
   *
   * @return possible object is {@link String }
   */
  String getDisplayName();

  /**
   * Sets the value of the displayName property.
   *
   * @param value allowed object is {@link String }
   */
  void setDisplayName(String value);

  /**
   * Gets the value of the optype property.
   *
   * @return possible object is {@link OPTYPE }
   */
  OPTYPE getOptype();

  /**
   * Sets the value of the optype property.
   *
   * @param value allowed object is {@link OPTYPE }
   */
  void setOptype(OPTYPE value);

  /**
   * Gets the value of the dataType property.
   *
   * @return possible object is {@link DATATYPE }
   */
  DATATYPE getDataType();

  /**
   * Sets the value of the dataType property.
   *
   * @param value allowed object is {@link DATATYPE }
   */
  void setDataType(DATATYPE value);

  /**
   * Gets the value of the targetField property.
   *
   * @return possible object is {@link String }
   */
  String getTargetField();

  /**
   * Sets the value of the targetField property.
   *
   * @param value allowed object is {@link String }
   */
  void setTargetField(String value);

  /**
   * Gets the value of the feature property.
   *
   * @return possible object is {@link RESULTFEATURE }
   */
  RESULTFEATURE getFeature();

  /**
   * Sets the value of the feature property.
   *
   * @param value allowed object is {@link RESULTFEATURE }
   */
  void setFeature(RESULTFEATURE value);

  /**
   * Gets the value of the value property.
   *
   * @return possible object is {@link String }
   */
  String getValue();

  /**
   * Sets the value of the value property.
   *
   * @param value allowed object is {@link String }
   */
  void setValue(String value);

  /**
   * Gets the value of the ruleFeature property.
   *
   * @return possible object is {@link RULEFEATURE }
   */
  RULEFEATURE getRuleFeature();

  /**
   * Sets the value of the ruleFeature property.
   *
   * @param value allowed object is {@link RULEFEATURE }
   */
  void setRuleFeature(RULEFEATURE value);

  /**
   * Gets the value of the algorithm property.
   *
   * @return possible object is {@link String }
   */
  String getAlgorithm();

  /**
   * Sets the value of the algorithm property.
   *
   * @param value allowed object is {@link String }
   */
  void setAlgorithm(String value);

  /**
   * Gets the value of the rank property.
   *
   * @return possible object is {@link BigInteger }
   */
  BigInteger getRank();

  /**
   * Sets the value of the rank property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  void setRank(BigInteger value);

  /**
   * Gets the value of the rankBasis property.
   *
   * @return possible object is {@link String }
   */
  String getRankBasis();

  /**
   * Sets the value of the rankBasis property.
   *
   * @param value allowed object is {@link String }
   */
  void setRankBasis(String value);

  /**
   * Gets the value of the rankOrder property.
   *
   * @return possible object is {@link String }
   */
  String getRankOrder();

  /**
   * Sets the value of the rankOrder property.
   *
   * @param value allowed object is {@link String }
   */
  void setRankOrder(String value);

  /**
   * Gets the value of the isMultiValued property.
   *
   * @return possible object is {@link String }
   */
  String getIsMultiValued();

  /**
   * Sets the value of the isMultiValued property.
   *
   * @param value allowed object is {@link String }
   */
  void setIsMultiValued(String value);

  /**
   * Gets the value of the segmentId property.
   *
   * @return possible object is {@link String }
   */
  String getSegmentId();

  /**
   * Sets the value of the segmentId property.
   *
   * @param value allowed object is {@link String }
   */
  void setSegmentId(String value);

  /**
   * Gets the value of the isFinalResult property.
   *
   * @return possible object is {@link Boolean }
   */
  boolean isIsFinalResult();

  /**
   * Sets the value of the isFinalResult property.
   *
   * @param value allowed object is {@link Boolean }
   */
  void setIsFinalResult(Boolean value);
}
