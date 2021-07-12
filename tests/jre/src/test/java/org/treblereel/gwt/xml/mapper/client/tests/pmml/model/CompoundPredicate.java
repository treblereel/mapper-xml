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
 *         &lt;sequence maxOccurs="unbounded" minOccurs="2"&gt;
 *           &lt;group ref="{http://www.dmg.org/PMML-4_4}PREDICATE"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="booleanOperator" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="or"/&gt;
 *             &lt;enumeration value="and"/&gt;
 *             &lt;enumeration value="xor"/&gt;
 *             &lt;enumeration value="surrogate"/&gt;
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
    propOrder = {"extension", "predicates"})
@XmlRootElement(name = "CompoundPredicate")
@JsType
public class CompoundPredicate implements ICompoundPredicate {

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
  protected List<ICompoundPredicate> predicates;

  @XmlAttribute(name = "booleanOperator", required = true)
  protected String booleanOperator;

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
   * Gets the value of the predicates property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the predicates property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getPredicates().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link SimplePredicate } {@link
   * CompoundPredicate } {@link SimpleSetPredicate } {@link True } {@link False }
   */
  public List<ICompoundPredicate> getPredicates() {
    if (predicates == null) {
      predicates = new ArrayList<ICompoundPredicate>();
    }
    return this.predicates;
  }

  /**
   * Gets the value of the booleanOperator property.
   *
   * @return possible object is {@link String }
   */
  public String getBooleanOperator() {
    return booleanOperator;
  }

  /**
   * Sets the value of the booleanOperator property.
   *
   * @param value allowed object is {@link String }
   */
  public void setBooleanOperator(String value) {
    this.booleanOperator = value;
  }
}
