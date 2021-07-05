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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Quantile" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="minimum" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="maximum" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="mean" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="standardDeviation" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="median" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="interQuartileRange" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "quantile"})
@XmlRootElement(name = "NumericInfo")
@JsType
public class NumericInfo {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "Quantile")
  protected List<Quantile> quantile;

  @XmlAttribute(name = "minimum")
  protected Double minimum;

  @XmlAttribute(name = "maximum")
  protected Double maximum;

  @XmlAttribute(name = "mean")
  protected Double mean;

  @XmlAttribute(name = "standardDeviation")
  protected Double standardDeviation;

  @XmlAttribute(name = "median")
  protected Double median;

  @XmlAttribute(name = "interQuartileRange")
  protected Double interQuartileRange;

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
   * Gets the value of the quantile property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the quantile property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getQuantile().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Quantile }
   */
  public List<Quantile> getQuantile() {
    if (quantile == null) {
      quantile = new ArrayList<Quantile>();
    }
    return this.quantile;
  }

  /**
   * Gets the value of the minimum property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMinimum() {
    return minimum;
  }

  /**
   * Sets the value of the minimum property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMinimum(Double value) {
    this.minimum = value;
  }

  /**
   * Gets the value of the maximum property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMaximum() {
    return maximum;
  }

  /**
   * Sets the value of the maximum property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMaximum(Double value) {
    this.maximum = value;
  }

  /**
   * Gets the value of the mean property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMean() {
    return mean;
  }

  /**
   * Sets the value of the mean property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMean(Double value) {
    this.mean = value;
  }

  /**
   * Gets the value of the standardDeviation property.
   *
   * @return possible object is {@link Double }
   */
  public Double getStandardDeviation() {
    return standardDeviation;
  }

  /**
   * Sets the value of the standardDeviation property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setStandardDeviation(Double value) {
    this.standardDeviation = value;
  }

  /**
   * Gets the value of the median property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMedian() {
    return median;
  }

  /**
   * Sets the value of the median property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMedian(Double value) {
    this.median = value;
  }

  /**
   * Gets the value of the interQuartileRange property.
   *
   * @return possible object is {@link Double }
   */
  public Double getInterQuartileRange() {
    return interQuartileRange;
  }

  /**
   * Sets the value of the interQuartileRange property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setInterQuartileRange(Double value) {
    this.interQuartileRange = value;
  }
}
