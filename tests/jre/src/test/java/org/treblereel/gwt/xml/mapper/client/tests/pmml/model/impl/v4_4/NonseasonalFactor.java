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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigInteger;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}REAL-ARRAY"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="difference" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" default="0" /&gt;
 *       &lt;attribute name="maximumOrder" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "realarray"})
@XmlRootElement(name = "NonseasonalFactor")
public class NonseasonalFactor {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElement(name = "REAL-ARRAY", required = true)
  protected REALARRAY realarray;

  @XmlAttribute(name = "difference")
  protected BigInteger difference;

  @XmlAttribute(name = "maximumOrder")
  protected BigInteger maximumOrder;

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
   * Gets the value of the realarray property.
   *
   * @return possible object is {@link REALARRAY }
   */
  public REALARRAY getREALARRAY() {
    return realarray;
  }

  /**
   * Sets the value of the realarray property.
   *
   * @param value allowed object is {@link REALARRAY }
   */
  public void setREALARRAY(REALARRAY value) {
    this.realarray = value;
  }

  /**
   * Gets the value of the difference property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getDifference() {
    if (difference == null) {
      return new BigInteger("0");
    } else {
      return difference;
    }
  }

  /**
   * Sets the value of the difference property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setDifference(BigInteger value) {
    this.difference = value;
  }

  /**
   * Gets the value of the maximumOrder property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaximumOrder() {
    return maximumOrder;
  }

  /**
   * Sets the value of the maximumOrder property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaximumOrder(BigInteger value) {
    this.maximumOrder = value;
  }
}
