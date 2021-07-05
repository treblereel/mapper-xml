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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}FinalNoise"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}FinalPredictedNoise"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}FinalTheta"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}FinalNu"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"finalNoise", "finalPredictedNoise", "finalTheta", "finalNu"})
@XmlRootElement(name = "ThetaRecursionState")
@JsType
public class ThetaRecursionState implements IMaximumLikelihoodStat {

  @XmlElement(name = "FinalNoise", required = true)
  protected FinalNoise finalNoise;

  @XmlElement(name = "FinalPredictedNoise", required = true)
  protected FinalPredictedNoise finalPredictedNoise;

  @XmlElement(name = "FinalTheta", required = true)
  protected FinalTheta finalTheta;

  @XmlElement(name = "FinalNu", required = true)
  protected FinalNu finalNu;

  /**
   * Gets the value of the finalNoise property.
   *
   * @return possible object is {@link FinalNoise }
   */
  public FinalNoise getFinalNoise() {
    return finalNoise;
  }

  /**
   * Sets the value of the finalNoise property.
   *
   * @param value allowed object is {@link FinalNoise }
   */
  public void setFinalNoise(FinalNoise value) {
    this.finalNoise = value;
  }

  /**
   * Gets the value of the finalPredictedNoise property.
   *
   * @return possible object is {@link FinalPredictedNoise }
   */
  public FinalPredictedNoise getFinalPredictedNoise() {
    return finalPredictedNoise;
  }

  /**
   * Sets the value of the finalPredictedNoise property.
   *
   * @param value allowed object is {@link FinalPredictedNoise }
   */
  public void setFinalPredictedNoise(FinalPredictedNoise value) {
    this.finalPredictedNoise = value;
  }

  /**
   * Gets the value of the finalTheta property.
   *
   * @return possible object is {@link FinalTheta }
   */
  public FinalTheta getFinalTheta() {
    return finalTheta;
  }

  /**
   * Sets the value of the finalTheta property.
   *
   * @param value allowed object is {@link FinalTheta }
   */
  public void setFinalTheta(FinalTheta value) {
    this.finalTheta = value;
  }

  /**
   * Gets the value of the finalNu property.
   *
   * @return possible object is {@link FinalNu }
   */
  public FinalNu getFinalNu() {
    return finalNu;
  }

  /**
   * Sets the value of the finalNu property.
   *
   * @param value allowed object is {@link FinalNu }
   */
  public void setFinalNu(FinalNu value) {
    this.finalNu = value;
  }
}
