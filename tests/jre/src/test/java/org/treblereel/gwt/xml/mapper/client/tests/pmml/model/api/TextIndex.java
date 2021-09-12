//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.08.06 at 04:43:12 PM BST
//

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model.api;

import java.math.BigInteger;
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
 *         &lt;element ref="{http://www.dmg.org/PMML-4_4}TextIndexNormalization" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;group ref="{http://www.dmg.org/PMML-4_4}EXPRESSION"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="textField" use="required" type="{http://www.dmg.org/PMML-4_4}FIELD-NAME" /&gt;
 *       &lt;attribute name="localTermWeights" default="termFrequency"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="termFrequency"/&gt;
 *             &lt;enumeration value="binary"/&gt;
 *             &lt;enumeration value="logarithmic"/&gt;
 *             &lt;enumeration value="augmentedNormalizedTermFrequency"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="isCaseSensitive" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="maxLevenshteinDistance" type="{http://www.w3.org/2001/XMLSchema}integer" default="0" /&gt;
 *       &lt;attribute name="countHits" default="allHits"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="allHits"/&gt;
 *             &lt;enumeration value="bestHits"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="wordSeparatorCharacterRE" type="{http://www.w3.org/2001/XMLSchema}string" default="\s+" /&gt;
 *       &lt;attribute name="tokenize" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public interface TextIndex {

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
   * Gets the value of the textIndexNormalization property.
   *
   * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
   * modification you make to the returned list will be present inside the JAXB object. This is why
   * there is not a <CODE>set</CODE> method for the textIndexNormalization property.
   *
   * <p>For example, to add a new item, do as follows:
   *
   * <pre>
   *    getTextIndexNormalization().add(newItem);
   * </pre>
   *
   * <p>Objects of the following type(s) are allowed in the list {@link TextIndexNormalization }
   */
  List<TextIndexNormalization> getTextIndexNormalization();

  /**
   * Gets the value of the expression property.
   *
   * @return possible object is {@link Constant } {@link FieldRef } {@link NormContinuous } {@link
   *     NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link Apply }
   *     {@link Aggregate } {@link Lag }
   */
  IExpression getExpression();

  /**
   * Sets the value of the expression property.
   *
   * @param value allowed object is {@link Constant } {@link FieldRef } {@link NormContinuous }
   *     {@link NormDiscrete } {@link Discretize } {@link MapValues } {@link TextIndex } {@link
   *     Apply } {@link Aggregate } {@link Lag }
   */
  void setExpression(IExpression value);

  /**
   * Gets the value of the textField property.
   *
   * @return possible object is {@link String }
   */
  String getTextField();

  /**
   * Sets the value of the textField property.
   *
   * @param value allowed object is {@link String }
   */
  void setTextField(String value);

  /**
   * Gets the value of the localTermWeights property.
   *
   * @return possible object is {@link String }
   */
  String getLocalTermWeights();

  /**
   * Sets the value of the localTermWeights property.
   *
   * @param value allowed object is {@link String }
   */
  void setLocalTermWeights(String value);

  /**
   * Gets the value of the isCaseSensitive property.
   *
   * @return possible object is {@link Boolean }
   */
  boolean isIsCaseSensitive();

  /**
   * Sets the value of the isCaseSensitive property.
   *
   * @param value allowed object is {@link Boolean }
   */
  void setIsCaseSensitive(Boolean value);

  /**
   * Gets the value of the maxLevenshteinDistance property.
   *
   * @return possible object is {@link BigInteger }
   */
  BigInteger getMaxLevenshteinDistance();

  /**
   * Sets the value of the maxLevenshteinDistance property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  void setMaxLevenshteinDistance(BigInteger value);

  /**
   * Gets the value of the countHits property.
   *
   * @return possible object is {@link String }
   */
  String getCountHits();

  /**
   * Sets the value of the countHits property.
   *
   * @param value allowed object is {@link String }
   */
  void setCountHits(String value);

  /**
   * Gets the value of the wordSeparatorCharacterRE property.
   *
   * @return possible object is {@link String }
   */
  String getWordSeparatorCharacterRE();

  /**
   * Sets the value of the wordSeparatorCharacterRE property.
   *
   * @param value allowed object is {@link String }
   */
  void setWordSeparatorCharacterRE(String value);

  /**
   * Gets the value of the tokenize property.
   *
   * @return possible object is {@link Boolean }
   */
  boolean isTokenize();

  /**
   * Sets the value of the tokenize property.
   *
   * @param value allowed object is {@link Boolean }
   */
  void setTokenize(Boolean value);
}