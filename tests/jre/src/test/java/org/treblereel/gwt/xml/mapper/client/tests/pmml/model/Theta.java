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
 *       &lt;attribute name="i" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="j" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="theta" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Theta")
@JsType
public class Theta {

  @XmlAttribute(name = "i")
  protected BigInteger i;

  @XmlAttribute(name = "j")
  protected BigInteger j;

  @XmlAttribute(name = "theta")
  protected Double theta;

  /**
   * Gets the value of the i property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getI() {
    return i;
  }

  /**
   * Sets the value of the i property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setI(BigInteger value) {
    this.i = value;
  }

  /**
   * Gets the value of the j property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getJ() {
    return j;
  }

  /**
   * Sets the value of the j property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setJ(BigInteger value) {
    this.j = value;
  }

  /**
   * Gets the value of the theta property.
   *
   * @return possible object is {@link Double }
   */
  public Double getTheta() {
    return theta;
  }

  /**
   * Sets the value of the theta property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setTheta(Double value) {
    this.theta = value;
  }
}
