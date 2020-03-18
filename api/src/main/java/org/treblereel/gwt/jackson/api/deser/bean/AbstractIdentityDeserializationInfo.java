package org.treblereel.gwt.jackson.api.deser.bean;

import java.io.Reader;

import org.treblereel.gwt.jackson.api.ObjectIdGenerator;
import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializer;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * <p>Abstract AbstractIdentityDeserializationInfo class.</p>
 *
 * @author Nicolas Morel
 * @version $Id: $
 */
public abstract class AbstractIdentityDeserializationInfo<T, V> extends HasDeserializer<V,
        XMLDeserializer<V>> implements IdentityDeserializationInfo<T> {

    /**
     * Name of the property holding the identity
     */
    private final String propertyName;

    /**
     * Type of {@link ObjectIdGenerator} used for generating Object Id
     */
    private final Class<?> type;

    /**
     * Scope of the Object Id (may be null, to denote global)
     */
    private final Class<?> scope;

    /**
     * <p>Constructor for AbstractIdentityDeserializationInfo.</p>
     *
     * @param propertyName a {@link java.lang.String} object.
     * @param type         a {@link java.lang.Class} object.
     * @param scope        a {@link java.lang.Class} object.
     */
    protected AbstractIdentityDeserializationInfo(String propertyName, Class<?> type, Class<?> scope) {
        this.propertyName = propertyName;
        this.type = type;
        this.scope = scope;
    }

    /** {@inheritDoc} */
    @Override
    public final String getPropertyName() {
        return propertyName;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isProperty() {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public ObjectIdGenerator.IdKey newIdKey(Object id) {
        return new ObjectIdGenerator.IdKey(type, scope, id);
    }

    /** {@inheritDoc} */
    @Override
    public final Object readId(XMLReader reader, XMLDeserializationContext ctx) {
        return getDeserializer().deserialize(reader, ctx);
    }

}
