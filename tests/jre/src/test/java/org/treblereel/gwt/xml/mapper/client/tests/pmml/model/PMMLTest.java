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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.j2cl.junit.apt.J2clTestInput;
import java.util.Random;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;

/** @author Dmitrii Tikhomirov Created by treblereel 7/5/21 */
@J2clTestInput(PMMLTest.class)
public class PMMLTest {

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

    String xml = mapper.write(pmml);

    // System.out.println("? \n" + xml);

    assertNotNull(xml);
    assertNotNull(mapper.read(xml));
    assertEquals(xml, mapper.write(mapper.read(xml)));
    assertEquals(xml, mapper.write(mapper.read(mapper.write(mapper.read(xml)))));
  }
}
