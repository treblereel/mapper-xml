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
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigInteger;
import org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.IState;

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
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}KalmanState"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}ThetaRecursionState"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="method" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="kalman"/&gt;
 *             &lt;enumeration value="thetaRecursion"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="periodDeficit" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" default="0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"state"})
@XmlRootElement(name = "MaximumLikelihoodStat")
public class MaximumLikelihoodStat {

  @XmlElementRefs({
    @XmlElementRef(
        name = "KalmanState",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = KalmanState.class,
        required = false),
    @XmlElementRef(
        name = "ThetaRecursionState",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = ThetaRecursionState.class,
        required = false)
  })
  protected IState state;

  @XmlAttribute(name = "method", required = true)
  protected String method;

  @XmlAttribute(name = "periodDeficit")
  protected BigInteger periodDeficit;

  /**
   * Gets the value of the state property.
   *
   * @return possible object is {@link KalmanState } {@link ThetaRecursionState }
   */
  public IState getState() {
    return state;
  }

  /**
   * Sets the value of the state property.
   *
   * @param value allowed object is {@link KalmanState } {@link ThetaRecursionState }
   */
  public void setState(IState value) {
    this.state = value;
  }

  /**
   * Gets the value of the method property.
   *
   * @return possible object is {@link String }
   */
  public String getMethod() {
    return method;
  }

  /**
   * Sets the value of the method property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMethod(String value) {
    this.method = value;
  }

  /**
   * Gets the value of the periodDeficit property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getPeriodDeficit() {
    if (periodDeficit == null) {
      return new BigInteger("0");
    } else {
      return periodDeficit;
    }
  }

  /**
   * Sets the value of the periodDeficit property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setPeriodDeficit(BigInteger value) {
    this.periodDeficit = value;
  }
}
