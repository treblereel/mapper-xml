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

import static org.junit.Assert.assertNotNull;

import com.google.j2cl.junit.apt.J2clTestInput;
import java.util.Random;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import org.treblereel.gwt.xml.mapper.api.DefaultXMLSerializationContext;
import org.treblereel.gwt.xml.mapper.api.XMLSerializationContext;

/** @author Dmitrii Tikhomirov Created by treblereel 7/5/21 */
@J2clTestInput(PMMLTest.class)
public class PMMLTest {

  private static final String XML =
      "<?xml version='1.0' encoding='UTF-8'?>"
          + "<PMML xmlns=\"http://www.dmg.org/PMML-4_4\" version=\"4.4\">\n"
          + "  <Header copyright=\"www.dmg.org\" description=\"Sample scorecard\">\n"
          + "    <Timestamp>2010-11-10T08:17:10.8</Timestamp>\n"
          + "  </Header>\n"
          + "  <DataDictionary>\n"
          + "    <DataField name=\"department\" dataType=\"string\" optype=\"categorical\"/>\n"
          + "    <DataField name=\"age\" dataType=\"integer\" optype=\"continuous\"/>\n"
          + "    <DataField name=\"income\" dataType=\"double\" optype=\"continuous\"/>\n"
          + "    <DataField name=\"overallScore\" dataType=\"double\" optype=\"continuous\"/>\n"
          + "  </DataDictionary>\n"
          + "  <Scorecard modelName=\"SampleScorecard\" functionName=\"regression\" useReasonCodes=\"true\" reasonCodeAlgorithm=\"pointsBelow\" initialScore=\"0\" baselineMethod=\"other\">\n"
          + "    <MiningSchema>\n"
          + "      <MiningField name=\"department\" usageType=\"active\" invalidValueTreatment=\"asMissing\"/>\n"
          + "      <MiningField name=\"age\" usageType=\"active\" invalidValueTreatment=\"asMissing\"/>\n"
          + "      <MiningField name=\"income\" usageType=\"active\" invalidValueTreatment=\"asMissing\"/>\n"
          + "      <MiningField name=\"overallScore\" usageType=\"predicted\"/>\n"
          + "    </MiningSchema>\n"
          + "    <Output>\n"
          + "      <OutputField name=\"Final Score\" feature=\"predictedValue\" dataType=\"double\" optype=\"continuous\"/>\n"
          + "      <OutputField name=\"Reason Code 1\" rank=\"1\" feature=\"reasonCode\" dataType=\"string\" optype=\"categorical\"/>\n"
          + "      <OutputField name=\"Reason Code 2\" rank=\"2\" feature=\"reasonCode\" dataType=\"string\" optype=\"categorical\"/>\n"
          + "      <OutputField name=\"Reason Code 3\" rank=\"3\" feature=\"reasonCode\" dataType=\"string\" optype=\"categorical\"/>\n"
          + "    </Output>\n"
          + "    <Characteristics>\n"
          + "      <Characteristic name=\"departmentScore\" reasonCode=\"RC1\" baselineScore=\"19\">\n"
          + "        <Attribute partialScore=\"-9\">\n"
          + "          <SimplePredicate field=\"department\" operator=\"isMissing\"/>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"19\">\n"
          + "          <SimplePredicate field=\"department\" operator=\"equal\" value=\"marketing\"/>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"3\">\n"
          + "          <SimplePredicate field=\"department\" operator=\"equal\" value=\"engineering\"/>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"6\">\n"
          + "          <SimplePredicate field=\"department\" operator=\"equal\" value=\"business\"/>\n"
          + "        </Attribute>\n"
          + "      </Characteristic>\n"
          + "      <Characteristic name=\"ageScore\" reasonCode=\"RC2\" baselineScore=\"18\">\n"
          + "        <Attribute partialScore=\"-1\">\n"
          + "          <SimplePredicate field=\"age\" operator=\"isMissing\"/>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"-3\">\n"
          + "          <SimplePredicate field=\"age\" operator=\"lessOrEqual\" value=\"18\"/>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"0\">\n"
          + "          <CompoundPredicate booleanOperator=\"and\">\n"
          + "            <SimplePredicate field=\"age\" operator=\"greaterThan\" value=\"18\"/>\n"
          + "            <SimplePredicate field=\"age\" operator=\"lessOrEqual\" value=\"29\"/>\n"
          + "          </CompoundPredicate>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"12\">\n"
          + "          <CompoundPredicate booleanOperator=\"and\">\n"
          + "            <SimplePredicate field=\"age\" operator=\"greaterThan\" value=\"29\"/>\n"
          + "            <SimplePredicate field=\"age\" operator=\"lessOrEqual\" value=\"39\"/>\n"
          + "          </CompoundPredicate>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"18\">\n"
          + "          <SimplePredicate field=\"age\" operator=\"greaterThan\" value=\"39\"/>\n"
          + "        </Attribute>\n"
          + "      </Characteristic>\n"
          + "      <Characteristic name=\"incomeScore\" reasonCode=\"RC3\" baselineScore=\"10\">\n"
          + "        <Attribute partialScore=\"5\">\n"
          + "          <SimplePredicate field=\"income\" operator=\"isMissing\"/>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"26\">\n"
          + "          <SimplePredicate field=\"income\" operator=\"lessOrEqual\" value=\"1000\"/>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"5\">\n"
          + "          <CompoundPredicate booleanOperator=\"and\">\n"
          + "            <SimplePredicate field=\"income\" operator=\"greaterThan\" value=\"1000\"/>\n"
          + "            <SimplePredicate field=\"income\" operator=\"lessOrEqual\" value=\"2500\"/>\n"
          + "          </CompoundPredicate>\n"
          + "        </Attribute>\n"
          + "        <Attribute partialScore=\"-3\">\n"
          + "          <SimplePredicate field=\"income\" operator=\"greaterThan\" value=\"2500\"/>\n"
          + "        </Attribute>\n"
          + "      </Characteristic>\n"
          + "    </Characteristics>\n"
          + "  </Scorecard>\n"
          + "</PMML>";

