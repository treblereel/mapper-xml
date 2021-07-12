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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}StateVector" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}TransitionMatrix" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}MeasurementMatrix" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}PsiVector" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}DynamicRegressor" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="variance" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" default="none" /&gt;
 *       &lt;attribute name="intercept" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" default="0" /&gt;
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
      "stateVector",
      "transitionMatrix",
      "measurementMatrix",
      "psiVector",
      "dynamicRegressor"
    })
@XmlRootElement(name = "StateSpaceModel")
@JsType
public class StateSpaceModel {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "StateVector")
  protected StateVector stateVector;

  @XmlElement(name = "TransitionMatrix")
  protected TransitionMatrix transitionMatrix;

  @XmlElement(name = "MeasurementMatrix")
  protected MeasurementMatrix measurementMatrix;

  @XmlElement(name = "PsiVector")
  protected PsiVector psiVector;

  @XmlElement(name = "DynamicRegressor")
  protected List<DynamicRegressor> dynamicRegressor;

  @XmlAttribute(name = "variance")
  protected Double variance;

  @XmlAttribute(name = "period")
  protected String period;

  @XmlAttribute(name = "intercept")
  protected Double intercept;

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
   * Gets the value of the stateVector property.
   *
   * @return possible object is {@link StateVector }
   */
  public StateVector getStateVector() {
    return stateVector;
  }

  /**
   * Sets the value of the stateVector property.
   *
   * @param value allowed object is {@link StateVector }
   */
  public void setStateVector(StateVector value) {
    this.stateVector = value;
  }

  /**
   * Gets the value of the transitionMatrix property.
   *
   * @return possible object is {@link TransitionMatrix }
   */
  public TransitionMatrix getTransitionMatrix() {
    return transitionMatrix;
  }

  /**
   * Sets the value of the transitionMatrix property.
   *
   * @param value allowed object is {@link TransitionMatrix }
   */
  public void setTransitionMatrix(TransitionMatrix value) {
    this.transitionMatrix = value;
  }

  /**
   * Gets the value of the measurementMatrix property.
   *
   * @return possible object is {@link MeasurementMatrix }
   */
  public MeasurementMatrix getMeasurementMatrix() {
    return measurementMatrix;
  }

  /**
   * Sets the value of the measurementMatrix property.
   *
   * @param value allowed object is {@link MeasurementMatrix }
   */
  public void setMeasurementMatrix(MeasurementMatrix value) {
    this.measurementMatrix = value;
  }

  /**
   * Gets the value of the psiVector property.
   *
   * @return possible object is {@link PsiVector }
   */
  public PsiVector getPsiVector() {
    return psiVector;
  }

  /**
   * Sets the value of the psiVector property.
   *
   * @param value allowed object is {@link PsiVector }
   */
  public void setPsiVector(PsiVector value) {
    this.psiVector = value;
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
   * Gets the value of the variance property.
   *
   * @return possible object is {@link Double }
   */
  public Double getVariance() {
    return variance;
  }

  /**
   * Sets the value of the variance property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setVariance(Double value) {
    this.variance = value;
  }

  /**
   * Gets the value of the period property.
   *
   * @return possible object is {@link String }
   */
  public String getPeriod() {
    if (period == null) {
      return "none";
    } else {
      return period;
    }
  }

  /**
   * Sets the value of the period property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPeriod(String value) {
    this.period = value;
  }

  /**
   * Gets the value of the intercept property.
   *
   * @return possible object is {@link Double }
   */
  public double getIntercept() {
    if (intercept == null) {
      return 0.0D;
    } else {
      return intercept;
    }
  }

  /**
   * Sets the value of the intercept property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setIntercept(Double value) {
    this.intercept = value;
  }
}
