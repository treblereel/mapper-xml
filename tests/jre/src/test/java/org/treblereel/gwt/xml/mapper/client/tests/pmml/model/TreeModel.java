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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelExplanation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Targets" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}LocalTransformations" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Node"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelVerification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-4_4}MINING-FUNCTION" /&gt;
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="missingValueStrategy" type="{http://www.dmg.org/PMML-4_4}MISSING-VALUE-STRATEGY" default="none" /&gt;
 *       &lt;attribute name="missingValuePenalty" type="{http://www.dmg.org/PMML-4_4}PROB-NUMBER" default="1.0" /&gt;
 *       &lt;attribute name="noTrueChildStrategy" type="{http://www.dmg.org/PMML-4_4}NO-TRUE-CHILD-STRATEGY" default="returnNullPrediction" /&gt;
 *       &lt;attribute name="splitCharacteristic" default="multiSplit"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="binarySplit"/&gt;
 *             &lt;enumeration value="multiSplit"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
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
      "modelExplanation",
      "targets",
      "localTransformations",
      "node",
      "modelVerification"
    })
@XmlRootElement(name = "TreeModel")
@JsType
public class TreeModel implements IPMML {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "MiningSchema", required = true)
  protected MiningSchema miningSchema;

  @XmlElement(name = "Output")
  protected Output output;

  @XmlElement(name = "ModelStats")
  protected ModelStats modelStats;

  @XmlElement(name = "ModelExplanation")
  protected ModelExplanation modelExplanation;

  @XmlElement(name = "Targets")
  protected Targets targets;

  @XmlElement(name = "LocalTransformations")
  protected LocalTransformations localTransformations;

  @XmlElement(name = "Node", required = true)
  protected Node node;

  @XmlElement(name = "ModelVerification")
  protected ModelVerification modelVerification;

  @XmlAttribute(name = "modelName")
  protected String modelName;

  @XmlAttribute(name = "functionName", required = true)
  protected MININGFUNCTION functionName;

  @XmlAttribute(name = "algorithmName")
  protected String algorithmName;

  @XmlAttribute(name = "missingValueStrategy")
  protected MISSINGVALUESTRATEGY missingValueStrategy;

  @XmlAttribute(name = "missingValuePenalty")
  protected Double missingValuePenalty;

  @XmlAttribute(name = "noTrueChildStrategy")
  protected NOTRUECHILDSTRATEGY noTrueChildStrategy;

  @XmlAttribute(name = "splitCharacteristic")
  protected String splitCharacteristic;

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
   * Gets the value of the modelExplanation property.
   *
   * @return possible object is {@link ModelExplanation }
   */
  public ModelExplanation getModelExplanation() {
    return modelExplanation;
  }

  /**
   * Sets the value of the modelExplanation property.
   *
   * @param value allowed object is {@link ModelExplanation }
   */
  public void setModelExplanation(ModelExplanation value) {
    this.modelExplanation = value;
  }

  /**
   * Gets the value of the targets property.
   *
   * @return possible object is {@link Targets }
   */
  public Targets getTargets() {
    return targets;
  }

  /**
   * Sets the value of the targets property.
   *
   * @param value allowed object is {@link Targets }
   */
  public void setTargets(Targets value) {
    this.targets = value;
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
   * Gets the value of the node property.
   *
   * @return possible object is {@link Node }
   */
  public Node getNode() {
    return node;
  }

  /**
   * Sets the value of the node property.
   *
   * @param value allowed object is {@link Node }
   */
  public void setNode(Node value) {
    this.node = value;
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
   * Gets the value of the missingValueStrategy property.
   *
   * @return possible object is {@link MISSINGVALUESTRATEGY }
   */
  public MISSINGVALUESTRATEGY getMissingValueStrategy() {
    if (missingValueStrategy == null) {
      return MISSINGVALUESTRATEGY.NONE;
    } else {
      return missingValueStrategy;
    }
  }

  /**
   * Sets the value of the missingValueStrategy property.
   *
   * @param value allowed object is {@link MISSINGVALUESTRATEGY }
   */
  public void setMissingValueStrategy(MISSINGVALUESTRATEGY value) {
    this.missingValueStrategy = value;
  }

  /**
   * Gets the value of the missingValuePenalty property.
   *
   * @return possible object is {@link Double }
   */
  public double getMissingValuePenalty() {
    if (missingValuePenalty == null) {
      return 1.0D;
    } else {
      return missingValuePenalty;
    }
  }

  /**
   * Sets the value of the missingValuePenalty property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMissingValuePenalty(Double value) {
    this.missingValuePenalty = value;
  }

  /**
   * Gets the value of the noTrueChildStrategy property.
   *
   * @return possible object is {@link NOTRUECHILDSTRATEGY }
   */
  public NOTRUECHILDSTRATEGY getNoTrueChildStrategy() {
    if (noTrueChildStrategy == null) {
      return NOTRUECHILDSTRATEGY.RETURN_NULL_PREDICTION;
    } else {
      return noTrueChildStrategy;
    }
  }

  /**
   * Sets the value of the noTrueChildStrategy property.
   *
   * @param value allowed object is {@link NOTRUECHILDSTRATEGY }
   */
  public void setNoTrueChildStrategy(NOTRUECHILDSTRATEGY value) {
    this.noTrueChildStrategy = value;
  }

  /**
   * Gets the value of the splitCharacteristic property.
   *
   * @return possible object is {@link String }
   */
  public String getSplitCharacteristic() {
    if (splitCharacteristic == null) {
      return "multiSplit";
    } else {
      return splitCharacteristic;
    }
  }

  /**
   * Sets the value of the splitCharacteristic property.
   *
   * @param value allowed object is {@link String }
   */
  public void setSplitCharacteristic(String value) {
    this.splitCharacteristic = value;
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
