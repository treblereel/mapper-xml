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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}DerivedField" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded"&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}DiscreteConditionalProbability"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}ValueProbability" maxOccurs="unbounded"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="count" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "derivedField", "discreteConditionalProbabilityOrValueProbability"})
@XmlRootElement(name = "DiscreteNode")
@JsType
public class DiscreteNode implements IBayesianNetworkNodes {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "DerivedField")
  protected List<DerivedField> derivedField;

  @XmlElementRefs({
    @XmlElementRef(
        name = "DiscreteConditionalProbability",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = DiscreteConditionalProbability.class,
        required = false),
    @XmlElementRef(
        name = "ValueProbability",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = ValueProbability.class,
        required = false)
  })
  protected List<IDiscreteNode> discreteConditionalProbabilityOrValueProbability;

  @XmlAttribute(name = "name", required = true)
  protected String name;

  @XmlAttribute(name = "count")
  protected Double count;

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
   * Gets the value of the derivedField property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the derivedField property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getDerivedField().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link DerivedField }
   */
  public List<DerivedField> getDerivedField() {
    if (derivedField == null) {
      derivedField = new ArrayList<DerivedField>();
    }
    return this.derivedField;
  }

  /**
   * Gets the value of the discreteConditionalProbabilityOrValueProbability property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the discreteConditionalProbabilityOrValueProbability
   * property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getDiscreteConditionalProbabilityOrValueProbability().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link
   * DiscreteConditionalProbability } {@link ValueProbability }
   */
  public List<IDiscreteNode> getDiscreteConditionalProbabilityOrValueProbability() {
    if (discreteConditionalProbabilityOrValueProbability == null) {
      discreteConditionalProbabilityOrValueProbability = new ArrayList<IDiscreteNode>();
    }
    return this.discreteConditionalProbabilityOrValueProbability;
  }

  /**
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets the value of the count property.
   *
   * @return possible object is {@link Double }
   */
  public Double getCount() {
    return count;
  }

  /**
   * Sets the value of the count property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setCount(Double value) {
    this.count = value;
  }
}
