package org.treblereel.gwt.jackson.api.deser.array.dd;

import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.treblereel.gwt.jackson.api.XMLDeserializationContext;
import org.treblereel.gwt.jackson.api.XMLDeserializerParameters;
import org.treblereel.gwt.jackson.api.deser.StringXMLDeserializer;
import org.treblereel.gwt.jackson.api.stream.XMLReader;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/28/20
 */
public class StringArray2dXMLDeserializer extends AbstractArray2dXMLDeserializer<String[][]> {

    private static final StringArray2dXMLDeserializer INSTANCE = new StringArray2dXMLDeserializer();

    private StringArray2dXMLDeserializer() {
    }

    /**
     * <p>getInstance</p>
     * @return an instance of {@link StringArray2dXMLDeserializer}
     */
    public static StringArray2dXMLDeserializer newInstance() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[][] doDeserialize(XMLReader reader, XMLDeserializationContext ctx, XMLDeserializerParameters params) throws XMLStreamException {
        List<List<String>> list = deserializeIntoList(reader, ctx, StringXMLDeserializer.getInstance(), params);

        if (list.isEmpty()) {
            return new String[0][0];
        }

        List<String> firstList = list.get(0);
        if (firstList.isEmpty()) {
            return new String[list.size()][0];
        }

        String[][] array = new String[list.size()][firstList.size()];

        int i = 0;
        int j;
        for (List<String> innerList : list) {
            j = 0;
            for (String value : innerList) {
                if (null != value) {
                    array[i][j] = value;
                }
                j++;
            }
            i++;
        }
        return array;
    }
}

