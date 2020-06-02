package org.treblereel.gwt.jackson.client.tests.annotations.handler;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XmlTypeAdapter;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 5/19/20
 */
@XmlTypeAdapter(
        serializer = IdMarshaller.class,
        deserializer = IdDemarshaller.class,
        isAttribute = true
)
public class Id {

    private String id;

    public Id() {

    }

    public Id(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Id)) {
            return false;
        }
        Id id1 = (Id) o;
        return Objects.equals(getId(), id1.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
