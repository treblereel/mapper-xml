/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/5/20
 */
@XmlSchema(
        namespace = "http://www.omg.org/bpmn20",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "xsi",
                        namespaceURI = "http://www.w3.org/2001/XMLSchema-instance")
        }
)
package org.treblereel.gwt.jackson.tests.annotations.type;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;