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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ConfusionMatrix" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}LiftData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ROC" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="targetField" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="dataName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dataUsage" default="training"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="training"/&gt;
 *             &lt;enumeration value="test"/&gt;
 *             &lt;enumeration value="validation"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="meanError" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="meanAbsoluteError" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="meanSquaredError" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="rootMeanSquaredError" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="r-squared" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="adj-r-squared" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="sumSquaredError" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="sumSquaredRegression" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="numOfRecords" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="numOfRecordsWeighted" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="numOfPredictors" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="degreesOfFreedom" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="fStatistic" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="AIC" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="BIC" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="AICc" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "confusionMatrix", "liftData", "roc"})
@XmlRootElement(name = "PredictiveModelQuality")
@JsType
public class PredictiveModelQuality implements IModelExplanation {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "ConfusionMatrix")
  protected ConfusionMatrix confusionMatrix;

  @XmlElement(name = "LiftData")
  protected List<LiftData> liftData;

  @XmlElement(name = "ROC")
  protected ROC roc;

  @XmlAttribute(name = "targetField", required = true)
  protected String targetField;

  @XmlAttribute(name = "dataName")
  protected String dataName;

  @XmlAttribute(name = "dataUsage")
  protected String dataUsage;

  @XmlAttribute(name = "meanError")
  protected Double meanError;

  @XmlAttribute(name = "meanAbsoluteError")
  protected Double meanAbsoluteError;

  @XmlAttribute(name = "meanSquaredError")
  protected Double meanSquaredError;

  @XmlAttribute(name = "rootMeanSquaredError")
  protected Double rootMeanSquaredError;

  @XmlAttribute(name = "r-squared")
  protected Double rSquared;

  @XmlAttribute(name = "adj-r-squared")
  protected Double adjRSquared;

  @XmlAttribute(name = "sumSquaredError")
  protected Double sumSquaredError;

  @XmlAttribute(name = "sumSquaredRegression")
  protected Double sumSquaredRegression;

  @XmlAttribute(name = "numOfRecords")
  protected Double numOfRecords;

  @XmlAttribute(name = "numOfRecordsWeighted")
  protected Double numOfRecordsWeighted;

  @XmlAttribute(name = "numOfPredictors")
  protected Double numOfPredictors;

  @XmlAttribute(name = "degreesOfFreedom")
  protected Double degreesOfFreedom;

  @XmlAttribute(name = "fStatistic")
  protected Double fStatistic;

  @XmlAttribute(name = "AIC")
  protected Double aic;

  @XmlAttribute(name = "BIC")
  protected Double bic;

  @XmlAttribute(name = "AICc")
  protected Double aiCc;

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
   * Gets the value of the confusionMatrix property.
   *
   * @return possible object is {@link ConfusionMatrix }
   */
  public ConfusionMatrix getConfusionMatrix() {
    return confusionMatrix;
  }

  /**
   * Sets the value of the confusionMatrix property.
   *
   * @param value allowed object is {@link ConfusionMatrix }
   */
  public void setConfusionMatrix(ConfusionMatrix value) {
    this.confusionMatrix = value;
  }

  /**
   * Gets the value of the liftData property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the liftData property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getLiftData().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link LiftData }
   */
  public List<LiftData> getLiftData() {
    if (liftData == null) {
      liftData = new ArrayList<LiftData>();
    }
    return this.liftData;
  }

  /**
   * Gets the value of the roc property.
   *
   * @return possible object is {@link ROC }
   */
  public ROC getROC() {
    return roc;
  }

  /**
   * Sets the value of the roc property.
   *
   * @param value allowed object is {@link ROC }
   */
  public void setROC(ROC value) {
    this.roc = value;
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
   * Gets the value of the dataName property.
   *
   * @return possible object is {@link String }
   */
  public String getDataName() {
    return dataName;
  }

  /**
   * Sets the value of the dataName property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDataName(String value) {
    this.dataName = value;
  }

  /**
   * Gets the value of the dataUsage property.
   *
   * @return possible object is {@link String }
   */
  public String getDataUsage() {
    if (dataUsage == null) {
      return "training";
    } else {
      return dataUsage;
    }
  }

  /**
   * Sets the value of the dataUsage property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDataUsage(String value) {
    this.dataUsage = value;
  }

  /**
   * Gets the value of the meanError property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMeanError() {
    return meanError;
  }

  /**
   * Sets the value of the meanError property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMeanError(Double value) {
    this.meanError = value;
  }

  /**
   * Gets the value of the meanAbsoluteError property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMeanAbsoluteError() {
    return meanAbsoluteError;
  }

  /**
   * Sets the value of the meanAbsoluteError property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMeanAbsoluteError(Double value) {
    this.meanAbsoluteError = value;
  }

  /**
   * Gets the value of the meanSquaredError property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMeanSquaredError() {
    return meanSquaredError;
  }

  /**
   * Sets the value of the meanSquaredError property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMeanSquaredError(Double value) {
    this.meanSquaredError = value;
  }

  /**
   * Gets the value of the rootMeanSquaredError property.
   *
   * @return possible object is {@link Double }
   */
  public Double getRootMeanSquaredError() {
    return rootMeanSquaredError;
  }

  /**
   * Sets the value of the rootMeanSquaredError property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setRootMeanSquaredError(Double value) {
    this.rootMeanSquaredError = value;
  }

  /**
   * Gets the value of the rSquared property.
   *
   * @return possible object is {@link Double }
   */
  public Double getRSquared() {
    return rSquared;
  }

  /**
   * Sets the value of the rSquared property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setRSquared(Double value) {
    this.rSquared = value;
  }

  /**
   * Gets the value of the adjRSquared property.
   *
   * @return possible object is {@link Double }
   */
  public Double getAdjRSquared() {
    return adjRSquared;
  }

  /**
   * Sets the value of the adjRSquared property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAdjRSquared(Double value) {
    this.adjRSquared = value;
  }

  /**
   * Gets the value of the sumSquaredError property.
   *
   * @return possible object is {@link Double }
   */
  public Double getSumSquaredError() {
    return sumSquaredError;
  }

  /**
   * Sets the value of the sumSquaredError property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setSumSquaredError(Double value) {
    this.sumSquaredError = value;
  }

  /**
   * Gets the value of the sumSquaredRegression property.
   *
   * @return possible object is {@link Double }
   */
  public Double getSumSquaredRegression() {
    return sumSquaredRegression;
  }

  /**
   * Sets the value of the sumSquaredRegression property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setSumSquaredRegression(Double value) {
    this.sumSquaredRegression = value;
  }

  /**
   * Gets the value of the numOfRecords property.
   *
   * @return possible object is {@link Double }
   */
  public Double getNumOfRecords() {
    return numOfRecords;
  }

  /**
   * Sets the value of the numOfRecords property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setNumOfRecords(Double value) {
    this.numOfRecords = value;
  }

  /**
   * Gets the value of the numOfRecordsWeighted property.
   *
   * @return possible object is {@link Double }
   */
  public Double getNumOfRecordsWeighted() {
    return numOfRecordsWeighted;
  }

  /**
   * Sets the value of the numOfRecordsWeighted property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setNumOfRecordsWeighted(Double value) {
    this.numOfRecordsWeighted = value;
  }

  /**
   * Gets the value of the numOfPredictors property.
   *
   * @return possible object is {@link Double }
   */
  public Double getNumOfPredictors() {
    return numOfPredictors;
  }

  /**
   * Sets the value of the numOfPredictors property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setNumOfPredictors(Double value) {
    this.numOfPredictors = value;
  }

  /**
   * Gets the value of the degreesOfFreedom property.
   *
   * @return possible object is {@link Double }
   */
  public Double getDegreesOfFreedom() {
    return degreesOfFreedom;
  }

  /**
   * Sets the value of the degreesOfFreedom property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setDegreesOfFreedom(Double value) {
    this.degreesOfFreedom = value;
  }

  /**
   * Gets the value of the fStatistic property.
   *
   * @return possible object is {@link Double }
   */
  public Double getFStatistic() {
    return fStatistic;
  }

  /**
   * Sets the value of the fStatistic property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setFStatistic(Double value) {
    this.fStatistic = value;
  }

  /**
   * Gets the value of the aic property.
   *
   * @return possible object is {@link Double }
   */
  public Double getAIC() {
    return aic;
  }

  /**
   * Sets the value of the aic property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAIC(Double value) {
    this.aic = value;
  }

  /**
   * Gets the value of the bic property.
   *
   * @return possible object is {@link Double }
   */
  public Double getBIC() {
    return bic;
  }

  /**
   * Sets the value of the bic property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setBIC(Double value) {
    this.bic = value;
  }

  /**
   * Gets the value of the aiCc property.
   *
   * @return possible object is {@link Double }
   */
  public Double getAICc() {
    return aiCc;
  }

  /**
   * Sets the value of the aiCc property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAICc(Double value) {
    this.aiCc = value;
  }
}
