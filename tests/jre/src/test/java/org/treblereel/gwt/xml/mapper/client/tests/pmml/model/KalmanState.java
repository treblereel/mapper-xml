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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}FinalOmega"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}FinalStateVector"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}HVector" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"finalOmega", "finalStateVector", "hVector"})
@XmlRootElement(name = "KalmanState")
@JsType
public class KalmanState implements IMaximumLikelihoodStat {

  @XmlElement(name = "FinalOmega", required = true)
  protected FinalOmega finalOmega;

  @XmlElement(name = "FinalStateVector", required = true)
  protected FinalStateVector finalStateVector;

  @XmlElement(name = "HVector")
  protected HVector hVector;

  /**
   * Gets the value of the finalOmega property.
   *
   * @return possible object is {@link FinalOmega }
   */
  public FinalOmega getFinalOmega() {
    return finalOmega;
  }

  /**
   * Sets the value of the finalOmega property.
   *
   * @param value allowed object is {@link FinalOmega }
   */
  public void setFinalOmega(FinalOmega value) {
    this.finalOmega = value;
  }

  /**
   * Gets the value of the finalStateVector property.
   *
   * @return possible object is {@link FinalStateVector }
   */
  public FinalStateVector getFinalStateVector() {
    return finalStateVector;
  }

  /**
   * Sets the value of the finalStateVector property.
   *
   * @param value allowed object is {@link FinalStateVector }
   */
  public void setFinalStateVector(FinalStateVector value) {
    this.finalStateVector = value;
  }

  /**
   * Gets the value of the hVector property.
   *
   * @return possible object is {@link HVector }
   */
  public HVector getHVector() {
    return hVector;
  }

  /**
   * Sets the value of the hVector property.
   *
   * @param value allowed object is {@link HVector }
   */
  public void setHVector(HVector value) {
    this.hVector = value;
  }
}
