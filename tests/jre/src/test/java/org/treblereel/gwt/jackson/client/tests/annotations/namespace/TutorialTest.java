package org.treblereel.gwt.jackson.client.tests.annotations.namespace;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;
import org.treblereel.gwt.jackson.client.tests.annotations.namespace.ci.Tutorial;
import org.treblereel.gwt.jackson.client.tests.annotations.namespace.ci.Tutorial_MapperImpl;
import org.treblereel.gwt.jackson.client.tests.annotations.namespace.cl.Name;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/28/20
 */
@J2clTestInput(TutorialTest.class)
public class TutorialTest {
    Tutorial_MapperImpl mapper = Tutorial_MapperImpl.INSTANCE;

    @Test
    public void test() throws XMLStreamException {
        Tutorial tutorial = new Tutorial();
        Name name1 = new Name("NAME");
        List<Name> names = new ArrayList<>();
        tutorial.setNames(names);
        names.add(name1);

        String xml = mapper.write(tutorial);

        assertEquals("<?xml version='1.0' encoding='UTF-8'?><ci:_tutorial xmlns=\"http://www.omg.org/bpmn20\" xmlns:ci=\"http://www.ci\" xmlns:cl=\"http://www.cl\"><id>0</id><names><cl:names><name>NAME</name></cl:names></names></ci:_tutorial>", xml);
        assertEquals(tutorial, mapper.read(xml));
    }

}
