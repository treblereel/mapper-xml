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

package org.treblereel.gwt.jackson.client.tests.generics;

import static org.junit.Assert.assertEquals;

import com.google.j2cl.junit.apt.J2clTestInput;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

@J2clTestInput(GenericTypesMapperTest.class)
public class GenericTypesMapperTest {

  private static final String GENERICMAPPERWITHSTRING_XML =
      "<?xml version='1.0' encoding='UTF-8'?><GenericMapperWithString><intField>11</intField><typeField>String test</typeField><genericArr><genericArr><genericArr>hi</genericArr><genericArr>there</genericArr></genericArr><genericArr><genericArr>my</genericArr><genericArr>name</genericArr><genericArr>is</genericArr><genericArr>gwt-jackson-apt</genericArr></genericArr></genericArr><str>str</str></GenericMapperWithString>";
  private static final String GENERICMAPPERWITHINTEGER_XML =
      "<?xml version='1.0' encoding='UTF-8'?><GenericMapperWithInteger><intField>201</intField><typeField>42</typeField><genericArr><genericArr><genericArr>101</genericArr><genericArr>202</genericArr></genericArr></genericArr><str>str</str></GenericMapperWithInteger>";
  private static final String GENERICMAPPERWITHLISTOFINTEGER_XML =
      "<?xml version='1.0' encoding='UTF-8'?><GenericMapperWithListOfInteger><intField>201</intField><typeField><typeField>1</typeField><typeField>3</typeField><typeField>5</typeField></typeField><genericArr><genericArr><genericArr><genericArr>1</genericArr><genericArr>2</genericArr></genericArr><genericArr><genericArr>10</genericArr><genericArr>20</genericArr></genericArr></genericArr><genericArr><genericArr><genericArr>1122</genericArr><genericArr>2211</genericArr></genericArr></genericArr></genericArr><str>str</str></GenericMapperWithListOfInteger>";
  private static final String CHILDOFGENERICMAPPER_XML =
      "<?xml version='1.0' encoding='UTF-8'?><ChildOfGenericMapper><subField>field in child class</subField><intField>201</intField><typeField>generic type field</typeField><str>string field</str></ChildOfGenericMapper>";
  private static final String GENERICHILDOFGENERICOBJECTMAPPER_XML =
      "<?xml version='1.0' encoding='UTF-8'?><GenericChildOfGenericMapper><subField>generic child field</subField><genericMap><entry><key>key</key><value><value>1</value><value>2</value><value>3</value></value></entry></genericMap><intField>11</intField><typeField>2012</typeField><str>string field</str></GenericChildOfGenericMapper>";
  GenericTypesMapperTest_GenericMapperWithString_MapperImpl GENERICMAPPERWITHSTRING =
      GenericTypesMapperTest_GenericMapperWithString_MapperImpl.INSTANCE;
  GenericTypesMapperTest_GenericMapperWithInteger_MapperImpl GENERICMAPPERWITHINTEGER =
      GenericTypesMapperTest_GenericMapperWithInteger_MapperImpl.INSTANCE;
  GenericTypesMapperTest_GenericMapperWithListOfInteger_MapperImpl GENERICMAPPERWITHLISTOFINTEGER =
      GenericTypesMapperTest_GenericMapperWithListOfInteger_MapperImpl.INSTANCE;
  GenericTypesMapperTest_ChildOfGenericMapper_MapperImpl CHILDOFGENERICMAPPER =
      GenericTypesMapperTest_ChildOfGenericMapper_MapperImpl.INSTANCE;
  GenericTypesMapperTest_GenericChildOfGenericMapper_MapperImpl GENERICHILDOFGENERICOBJECTMAPPER =
      GenericTypesMapperTest_GenericChildOfGenericMapper_MapperImpl.INSTANCE;

