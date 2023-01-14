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
import org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.IBayesianNode;

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
 *         &lt;choice maxOccurs="unbounded"&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}DiscreteNode"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}ContinuousNode"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "discreteNodeOrContinuousNode"})
@XmlRootElement(name = "BayesianNetworkNodes")
public class BayesianNetworkNodes {

  @XmlElement(name = "Extension")
  protected List<Extension> extension;

  @XmlElementRefs({
    @XmlElementRef(
        name = "DiscreteNode",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = DiscreteNode.class,
        required = false),
    @XmlElementRef(
        name = "ContinuousNode",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = ContinuousNode.class,
        required = false)
  })
  protected List<IBayesianNode> discreteNodeOrContinuousNode;

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
   * Gets the value of the discreteNodeOrContinuousNode property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the discreteNodeOrContinuousNode property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getDiscreteNodeOrContinuousNode().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link DiscreteNode } {@link
   * ContinuousNode }
   */
  public List<IBayesianNode> getDiscreteNodeOrContinuousNode() {
    if (discreteNodeOrContinuousNode == null) {
      discreteNodeOrContinuousNode = new ArrayList<IBayesianNode>();
    }
    return this.discreteNodeOrContinuousNode;
  }
}
