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
import org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.IExpression;
import org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.ITable;

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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}FieldColumnPair" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}TableLocator"/&gt;
 *           &lt;element ref="{http://www.dmg.org/PMML-4_4}InlineTable"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="mapMissingTo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="outputColumn" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dataType" type="{http://www.dmg.org/PMML-4_4}DATATYPE" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"extension", "fieldColumnPair", "table"})
@XmlRootElement(name = "MapValues")
public class MapValues
    implements IExpression, org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.MapValues {

  @XmlElement(name = "Extension", type = Extension.class)
  protected List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.Extension> extension;

  @XmlElement(name = "FieldColumnPair", type = FieldColumnPair.class)
  protected List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.FieldColumnPair>
      fieldColumnPair;

  @XmlElementRefs({
    @XmlElementRef(
        name = "TableLocator",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = TableLocator.class,
        required = false),
    @XmlElementRef(
        name = "InlineTable",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = InlineTable.class,
        required = false)
  })
  protected ITable table;

  @XmlAttribute(name = "mapMissingTo")
  protected String mapMissingTo;

  @XmlAttribute(name = "defaultValue")
  protected String defaultValue;

  @XmlAttribute(name = "outputColumn", required = true)
  protected String outputColumn;

  @XmlAttribute(name = "dataType")
  protected org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.DATATYPE dataType;

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
   * Gets the value of the fieldColumnPair property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the fieldColumnPair property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getFieldColumnPair().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link FieldColumnPair }
   */
  public List<org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.FieldColumnPair>
      getFieldColumnPair() {
    if (fieldColumnPair == null) {
      fieldColumnPair =
          new ArrayList<
              org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.FieldColumnPair>();
    }
    return this.fieldColumnPair;
  }

  /**
   * Gets the value of the table property.
   *
   * @return possible object is {@link TableLocator } {@link InlineTable }
   */
  public ITable getTable() {
    return table;
  }

  /**
   * Sets the value of the table property.
   *
   * @param value allowed object is {@link TableLocator } {@link InlineTable }
   */
  public void setTable(ITable value) {
    this.table = value;
  }

  /**
   * Gets the value of the mapMissingTo property.
   *
   * @return possible object is {@link String }
   */
  public String getMapMissingTo() {
    return mapMissingTo;
  }

  /**
   * Sets the value of the mapMissingTo property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMapMissingTo(String value) {
    this.mapMissingTo = value;
  }

  /**
   * Gets the value of the defaultValue property.
   *
   * @return possible object is {@link String }
   */
  public String getDefaultValue() {
    return defaultValue;
  }

  /**
   * Sets the value of the defaultValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDefaultValue(String value) {
    this.defaultValue = value;
  }

  /**
   * Gets the value of the outputColumn property.
   *
   * @return possible object is {@link String }
   */
  public String getOutputColumn() {
    return outputColumn;
  }

  /**
   * Sets the value of the outputColumn property.
   *
   * @param value allowed object is {@link String }
   */
  public void setOutputColumn(String value) {
    this.outputColumn = value;
  }

  /**
   * Gets the value of the dataType property.
   *
   * @return possible object is {@link DATATYPE }
   */
  public org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.DATATYPE getDataType() {
    return dataType;
  }

  /**
   * Sets the value of the dataType property.
   *
   * @param value allowed object is {@link DATATYPE }
   */
  public void setDataType(
      org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api.DATATYPE value) {
    this.dataType = value;
  }
}
