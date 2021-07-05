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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}MiningSchema"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Output" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelStats" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelExplanation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Targets" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}LocalTransformations" minOccurs="0"/&gt;
 *         &lt;sequence&gt;
 *           &lt;choice&gt;
 *             &lt;element ref="{http://www.dmg.org/PMML-4_4}LinearKernelType"/&gt;
 *             &lt;element ref="{http://www.dmg.org/PMML-4_4}PolynomialKernelType"/&gt;
 *             &lt;element ref="{http://www.dmg.org/PMML-4_4}RadialBasisKernelType"/&gt;
 *             &lt;element ref="{http://www.dmg.org/PMML-4_4}SigmoidKernelType"/&gt;
 *           &lt;/choice&gt;
 *         &lt;/sequence&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}VectorDictionary"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}SupportVectorMachine" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelVerification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-4_4}MINING-FUNCTION" /&gt;
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="threshold" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="svmRepresentation" type="{http://www.dmg.org/PMML-4_4}SVM-REPRESENTATION" default="SupportVectors" /&gt;
 *       &lt;attribute name="classificationMethod" type="{http://www.dmg.org/PMML-4_4}SVM-CLASSIFICATION-METHOD" default="OneAgainstAll" /&gt;
 *       &lt;attribute name="maxWins" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
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
      "supportVectorMachineModel",
      "vectorDictionary",
      "supportVectorMachine",
      "modelVerification"
    })
@XmlRootElement(name = "SupportVectorMachineModel")
@JsType
public class SupportVectorMachineModel implements IPMML {

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

  @XmlElementRefs({
    @XmlElementRef(
        name = "LinearKernelType",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = LinearKernelType.class,
        required = false),
    @XmlElementRef(
        name = "PolynomialKernelType",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = PolynomialKernelType.class,
        required = false),
    @XmlElementRef(
        name = "RadialBasisKernelType",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = RadialBasisKernelType.class,
        required = false),
    @XmlElementRef(
        name = "SigmoidKernelType",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SigmoidKernelType.class,
        required = false)
  })
  protected ISupportVectorMachineModel supportVectorMachineModel;

  @XmlElement(name = "VectorDictionary", required = true)
  protected VectorDictionary vectorDictionary;

  @XmlElement(name = "SupportVectorMachine", required = true)
  protected List<SupportVectorMachine> supportVectorMachine;

  @XmlElement(name = "ModelVerification")
  protected ModelVerification modelVerification;

  @XmlAttribute(name = "modelName")
  protected String modelName;

  @XmlAttribute(name = "functionName", required = true)
  protected MININGFUNCTION functionName;

  @XmlAttribute(name = "algorithmName")
  protected String algorithmName;

  @XmlAttribute(name = "threshold")
  protected Double threshold;

  @XmlAttribute(name = "svmRepresentation")
  protected SVMREPRESENTATION svmRepresentation;

  @XmlAttribute(name = "classificationMethod")
  protected SVMCLASSIFICATIONMETHOD classificationMethod;

  @XmlAttribute(name = "maxWins")
  protected Boolean maxWins;

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
   * Gets the value of the supportVectorMachineModel property.
   *
   * @return possible object is {@link LinearKernelType } {@link PolynomialKernelType } {@link
   *     RadialBasisKernelType } {@link SigmoidKernelType }
   */
  public ISupportVectorMachineModel getSupportVectorMachineModel() {
    return supportVectorMachineModel;
  }

  /**
   * Sets the value of the supportVectorMachineModel property.
   *
   * @param value allowed object is {@link LinearKernelType } {@link PolynomialKernelType } {@link
   *     RadialBasisKernelType } {@link SigmoidKernelType }
   */
  public void setSupportVectorMachineModel(ISupportVectorMachineModel value) {
    this.supportVectorMachineModel = value;
  }

  /**
   * Gets the value of the vectorDictionary property.
   *
   * @return possible object is {@link VectorDictionary }
   */
  public VectorDictionary getVectorDictionary() {
    return vectorDictionary;
  }

  /**
   * Sets the value of the vectorDictionary property.
   *
   * @param value allowed object is {@link VectorDictionary }
   */
  public void setVectorDictionary(VectorDictionary value) {
    this.vectorDictionary = value;
  }

  /**
   * Gets the value of the supportVectorMachine property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the supportVectorMachine property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getSupportVectorMachine().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link SupportVectorMachine }
   */
  public List<SupportVectorMachine> getSupportVectorMachine() {
    if (supportVectorMachine == null) {
      supportVectorMachine = new ArrayList<SupportVectorMachine>();
    }
    return this.supportVectorMachine;
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
   * Gets the value of the svmRepresentation property.
   *
   * @return possible object is {@link SVMREPRESENTATION }
   */
  public SVMREPRESENTATION getSvmRepresentation() {
    if (svmRepresentation == null) {
      return SVMREPRESENTATION.SUPPORT_VECTORS;
    } else {
      return svmRepresentation;
    }
  }

  /**
   * Sets the value of the svmRepresentation property.
   *
   * @param value allowed object is {@link SVMREPRESENTATION }
   */
  public void setSvmRepresentation(SVMREPRESENTATION value) {
    this.svmRepresentation = value;
  }

  /**
   * Gets the value of the classificationMethod property.
   *
   * @return possible object is {@link SVMCLASSIFICATIONMETHOD }
   */
  public SVMCLASSIFICATIONMETHOD getClassificationMethod() {
    if (classificationMethod == null) {
      return SVMCLASSIFICATIONMETHOD.ONE_AGAINST_ALL;
    } else {
      return classificationMethod;
    }
  }

  /**
   * Sets the value of the classificationMethod property.
   *
   * @param value allowed object is {@link SVMCLASSIFICATIONMETHOD }
   */
  public void setClassificationMethod(SVMCLASSIFICATIONMETHOD value) {
    this.classificationMethod = value;
  }

  /**
   * Gets the value of the maxWins property.
   *
   * @return possible object is {@link Boolean }
   */
  public boolean isMaxWins() {
    if (maxWins == null) {
      return false;
    } else {
      return maxWins;
    }
  }

  /**
   * Sets the value of the maxWins property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setMaxWins(Boolean value) {
    this.maxWins = value;
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