  @Test
  public void testGenericObject() throws XMLStreamException {
    GenericMapperWithString genericWithString = new GenericMapperWithString();
    genericWithString.intField = 11;
    genericWithString.typeField = "String test";
    genericWithString.genericArr = (List<String>[]) Array.newInstance(List.class, 2);
    genericWithString.genericArr[0] = Arrays.asList("hi", "there");
    genericWithString.genericArr[1] = Arrays.asList("my", "name", "is", "gwt-jackson-apt");

    assertEquals(GENERICMAPPERWITHSTRING_XML, GENERICMAPPERWITHSTRING.write(genericWithString));

    assertEquals(genericWithString, GENERICMAPPERWITHSTRING.read(GENERICMAPPERWITHSTRING_XML));

    GenericMapperWithInteger genericWithInteger = new GenericMapperWithInteger();
    genericWithInteger.intField = 201;
    genericWithInteger.typeField = 42;
    genericWithInteger.genericArr = (List<Integer>[]) Array.newInstance(List.class, 1);
    genericWithInteger.genericArr[0] = Arrays.asList(101, 202);

    assertEquals(GENERICMAPPERWITHINTEGER_XML, GENERICMAPPERWITHINTEGER.write(genericWithInteger));
    assertEquals(genericWithInteger, GENERICMAPPERWITHINTEGER.read(GENERICMAPPERWITHINTEGER_XML));
  }

  @Test
  public void testGenericObjectWithCollection() throws XMLStreamException {
    GenericMapperWithListOfInteger genericListOfInteger = new GenericMapperWithListOfInteger();
    genericListOfInteger.intField = 201;
    genericListOfInteger.typeField = Arrays.asList(1, 3, 5);
    genericListOfInteger.genericArr = (List<List<Integer>>[]) Array.newInstance(List.class, 2);
    genericListOfInteger.genericArr[0] = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(10, 20));
    genericListOfInteger.genericArr[1] = Arrays.asList(Arrays.asList(1122, 2211));

    assertEquals(
        GENERICMAPPERWITHLISTOFINTEGER_XML,
        GENERICMAPPERWITHLISTOFINTEGER.write(genericListOfInteger));

    assertEquals(
        genericListOfInteger,
        GENERICMAPPERWITHLISTOFINTEGER.read(GENERICMAPPERWITHLISTOFINTEGER_XML));
  }

  @Test
  public void testGenericObjectWithInheritance() throws XMLStreamException {
    ChildOfGenericMapper childOfGenericObjectWithString = new ChildOfGenericMapper();
    childOfGenericObjectWithString.intField = 201;
    childOfGenericObjectWithString.typeField = "generic type field";
    childOfGenericObjectWithString.str = "string field";
    childOfGenericObjectWithString.subField = "field in child class";

    assertEquals(
        CHILDOFGENERICMAPPER_XML, CHILDOFGENERICMAPPER.write(childOfGenericObjectWithString));
    assertEquals(
        childOfGenericObjectWithString, CHILDOFGENERICMAPPER.read(CHILDOFGENERICMAPPER_XML));
  }

  @Test
  public void testGenericChildOfGenericObjectInheritance() throws XMLStreamException {
    GenericChildOfGenericMapper object = new GenericChildOfGenericMapper();
    object.intField = 11;
    object.subField = "generic child field";
    object.typeField = 2012;
    object.str = "string field";
    object.genericMap = new HashMap<>();
    object.genericMap.put("key", Arrays.asList(1, 2, 3));

    System.out.println("XML \n " + GENERICHILDOFGENERICOBJECTMAPPER.write(object));

    assertEquals(
        GENERICHILDOFGENERICOBJECTMAPPER_XML, GENERICHILDOFGENERICOBJECTMAPPER.write(object));
    assertEquals(
        object,
        GENERICHILDOFGENERICOBJECTMAPPER.read(GENERICHILDOFGENERICOBJECTMAPPER.write(object)));
  }

  @XMLMapper
  static class GenericMapperWithString extends SimpleGenericBeanObject<String> {}

  @XMLMapper
  static class GenericMapperWithInteger extends SimpleGenericBeanObject<Integer> {}

  @XMLMapper
  static class GenericMapperWithListOfInteger extends SimpleGenericBeanObject<List<Integer>> {}

  @XMLMapper
  static class ChildOfGenericMapper extends ChildOfGenericObject {}

  @XMLMapper
  static class GenericChildOfGenericMapper extends GenericChildOfGenericObject<String, Integer> {}
}
