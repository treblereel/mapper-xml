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
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}PREDICATE"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}ComplexPartialScore" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="reasonCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="partialScore" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "predicate", "complexPartialScore"})
@XmlRootElement(name = "Attribute")
@JsType
public class Attribute {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElementRefs({
    @XmlElementRef(
        name = "SimplePredicate",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SimplePredicate.class,
        required = false),
    @XmlElementRef(
        name = "CompoundPredicate",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = CompoundPredicate.class,
        required = false),
    @XmlElementRef(
        name = "SimpleSetPredicate",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SimpleSetPredicate.class,
        required = false),
    @XmlElementRef(
        name = "True",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = True.class,
        required = false),
    @XmlElementRef(
        name = "False",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = False.class,
        required = false)
  })
  protected ICompoundPredicate predicate;

  @XmlElement(name = "ComplexPartialScore")
  protected ComplexPartialScore complexPartialScore;

  @XmlAttribute(name = "reasonCode")
  protected String reasonCode;

  @XmlAttribute(name = "partialScore")
  protected Double partialScore;

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
   * Gets the value of the predicate property.
   *
   * @return possible object is {@link SimplePredicate } {@link CompoundPredicate } {@link
   *     SimpleSetPredicate } {@link True } {@link False }
   */
  public ICompoundPredicate getPredicate() {
    return predicate;
  }

  /**
   * Sets the value of the predicate property.
   *
   * @param value allowed object is {@link SimplePredicate } {@link CompoundPredicate } {@link
   *     SimpleSetPredicate } {@link True } {@link False }
   */
  public void setPredicate(ICompoundPredicate value) {
    this.predicate = value;
  }

  /**
   * Gets the value of the complexPartialScore property.
   *
   * @return possible object is {@link ComplexPartialScore }
   */
  public ComplexPartialScore getComplexPartialScore() {
    return complexPartialScore;
  }

  /**
   * Sets the value of the complexPartialScore property.
   *
   * @param value allowed object is {@link ComplexPartialScore }
   */
  public void setComplexPartialScore(ComplexPartialScore value) {
    this.complexPartialScore = value;
  }

  /**
   * Gets the value of the reasonCode property.
   *
   * @return possible object is {@link String }
   */
  public String getReasonCode() {
    return reasonCode;
  }

  /**
   * Sets the value of the reasonCode property.
   *
   * @param value allowed object is {@link String }
   */
  public void setReasonCode(String value) {
    this.reasonCode = value;
  }

  /**
   * Gets the value of the partialScore property.
   *
   * @return possible object is {@link Double }
   */
  public Double getPartialScore() {
    return partialScore;
  }

  /**
   * Sets the value of the partialScore property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setPartialScore(Double value) {
    this.partialScore = value;
  }
}
