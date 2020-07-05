package org.treblereel.gwt.jackson.client.tests.annotations.seealso.type;

import java.util.Objects;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.client.tests.annotations.seealso.Animal;
import org.treblereel.gwt.jackson.client.tests.annotations.seealso.SeeAlsoTest;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 7/3/20
 */
@XMLMapper
public class SeeAlsoAnimalXsiTypeHolder {

    private Animal first;
    private Animal second;
    private Animal animal;

    public Animal getFirst() {
        return first;
    }

    public void setFirst(Animal first) {
        this.first = first;
    }

    public Animal getSecond() {
        return second;
    }

    public void setSecond(Animal second) {
        this.second = second;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SeeAlsoAnimalXsiTypeHolder)) {
            return false;
        }
        SeeAlsoAnimalXsiTypeHolder that = (SeeAlsoAnimalXsiTypeHolder) o;
        return Objects.equals(getFirst(), that.getFirst()) &&
                Objects.equals(getSecond(), that.getSecond()) &&
                Objects.equals(getAnimal(), that.getAnimal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond(), getAnimal());
    }
}