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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}KohonenMap" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}NUM-ARRAY" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Partition" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Covariances" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "kohonenMap", "numarray", "partition", "covariances"})
@XmlRootElement(name = "Cluster")
@JsType
public class Cluster {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "KohonenMap")
  protected KohonenMap kohonenMap;

  @XmlElement(name = "NUM-ARRAY")
  protected NUMARRAY numarray;

  @XmlElement(name = "Partition")
  protected Partition partition;

  @XmlElement(name = "Covariances")
  protected Covariances covariances;

  @XmlAttribute(name = "id")
  protected String id;

  @XmlAttribute(name = "name")
  protected String name;

  @XmlAttribute(name = "size")
  protected BigInteger size;

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
   * Gets the value of the kohonenMap property.
   *
   * @return possible object is {@link KohonenMap }
   */
  public KohonenMap getKohonenMap() {
    return kohonenMap;
  }

  /**
   * Sets the value of the kohonenMap property.
   *
   * @param value allowed object is {@link KohonenMap }
   */
  public void setKohonenMap(KohonenMap value) {
    this.kohonenMap = value;
  }

  /**
   * Gets the value of the numarray property.
   *
   * @return possible object is {@link NUMARRAY }
   */
  public NUMARRAY getNUMARRAY() {
    return numarray;
  }

  /**
   * Sets the value of the numarray property.
   *
   * @param value allowed object is {@link NUMARRAY }
   */
  public void setNUMARRAY(NUMARRAY value) {
    this.numarray = value;
  }

  /**
   * Gets the value of the partition property.
   *
   * @return possible object is {@link Partition }
   */
  public Partition getPartition() {
    return partition;
  }

  /**
   * Sets the value of the partition property.
   *
   * @param value allowed object is {@link Partition }
   */
  public void setPartition(Partition value) {
    this.partition = value;
  }

  /**
   * Gets the value of the covariances property.
   *
   * @return possible object is {@link Covariances }
   */
  public Covariances getCovariances() {
    return covariances;
  }

  /**
   * Sets the value of the covariances property.
   *
   * @param value allowed object is {@link Covariances }
   */
  public void setCovariances(Covariances value) {
    this.covariances = value;
  }

  /**
   * Gets the value of the id property.
   *
   * @return possible object is {@link String }
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value allowed object is {@link String }
   */
  public void setId(String value) {
    this.id = value;
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
   * Gets the value of the size property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getSize() {
    return size;
  }

  /**
   * Sets the value of the size property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setSize(BigInteger value) {
    this.size = value;
  }
}
