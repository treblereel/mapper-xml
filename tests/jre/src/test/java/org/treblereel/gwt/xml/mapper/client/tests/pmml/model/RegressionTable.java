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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}NumericPredictor" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}CategoricalPredictor" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}PredictorTerm" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="intercept" use="required" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="targetCategory" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "numericPredictor", "categoricalPredictor", "predictorTerm"})
@XmlRootElement(name = "RegressionTable")
@JsType
public class RegressionTable {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "NumericPredictor")
  protected List<NumericPredictor> numericPredictor;

  @XmlElement(name = "CategoricalPredictor")
  protected List<CategoricalPredictor> categoricalPredictor;

  @XmlElement(name = "PredictorTerm")
  protected List<PredictorTerm> predictorTerm;

  @XmlAttribute(name = "intercept", required = true)
  protected double intercept;

  @XmlAttribute(name = "targetCategory")
  protected String targetCategory;

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
   * Gets the value of the numericPredictor property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the numericPredictor property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getNumericPredictor().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link NumericPredictor }
   */
  public List<NumericPredictor> getNumericPredictor() {
    if (numericPredictor == null) {
      numericPredictor = new ArrayList<NumericPredictor>();
    }
    return this.numericPredictor;
  }

  /**
   * Gets the value of the categoricalPredictor property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the categoricalPredictor property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getCategoricalPredictor().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link CategoricalPredictor }
   */
  public List<CategoricalPredictor> getCategoricalPredictor() {
    if (categoricalPredictor == null) {
      categoricalPredictor = new ArrayList<CategoricalPredictor>();
    }
    return this.categoricalPredictor;
  }

  /**
   * Gets the value of the predictorTerm property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the predictorTerm property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getPredictorTerm().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link PredictorTerm }
   */
  public List<PredictorTerm> getPredictorTerm() {
    if (predictorTerm == null) {
      predictorTerm = new ArrayList<PredictorTerm>();
    }
    return this.predictorTerm;
  }

  /** Gets the value of the intercept property. */
  public double getIntercept() {
    return intercept;
  }

  /** Sets the value of the intercept property. */
  public void setIntercept(double value) {
    this.intercept = value;
  }

  /**
   * Gets the value of the targetCategory property.
   *
   * @return possible object is {@link String }
   */
  public String getTargetCategory() {
    return targetCategory;
  }

  /**
   * Sets the value of the targetCategory property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTargetCategory(String value) {
    this.targetCategory = value;
  }
}
