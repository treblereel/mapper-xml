//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}LinearNorm" maxOccurs="unbounded" minOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="mapMissingTo" type="{http://www.dmg.org/PMML-4_4}NUMBER" /&gt;
 *       &lt;attribute name="field" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="outliers" type="{http://www.dmg.org/PMML-4_4}OUTLIER-TREATMENT-METHOD" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface NormContinuous {

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
  List<Extension> getExtension();

  /**
   * Gets the value of the linearNorm property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the linearNorm property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getLinearNorm().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link LinearNorm }
   */
  List<LinearNorm> getLinearNorm();

  /**
   * Gets the value of the mapMissingTo property.
   *
   * @return possible object is {@link Double }
   */
  Double getMapMissingTo();

  /**
   * Sets the value of the mapMissingTo property.
   *
   * @param value allowed object is {@link Double }
   */
  void setMapMissingTo(Double value);

  /**
   * Gets the value of the field property.
   *
   * @return possible object is {@link String }
   */
  String getField();

  /**
   * Sets the value of the field property.
   *
   * @param value allowed object is {@link String }
   */
  void setField(String value);

  /**
   * Gets the value of the outliers property.
   *
   * @return possible object is {@link OUTLIERTREATMENTMETHOD }
   */
  OUTLIERTREATMENTMETHOD getOutliers();

  /**
   * Sets the value of the outliers property.
   *
   * @param value allowed object is {@link OUTLIERTREATMENTMETHOD }
   */
  void setOutliers(OUTLIERTREATMENTMETHOD value);
}
