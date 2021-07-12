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
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}EXPRESSION"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Value" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="optype" use="required" type="{http://www.dmg.org/PMML-4_4}OPTYPE" /&gt;
 *       &lt;attribute name="dataType" use="required" type="{http://www.dmg.org/PMML-4_4}DATATYPE" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "expression", "value"})
@XmlRootElement(name = "DerivedField")
@JsType
public class DerivedField implements IBayesInput {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElementRefs({
    @XmlElementRef(
        name = "Constant",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Constant.class,
        required = false),
    @XmlElementRef(
        name = "FieldRef",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = FieldRef.class,
        required = false),
    @XmlElementRef(
        name = "NormContinuous",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NormContinuous.class,
        required = false),
    @XmlElementRef(
        name = "NormDiscrete",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NormDiscrete.class,
        required = false),
    @XmlElementRef(
        name = "Discretize",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Discretize.class,
        required = false),
    @XmlElementRef(
        name = "MapValues",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = MapValues.class,
        required = false),
    @XmlElementRef(
        name = "TextIndex",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TextIndex.class,
        required = false),
    @XmlElementRef(
        name = "Apply",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Apply.class,
        required = false),
    @XmlElementRef(
        name = "Aggregate",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Aggregate.class,
        required = false),
    @XmlElementRef(
        name = "Lag",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Lag.class,
        required = false)
  })
  protected IApply expression;

  @XmlElement(name = "Value")
  protected List<Value> value;

  @XmlAttribute(name = "name")
  protected String name;

  @XmlAttribute(name = "displayName")
  protected String displayName;

  @XmlAttribute(name = "optype", required = true)
  protected OPTYPE optype;

  @XmlAttribute(name = "dataType", required = true)
  protected DATATYPE dataType;

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
   * Gets the value of the expression property.
   *
   * @return possible object is {@link Constant } {@link FieldRef } {@link NormContinuous } {@link
   *     NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link Apply }
   *     {@link Aggregate } {@link Lag }
   */
  public IApply getExpression() {
    return expression;
  }

  /**
   * Sets the value of the expression property.
   *
   * @param value allowed object is {@link Constant } {@link FieldRef } {@link NormContinuous }
   *     {@link NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link
   *     Apply } {@link Aggregate } {@link Lag }
   */
  public void setExpression(IApply value) {
    this.expression = value;
  }

  /**
   * Gets the value of the value property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the value property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getValue().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Value }
   */
  public List<Value> getValue() {
    if (value == null) {
      value = new ArrayList<Value>();
    }
    return this.value;
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

  /**
   * Gets the value of the optype property.
   *
   * @return possible object is {@link OPTYPE }
   */
  public OPTYPE getOptype() {
    return optype;
  }

  /**
   * Sets the value of the optype property.
   *
   * @param value allowed object is {@link OPTYPE }
   */
  public void setOptype(OPTYPE value) {
    this.optype = value;
  }

  /**
   * Gets the value of the dataType property.
   *
   * @return possible object is {@link DATATYPE }
   */
  public DATATYPE getDataType() {
    return dataType;
  }

  /**
   * Sets the value of the dataType property.
   *
   * @param value allowed object is {@link DATATYPE }
   */
  public void setDataType(DATATYPE value) {
    this.dataType = value;
  }
}
