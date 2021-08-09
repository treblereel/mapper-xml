package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.generic;

public class ValueInterfaceImplementation implements ValueInterface {

    private String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
