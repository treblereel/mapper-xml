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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}MiningSchema"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Output" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelStats" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelExplanation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Targets" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}LocalTransformations" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}TrainingInstances"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ComparisonMeasure"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}KNNInputs"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelVerification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="modelName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="functionName" use="required" type="{http://www.dmg.org/PMML-4_4}MINING-FUNCTION" /&gt;
 *       &lt;attribute name="algorithmName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="numberOfNeighbors" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="continuousScoringMethod" type="{http://www.dmg.org/PMML-4_4}CONT-SCORING-METHOD" default="average" /&gt;
 *       &lt;attribute name="categoricalScoringMethod" type="{http://www.dmg.org/PMML-4_4}CAT-SCORING-METHOD" default="majorityVote" /&gt;
 *       &lt;attribute name="instanceIdVariable" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="threshold" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0.001" /&gt;
 *       &lt;attribute name="isScorable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface NearestNeighborModel {

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
   * Gets the value of the miningSchema property.
   *
   * @return possible object is {@link MiningSchema }
   */
  MiningSchema getMiningSchema();

  /**
   * Sets the value of the miningSchema property.
   *
   * @param value allowed object is {@link MiningSchema }
   */
  void setMiningSchema(MiningSchema value);

  /**
   * Gets the value of the output property.
   *
   * @return possible object is {@link Output }
   */
  Output getOutput();

  /**
   * Sets the value of the output property.
   *
   * @param value allowed object is {@link Output }
   */
  void setOutput(Output value);

  /**
   * Gets the value of the modelStats property.
   *
   * @return possible object is {@link ModelStats }
   */
  ModelStats getModelStats();

  /**
   * Sets the value of the modelStats property.
   *
   * @param value allowed object is {@link ModelStats }
   */
  void setModelStats(ModelStats value);

  /**
   * Gets the value of the modelExplanation property.
   *
   * @return possible object is {@link ModelExplanation }
   */
  ModelExplanation getModelExplanation();

  /**
   * Sets the value of the modelExplanation property.
   *
   * @param value allowed object is {@link ModelExplanation }
   */
  void setModelExplanation(ModelExplanation value);

  /**
   * Gets the value of the targets property.
   *
   * @return possible object is {@link Targets }
   */
  Targets getTargets();

  /**
   * Sets the value of the targets property.
   *
   * @param value allowed object is {@link Targets }
   */
  void setTargets(Targets value);

  /**
   * Gets the value of the localTransformations property.
   *
   * @return possible object is {@link LocalTransformations }
   */
  LocalTransformations getLocalTransformations();

  /**
   * Sets the value of the localTransformations property.
   *
   * @param value allowed object is {@link LocalTransformations }
   */
  void setLocalTransformations(LocalTransformations value);

  /**
   * Gets the value of the trainingInstances property.
   *
   * @return possible object is {@link TrainingInstances }
   */
  TrainingInstances getTrainingInstances();

  /**
   * Sets the value of the trainingInstances property.
   *
   * @param value allowed object is {@link TrainingInstances }
   */
  void setTrainingInstances(TrainingInstances value);

  /**
   * Gets the value of the comparisonMeasure property.
   *
   * @return possible object is {@link ComparisonMeasure }
   */
  ComparisonMeasure getComparisonMeasure();

  /**
   * Sets the value of the comparisonMeasure property.
   *
   * @param value allowed object is {@link ComparisonMeasure }
   */
  void setComparisonMeasure(ComparisonMeasure value);

  /**
   * Gets the value of the knnInputs property.
   *
   * @return possible object is {@link KNNInputs }
   */
  KNNInputs getKNNInputs();

  /**
   * Sets the value of the knnInputs property.
   *
   * @param value allowed object is {@link KNNInputs }
   */
  void setKNNInputs(KNNInputs value);

  /**
   * Gets the value of the modelVerification property.
   *
   * @return possible object is {@link ModelVerification }
   */
  ModelVerification getModelVerification();

  /**
   * Sets the value of the modelVerification property.
   *
   * @param value allowed object is {@link ModelVerification }
   */
  void setModelVerification(ModelVerification value);

  /**
   * Gets the value of the modelName property.
   *
   * @return possible object is {@link String }
   */
  String getModelName();

  /**
   * Sets the value of the modelName property.
   *
   * @param value allowed object is {@link String }
   */
  void setModelName(String value);

  /**
   * Gets the value of the functionName property.
   *
   * @return possible object is {@link MININGFUNCTION }
   */
  MININGFUNCTION getFunctionName();

  /**
   * Sets the value of the functionName property.
   *
   * @param value allowed object is {@link MININGFUNCTION }
   */
  void setFunctionName(MININGFUNCTION value);

  /**
   * Gets the value of the algorithmName property.
   *
   * @return possible object is {@link String }
   */
  String getAlgorithmName();

  /**
   * Sets the value of the algorithmName property.
   *
   * @param value allowed object is {@link String }
   */
  void setAlgorithmName(String value);

  /**
   * Gets the value of the numberOfNeighbors property.
   *
   * @return possible object is {@link BigInteger }
   */
  BigInteger getNumberOfNeighbors();

  /**
   * Sets the value of the numberOfNeighbors property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  void setNumberOfNeighbors(BigInteger value);

  /**
   * Gets the value of the continuousScoringMethod property.
   *
   * @return possible object is {@link CONTSCORINGMETHOD }
   */
  CONTSCORINGMETHOD getContinuousScoringMethod();

  /**
   * Sets the value of the continuousScoringMethod property.
   *
   * @param value allowed object is {@link CONTSCORINGMETHOD }
   */
  void setContinuousScoringMethod(CONTSCORINGMETHOD value);

  /**
   * Gets the value of the categoricalScoringMethod property.
   *
   * @return possible object is {@link CATSCORINGMETHOD }
   */
  CATSCORINGMETHOD getCategoricalScoringMethod();

  /**
   * Sets the value of the categoricalScoringMethod property.
   *
   * @param value allowed object is {@link CATSCORINGMETHOD }
   */
  void setCategoricalScoringMethod(CATSCORINGMETHOD value);

  /**
   * Gets the value of the instanceIdVariable property.
   *
   * @return possible object is {@link String }
   */
  String getInstanceIdVariable();

  /**
   * Sets the value of the instanceIdVariable property.
   *
   * @param value allowed object is {@link String }
   */
  void setInstanceIdVariable(String value);

  /**
   * Gets the value of the threshold property.
   *
   * @return possible object is {@link Double }
   */
  double getThreshold();

  /**
   * Sets the value of the threshold property.
   *
   * @param value allowed object is {@link Double }
   */
  void setThreshold(Double value);

  /**
   * Gets the value of the isScorable property.
   *
   * @return possible object is {@link Boolean }
   */
  boolean isIsScorable();

  /**
   * Sets the value of the isScorable property.
   *
   * @param value allowed object is {@link Boolean }
   */
  void setIsScorable(Boolean value);
}
