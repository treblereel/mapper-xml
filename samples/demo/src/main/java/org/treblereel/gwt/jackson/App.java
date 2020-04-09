package org.treblereel.gwt.jackson;

import javax.xml.stream.XMLStreamException;

import com.google.gwt.core.client.EntryPoint;
import elemental2.dom.CSSProperties;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLLabelElement;
import elemental2.dom.HTMLTextAreaElement;
import org.treblereel.gwt.jackson.bpmn.dc.Bounds;
import org.treblereel.gwt.jackson.bpmn.di.BPMNDiagram;
import org.treblereel.gwt.jackson.bpmn.di.BPMNPlane;
import org.treblereel.gwt.jackson.bpmn.di.BPMNShape;
import org.treblereel.gwt.jackson.bpmn2.DataObject;
import org.treblereel.gwt.jackson.bpmn2.DataObjectReference;
import org.treblereel.gwt.jackson.bpmn2.Definitions;
import org.treblereel.gwt.jackson.bpmn2.Definitions_MapperImpl;
import org.treblereel.gwt.jackson.bpmn2.ItemDefinition;
import org.treblereel.gwt.jackson.bpmn2.Process;
import org.treblereel.gwt.jackson.bpmn2.SubProcess;
import org.treblereel.gwt.jackson.drools.MetaData;

public class App implements EntryPoint {

    public static final String HELLO_WORLD = "Hello J2CL world!";

    Definitions_MapperImpl mapper = Definitions_MapperImpl.INSTANCE;

    private HTMLTextAreaElement generatedXML = (HTMLTextAreaElement) DomGlobal.document.createElement("textarea");

    private HTMLTextAreaElement generatedPOJO = (HTMLTextAreaElement) DomGlobal.document.createElement("textarea");

    @Override
    public void onModuleLoad() {
        HTMLLabelElement label1 = (HTMLLabelElement) DomGlobal.document.createElement("label");
        label1.textContent = "Pojo to XML";
        DomGlobal.document.body.appendChild(label1);
        DomGlobal.document.body.appendChild(DomGlobal.document.createElement("br"));

        DomGlobal.document.body.appendChild(generatedXML);
        generatedXML.classList.add("prettyprint", "lang-html");
        generatedXML.style.height = CSSProperties.HeightUnionType.of("20pc");
        generatedXML.style.width = CSSProperties.WidthUnionType.of("700px");
        generatedXML.style.overflow = "scroll";

        DomGlobal.document.body.appendChild(DomGlobal.document.createElement("br"));

        HTMLLabelElement label2 = (HTMLLabelElement) DomGlobal.document.createElement("label");
        label2.textContent = "... and back to Pojo";
        DomGlobal.document.body.appendChild(label2);
        DomGlobal.document.body.appendChild(DomGlobal.document.createElement("br"));

        DomGlobal.document.body.appendChild(generatedPOJO);
        generatedPOJO.classList.add("prettyprint", "lang-html");
        generatedPOJO.style.height = CSSProperties.HeightUnionType.of("20pc");
        generatedPOJO.style.width = CSSProperties.WidthUnionType.of("700px");
        generatedPOJO.style.overflow = "scroll";

        try {
            ser();
        } catch (XMLStreamException ex) {
            DomGlobal.console.log(ex);
        }
    }


    private void ser() throws XMLStreamException {
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

        generatedXML.value = xml;

        generatedPOJO.value = mapper.read(xml).toString();
    }

    String helloWorldString() {
        return HELLO_WORLD;
    }
}
