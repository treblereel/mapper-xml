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
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}TriangularDistributionForBN"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}NormalDistributionForBN"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}LognormalDistributionForBN"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}UniformDistributionForBN"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {
      "extension",
      "triangularDistributionForBNOrNormalDistributionForBNOrLognormalDistributionForBN"
    })
@XmlRootElement(name = "ContinuousDistribution")
@JsType
public class ContinuousDistribution implements IContinuousNode {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElementRefs({
    @XmlElementRef(
        name = "TriangularDistributionForBN",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TriangularDistributionForBN.class,
        required = false),
    @XmlElementRef(
        name = "NormalDistributionForBN",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NormalDistributionForBN.class,
        required = false),
    @XmlElementRef(
        name = "LognormalDistributionForBN",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = LognormalDistributionForBN.class,
        required = false),
    @XmlElementRef(
        name = "UniformDistributionForBN",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = UniformDistributionForBN.class,
        required = false)
  })
  protected IContinuousDistribution
      triangularDistributionForBNOrNormalDistributionForBNOrLognormalDistributionForBN;

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
   * Gets the value of the
   * triangularDistributionForBNOrNormalDistributionForBNOrLognormalDistributionForBN property.
   *
   * @return possible object is {@link TriangularDistributionForBN } {@link NormalDistributionForBN
   *     } {@link LognormalDistributionForBN } {@link UniformDistributionForBN }
   */
  public IContinuousDistribution
      getTriangularDistributionForBNOrNormalDistributionForBNOrLognormalDistributionForBN() {
    return triangularDistributionForBNOrNormalDistributionForBNOrLognormalDistributionForBN;
  }

  /**
   * Sets the value of the
   * triangularDistributionForBNOrNormalDistributionForBNOrLognormalDistributionForBN property.
   *
   * @param value allowed object is {@link TriangularDistributionForBN } {@link
   *     NormalDistributionForBN } {@link LognormalDistributionForBN } {@link
   *     UniformDistributionForBN }
   */
  public void setTriangularDistributionForBNOrNormalDistributionForBNOrLognormalDistributionForBN(
      IContinuousDistribution value) {
    this.triangularDistributionForBNOrNormalDistributionForBNOrLognormalDistributionForBN = value;
  }
}
