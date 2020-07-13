/*
 * Copyright © 2020 Treblereel
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
package org.treblereel.gwt.jackson.client.tests.bpmn.bpmn2;

import static org.junit.Assert.assertEquals;

import com.google.j2cl.junit.apt.J2clTestInput;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.DefaultXMLDeserializationContext;
import org.treblereel.gwt.jackson.api.DefaultXMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;
import org.treblereel.gwt.jackson.client.tests.bpmn.bpmn.dc.Bounds;
import org.treblereel.gwt.jackson.client.tests.bpmn.bpmn.di.BPMNDiagram;
import org.treblereel.gwt.jackson.client.tests.bpmn.bpmn.di.BPMNPlane;
import org.treblereel.gwt.jackson.client.tests.bpmn.bpmn.di.BPMNShape;
import org.treblereel.gwt.jackson.client.tests.bpmn.drools.MetaData;

/** @author Dmitrii Tikhomirov Created by treblereel 4/6/20 */
@J2clTestInput(BPMNTest.class)
public class BPMNTest {

  Definitions_MapperImpl mapper = Definitions_MapperImpl.INSTANCE;

  @Test
  public void test() throws XMLStreamException {

    String expected =
        "<?xml version='1.0' encoding='UTF-8'?><bpmn2:definitions xmlns=\"http://www.omg.org/bpmn20\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:bpsim=\"http://www.bpsim.org/schemas/1.0\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:drools=\"http://www.jboss.org/drools\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd http://www.jboss.org/drools drools.xsd http://www.bpsim.org/schemas/1.0 bpsim.xsd http://www.omg.org/spec/DD/20100524/DC DC.xsd http://www.omg.org/spec/DD/20100524/DI DI.xsd\" targetNamespace=\"http://www.omg.org/bpmn20\" id=\"ad04f8e4-9ac1-11ea-bb37-0242ac130002\" exporter=\"jBPM Process Modeler\" exporterVersion=\"2.0\"><itemDefinitions><bpmn2:itemDefinitions id=\"_DataObjectItem\" structureRef=\"String\"/></itemDefinitions><bpmn2:process id=\"twdo.twodosubprocess\" name=\"twodosubprocess\" isExecutable=\"true\" drools:packageName=\"com.myspace.twdo\" drools:version=\"1.0\" drools:adHoc=\"false\"><subProcesses><bpmn2:subProcesses id=\"_7503B170-81DB-47F5-BAF3-F67957B95DF7\" name=\"Event Sub-process\" triggeredByEvent=\"true\"><extensionElements><drools:extensionElements name=\"elementname\"><metaValue><![CDATA[Event Sub-process]]></metaValue></drools:extensionElements></extensionElements><dataObjectReference/></bpmn2:subProcesses></subProcesses><dataObjects><bpmn2:dataObjects id=\"DataObject\" name=\"DataObject\" itemSubjectRef=\"_DataObjectItem\"/></dataObjects><dataObjectReferences><bpmn2:dataObjectReferences id=\"_D7D714AE-A0C9-4A33-89C1-25300898967E\" dataObjectRef=\"DataObject\"/></dataObjectReferences></bpmn2:process><bpmndi:BPMNDiagram id=\"_QB3JgVY5Eeq0CdSiRkduQA\"><planes><bpmndi:planes id=\"_QB3JglY5Eeq0CdSiRkduQA\" bpmnElement=\"twdo.twodosubprocess\"><shapes><bpmndi:shapes id=\"shape__7503B170-81DB-47F5-BAF3-F67957B95DF7\" bpmnElement=\"_7503B170-81DB-47F5-BAF3-F67957B95DF7\" isExpanded=\"true\"><dc:bounds height=\"253.0\" width=\"653.0\" x=\"488.0\" y=\"210.0\"/></bpmndi:shapes></shapes></bpmndi:planes></planes></bpmndi:BPMNDiagram></bpmn2:definitions>";

    Definitions tested = new Definitions();
    tested.setId("ad04f8e4-9ac1-11ea-bb37-0242ac130002");
    tested.setExporter("jBPM Process Modeler");
    tested.setExporterVersion("2.0");

    ItemDefinition itemDefinition = new ItemDefinition();
    itemDefinition.setId("_DataObjectItem");
    itemDefinition.setStructureRef("String");
    tested.getItemDefinitions().add(itemDefinition);

    Process process = new Process();
    process.setId("twdo.twodosubprocess");
    process.setName("twodosubprocess");
    process.setPackageName("com.myspace.twdo");
    process.setAdHoc(false);
    process.setVersion("1.0");
    process.setExecutable(true);

    SubProcess subProcess = new SubProcess();
    subProcess.setId("_7503B170-81DB-47F5-BAF3-F67957B95DF7");
    subProcess.setName("Event Sub-process");
    subProcess.setTriggeredByEvent(true);

    process.getSubProcesses().add(subProcess);

    MetaData meta = new MetaData();
    meta.setName("elementname");
    meta.setMetaValue("Event Sub-process");
    subProcess.getExtensionElements().add(meta);

    tested.setProcess(process);

    DataObject dataObject = new DataObject();
    dataObject.setId("DataObject");
    dataObject.setName("DataObject");
    dataObject.setItemSubjectRef("_DataObjectItem");
    process.getDataObjects().add(dataObject);

    DataObjectReference dataObjectReference = new DataObjectReference();
    dataObjectReference.setId("_D7D714AE-A0C9-4A33-89C1-25300898967E");
    dataObjectReference.setDataObjectRef(dataObject);
    process.getDataObjectReferences().add(dataObjectReference);

    BPMNDiagram diagram = new BPMNDiagram();
    diagram.setId("_QB3JgVY5Eeq0CdSiRkduQA");
    tested.setBpmnDiagram(diagram);

    BPMNPlane plane = new BPMNPlane();
    plane.setId("_QB3JglY5Eeq0CdSiRkduQA");
    plane.setBpmnElement("twdo.twodosubprocess");
    diagram.getPlanes().add(plane);

    BPMNShape shape = new BPMNShape();
    shape.setId("shape__7503B170-81DB-47F5-BAF3-F67957B95DF7");
    shape.setBpmnElement("_7503B170-81DB-47F5-BAF3-F67957B95DF7");
    shape.setExpanded(true);
    plane.getShapes().add(shape);

    Bounds bounds = new Bounds();
    bounds.setHeight(253.0);
    bounds.setWidth(653.0);
    bounds.setX(488.0);
    bounds.setY(210.0);
    shape.setBounds(bounds);

    String xml = mapper.write(tested);

    assertEquals(expected, xml); // works in a browser. fails in htmlunit
    Definitions encoded = mapper.read(xml);
    assertEquals(xml, mapper.write(encoded));
    assertEquals(tested, mapper.read(mapper.write(encoded)));
  }

