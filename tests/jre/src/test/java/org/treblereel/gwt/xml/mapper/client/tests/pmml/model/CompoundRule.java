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
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}Rule" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "predicate", "rule"})
@XmlRootElement(name = "CompoundRule")
@JsType
public class CompoundRule implements ICompoundRule, IRuleSet {

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

  @XmlElementRefs({
    @XmlElementRef(
        name = "SimpleRule",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SimpleRule.class,
        required = false),
    @XmlElementRef(
        name = "CompoundRule",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = CompoundRule.class,
        required = false)
  })
  protected List<ICompoundRule> rule;

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
   * Gets the value of the rule property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the rule property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getRule().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link SimpleRule } {@link
   * CompoundRule }
   */
  public List<ICompoundRule> getRule() {
    if (rule == null) {
      rule = new ArrayList<ICompoundRule>();
    }
    return this.rule;
  }
}
