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
package org.treblereel.gwt.xml.mapper;

import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import org.treblereel.gwt.xml.mapper.client.tests.RemoveWhitespaceTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.TransientBeanTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.XmlRootElementTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.accessortype.CustomerTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.cdata.UserCdataTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.cdata.ValueTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.cdata.XmlValueHolderTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.collection.ArrayAndListWrapTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.collection.DataHolderTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.handler.BeanTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.namespace.test1.TutorialTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.namespace.test2.NamespaceTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.namespace.test3.NamespaceTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.namespace.test4.NamespaceTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.seealso.SeeAlsoTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.type.CustomerTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.type.XsiTypeTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.wrapper.WrapperTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmlaccesstype.field.CustomerTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.MyTestBeanTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.attribute.AttributeAdapterTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.collection.BeanWithCollectionTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.generic.AdapterForInterfaceTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.pkg.MyTestBeanTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmlelementref.TargetTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmlelementref.interfaces.ITaskTest;
import org.treblereel.gwt.xml.mapper.client.tests.annotations.xmlvalue.EventTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.BoxedArraysTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.CollectionTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.PrimitiveArraysTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.dd.BooleanArray2dTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.dd.ByteArray2dTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.dd.DoubleArray2dTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.dd.FloatArray2dTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.dd.IntegerArray2dTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.dd.LongArray2dTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.dd.ShortArray2dTest;
import org.treblereel.gwt.xml.mapper.client.tests.arrays.dd.StringArray2dTest;
import org.treblereel.gwt.xml.mapper.client.tests.beans.EnumTest;
import org.treblereel.gwt.xml.mapper.client.tests.beans.FailOnUnknownPropertiesTest;
import org.treblereel.gwt.xml.mapper.client.tests.beans.UUIDTest;
import org.treblereel.gwt.xml.mapper.client.tests.beans.company.XmlRootElementTest;
import org.treblereel.gwt.xml.mapper.client.tests.beans.iface.IfaceBeanTest;
import org.treblereel.gwt.xml.mapper.client.tests.beans.inheritance.InheritanceTest;
import org.treblereel.gwt.xml.mapper.client.tests.beans.scope.ProtectedBeanTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.BigDecimalTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.BigIntegerTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.BooleanBoxedTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.BooleanTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.ByteBoxedTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.DoubleBoxedTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.FloatBoxedTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.IntegerBoxedTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.LongBoxedTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.ShortBoxedTest;
import org.treblereel.gwt.xml.mapper.client.tests.boxed.StringTest;
import org.treblereel.gwt.xml.mapper.client.tests.bpmn.bpmn2.BPMNTest;
import org.treblereel.gwt.xml.mapper.client.tests.collections.BeanMapTest;
import org.treblereel.gwt.xml.mapper.client.tests.collections.BoxedListsTest;
import org.treblereel.gwt.xml.mapper.client.tests.collections.BoxedSetsTest;
import org.treblereel.gwt.xml.mapper.client.tests.collections.PersonMapTest;
import org.treblereel.gwt.xml.mapper.client.tests.collections.StringMapTest;
import org.treblereel.gwt.xml.mapper.client.tests.date.DateTest;
import org.treblereel.gwt.xml.mapper.client.tests.date.SqlDateTest;
import org.treblereel.gwt.xml.mapper.client.tests.date.SqlTimeTest;
import org.treblereel.gwt.xml.mapper.client.tests.date.SqlTimestampTest;
import org.treblereel.gwt.xml.mapper.client.tests.doctype.DoctypedTest;
import org.treblereel.gwt.xml.mapper.client.tests.generics.SampleGenericTypeTest;
import org.treblereel.gwt.xml.mapper.client.tests.primitive.BooleanTest;
import org.treblereel.gwt.xml.mapper.client.tests.primitive.ByteTest;
import org.treblereel.gwt.xml.mapper.client.tests.primitive.CharTest;
import org.treblereel.gwt.xml.mapper.client.tests.primitive.CharacterTest;
import org.treblereel.gwt.xml.mapper.client.tests.primitive.DoubleTest;
import org.treblereel.gwt.xml.mapper.client.tests.primitive.FloatTest;
import org.treblereel.gwt.xml.mapper.client.tests.primitive.IntTest;
import org.treblereel.gwt.xml.mapper.client.tests.primitive.LongTest;
import org.treblereel.gwt.xml.mapper.client.tests.primitive.ShortTest;

public class MapperSuite {

