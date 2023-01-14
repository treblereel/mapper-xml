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
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}CONTINUOUS-DISTRIBUTION-TYPES"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "distribution"})
@XmlRootElement(name = "TargetValueStat")
public class TargetValueStat {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElementRefs({
    @XmlElementRef(
        name = "AnyDistribution",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = AnyDistribution.class,
        required = false),
    @XmlElementRef(
        name = "GaussianDistribution",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = GaussianDistribution.class,
        required = false),
    @XmlElementRef(
        name = "PoissonDistribution",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = PoissonDistribution.class,
        required = false),
    @XmlElementRef(
        name = "UniformDistribution",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = UniformDistribution.class,
        required = false)
  })
  protected IDistribution distribution;

  @XmlAttribute(name = "value", required = true)
  protected String value;

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
   * Gets the value of the distribution property.
   *
   * @return possible object is {@link AnyDistribution } {@link GaussianDistribution } {@link
   *     PoissonDistribution } {@link UniformDistribution }
   */
  public IDistribution getDistribution() {
    return distribution;
  }

  /**
   * Sets the value of the distribution property.
   *
   * @param value allowed object is {@link AnyDistribution } {@link GaussianDistribution } {@link
   *     PoissonDistribution } {@link UniformDistribution }
   */
  public void setDistribution(IDistribution value) {
    this.distribution = value;
  }

  /**
   * Gets the value of the value property.
   *
   * @return possible object is {@link String }
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value of the value property.
   *
   * @param value allowed object is {@link String }
   */
  public void setValue(String value) {
    this.value = value;
  }
}
