package org.treblereel.gwt.jackson.api.ser.bean;

import org.treblereel.gwt.jackson.api.XMLSerializationContext;

/**
 * Contains identity informations for serialization process.
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public interface IdentitySerializationInfo<T> {

    /**
     * <p>isAlwaysAsId</p>
     *
     * @return true if we should always serialize the bean as an identifier even if it has not been seralized yet
     */
    boolean isAlwaysAsId();

    /**
     * <p>isProperty</p>
     *
     * @return true if the identifier is also a property of the bean
     */
    boolean isProperty();

    /**
     * <p>getPropertyName</p>
     *
     * @return name of the identifier property
     */
    String getPropertyName();

    /**
     * <p>getObjectId</p>
     *
     * @param bean a T object.
     * @param ctx  a {@link XMLSerializationContext} object.
     * @return a {@link ObjectIdSerializer} object.
     */
    ObjectIdSerializer<?> getObjectId(T bean, XMLSerializationContext ctx);
}
