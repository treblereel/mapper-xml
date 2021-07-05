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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}TimeCycle" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}TimeException" maxOccurs="2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" type="{http://www.dmg.org/PMML-4_4}TIME-ANCHOR" /&gt;
 *       &lt;attribute name="offset" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="stepsize" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"timeCycle", "timeException"})
@XmlRootElement(name = "TimeAnchor")
@JsType
public class TimeAnchor {

  @XmlElement(name = "TimeCycle")
  protected List<TimeCycle> timeCycle;

  @XmlElement(name = "TimeException")
  protected List<TimeException> timeException;

  @XmlAttribute(name = "type")
  protected TIMEANCHOR type;

  @XmlAttribute(name = "offset")
  protected BigInteger offset;

  @XmlAttribute(name = "stepsize")
  protected BigInteger stepsize;

  @XmlAttribute(name = "displayName")
  protected String displayName;

  /**
   * Gets the value of the timeCycle property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the timeCycle property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getTimeCycle().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link TimeCycle }
   */
  public List<TimeCycle> getTimeCycle() {
    if (timeCycle == null) {
      timeCycle = new ArrayList<TimeCycle>();
    }
    return this.timeCycle;
  }

  /**
   * Gets the value of the timeException property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the timeException property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getTimeException().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link TimeException }
   */
  public List<TimeException> getTimeException() {
    if (timeException == null) {
      timeException = new ArrayList<TimeException>();
    }
    return this.timeException;
  }

  /**
   * Gets the value of the type property.
   *
   * @return possible object is {@link TIMEANCHOR }
   */
  public TIMEANCHOR getType() {
    return type;
  }

  /**
   * Sets the value of the type property.
   *
   * @param value allowed object is {@link TIMEANCHOR }
   */
  public void setType(TIMEANCHOR value) {
    this.type = value;
  }

  /**
   * Gets the value of the offset property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getOffset() {
    return offset;
  }

  /**
   * Sets the value of the offset property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setOffset(BigInteger value) {
    this.offset = value;
  }

  /**
   * Gets the value of the stepsize property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getStepsize() {
    return stepsize;
  }

  /**
   * Sets the value of the stepsize property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setStepsize(BigInteger value) {
    this.stepsize = value;
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
