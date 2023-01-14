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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}XCoordinates"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}YCoordinates"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}BoundaryValues" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "xCoordinates", "yCoordinates", "boundaryValues"})
@XmlRootElement(name = "ROCGraph")
public class ROCGraph
    implements org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.ROCGraph {

  @XmlElement(name = "Extension", type = Extension.class)
  protected List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Extension> extension;

  @XmlElement(name = "XCoordinates", required = true, type = XCoordinates.class)
  protected org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.XCoordinates xCoordinates;

  @XmlElement(name = "YCoordinates", required = true, type = YCoordinates.class)
  protected org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.YCoordinates yCoordinates;

  @XmlElement(name = "BoundaryValues", type = BoundaryValues.class)
  protected org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.BoundaryValues boundaryValues;

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
  public List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Extension> getExtension() {
    if (extension == null) {
      extension =
          new ArrayList<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Extension>();
    }
    return this.extension;
  }

  /**
   * Gets the value of the xCoordinates property.
   *
   * @return possible object is {@link XCoordinates }
   */
  public org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.XCoordinates getXCoordinates() {
    return xCoordinates;
  }

  /**
   * Sets the value of the xCoordinates property.
   *
   * @param value allowed object is {@link XCoordinates }
   */
  public void setXCoordinates(
      org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.XCoordinates value) {
    this.xCoordinates = value;
  }

  /**
   * Gets the value of the yCoordinates property.
   *
   * @return possible object is {@link YCoordinates }
   */
  public org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.YCoordinates getYCoordinates() {
    return yCoordinates;
  }

  /**
   * Sets the value of the yCoordinates property.
   *
   * @param value allowed object is {@link YCoordinates }
   */
  public void setYCoordinates(
      org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.YCoordinates value) {
    this.yCoordinates = value;
  }

  /**
   * Gets the value of the boundaryValues property.
   *
   * @return possible object is {@link BoundaryValues }
   */
  public org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.BoundaryValues
      getBoundaryValues() {
    return boundaryValues;
  }

  /**
   * Sets the value of the boundaryValues property.
   *
   * @param value allowed object is {@link BoundaryValues }
   */
  public void setBoundaryValues(
      org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.BoundaryValues value) {
    this.boundaryValues = value;
  }
}
