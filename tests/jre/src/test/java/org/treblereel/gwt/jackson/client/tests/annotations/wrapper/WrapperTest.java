/*
 * Copyright © 2020 Treblereel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.treblereel.gwt.jackson.client.tests.annotations.wrapper;

import static org.junit.Assert.assertEquals;

import com.google.j2cl.junit.apt.J2clTestInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/** @author Dmitrii Tikhomirov Created by treblereel 7/1/20 */
@J2clTestInput(WrapperTest.class)
public class WrapperTest {

  WrapperTest_Foo_MapperImpl mapper = WrapperTest_Foo_MapperImpl.INSTANCE;

  private static final String XML =
      "<?xml version='1.0' encoding='UTF-8'?><my-foo><stuff><stuff><stuff><name>AAAA</name></stuff><stuff><name>BBBB</name></stuff><stuff><name>CCCC</name></stuff></stuff></stuff><wrapper><stuff2><stuff2><name>AAAA</name></stuff2><stuff2><name>BBBB</name></stuff2><stuff2><name>CCCC</name></stuff2></stuff2></wrapper><wrapper_root><Root><test>ROOT</test></Root></wrapper_root></my-foo>";

  @Test
  public void testDeserializeValue() throws XMLStreamException {
    Foo test = new Foo();
    test.setRoot(new Root("ROOT"));

    List<Child> children = new ArrayList<>();
    children.add(new Child("AAAA"));
    children.add(new Child("BBBB"));
    children.add(new Child("CCCC"));
    test.setStuff(children);
    test.setStuff2(children);

    assertEquals(XML, mapper.write(test));
    assertEquals(test, mapper.read(mapper.write(test)));
  }

  @XMLMapper
  @XmlRootElement(name = "my-foo")
  public static class Foo {

    @XmlElementWrapper private List<Child> stuff;

    @XmlElementWrapper(name = "wrapper")
    private List<Child> stuff2;

    @XmlElementWrapper(name = "wrapper_root")
    private Root root;

    @Override
    public int hashCode() {
      return Objects.hash(getStuff(), getStuff2(), getRoot());
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Foo)) {
        return false;
      }
      Foo foo = (Foo) o;
      return Objects.equals(getStuff(), foo.getStuff())
          && Objects.equals(getStuff2(), foo.getStuff2())
          && Objects.equals(getRoot(), foo.getRoot());
    }

    public List<Child> getStuff() {
      return stuff;
    }

    public void setStuff(List<Child> stuff) {
      this.stuff = stuff;
    }

    public List<Child> getStuff2() {
      return stuff2;
    }

    public void setStuff2(List<Child> stuff2) {
      this.stuff2 = stuff2;
    }

    public Root getRoot() {
      return root;
    }

    public void setRoot(Root root) {
      this.root = root;
    }
  }

  @XmlRootElement
  public static class Child {

    private String name;

    public Child() {}

    public Child(String name) {
      this.name = name;
    }

    @Override
    public int hashCode() {
      return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Child)) {
        return false;
      }
      Child child = (Child) o;
      return Objects.equals(getName(), child.getName());
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  @XmlType(
      name = "ZZZZ2",
      namespace = "ololo.org",
      propOrder = {"test"})
  public static class Root {

    private String test;

    public Root() {}

    public Root(String test) {
      this.test = test;
    }

    @Override
    public int hashCode() {
      return Objects.hash(getTest());
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Root)) {
        return false;
      }
      Root root = (Root) o;
      return Objects.equals(getTest(), root.getTest());
    }

    public String getTest() {
      return test;
    }

    public void setTest(String test) {
      this.test = test;
    }
  }
}
