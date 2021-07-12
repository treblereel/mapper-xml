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

import java.math.BigInteger;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Neuron" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="numberOfNeurons" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *       &lt;attribute name="activationFunction" type="{http://www.dmg.org/PMML-4_4}ACTIVATION-FUNCTION" /&gt;
 *       &lt;attribute name="threshold" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="width" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="altitude" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="normalizationMethod" type="{http://www.dmg.org/PMML-4_4}NN-NORMALIZATION-METHOD" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "neuron"})
@XmlRootElement(name = "NeuralLayer")
@JsType
public class NeuralLayer {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "Neuron", required = true)
  protected List<Neuron> neuron;

  @XmlAttribute(name = "numberOfNeurons")
  protected BigInteger numberOfNeurons;

  @XmlAttribute(name = "activationFunction")
  protected ACTIVATIONFUNCTION activationFunction;

  @XmlAttribute(name = "threshold")
  protected Double threshold;

  @XmlAttribute(name = "width")
  protected Double width;

  @XmlAttribute(name = "altitude")
  protected Double altitude;

  @XmlAttribute(name = "normalizationMethod")
  protected NNNORMALIZATIONMETHOD normalizationMethod;

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
   * Gets the value of the neuron property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the neuron property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getNeuron().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Neuron }
   */
  public List<Neuron> getNeuron() {
    if (neuron == null) {
      neuron = new ArrayList<Neuron>();
    }
    return this.neuron;
  }

  /**
   * Gets the value of the numberOfNeurons property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNumberOfNeurons() {
    return numberOfNeurons;
  }

  /**
   * Sets the value of the numberOfNeurons property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNumberOfNeurons(BigInteger value) {
    this.numberOfNeurons = value;
  }

  /**
   * Gets the value of the activationFunction property.
   *
   * @return possible object is {@link ACTIVATIONFUNCTION }
   */
  public ACTIVATIONFUNCTION getActivationFunction() {
    return activationFunction;
  }

  /**
   * Sets the value of the activationFunction property.
   *
   * @param value allowed object is {@link ACTIVATIONFUNCTION }
   */
  public void setActivationFunction(ACTIVATIONFUNCTION value) {
    this.activationFunction = value;
  }

  /**
   * Gets the value of the threshold property.
   *
   * @return possible object is {@link Double }
   */
  public Double getThreshold() {
    return threshold;
  }

  /**
   * Sets the value of the threshold property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setThreshold(Double value) {
    this.threshold = value;
  }

  /**
   * Gets the value of the width property.
   *
   * @return possible object is {@link Double }
   */
  public Double getWidth() {
    return width;
  }

  /**
   * Sets the value of the width property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setWidth(Double value) {
    this.width = value;
  }

  /**
   * Gets the value of the altitude property.
   *
   * @return possible object is {@link Double }
   */
  public Double getAltitude() {
    return altitude;
  }

  /**
   * Sets the value of the altitude property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setAltitude(Double value) {
    this.altitude = value;
  }

  /**
   * Gets the value of the normalizationMethod property.
   *
   * @return possible object is {@link NNNORMALIZATIONMETHOD }
   */
  public NNNORMALIZATIONMETHOD getNormalizationMethod() {
    return normalizationMethod;
  }

  /**
   * Sets the value of the normalizationMethod property.
   *
   * @param value allowed object is {@link NNNORMALIZATIONMETHOD }
   */
  public void setNormalizationMethod(NNNORMALIZATIONMETHOD value) {
    this.normalizationMethod = value;
  }
}
