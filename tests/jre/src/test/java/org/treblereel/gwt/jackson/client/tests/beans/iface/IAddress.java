package org.treblereel.gwt.jackson.client.tests.beans.iface;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.api.annotation.XmlSubtypes;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/13/20
 */
@XmlSubtypes(
        @XmlSubtypes.Type(Address.class)
)
@XMLMapper
public interface IAddress {

    String getAddress();

    void setAddress(String address);
}
