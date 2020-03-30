package org.treblereel.gwt.jackson.api.ser.bean;

/**
 * Contains identity informations for serialization process.
 * @author Nicolas Morel
 * @version $Id: $
 */
public interface IdentitySerializationInfo<T> {

    /**
     * <p>isProperty</p>
     * @return true if the identifier is also a property of the bean
     */
    boolean isProperty();

    /**
     * <p>getPropertyName</p>
     * @return name of the identifier property
     */
    String getPropertyName();
}
