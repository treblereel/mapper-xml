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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Application" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Annotation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Timestamp" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="copyright" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="modelVersion" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "application", "annotation", "timestamp"})
@XmlRootElement(name = "Header")
@JsType
public class Header {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "Application")
  protected Application application;

  @XmlElement(name = "Annotation")
  protected List<Annotation> annotation;

  @XmlElement(name = "Timestamp")
  protected Timestamp timestamp;

  @XmlAttribute(name = "copyright")
  protected String copyright;

  @XmlAttribute(name = "description")
  protected String description;

  @XmlAttribute(name = "modelVersion")
  protected String modelVersion;

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
   * Gets the value of the application property.
   *
   * @return possible object is {@link Application }
   */
  public Application getApplication() {
    return application;
  }

  /**
   * Sets the value of the application property.
   *
   * @param value allowed object is {@link Application }
   */
  public void setApplication(Application value) {
    this.application = value;
  }

  /**
   * Gets the value of the annotation property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the annotation property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getAnnotation().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Annotation }
   */
  public List<Annotation> getAnnotation() {
    if (annotation == null) {
      annotation = new ArrayList<Annotation>();
    }
    return this.annotation;
  }

  /**
   * Gets the value of the timestamp property.
   *
   * @return possible object is {@link Timestamp }
   */
  public Timestamp getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the timestamp property.
   *
   * @param value allowed object is {@link Timestamp }
   */
  public void setTimestamp(Timestamp value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the copyright property.
   *
   * @return possible object is {@link String }
   */
  public String getCopyright() {
    return copyright;
  }

  /**
   * Sets the value of the copyright property.
   *
   * @param value allowed object is {@link String }
   */
  public void setCopyright(String value) {
    this.copyright = value;
  }

  /**
   * Gets the value of the description property.
   *
   * @return possible object is {@link String }
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the value of the description property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDescription(String value) {
    this.description = value;
  }

  /**
   * Gets the value of the modelVersion property.
   *
   * @return possible object is {@link String }
   */
  public String getModelVersion() {
    return modelVersion;
  }

  /**
   * Sets the value of the modelVersion property.
   *
   * @param value allowed object is {@link String }
   */
  public void setModelVersion(String value) {
    this.modelVersion = value;
  }
}
