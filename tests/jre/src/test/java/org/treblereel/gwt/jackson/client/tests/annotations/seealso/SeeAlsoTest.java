package org.treblereel.gwt.jackson.client.tests.annotations.seealso;

import java.util.Objects;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.client.tests.annotations.seealso.type.SeeAlsoAnimalXsiTypeHolder;
import org.treblereel.gwt.jackson.client.tests.annotations.seealso.type.SeeAlsoAnimalXsiTypeHolder_MapperImpl;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 7/1/20
 */
@J2clTestInput(SeeAlsoTest.class)
public class SeeAlsoTest {

    private final String XML_FOO = "<?xml version='1.0' encoding='UTF-8'?><SeeAlsoHolder><first xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"First\"><test1>first</test1><test>Test1</test></first><second xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"Second\"><test2>second</test2><test>Test1</test></second></SeeAlsoHolder>";
    private final String XML_ANIMAL = "<?xml version='1.0' encoding='UTF-8'?><SeeAlsoAnimalHolder><first xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"Cat\"><nickname>Cat</nickname></first><second xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"Dog\"><nickname>Dog</nickname></second><animal><name>Animal</name></animal></SeeAlsoAnimalHolder>";
    private final String XML_XSI = "<?xml version='1.0' encoding='UTF-8'?><SeeAlsoAnimalXsiTypeHolder xmlns=\"http://www.omg.org/bpmn20\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><first xsi:type=\"Cat\"><nickname>Cat</nickname></first><second xsi:type=\"Dog\"><nickname>Dog</nickname></second><animal><name>Animal</name></animal></SeeAlsoAnimalXsiTypeHolder>";

    @org.junit.Test
    public void testFoo() throws XMLStreamException {
        final SeeAlsoTest_SeeAlsoHolder_MapperImpl mapper = SeeAlsoTest_SeeAlsoHolder_MapperImpl.INSTANCE;

        First first = new First();
        first.setTest1("first");
        first.setTest("Test1");

        Second second = new Second();
        second.setTest2("second");
        second.setTest("Test1");

        SeeAlsoHolder holder = new SeeAlsoHolder();
        holder.first = first;
        holder.second = second;

        String result = mapper.write(holder);

        System.out.println("result \n"+result);


        assertEquals(XML_FOO, result);

        assertEquals(holder, mapper.read(mapper.write(holder)));
    }

    @org.junit.Test
    public void testAnimal() throws XMLStreamException {
        final SeeAlsoTest_SeeAlsoAnimalHolder_MapperImpl mapper = SeeAlsoTest_SeeAlsoAnimalHolder_MapperImpl.INSTANCE;
        final Animal_MapperImpl mapperAnimal = Animal_MapperImpl.INSTANCE;

        Animal animal = new Animal();
        animal.setName("Animal");

        Cat cat = new Cat();
        cat.setNickname("Cat");

        Dog dog = new Dog();
        dog.setNickname("Dog");

        SeeAlsoAnimalHolder holder = new SeeAlsoAnimalHolder();
        holder.first = cat;
        holder.second = dog;
        holder.animal = animal;

        String result = mapper.write(holder);
        assertEquals(XML_ANIMAL, result);
        assertEquals(holder, mapper.read(mapper.write(holder)));
        assertEquals("<?xml version='1.0' encoding='UTF-8'?><Animal><name>Animal</name></Animal>", mapperAnimal.write(animal));
        assertEquals(animal, mapperAnimal.read(mapperAnimal.write(animal)));
    }

    @org.junit.Test
    public void testSeeAlsoAnimalXsiTypeHolder() throws XMLStreamException {
        final SeeAlsoAnimalXsiTypeHolder_MapperImpl mapper = SeeAlsoAnimalXsiTypeHolder_MapperImpl.INSTANCE;

        Animal animal = new Animal();
        animal.setName("Animal");

        Cat cat = new Cat();
        cat.setNickname("Cat");

        Dog dog = new Dog();
        dog.setNickname("Dog");

        SeeAlsoAnimalXsiTypeHolder holder = new SeeAlsoAnimalXsiTypeHolder();
        holder.setFirst(cat);
        holder.setSecond(dog);
        holder.setAnimal(animal);

        String result = mapper.write(holder);

        assertEquals(XML_XSI, result);
        assertEquals(holder, mapper.read(mapper.write(holder)));
    }

    @XMLMapper
    public static class SeeAlsoHolder {

        private Foo first;
        private Foo second;

        public Foo getFirst() {
            return first;
        }

        public void setFirst(Foo first) {
            this.first = first;
        }

        public Foo getSecond() {
            return second;
        }

        public void setSecond(Foo second) {
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof SeeAlsoHolder)) {
                return false;
            }
            SeeAlsoHolder holder = (SeeAlsoHolder) o;
            return Objects.equals(getFirst(), holder.getFirst()) &&
                    Objects.equals(getSecond(), holder.getSecond());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getFirst(), getSecond());
        }
    }

    @XMLMapper
    public static class SeeAlsoAnimalHolder {

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
            if (!(o instanceof SeeAlsoAnimalHolder)) {
                return false;
            }
            SeeAlsoAnimalHolder that = (SeeAlsoAnimalHolder) o;
            return Objects.equals(getFirst(), that.getFirst()) &&
                    Objects.equals(getSecond(), that.getSecond()) &&
                    Objects.equals(getAnimal(), that.getAnimal());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getFirst(), getSecond(), getAnimal());
        }
    }
}
