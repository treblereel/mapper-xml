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
 *       &lt;choice&gt;
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}CONTINUOUS-DISTRIBUTION-TYPES"/&gt;
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}DISCRETE-DISTRIBUTION-TYPES"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"distribution"})
@XmlRootElement(name = "Baseline")
@JsType
public class Baseline {

  @XmlElementRefs({
    @XmlElementRef(
        name = "AnyDistribution",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = AnyDistribution.class,
        required = false),
    @XmlElementRef(
        name = "GaussianDistribution",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = GaussianDistribution.class,
        required = false),
    @XmlElementRef(
        name = "PoissonDistribution",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = PoissonDistribution.class,
        required = false),
    @XmlElementRef(
        name = "UniformDistribution",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = UniformDistribution.class,
        required = false),
    @XmlElementRef(
        name = "CountTable",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = CountTable.class,
        required = false),
    @XmlElementRef(
        name = "NormalizedCountTable",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NormalizedCountTable.class,
        required = false),
    @XmlElementRef(
        name = "FieldRef",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = FieldRef.class,
        required = false)
  })
  protected List<IDistribution> distribution;

  /**
   * Gets the value of the distribution property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the distribution property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getDistribution().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link AnyDistribution } {@link
   * GaussianDistribution } {@link PoissonDistribution } {@link UniformDistribution } {@link
   * CountTable } {@link NormalizedCountTable } {@link FieldRef }
   */
  public List<IDistribution> getDistribution() {
    if (distribution == null) {
      distribution = new ArrayList<IDistribution>();
    }
    return this.distribution;
  }
}
