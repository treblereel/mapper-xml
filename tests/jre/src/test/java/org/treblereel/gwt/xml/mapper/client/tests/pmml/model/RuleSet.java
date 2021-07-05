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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}RuleSelectionMethod" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ScoreDistribution" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}Rule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="recordCount" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="nbCorrect" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="defaultScore" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="defaultConfidence" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "ruleSelectionMethod", "scoreDistribution", "rule"})
@XmlRootElement(name = "RuleSet")
@JsType
public class RuleSet {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "RuleSelectionMethod", required = true)
  protected List<RuleSelectionMethod> ruleSelectionMethod;

  @XmlElement(name = "ScoreDistribution")
  protected List<ScoreDistribution> scoreDistribution;

  @XmlElementRefs({
    @XmlElementRef(
        name = "SimpleRule",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SimpleRule.class,
        required = false),
    @XmlElementRef(
        name = "CompoundRule",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = CompoundRule.class,
        required = false)
  })
  protected List<IRuleSet> rule;

  @XmlAttribute(name = "recordCount")
  protected Double recordCount;

  @XmlAttribute(name = "nbCorrect")
  protected Double nbCorrect;

  @XmlAttribute(name = "defaultScore")
  protected String defaultScore;

  @XmlAttribute(name = "defaultConfidence")
  protected Double defaultConfidence;

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
   * Gets the value of the ruleSelectionMethod property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the ruleSelectionMethod property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getRuleSelectionMethod().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link RuleSelectionMethod }
   */
  public List<RuleSelectionMethod> getRuleSelectionMethod() {
    if (ruleSelectionMethod == null) {
      ruleSelectionMethod = new ArrayList<RuleSelectionMethod>();
    }
    return this.ruleSelectionMethod;
  }

  /**
   * Gets the value of the scoreDistribution property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the scoreDistribution property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getScoreDistribution().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link ScoreDistribution }
   */
  public List<ScoreDistribution> getScoreDistribution() {
    if (scoreDistribution == null) {
      scoreDistribution = new ArrayList<ScoreDistribution>();
    }
    return this.scoreDistribution;
  }

  /**
   * Gets the value of the rule property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the rule property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getRule().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link SimpleRule } {@link
   * CompoundRule }
   */
  public List<IRuleSet> getRule() {
    if (rule == null) {
      rule = new ArrayList<IRuleSet>();
    }
    return this.rule;
  }

  /**
   * Gets the value of the recordCount property.
   *
   * @return possible object is {@link Double }
   */
  public Double getRecordCount() {
    return recordCount;
  }

  /**
   * Sets the value of the recordCount property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setRecordCount(Double value) {
    this.recordCount = value;
  }

  /**
   * Gets the value of the nbCorrect property.
   *
   * @return possible object is {@link Double }
   */
  public Double getNbCorrect() {
    return nbCorrect;
  }

  /**
   * Sets the value of the nbCorrect property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setNbCorrect(Double value) {
    this.nbCorrect = value;
  }

  /**
   * Gets the value of the defaultScore property.
   *
   * @return possible object is {@link String }
   */
  public String getDefaultScore() {
    return defaultScore;
  }

  /**
   * Sets the value of the defaultScore property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDefaultScore(String value) {
    this.defaultScore = value;
  }

  /**
   * Gets the value of the defaultConfidence property.
   *
   * @return possible object is {@link Double }
   */
  public Double getDefaultConfidence() {
    return defaultConfidence;
  }

  /**
   * Sets the value of the defaultConfidence property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setDefaultConfidence(Double value) {
    this.defaultConfidence = value;
  }
}
