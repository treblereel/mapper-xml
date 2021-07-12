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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}NonseasonalComponent" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}SeasonalComponent" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}DynamicRegressor" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}MaximumLikelihoodStat" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}OutlierEffect" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="RMSE" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="transformation" default="none"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="none"/&gt;
 *             &lt;enumeration value="logarithmic"/&gt;
 *             &lt;enumeration value="squareroot"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="constantTerm" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
 *       &lt;attribute name="predictionMethod" default="conditionalLeastSquares"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="conditionalLeastSquares"/&gt;
 *             &lt;enumeration value="exactLeastSquares"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
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
      "nonseasonalComponent",
      "seasonalComponent",
      "dynamicRegressor",
      "maximumLikelihoodStat",
      "outlierEffect"
    })
@XmlRootElement(name = "ARIMA")
@JsType
public class ARIMA {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "NonseasonalComponent")
  protected NonseasonalComponent nonseasonalComponent;

  @XmlElement(name = "SeasonalComponent")
  protected SeasonalComponent seasonalComponent;

  @XmlElement(name = "DynamicRegressor")
  protected List<DynamicRegressor> dynamicRegressor;

  @XmlElement(name = "MaximumLikelihoodStat")
  protected MaximumLikelihoodStat maximumLikelihoodStat;

  @XmlElement(name = "OutlierEffect")
  protected List<OutlierEffect> outlierEffect;

  @XmlAttribute(name = "RMSE")
  protected Double rmse;

  @XmlAttribute(name = "transformation")
  protected String transformation;

  @XmlAttribute(name = "constantTerm")
  protected Double constantTerm;

  @XmlAttribute(name = "predictionMethod")
  protected String predictionMethod;

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
   * Gets the value of the nonseasonalComponent property.
   *
   * @return possible object is {@link NonseasonalComponent }
   */
  public NonseasonalComponent getNonseasonalComponent() {
    return nonseasonalComponent;
  }

  /**
   * Sets the value of the nonseasonalComponent property.
   *
   * @param value allowed object is {@link NonseasonalComponent }
   */
  public void setNonseasonalComponent(NonseasonalComponent value) {
    this.nonseasonalComponent = value;
  }

  /**
   * Gets the value of the seasonalComponent property.
   *
   * @return possible object is {@link SeasonalComponent }
   */
  public SeasonalComponent getSeasonalComponent() {
    return seasonalComponent;
  }

  /**
   * Sets the value of the seasonalComponent property.
   *
   * @param value allowed object is {@link SeasonalComponent }
   */
  public void setSeasonalComponent(SeasonalComponent value) {
    this.seasonalComponent = value;
  }

  /**
   * Gets the value of the dynamicRegressor property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the dynamicRegressor property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getDynamicRegressor().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link DynamicRegressor }
   */
  public List<DynamicRegressor> getDynamicRegressor() {
    if (dynamicRegressor == null) {
      dynamicRegressor = new ArrayList<DynamicRegressor>();
    }
    return this.dynamicRegressor;
  }

  /**
   * Gets the value of the maximumLikelihoodStat property.
   *
   * @return possible object is {@link MaximumLikelihoodStat }
   */
  public MaximumLikelihoodStat getMaximumLikelihoodStat() {
    return maximumLikelihoodStat;
  }

  /**
   * Sets the value of the maximumLikelihoodStat property.
   *
   * @param value allowed object is {@link MaximumLikelihoodStat }
   */
  public void setMaximumLikelihoodStat(MaximumLikelihoodStat value) {
    this.maximumLikelihoodStat = value;
  }

  /**
   * Gets the value of the outlierEffect property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the outlierEffect property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getOutlierEffect().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link OutlierEffect }
   */
  public List<OutlierEffect> getOutlierEffect() {
    if (outlierEffect == null) {
      outlierEffect = new ArrayList<OutlierEffect>();
    }
    return this.outlierEffect;
  }

  /**
   * Gets the value of the rmse property.
   *
   * @return possible object is {@link Double }
   */
  public Double getRMSE() {
    return rmse;
  }

  /**
   * Sets the value of the rmse property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setRMSE(Double value) {
    this.rmse = value;
  }

  /**
   * Gets the value of the transformation property.
   *
   * @return possible object is {@link String }
   */
  public String getTransformation() {
    if (transformation == null) {
      return "none";
    } else {
      return transformation;
    }
  }

  /**
   * Sets the value of the transformation property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTransformation(String value) {
    this.transformation = value;
  }

  /**
   * Gets the value of the constantTerm property.
   *
   * @return possible object is {@link Double }
   */
  public double getConstantTerm() {
    if (constantTerm == null) {
      return 0.0D;
    } else {
      return constantTerm;
    }
  }

  /**
   * Sets the value of the constantTerm property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setConstantTerm(Double value) {
    this.constantTerm = value;
  }

  /**
   * Gets the value of the predictionMethod property.
   *
   * @return possible object is {@link String }
   */
  public String getPredictionMethod() {
    if (predictionMethod == null) {
      return "conditionalLeastSquares";
    } else {
      return predictionMethod;
    }
  }

  /**
   * Sets the value of the predictionMethod property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPredictionMethod(String value) {
    this.predictionMethod = value;
  }
}
