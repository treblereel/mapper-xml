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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}Interval" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}FrequenciesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="totalValuesSum" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="totalSquaresSum" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "interval", "frequenciesType"})
@XmlRootElement(name = "ContStats")
public class ContStats
    implements org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.ContStats {

  @XmlElement(name = "Extension", type = Extension.class)
  protected List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Extension> extension;

  @XmlElement(name = "Interval", type = Interval.class)
  protected List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Interval> interval;

  @XmlElement(name = "NUM-ARRAY", type = NUMARRAY.class)
  protected List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.NUMARRAY>
      frequenciesType;

  @XmlAttribute(name = "totalValuesSum")
  protected Double totalValuesSum;

  @XmlAttribute(name = "totalSquaresSum")
  protected Double totalSquaresSum;

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
   * Gets the value of the interval property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the interval property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getInterval().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link Interval }
   */
  public List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Interval> getInterval() {
    if (interval == null) {
      interval =
          new ArrayList<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Interval>();
    }
    return this.interval;
  }

  /**
   * Gets the value of the frequenciesType property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the frequenciesType property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getFrequenciesType().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link NUMARRAY }
   */
  public List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.NUMARRAY>
      getFrequenciesType() {
    if (frequenciesType == null) {
      frequenciesType =
          new ArrayList<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.NUMARRAY>();
    }
    return this.frequenciesType;
  }

  /**
   * Gets the value of the totalValuesSum property.
   *
   * @return possible object is {@link Double }
   */
  public Double getTotalValuesSum() {
    return totalValuesSum;
  }

  /**
   * Sets the value of the totalValuesSum property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setTotalValuesSum(Double value) {
    this.totalValuesSum = value;
  }

  /**
   * Gets the value of the totalSquaresSum property.
   *
   * @return possible object is {@link Double }
   */
  public Double getTotalSquaresSum() {
    return totalSquaresSum;
  }

  /**
   * Sets the value of the totalSquaresSum property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setTotalSquaresSum(Double value) {
    this.totalSquaresSum = value;
  }
}
