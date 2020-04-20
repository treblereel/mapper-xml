package org.bpmn2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.bpmn.dc.Bounds;
import org.bpmn.di.BPMNDiagram;
import org.bpmn.di.BPMNPlane;
import org.bpmn.di.BPMNShape;
import org.drools.MetaData;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.DefaultXMLDeserializationContext;
import org.treblereel.gwt.jackson.api.DefaultXMLSerializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLSerializationContext;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
@J2clTestInput(BPMNTest.class)
public class BPMNTest {

    Definitions_MapperImpl mapper = Definitions_MapperImpl.INSTANCE;

    @Test
    public void test() throws XMLStreamException {

        Definitions tested = new Definitions();
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
        Definitions encoded = mapper.read(xml);
        assertEquals(xml, mapper.write(encoded));
        assertEquals(tested, mapper.read(mapper.write(encoded)));
    }

    @Test
    public void testUnwrappedCollections() throws XMLStreamException {
        XMLSerializationContext serializationContext = DefaultXMLSerializationContext.builder()
                .wrapCollections(false)
                .build();

        XMLDeserializationContext deserializationContext = DefaultXMLDeserializationContext.builder()
                .wrapCollections(false)
                .build();

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
        Definitions result = mapper.read(mapper.write(definition,
                                                      serializationContext),
                                         deserializationContext);
        assertEquals(definition, result);
        assertEquals(xml, mapper.write(mapper.read(mapper.write(result, serializationContext), deserializationContext), serializationContext));
        assertEquals(xml, mapper.write(mapper.read(mapper.write(result, serializationContext), deserializationContext), serializationContext));
    }
}
