/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/5/20
 */
@XmlSchema(
        namespace = "http://www.omg.org/bpmn20",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "xsi",
                        namespaceURI = "http://www.w3.org/2001/XMLSchema-instance"),

                @XmlNs(prefix = "bpmn2",
                        namespaceURI = "http://www.omg.org/spec/BPMN/20100524/MODEL"),
                @XmlNs(prefix = "bpmndi",
                        namespaceURI = "http://www.omg.org/spec/BPMN/20100524/DI"),
                @XmlNs(prefix = "bpsim",
                        namespaceURI = "http://www.bpsim.org/schemas/1.0"),
                @XmlNs(prefix = "dc",
                        namespaceURI = "http://www.omg.org/spec/DD/20100524/DC"),
                @XmlNs(prefix = "drools",
                        namespaceURI = "http://www.jboss.org/drools")
        },
        location = "http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd http://www.jboss.org/drools drools.xsd http://www.bpsim.org/schemas/1.0 bpsim.xsd http://www.omg.org/spec/DD/20100524/DC DC.xsd http://www.omg.org/spec/DD/20100524/DI DI.xsd"
)
//<bpmn2:definitions xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        // xmlns="http://www.omg.org/bpmn20" xmlns:bpmn2="http://www.omg.org/spec/BPMN/20100524/MODEL"
        // xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI"
        // xmlns:bpsim="http://www.bpsim.org/schemas/1.0"
        // xmlns:dc="http://www.omg.org/spec/DD/20100524/DC"
        // xmlns:drools="http://www.jboss.org/drools" id="_QB3JgFY5Eeq0CdSiRkduQA"
        // xsi:schemaLocation="http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd http://www.jboss.org/drools drools.xsd http://www.bpsim.org/schemas/1.0 bpsim.xsd http://www.omg.org/spec/DD/20100524/DC DC.xsd http://www.omg.org/spec/DD/20100524/DI DI.xsd "
        // exporter="jBPM Process Modeler" exporterVersion="2.0" targetNamespace="http://www.omg.org/bpmn20">
        package org.treblereel.gwt.jackson.tests.annotations.beans;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;