  PMML_XMLMapperImpl mapper = PMML_XMLMapperImpl.INSTANCE;

  private static Attribute generateAttribute() {
    Attribute attribute = new Attribute();
    attribute.setPartialScore(new Random().nextDouble());
    attribute.setReasonCode("code " + new Random().nextInt());
    attribute.setPredicate(new True());

    SimplePredicate simplePredicate = new SimplePredicate();

    attribute.setPredicate(simplePredicate);
    return attribute;
  }

  @Test
  public void testGenericObject() throws XMLStreamException {

    PMML pmml = new PMML();

    AnomalyDetectionModel anomalyDetectionModel = new AnomalyDetectionModel();
    pmml.getModel().add(anomalyDetectionModel);

    Scorecard scorecard = new Scorecard();

    Characteristics characteristics = new Characteristics();
    scorecard.setCharacteristics(characteristics);

    Characteristic characteristic = new Characteristic();
    characteristics.getCharacteristic().add(characteristic);

    characteristic.getAttribute().add(generateAttribute());
    characteristic.getAttribute().add(generateAttribute());
    characteristic.getAttribute().add(generateAttribute());
    characteristic.getAttribute().add(generateAttribute());
    characteristic.getAttribute().add(generateAttribute());
    characteristic.getAttribute().add(generateAttribute());

    pmml.getModel().add(scorecard);

    XMLSerializationContext serializationContext =
        DefaultXMLSerializationContext.builder().writeEmptyXMLArrays(false).build();

    // System.out.println("XML \n" + mapper.write(mapper.read(XML)));

    String xml = mapper.write(mapper.read(XML));

    assertNotNull(xml);
  }
}
