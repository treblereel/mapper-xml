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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.IExpression;

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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}BlockIndicator" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="field" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="n" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" default="1" /&gt;
 *       &lt;attribute name="aggregate" default="none"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="none"/&gt;
 *             &lt;enumeration value="avg"/&gt;
 *             &lt;enumeration value="max"/&gt;
 *             &lt;enumeration value="median"/&gt;
 *             &lt;enumeration value="min"/&gt;
 *             &lt;enumeration value="product"/&gt;
 *             &lt;enumeration value="sum"/&gt;
 *             &lt;enumeration value="stddev"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "blockIndicator"})
@XmlRootElement(name = "Lag")
public class Lag
    implements IExpression, org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Lag {

  @XmlElement(name = "Extension", type = Extension.class)
  protected List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Extension> extension;

  @XmlElement(name = "BlockIndicator", type = BlockIndicator.class)
  protected List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.BlockIndicator>
      blockIndicator;

  @XmlAttribute(name = "field", required = true)
  protected String field;

  @XmlAttribute(name = "n")
  @XmlSchemaType(name = "positiveInteger")
  protected BigInteger n;

  @XmlAttribute(name = "aggregate")
  protected String aggregate;

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
   * Gets the value of the blockIndicator property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the blockIndicator property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getBlockIndicator().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link BlockIndicator }
   */
  public List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.BlockIndicator>
      getBlockIndicator() {
    if (blockIndicator == null) {
      blockIndicator =
          new ArrayList<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.BlockIndicator>();
    }
    return this.blockIndicator;
  }

  /**
   * Gets the value of the field property.
   *
   * @return possible object is {@link String }
   */
  public String getField() {
    return field;
  }

  /**
   * Sets the value of the field property.
   *
   * @param value allowed object is {@link String }
   */
  public void setField(String value) {
    this.field = value;
  }

  /**
   * Gets the value of the n property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getN() {
    if (n == null) {
      return new BigInteger("1");
    } else {
      return n;
    }
  }

  /**
   * Sets the value of the n property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setN(BigInteger value) {
    this.n = value;
  }

  /**
   * Gets the value of the aggregate property.
   *
   * @return possible object is {@link String }
   */
  public String getAggregate() {
    if (aggregate == null) {
      return "none";
    } else {
      return aggregate;
    }
  }

  /**
   * Sets the value of the aggregate property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAggregate(String value) {
    this.aggregate = value;
  }
}
