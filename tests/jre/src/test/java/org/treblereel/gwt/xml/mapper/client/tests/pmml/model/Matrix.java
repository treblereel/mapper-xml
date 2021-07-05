/*
 * Copyright © 2021 Treblereel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import jsinterop.annotations.JsType;

/**
 * Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}NUM-ARRAY" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}MatCell" maxOccurs="unbounded"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="kind" default="any"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="diagonal"/&gt;
 *             &lt;enumeration value="symmetric"/&gt;
 *             &lt;enumeration value="any"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="nbRows" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="nbCols" type="{http://www.dmg.org/PMML-4_4}INT-NUMBER" /&gt;
 *       &lt;attribute name="diagDefault" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *       &lt;attribute name="offDiagDefault" type="{http://www.dmg.org/PMML-4_4}REAL-NUMBER" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"matrix"})
@XmlRootElement(name = "Matrix")
@JsType
public class Matrix {

  @XmlElementRefs({
    @XmlElementRef(
        name = "NUM-ARRAY",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = NUMARRAY.class,
        required = false),
    @XmlElementRef(
        name = "MatCell",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = MatCell.class,
        required = false)
  })
  protected List<IMatrix> matrix;

  @XmlAttribute(name = "kind")
  protected String kind;

  @XmlAttribute(name = "nbRows")
  protected BigInteger nbRows;

  @XmlAttribute(name = "nbCols")
  protected BigInteger nbCols;

  @XmlAttribute(name = "diagDefault")
  protected Double diagDefault;

  @XmlAttribute(name = "offDiagDefault")
  protected Double offDiagDefault;

  /**
   * Gets the value of the matrix property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the matrix property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getMatrix().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link NUMARRAY } {@link MatCell }
   */
  public List<IMatrix> getMatrix() {
    if (matrix == null) {
      matrix = new ArrayList<IMatrix>();
    }
    return this.matrix;
  }

  /**
   * Gets the value of the kind property.
   *
   * @return possible object is {@link String }
   */
  public String getKind() {
    if (kind == null) {
      return "any";
    } else {
      return kind;
    }
  }

  /**
   * Sets the value of the kind property.
   *
   * @param value allowed object is {@link String }
   */
  public void setKind(String value) {
    this.kind = value;
  }

  /**
   * Gets the value of the nbRows property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNbRows() {
    return nbRows;
  }

  /**
   * Sets the value of the nbRows property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNbRows(BigInteger value) {
    this.nbRows = value;
  }

  /**
   * Gets the value of the nbCols property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getNbCols() {
    return nbCols;
  }

  /**
   * Sets the value of the nbCols property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setNbCols(BigInteger value) {
    this.nbCols = value;
  }

  /**
   * Gets the value of the diagDefault property.
   *
   * @return possible object is {@link Double }
   */
  public Double getDiagDefault() {
    return diagDefault;
  }

  /**
   * Sets the value of the diagDefault property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setDiagDefault(Double value) {
    this.diagDefault = value;
  }

  /**
   * Gets the value of the offDiagDefault property.
   *
   * @return possible object is {@link Double }
   */
  public Double getOffDiagDefault() {
    return offDiagDefault;
  }

  /**
   * Sets the value of the offDiagDefault property.
   *
   * @param value allowed object is {@link Double }
   */
  public void setOffDiagDefault(Double value) {
    this.offDiagDefault = value;
  }
}
