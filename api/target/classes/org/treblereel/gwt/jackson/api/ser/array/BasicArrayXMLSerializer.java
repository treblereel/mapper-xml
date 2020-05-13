package org.treblereel.gwt.jackson.api.ser.array;

import org.treblereel.gwt.jackson.api.XMLSerializer;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/28/20
 */
public abstract class BasicArrayXMLSerializer<T> extends XMLSerializer<T> {

    protected String propertyName;

    public BasicArrayXMLSerializer<T> setPropertyName(String propertyName) {
        this.propertyName = propertyName;
        return this;
    }
}
