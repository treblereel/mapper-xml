package org.treblereel.gwt.jackson.tests.annotations.collection;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
public class DataHolderTest {

    DataHolder_MapperImpl mapperEmployee = DataHolder_MapperImpl.INSTANCE;

    @Test
    public void testDataHolder() throws XMLStreamException {
        DataHolder holder = new DataHolder();
        holder.addDataHolder(new Data("AAA"));
        holder.addDataHolder(new Data("BBB"));
        holder.addDataHolder(new Data("CCC"));

        holder.addDataHolder(new Data("CCC1"));
        holder.addDataHolder(new Data("CCC2"));
        holder.addDataHolder(new Data("CCC3"));
        holder.addDataHolder(new Data("CCC4"));
        holder.addDataHolder(new Data("CCC5"));

        holder.getData2().addDataHolder(new Data("QQQ"));
        holder.getData2().addDataHolder(new Data("WWW"));
        holder.getData2().addDataHolder(new Data("EEE"));

        String xml = mapperEmployee.write(holder);

        System.out.println(xml);
        //assertEquals("<?xml version='1.0' encoding='UTF-8'?><DataHolder><dataList><dataList name=\"AAA\"/><dataList name=\"BBB\"/><dataList name=\"CCC\"/></dataList><data2><dataList><dataList name=\"QQQ\"/><dataList name=\"WWW\"/><dataList name=\"EEE\"/></dataList></data2></DataHolder>", xml);

        System.out.println("\n\n");
        DataHolder holder2 = mapperEmployee.read(xml);


        System.out.println("LIST  " + holder2.getDataList().size());
        holder2.getDataList().forEach(d -> {
            System.out.println("            d " + d.getName());
        });
        System.out.println("LIST 2 " + holder2.getData2().getCollection().size());
        holder2.getData2().getCollection().forEach(d -> {
            System.out.println("            d2 " + d.getName());
        });

        assertEquals(holder, mapperEmployee.read(xml));

    }
}
