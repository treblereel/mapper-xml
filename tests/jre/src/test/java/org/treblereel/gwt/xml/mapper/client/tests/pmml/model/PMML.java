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
import org.treblereel.gwt.xml.mapper.api.annotation.Configuration;
import org.treblereel.gwt.xml.mapper.api.annotation.XMLMapper;

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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Header"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}MiningBuildTask" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}DataDictionary"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}TransformationDictionary" minOccurs="0"/&gt;
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;group ref="{http://www.dmg.org/PMML-4_4}MODEL-ELEMENT"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Extension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {
      "header",
      "miningBuildTask",
      "dataDictionary",
      "transformationDictionary",
      "model",
      "extension"
    })
@XmlRootElement(name = "PMML")
@JsType
@XMLMapper
@Configuration(
    additionalAnnotation = {@Configuration.ConfigurationAnnotation(JsType.class)
      // TODO {manstis} See https://github.com/treblereel/gwt3-processors/issues/10
      // @Configuration.ConfigurationAnnotation(GWT3Export.class)
    })
public class PMML {

  @XmlElement(name = "Header", required = true)
  protected Header header;

  @XmlElement(name = "MiningBuildTask")
  protected MiningBuildTask miningBuildTask;

  @XmlElement(name = "DataDictionary", required = true)
  protected DataDictionary dataDictionary;

  @XmlElement(name = "TransformationDictionary")
  protected TransformationDictionary transformationDictionary;

  @XmlElementRefs({
    @XmlElementRef(
        name = "AnomalyDetectionModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = AnomalyDetectionModel.class,
        required = false),
    @XmlElementRef(
        name = "AssociationModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = AssociationModel.class,
        required = false),
    @XmlElementRef(
        name = "BayesianNetworkModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = BayesianNetworkModel.class,
        required = false),
    @XmlElementRef(
        name = "BaselineModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = BaselineModel.class,
        required = false),
    @XmlElementRef(
        name = "ClusteringModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = ClusteringModel.class,
        required = false),
    @XmlElementRef(
        name = "GaussianProcessModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = GaussianProcessModel.class,
        required = false),
    @XmlElementRef(
        name = "GeneralRegressionModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = GeneralRegressionModel.class,
        required = false),
    @XmlElementRef(
        name = "MiningModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = MiningModel.class,
        required = false),
    @XmlElementRef(
        name = "NaiveBayesModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NaiveBayesModel.class,
        required = false),
    @XmlElementRef(
        name = "NearestNeighborModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NearestNeighborModel.class,
        required = false),
    @XmlElementRef(
        name = "NeuralNetwork",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NeuralNetwork.class,
        required = false),
    @XmlElementRef(
        name = "RegressionModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = RegressionModel.class,
        required = false),
    @XmlElementRef(
        name = "RuleSetModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = RuleSetModel.class,
        required = false),
    @XmlElementRef(
        name = "SequenceModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SequenceModel.class,
        required = false),
    @XmlElementRef(
        name = "Scorecard",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Scorecard.class,
        required = false),
    @XmlElementRef(
        name = "SupportVectorMachineModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = SupportVectorMachineModel.class,
        required = false),
    @XmlElementRef(
        name = "TextModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TextModel.class,
        required = false),
    @XmlElementRef(
        name = "TimeSeriesModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TimeSeriesModel.class,
        required = false),
    @XmlElementRef(
        name = "TreeModel",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TreeModel.class,
        required = false)
  })
  protected List<IPMML> model;

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlAttribute(name = "version", required = true)
  protected String version;

  /**
   * Gets the value of the header property.
   *
   * @return possible object is {@link Header }
   */
  public Header getHeader() {
    return header;
  }

  /**
   * Sets the value of the header property.
   *
   * @param value allowed object is {@link Header }
   */
  public void setHeader(Header value) {
    this.header = value;
  }

  /**
   * Gets the value of the miningBuildTask property.
   *
   * @return possible object is {@link MiningBuildTask }
   */
  public MiningBuildTask getMiningBuildTask() {
    return miningBuildTask;
  }

  /**
   * Sets the value of the miningBuildTask property.
   *
   * @param value allowed object is {@link MiningBuildTask }
   */
  public void setMiningBuildTask(MiningBuildTask value) {
    this.miningBuildTask = value;
  }

  /**
   * Gets the value of the dataDictionary property.
   *
   * @return possible object is {@link DataDictionary }
   */
  public DataDictionary getDataDictionary() {
    return dataDictionary;
  }

  /**
   * Sets the value of the dataDictionary property.
   *
   * @param value allowed object is {@link DataDictionary }
   */
  public void setDataDictionary(DataDictionary value) {
    this.dataDictionary = value;
  }

  /**
   * Gets the value of the transformationDictionary property.
   *
   * @return possible object is {@link TransformationDictionary }
   */
  public TransformationDictionary getTransformationDictionary() {
    return transformationDictionary;
  }

  /**
   * Sets the value of the transformationDictionary property.
   *
   * @param value allowed object is {@link TransformationDictionary }
   */
  public void setTransformationDictionary(TransformationDictionary value) {
    this.transformationDictionary = value;
  }

  /**
   * Gets the value of the model property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the model property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getModel().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link AnomalyDetectionModel }
   * {@link AssociationModel } {@link BayesianNetworkModel } {@link BaselineModel } {@link
   * ClusteringModel } {@link GaussianProcessModel } {@link GeneralRegressionModel } {@link
   * MiningModel } {@link NaiveBayesModel } {@link NearestNeighborModel } {@link NeuralNetwork }
   * {@link RegressionModel } {@link RuleSetModel } {@link SequenceModel } {@link Scorecard } {@link
   * SupportVectorMachineModel } {@link TextModel } {@link TimeSeriesModel } {@link TreeModel }
   */
  public List<IPMML> getModel() {
    if (model == null) {
      model = new ArrayList<IPMML>();
    }
    return this.model;
  }

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
   * Gets the value of the version property.
   *
   * @return possible object is {@link String }
   */
  public String getVersion() {
    return version;
  }

  /**
   * Sets the value of the version property.
   *
   * @param value allowed object is {@link String }
   */
  public void setVersion(String value) {
    this.version = value;
  }
}
