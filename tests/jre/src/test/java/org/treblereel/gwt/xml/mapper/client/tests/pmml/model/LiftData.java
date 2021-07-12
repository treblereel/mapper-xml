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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ModelLiftGraph"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}OptimumLiftGraph" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}RandomLiftGraph" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="targetFieldValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="targetFieldDisplayValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="rankingQuality" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "modelLiftGraph", "optimumLiftGraph", "randomLiftGraph"})
@XmlRootElement(name = "LiftData")
@JsType
public class LiftData {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "ModelLiftGraph", required = true)
  protected ModelLiftGraph modelLiftGraph;

  @XmlElement(name = "OptimumLiftGraph")
  protected OptimumLiftGraph optimumLiftGraph;

  @XmlElement(name = "RandomLiftGraph")
  protected RandomLiftGraph randomLiftGraph;

  @XmlAttribute(name = "targetFieldValue")
  protected String targetFieldValue;

  @XmlAttribute(name = "targetFieldDisplayValue")
  protected String targetFieldDisplayValue;

  @XmlAttribute(name = "rankingQuality")
  protected Double rankingQuality;

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
   * Gets the value of the modelLiftGraph property.
   *
   * @return possible object is {@link ModelLiftGraph }
   */
  public ModelLiftGraph getModelLiftGraph() {
    return modelLiftGraph;
  }

  /**
   * Sets the value of the modelLiftGraph property.
   *
   * @param value allowed object is {@link ModelLiftGraph }
   */
  public void setModelLiftGraph(ModelLiftGraph value) {
    this.modelLiftGraph = value;
  }

  /**
   * Gets the value of the optimumLiftGraph property.
   *
   * @return possible object is {@link OptimumLiftGraph }
   */
  public OptimumLiftGraph getOptimumLiftGraph() {
    return optimumLiftGraph;
  }

  /**
   * Sets the value of the optimumLiftGraph property.
   *
   * @param value allowed object is {@link OptimumLiftGraph }
   */
  public void setOptimumLiftGraph(OptimumLiftGraph value) {
    this.optimumLiftGraph = value;
  }

  /**
   * Gets the value of the randomLiftGraph property.
   *
   * @return possible object is {@link RandomLiftGraph }
   */
  public RandomLiftGraph getRandomLiftGraph() {
    return randomLiftGraph;
  }

  /**
   * Sets the value of the randomLiftGraph property.
   *
   * @param value allowed object is {@link RandomLiftGraph }
   */
  public void setRandomLiftGraph(RandomLiftGraph value) {
    this.randomLiftGraph = value;
  }

  /**
   * Gets the value of the targetFieldValue property.
   *
   * @return possible object is {@link String }
   */
  public String getTargetFieldValue() {
    return targetFieldValue;
  }

  /**
   * Sets the value of the targetFieldValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTargetFieldValue(String value) {
    this.targetFieldValue = value;
  }

  /**
   * Gets the value of the targetFieldDisplayValue property.
   *
   * @return possible object is {@link String }
   */
  public String getTargetFieldDisplayValue() {
    return targetFieldDisplayValue;
  }

  /**
   * Sets the value of the targetFieldDisplayValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTargetFieldDisplayValue(String value) {
    this.targetFieldDisplayValue = value;
  }

  /**
   * Gets the value of the rankingQuality property.
   *
   * @return possible object is {@link Double }
   */
  public Double getRankingQuality() {
    return rankingQuality;
  }

  /**
   * Sets the value of the rankingQuality property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setRankingQuality(Double value) {
    this.rankingQuality = value;
  }
}
