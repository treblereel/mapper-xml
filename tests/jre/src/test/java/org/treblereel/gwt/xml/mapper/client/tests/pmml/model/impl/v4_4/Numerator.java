//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:18 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.impl.v4_4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}NonseasonalFactor" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}SeasonalFactor" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "nonseasonalFactor", "seasonalFactor"})
@XmlRootElement(name = "Numerator")
public class Numerator {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "NonseasonalFactor")
  protected NonseasonalFactor nonseasonalFactor;

  @XmlElement(name = "SeasonalFactor")
  protected SeasonalFactor seasonalFactor;

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
   * Gets the value of the nonseasonalFactor property.
   *
   * @return possible object is {@link NonseasonalFactor }
   */
  public NonseasonalFactor getNonseasonalFactor() {
    return nonseasonalFactor;
  }

  /**
   * Sets the value of the nonseasonalFactor property.
   *
   * @param value allowed object is {@link NonseasonalFactor }
   */
  public void setNonseasonalFactor(NonseasonalFactor value) {
    this.nonseasonalFactor = value;
  }

  /**
   * Gets the value of the seasonalFactor property.
   *
   * @return possible object is {@link SeasonalFactor }
   */
  public SeasonalFactor getSeasonalFactor() {
    return seasonalFactor;
  }

  /**
   * Sets the value of the seasonalFactor property.
   *
   * @param value allowed object is {@link SeasonalFactor }
   */
  public void setSeasonalFactor(SeasonalFactor value) {
    this.seasonalFactor = value;
  }
}