  @Test
  public void testUnwrappedCollections() throws XMLStreamException {
    XMLSerializationContext serializationContext =
        DefaultXMLSerializationContext.builder().wrapCollections(false).build();

    XMLDeserializationContext deserializationContext =
        DefaultXMLDeserializationContext.builder().wrapCollections(false).build();

    Definitions definition = new Definitions();

    List<ItemDefinition> itemDefinitionList = new ArrayList<>();
    definition.setItemDefinitions(itemDefinitionList);

    ItemDefinition itemDefinition = new ItemDefinition();
    itemDefinition.setId("_DataObjectItem");
    itemDefinition.setStructureRef("String");
    definition.getItemDefinitions().add(itemDefinition);

    itemDefinition = new ItemDefinition();
    itemDefinition.setId("_DataObjectItem_1");
    itemDefinition.setStructureRef("String_1");
    definition.getItemDefinitions().add(itemDefinition);

    Definitions_MapperImpl mapper = new Definitions_MapperImpl();
    String xml = mapper.write(definition, serializationContext);
    Definitions result =
        mapper.read(mapper.write(definition, serializationContext), deserializationContext);
    assertEquals(definition, result);
    assertEquals(
        xml,
        mapper.write(
            mapper.read(mapper.write(result, serializationContext), deserializationContext),
            serializationContext));
    assertEquals(
        xml,
        mapper.write(
            mapper.read(mapper.write(result, serializationContext), deserializationContext),
            serializationContext));
  }
}
