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
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
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
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}EXPRESSION"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "expression"})
@XmlRootElement(name = "ComplexPartialScore")
public class ComplexPartialScore
    implements org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.ComplexPartialScore {

  @XmlElement(name = "Extension", type = Extension.class)
  protected List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Extension> extension;

  @XmlElementRefs({
    @XmlElementRef(
        name = "Constant",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Constant.class,
        required = false),
    @XmlElementRef(
        name = "FieldRef",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = FieldRef.class,
        required = false),
    @XmlElementRef(
        name = "NormContinuous",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NormContinuous.class,
        required = false),
    @XmlElementRef(
        name = "NormDiscrete",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NormDiscrete.class,
        required = false),
    @XmlElementRef(
        name = "Discretize",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Discretize.class,
        required = false),
    @XmlElementRef(
        name = "MapValues",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = MapValues.class,
        required = false),
    @XmlElementRef(
        name = "TextIndex",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TextIndex.class,
        required = false),
    @XmlElementRef(
        name = "Apply",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Apply.class,
        required = false),
    @XmlElementRef(
        name = "Aggregate",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Aggregate.class,
        required = false),
    @XmlElementRef(
        name = "Lag",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = Lag.class,
        required = false)
  })
  protected IExpression expression;

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
   * Gets the value of the expression property.
   *
   * @return possible object is {@link Constant } {@link FieldRef } {@link NormContinuous } {@link
   *     NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link Apply }
   *     {@link Aggregate } {@link Lag }
   */
  public IExpression getExpression() {
    return expression;
  }

  /**
   * Sets the value of the expression property.
   *
   * @param value allowed object is {@link Constant } {@link FieldRef } {@link NormContinuous }
   *     {@link NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link
   *     Apply } {@link Aggregate } {@link Lag }
   */
  public void setExpression(IExpression value) {
    this.expression = value;
  }
}
