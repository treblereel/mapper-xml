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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}FieldColumnPair" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}TableLocator"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}InlineTable"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="mapMissingTo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="outputColumn" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dataType" type="{http://www.dmg.org/PMML-4_4}DATATYPE" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "fieldColumnPair", "table"})
@XmlRootElement(name = "MapValues")
@JsType
public class MapValues implements IApply {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "FieldColumnPair")
  protected List<FieldColumnPair> fieldColumnPair;

  @XmlElementRefs({
    @XmlElementRef(
        name = "TableLocator",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TableLocator.class,
        required = false),
    @XmlElementRef(
        name = "InlineTable",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = InlineTable.class,
        required = false)
  })
  protected IChildParent table;

  @XmlAttribute(name = "mapMissingTo")
  protected String mapMissingTo;

  @XmlAttribute(name = "defaultValue")
  protected String defaultValue;

  @XmlAttribute(name = "outputColumn", required = true)
  protected String outputColumn;

  @XmlAttribute(name = "dataType")
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
   * Gets the value of the fieldColumnPair property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the fieldColumnPair property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getFieldColumnPair().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link FieldColumnPair }
   */
  public List<FieldColumnPair> getFieldColumnPair() {
    if (fieldColumnPair == null) {
      fieldColumnPair = new ArrayList<FieldColumnPair>();
    }
    return this.fieldColumnPair;
  }

  /**
   * Gets the value of the table property.
   *
   * @return possible object is {@link TableLocator } {@link InlineTable }
   */
  public IChildParent getTable() {
    return table;
  }

  /**
   * Sets the value of the table property.
   *
   * @param value allowed object is {@link TableLocator } {@link InlineTable }
   */
  public void setTable(IChildParent value) {
    this.table = value;
  }

  /**
   * Gets the value of the mapMissingTo property.
   *
   * @return possible object is {@link String }
   */
  public String getMapMissingTo() {
    return mapMissingTo;
  }

  /**
   * Sets the value of the mapMissingTo property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMapMissingTo(String value) {
    this.mapMissingTo = value;
  }

  /**
   * Gets the value of the defaultValue property.
   *
   * @return possible object is {@link String }
   */
  public String getDefaultValue() {
    return defaultValue;
  }

  /**
   * Sets the value of the defaultValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDefaultValue(String value) {
    this.defaultValue = value;
  }

  /**
   * Gets the value of the outputColumn property.
   *
   * @return possible object is {@link String }
   */
  public String getOutputColumn() {
    return outputColumn;
  }

  /**
   * Sets the value of the outputColumn property.
   *
   * @param value allowed object is {@link String }
   */
  public void setOutputColumn(String value) {
    this.outputColumn = value;
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
