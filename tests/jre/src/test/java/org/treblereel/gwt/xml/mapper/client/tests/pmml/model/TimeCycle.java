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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}INT-ARRAY" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="length" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="type" type="{http://www.dmg.org/PMML-4_4}VALID-TIME-SPEC" /&gt;
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"intarray"})
@XmlRootElement(name = "TimeCycle")
@JsType
public class TimeCycle {

  @XmlElement(name = "INT-ARRAY")
  protected INTARRAY intarray;

  @XmlAttribute(name = "length")
  protected BigInteger length;

  @XmlAttribute(name = "type")
  protected VALIDTIMESPEC type;

  @XmlAttribute(name = "displayName")
  protected String displayName;

  /**
   * Gets the value of the intarray property.
   *
   * @return possible object is {@link INTARRAY }
   */
  public INTARRAY getINTARRAY() {
    return intarray;
  }

  /**
   * Sets the value of the intarray property.
   *
   * @param value allowed object is {@link INTARRAY }
   */
  public void setINTARRAY(INTARRAY value) {
    this.intarray = value;
  }

  /**
   * Gets the value of the length property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getLength() {
    return length;
  }

  /**
   * Sets the value of the length property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setLength(BigInteger value) {
    this.length = value;
  }

  /**
   * Gets the value of the type property.
   *
   * @return possible object is {@link VALIDTIMESPEC }
   */
  public VALIDTIMESPEC getType() {
    return type;
  }

  /**
   * Sets the value of the type property.
   *
   * @param value allowed object is {@link VALIDTIMESPEC }
   */
  public void setType(VALIDTIMESPEC value) {
    this.type = value;
  }

  /**
   * Gets the value of the displayName property.
   *
   * @return possible object is {@link String }
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Sets the value of the displayName property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDisplayName(String value) {
    this.displayName = value;
  }
}
