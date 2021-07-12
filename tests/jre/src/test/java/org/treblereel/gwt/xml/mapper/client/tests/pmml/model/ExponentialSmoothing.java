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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Level"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Trend_ExpoSmooth" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Seasonality_ExpoSmooth" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}TimeValue" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="RMSE" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="transformation" default="none"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="none"/&gt;
 *             &lt;enumeration value="logarithmic"/&gt;
 *             &lt;enumeration value="squareroot"/&gt;
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
    propOrder = {"level", "trendExpoSmooth", "seasonalityExpoSmooth", "timeValue"})
@XmlRootElement(name = "ExponentialSmoothing")
@JsType
public class ExponentialSmoothing {

  @XmlElement(name = "Level", required = true)
  protected Level level;

  @XmlElement(name = "Trend_ExpoSmooth")
  protected TrendExpoSmooth trendExpoSmooth;

  @XmlElement(name = "Seasonality_ExpoSmooth")
  protected SeasonalityExpoSmooth seasonalityExpoSmooth;

  @XmlElement(name = "TimeValue")
  protected List<TimeValue> timeValue;

  @XmlAttribute(name = "RMSE")
  protected Double rmse;

  @XmlAttribute(name = "transformation")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String transformation;

  /**
   * Gets the value of the level property.
   *
   * @return possible object is {@link Level }
   */
  public Level getLevel() {
    return level;
  }

  /**
   * Sets the value of the level property.
   *
   * @param value allowed object is {@link Level }
   */
  public void setLevel(Level value) {
    this.level = value;
  }

  /**
   * Gets the value of the trendExpoSmooth property.
   *
   * @return possible object is {@link TrendExpoSmooth }
   */
  public TrendExpoSmooth getTrendExpoSmooth() {
    return trendExpoSmooth;
  }

  /**
   * Sets the value of the trendExpoSmooth property.
   *
   * @param value allowed object is {@link TrendExpoSmooth }
   */
  public void setTrendExpoSmooth(TrendExpoSmooth value) {
    this.trendExpoSmooth = value;
  }

  /**
   * Gets the value of the seasonalityExpoSmooth property.
   *
   * @return possible object is {@link SeasonalityExpoSmooth }
   */
  public SeasonalityExpoSmooth getSeasonalityExpoSmooth() {
    return seasonalityExpoSmooth;
  }

  /**
   * Sets the value of the seasonalityExpoSmooth property.
   *
   * @param value allowed object is {@link SeasonalityExpoSmooth }
   */
  public void setSeasonalityExpoSmooth(SeasonalityExpoSmooth value) {
    this.seasonalityExpoSmooth = value;
  }

  /**
   * Gets the value of the timeValue property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the timeValue property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getTimeValue().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link TimeValue }
   */
  public List<TimeValue> getTimeValue() {
    if (timeValue == null) {
      timeValue = new ArrayList<TimeValue>();
    }
    return this.timeValue;
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
}
