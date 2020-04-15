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
        assertEquals(holder, mapperEmployee.read(xml));
    }
}
