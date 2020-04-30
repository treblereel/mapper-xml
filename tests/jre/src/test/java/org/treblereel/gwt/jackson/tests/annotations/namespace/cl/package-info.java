/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/5/20
 */
@XmlSchema(
        namespace = "http://www.cl",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "ci",
                        namespaceURI = "http://www.ci"),
                @XmlNs(prefix = "cl",
                        namespaceURI = "http://www.cl")
        }
)
package org.treblereel.gwt.jackson.tests.annotations.namespace.cl;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;