  public static Test suite() {
    GWTTestSuite suite = new GWTTestSuite("XML Mapper test suite");
    suite.addTestSuite(RemoveWhitespaceTest.class);
    suite.addTestSuite(TransientBeanTest.class);
    suite.addTestSuite(XmlRootElementTest.class);
    suite.addTestSuite(CustomerTest.class);
    suite.addTestSuite(UserCdataTest.class);
    suite.addTestSuite(ValueTest.class);
    suite.addTestSuite(XmlValueHolderTest.class);
    suite.addTestSuite(ArrayAndListWrapTest.class);
    suite.addTestSuite(DataHolderTest.class);
    suite.addTestSuite(BeanTest.class);
    suite.addTestSuite(TutorialTest.class);
    suite.addTestSuite(NamespaceTest.class);
    suite.addTestSuite(NamespaceTest.class);
    suite.addTestSuite(NamespaceTest.class);
    suite.addTestSuite(SeeAlsoTest.class);
    suite.addTestSuite(CustomerTest.class);
    suite.addTestSuite(XsiTypeTest.class);
    suite.addTestSuite(WrapperTest.class);
    suite.addTestSuite(CustomerTest.class);
    suite.addTestSuite(MyTestBeanTest.class);
    suite.addTestSuite(AttributeAdapterTest.class);
    suite.addTestSuite(BeanWithCollectionTest.class);
    suite.addTestSuite(AdapterForInterfaceTest.class);
    suite.addTestSuite(MyTestBeanTest.class);
    suite.addTestSuite(TargetTest.class);
    suite.addTestSuite(ITaskTest.class);
    suite.addTestSuite(EventTest.class);
    suite.addTestSuite(BoxedArraysTest.class);
    suite.addTestSuite(CollectionTest.class);
    suite.addTestSuite(PrimitiveArraysTest.class);
    suite.addTestSuite(BooleanArray2dTest.class);
    suite.addTestSuite(ByteArray2dTest.class);
    suite.addTestSuite(DoubleArray2dTest.class);
    suite.addTestSuite(FloatArray2dTest.class);
    suite.addTestSuite(IntegerArray2dTest.class);
    suite.addTestSuite(LongArray2dTest.class);
    suite.addTestSuite(ShortArray2dTest.class);
    suite.addTestSuite(StringArray2dTest.class);
    suite.addTestSuite(EnumTest.class);
    suite.addTestSuite(FailOnUnknownPropertiesTest.class);
    suite.addTestSuite(UUIDTest.class);
    suite.addTestSuite(XmlRootElementTest.class);
    suite.addTestSuite(IfaceBeanTest.class);
    suite.addTestSuite(InheritanceTest.class);
    suite.addTestSuite(ProtectedBeanTest.class);
    suite.addTestSuite(BigDecimalTest.class);
    suite.addTestSuite(BigIntegerTest.class);
    suite.addTestSuite(BooleanBoxedTest.class);
    suite.addTestSuite(BooleanTest.class);
    suite.addTestSuite(ByteBoxedTest.class);
    suite.addTestSuite(DoubleBoxedTest.class);
    suite.addTestSuite(FloatBoxedTest.class);
    suite.addTestSuite(IntegerBoxedTest.class);
    suite.addTestSuite(LongBoxedTest.class);
    suite.addTestSuite(ShortBoxedTest.class);
    suite.addTestSuite(StringTest.class);
    suite.addTestSuite(BPMNTest.class);
    suite.addTestSuite(BeanMapTest.class);
    suite.addTestSuite(BoxedListsTest.class);
    suite.addTestSuite(BoxedSetsTest.class);
    suite.addTestSuite(PersonMapTest.class);
    suite.addTestSuite(StringMapTest.class);
    suite.addTestSuite(DateTest.class);
    suite.addTestSuite(SqlDateTest.class);
    suite.addTestSuite(SqlTimeTest.class);
    suite.addTestSuite(SqlTimestampTest.class);
    suite.addTestSuite(DoctypedTest.class);
    suite.addTestSuite(SampleGenericTypeTest.class);
    suite.addTestSuite(BooleanTest.class);
    suite.addTestSuite(ByteTest.class);
    suite.addTestSuite(CharTest.class);
    suite.addTestSuite(CharacterTest.class);
    suite.addTestSuite(DoubleTest.class);
    suite.addTestSuite(FloatTest.class);
    suite.addTestSuite(IntTest.class);
    suite.addTestSuite(LongTest.class);
    suite.addTestSuite(ShortTest.class);
    return suite;
  }
}
