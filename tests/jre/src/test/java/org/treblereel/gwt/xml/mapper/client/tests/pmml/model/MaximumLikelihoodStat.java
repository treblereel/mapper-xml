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

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}KalmanState"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}ThetaRecursionState"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="method" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="kalman"/&gt;
 *             &lt;enumeration value="thetaRecursion"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="periodDeficit" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" default="0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"state"})
@XmlRootElement(name = "MaximumLikelihoodStat")
@JsType
public class MaximumLikelihoodStat {

  @XmlElementRefs({
    @XmlElementRef(
        name = "KalmanState",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = KalmanState.class,
        required = false),
    @XmlElementRef(
        name = "ThetaRecursionState",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = ThetaRecursionState.class,
        required = false)
  })
  protected IMaximumLikelihoodStat state;

  @XmlAttribute(name = "method", required = true)
  protected String method;

  @XmlAttribute(name = "periodDeficit")
  protected BigInteger periodDeficit;

  /**
   * Gets the value of the state property.
   *
   * @return possible object is {@link KalmanState } {@link ThetaRecursionState }
   */
  public IMaximumLikelihoodStat getState() {
    return state;
  }

  /**
   * Sets the value of the state property.
   *
   * @param value allowed object is {@link KalmanState } {@link ThetaRecursionState }
   */
  public void setState(IMaximumLikelihoodStat value) {
    this.state = value;
  }

  /**
   * Gets the value of the method property.
   *
   * @return possible object is {@link String }
   */
  public String getMethod() {
    return method;
  }

  /**
   * Sets the value of the method property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMethod(String value) {
    this.method = value;
  }

  /**
   * Gets the value of the periodDeficit property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getPeriodDeficit() {
    if (periodDeficit == null) {
      return new BigInteger("0");
    } else {
      return periodDeficit;
    }
  }

  /**
   * Sets the value of the periodDeficit property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setPeriodDeficit(BigInteger value) {
    this.periodDeficit = value;
  }
}
