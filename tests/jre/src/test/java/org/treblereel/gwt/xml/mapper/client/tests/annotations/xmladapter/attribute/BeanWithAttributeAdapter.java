package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.attribute;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BeanWithAttributeAdapter extends XmlAdapter<String, AttributeObject> {

    @Override
    public AttributeObject unmarshal(String v) throws Exception {
        return new AttributeObject(v);
    }

    @Override
    public String marshal(AttributeObject v) throws Exception {
        return v.getValue();
    }
}
