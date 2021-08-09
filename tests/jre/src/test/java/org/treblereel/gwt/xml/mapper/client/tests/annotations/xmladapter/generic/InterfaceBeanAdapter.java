package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.generic;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class InterfaceBeanAdapter extends XmlAdapter<BeanModel, Bean> {

    @Override
    public Bean unmarshal(BeanModel model) throws Exception {
        return new Bean(model);
    }

    @Override
    public BeanModel marshal(Bean bean) throws Exception {
        return new BeanModel(bean);
    }
}
