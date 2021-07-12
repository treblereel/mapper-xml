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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}LinearNorm" maxOccurs="unbounded" minOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="mapMissingTo" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="field" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="outliers" type="{http://www.dmg.org/PMML-4_4}OUTLIER-TREATMENT-METHOD" default="asIs" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "linearNorm"})
@XmlRootElement(name = "NormContinuous")
@JsType
public class NormContinuous implements IApply {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "LinearNorm", required = true)
  protected List<LinearNorm> linearNorm;

  @XmlAttribute(name = "mapMissingTo")
  protected Double mapMissingTo;

  @XmlAttribute(name = "field", required = true)
  protected String field;

  @XmlAttribute(name = "outliers")
  protected OUTLIERTREATMENTMETHOD outliers;

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
   * Gets the value of the linearNorm property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the linearNorm property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getLinearNorm().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link LinearNorm }
   */
  public List<LinearNorm> getLinearNorm() {
    if (linearNorm == null) {
      linearNorm = new ArrayList<LinearNorm>();
    }
    return this.linearNorm;
  }

  /**
   * Gets the value of the mapMissingTo property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMapMissingTo() {
    return mapMissingTo;
  }

  /**
   * Sets the value of the mapMissingTo property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMapMissingTo(Double value) {
    this.mapMissingTo = value;
  }

  /**
   * Gets the value of the field property.
   *
   * @return possible object is {@link String }
   */
  public String getField() {
    return field;
  }

  /**
   * Sets the value of the field property.
   *
   * @param value allowed object is {@link String }
   */
  public void setField(String value) {
    this.field = value;
  }

  /**
   * Gets the value of the outliers property.
   *
   * @return possible object is {@link OUTLIERTREATMENTMETHOD }
   */
  public OUTLIERTREATMENTMETHOD getOutliers() {
    if (outliers == null) {
      return OUTLIERTREATMENTMETHOD.AS_IS;
    } else {
      return outliers;
    }
  }

  /**
   * Sets the value of the outliers property.
   *
   * @param value allowed object is {@link OUTLIERTREATMENTMETHOD }
   */
  public void setOutliers(OUTLIERTREATMENTMETHOD value) {
    this.outliers = value;
  }
}
