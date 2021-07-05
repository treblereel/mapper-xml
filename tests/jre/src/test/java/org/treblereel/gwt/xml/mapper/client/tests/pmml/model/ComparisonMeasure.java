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
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}euclidean"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}squaredEuclidean"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}chebychev"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}cityBlock"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}minkowski"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}simpleMatching"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}jaccard"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}tanimoto"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}binarySimilarity"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="kind" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="distance"/&gt;
 *             &lt;enumeration value="similarity"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="compareFunction" type="{http://www.dmg.org/PMML-4_4}COMPARE-FUNCTION" default="absDiff" /&gt;
 *       &lt;attribute name="minimum" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="maximum" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "measure"})
@XmlRootElement(name = "ComparisonMeasure")
@JsType
public class ComparisonMeasure {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElementRefs({
    @XmlElementRef(
        name = "euclidean",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Euclidean.class,
        required = false),
    @XmlElementRef(
        name = "squaredEuclidean",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SquaredEuclidean.class,
        required = false),
    @XmlElementRef(
        name = "chebychev",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Chebychev.class,
        required = false),
    @XmlElementRef(
        name = "cityBlock",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = CityBlock.class,
        required = false),
    @XmlElementRef(
        name = "minkowski",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Minkowski.class,
        required = false),
    @XmlElementRef(
        name = "simpleMatching",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SimpleMatching.class,
        required = false),
    @XmlElementRef(
        name = "jaccard",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Jaccard.class,
        required = false),
    @XmlElementRef(
        name = "tanimoto",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Tanimoto.class,
        required = false),
    @XmlElementRef(
        name = "binarySimilarity",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = BinarySimilarity.class,
        required = false)
  })
  protected IComparisonMeasure measure;

  @XmlAttribute(name = "kind", required = true)
  protected String kind;

  @XmlAttribute(name = "compareFunction")
  protected COMPAREFUNCTION compareFunction;

  @XmlAttribute(name = "minimum")
  protected Double minimum;

  @XmlAttribute(name = "maximum")
  protected Double maximum;

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
   * Gets the value of the measure property.
   *
   * @return possible object is {@link Euclidean } {@link SquaredEuclidean } {@link Chebychev }
   *     {@link CityBlock } {@link Minkowski } {@link SimpleMatching } {@link Jaccard } {@link
   *     Tanimoto } {@link BinarySimilarity }
   */
  public IComparisonMeasure getMeasure() {
    return measure;
  }

  /**
   * Sets the value of the measure property.
   *
   * @param value allowed object is {@link Euclidean } {@link SquaredEuclidean } {@link Chebychev }
   *     {@link CityBlock } {@link Minkowski } {@link SimpleMatching } {@link Jaccard } {@link
   *     Tanimoto } {@link BinarySimilarity }
   */
  public void setMeasure(IComparisonMeasure value) {
    this.measure = value;
  }

  /**
   * Gets the value of the kind property.
   *
   * @return possible object is {@link String }
   */
  public String getKind() {
    return kind;
  }

  /**
   * Sets the value of the kind property.
   *
   * @param value allowed object is {@link String }
   */
  public void setKind(String value) {
    this.kind = value;
  }

  /**
   * Gets the value of the compareFunction property.
   *
   * @return possible object is {@link COMPAREFUNCTION }
   */
  public COMPAREFUNCTION getCompareFunction() {
    if (compareFunction == null) {
      return COMPAREFUNCTION.ABS_DIFF;
    } else {
      return compareFunction;
    }
  }

  /**
   * Sets the value of the compareFunction property.
   *
   * @param value allowed object is {@link COMPAREFUNCTION }
   */
  public void setCompareFunction(COMPAREFUNCTION value) {
    this.compareFunction = value;
  }

  /**
   * Gets the value of the minimum property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMinimum() {
    return minimum;
  }

  /**
   * Sets the value of the minimum property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMinimum(Double value) {
    this.minimum = value;
  }

  /**
   * Gets the value of the maximum property.
   *
   * @return possible object is {@link Double }
   */
  public Double getMaximum() {
    return maximum;
  }

  /**
   * Sets the value of the maximum property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setMaximum(Double value) {
    this.maximum = value;
  }
}
