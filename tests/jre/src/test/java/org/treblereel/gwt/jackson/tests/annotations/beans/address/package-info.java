/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/5/20
 */
@XmlSchema(
        namespace = "address",
        elementFormDefault = XmlNsForm.QUALIFIED,
        location = "http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd http://www.jboss.org/drools drools.xsd http://www.bpsim.org/schemas/1.0 bpsim.xsd http://www.omg.org/spec/DD/20100524/DC DC.xsd http://www.omg.org/spec/DD/20100524/DI DI.xsd"
)
package org.treblereel.gwt.jackson.tests.annotations.beans.address;

import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;