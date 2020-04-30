/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/5/20
 */
@XmlSchema(
        namespace = "http://www.omg.org/bpmn20",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "ci",
                        namespaceURI = "http://www.ci"),
                @XmlNs(prefix = "cl",
                        namespaceURI = "http://www.cl")
        }
)
package org.treblereel.gwt.jackson.tests.annotations.namespace.ci;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;