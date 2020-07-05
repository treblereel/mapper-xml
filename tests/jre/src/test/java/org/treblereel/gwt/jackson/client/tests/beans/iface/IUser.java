package org.treblereel.gwt.jackson.client.tests.beans.iface;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.api.annotation.XmlSubtypes;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/13/20
 */
@XmlSubtypes({
        @XmlSubtypes.Type(User.class)
})
//@XMLMapper
public interface IUser {

    String getUser();

    void setUser(String name);

    IAddress getIAddress();

    void setIAddress(IAddress address);
}
