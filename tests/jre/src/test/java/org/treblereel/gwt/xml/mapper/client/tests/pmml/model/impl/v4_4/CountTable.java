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
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.IDistribution;
import org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.IFieldValue;

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
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}FieldValue" maxOccurs="unbounded"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}FieldValueCount" maxOccurs="unbounded"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="sample" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "fieldValue"})
@XmlRootElement(name = "CountTable")
public class CountTable implements IDistribution {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElementRefs({
    @XmlElementRef(
        name = "FieldValue",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = FieldValue.class,
        required = false),
    @XmlElementRef(
        name = "FieldValueCount",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = FieldValueCount.class,
        required = false)
  })
  protected List<IFieldValue> fieldValue;

  @XmlAttribute(name = "sample")
  protected Double sample;

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
   * Gets the value of the fieldValue property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the fieldValue property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getFieldValue().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link FieldValue } {@link
   * FieldValueCount }
   */
  public List<IFieldValue> getFieldValue() {
    if (fieldValue == null) {
      fieldValue = new ArrayList<IFieldValue>();
    }
    return this.fieldValue;
  }

  /**
   * Gets the value of the sample property.
   *
   * @return possible object is {@link Double }
   */
  public Double getSample() {
    return sample;
  }

  /**
   * Sets the value of the sample property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setSample(Double value) {
    this.sample = value;
  }
}
