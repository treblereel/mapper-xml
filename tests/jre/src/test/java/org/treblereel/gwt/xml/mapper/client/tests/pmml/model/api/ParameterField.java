//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

/**
 * Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="optype" type="{http://www.dmg.org/PMML-4_4}OPTYPE" /&gt;
 *       &lt;attribute name="dataType" type="{http://www.dmg.org/PMML-4_4}DATATYPE" /&gt;
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface ParameterField {

  /**
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  String getName();

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  void setName(String value);

  /**
   * Gets the value of the optype property.
   *
   * @return possible object is {@link OPTYPE }
   */
  OPTYPE getOptype();

  /**
   * Sets the value of the optype property.
   *
   * @param value allowed object is {@link OPTYPE }
   */
  void setOptype(OPTYPE value);

  /**
   * Gets the value of the dataType property.
   *
   * @return possible object is {@link DATATYPE }
   */
  DATATYPE getDataType();

  /**
   * Sets the value of the dataType property.
   *
   * @param value allowed object is {@link DATATYPE }
   */
  void setDataType(DATATYPE value);

  /**
   * Gets the value of the displayName property.
   *
   * @return possible object is {@link String }
   */
  String getDisplayName();

  /**
   * Sets the value of the displayName property.
   *
   * @param value allowed object is {@link String }
   */
  void setDisplayName(String value);
}
