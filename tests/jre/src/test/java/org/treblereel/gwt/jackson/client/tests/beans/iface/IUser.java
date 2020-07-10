package org.treblereel.gwt.jackson.client.tests.beans.iface;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/13/20
 */
public interface IUser {

    String getUser();

    void setUser(String name);

    IAddress getIAddress();

    void setIAddress(IAddress address);
}
