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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelExplanation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Targets" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}LocalTransformations" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}NeuralInputs"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}NeuralLayer" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}NeuralOutputs" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelVerification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-4_4}MINING-FUNCTION" /&gt;
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="activationFunction" use="required" type="{http://www.dmg.org/PMML-4_4}ACTIVATION-FUNCTION" /&gt;
 *       &lt;attribute name="normalizationMethod" type="{http://www.dmg.org/PMML-4_4}NN-NORMALIZATION-METHOD" default="none" /&gt;
 *       &lt;attribute name="threshold" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="width" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="altitude" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="1.0" /&gt;
 *       &lt;attribute name="numberOfLayers" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
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
      "neuralInputs",
      "neuralLayer",
      "neuralOutputs",
      "modelVerification"
    })
@XmlRootElement(name = "NeuralNetwork")
@JsType
public class NeuralNetwork implements IPMML {

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

  @XmlElement(name = "NeuralInputs", required = true)
  protected NeuralInputs neuralInputs;

  @XmlElement(name = "NeuralLayer", required = true)
  protected List<NeuralLayer> neuralLayer;

  @XmlElement(name = "NeuralOutputs")
  protected NeuralOutputs neuralOutputs;

  @XmlElement(name = "ModelVerification")
  protected ModelVerification modelVerification;

  @XmlAttribute(name = "modelName")
  protected String modelName;

  @XmlAttribute(name = "functionName", required = true)
  protected MININGFUNCTION functionName;

  @XmlAttribute(name = "algorithmName")
  protected String algorithmName;

  @XmlAttribute(name = "activationFunction", required = true)
  protected ACTIVATIONFUNCTION activationFunction;

  @XmlAttribute(name = "normalizationMethod")
  protected NNNORMALIZATIONMETHOD normalizationMethod;

  @XmlAttribute(name = "threshold")
  protected Double threshold;

  @XmlAttribute(name = "width")
  protected Double width;

  @XmlAttribute(name = "altitude")
  protected Double altitude;

  @XmlAttribute(name = "numberOfLayers")
  protected BigInteger numberOfLayers;

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
   * Gets the value of the neuralInputs property.
   *
   * @return possible object is {@link NeuralInputs }
   */
  public NeuralInputs getNeuralInputs() {
    return neuralInputs;
  }

  /**
   * Sets the value of the neuralInputs property.
   *
   * @param value allowed object is {@link NeuralInputs }
   */
  public void setNeuralInputs(NeuralInputs value) {
    this.neuralInputs = value;
  }

  /**
   * Gets the value of the neuralLayer property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the neuralLayer property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getNeuralLayer().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link NeuralLayer }
   */
  public List<NeuralLayer> getNeuralLayer() {
    if (neuralLayer == null) {
      neuralLayer = new ArrayList<NeuralLayer>();
    }
    return this.neuralLayer;
  }

  /**
   * Gets the value of the neuralOutputs property.
   *
   * @return possible object is {@link NeuralOutputs }
   */
  public NeuralOutputs getNeuralOutputs() {
    return neuralOutputs;
  }

  /**
   * Sets the value of the neuralOutputs property.
   *
   * @param value allowed object is {@link NeuralOutputs }
   */
  public void setNeuralOutputs(NeuralOutputs value) {
    this.neuralOutputs = value;
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
   * Gets the value of the activationFunction property.
   *
   * @return possible object is {@link ACTIVATIONFUNCTION }
   */
  public ACTIVATIONFUNCTION getActivationFunction() {
    return activationFunction;
  }

  /**
   * Sets the value of the activationFunction property.
   *
   * @param value allowed object is {@link ACTIVATIONFUNCTION }
   */
  public void setActivationFunction(ACTIVATIONFUNCTION value) {
    this.activationFunction = value;
  }

  /**
   * Gets the value of the normalizationMethod property.
   *
   * @return possible object is {@link NNNORMALIZATIONMETHOD }
   */
  public NNNORMALIZATIONMETHOD getNormalizationMethod() {
    if (normalizationMethod == null) {
      return NNNORMALIZATIONMETHOD.NONE;
    } else {
      return normalizationMethod;
    }
  }

  /**
   * Sets the value of the normalizationMethod property.
   *
   * @param value allowed object is {@link NNNORMALIZATIONMETHOD }
   */
  public void setNormalizationMethod(NNNORMALIZATIONMETHOD value) {
    this.normalizationMethod = value;
  }

  /**
   * Gets the value of the threshold property.
   *
   * @return possible object is {@link Double }
   */
  public double getThreshold() {
    if (threshold == null) {
      return 0.0D;
    } else {
      return threshold;
    }
  }

  /**
   * Sets the value of the threshold property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setThreshold(Double value) {
    this.threshold = value;
  }

  /**
   * Gets the value of the width property.
   *
   * @return possible object is {@link Double }
   */
  public Double getWidth() {
    return width;
  }

  /**
   * Sets the value of the width property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setWidth(Double value) {
    this.width = value;
  }

  /**
   * Gets the value of the altitude property.
   *
   * @return possible object is {@link Double }
   */
  public double getAltitude() {
    if (altitude == null) {
      return 1.0D;
    } else {
      return altitude;
    }
  }

  /**
   * Sets the value of the altitude property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAltitude(Double value) {
    this.altitude = value;
  }

  /**
   * Gets the value of the numberOfLayers property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNumberOfLayers() {
    return numberOfLayers;
  }

  /**
   * Sets the value of the numberOfLayers property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNumberOfLayers(BigInteger value) {
    this.numberOfLayers = value;
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
