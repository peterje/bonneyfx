package com.edmointel.bonneyfx.serializer;

import com.edmointel.bonneyfx.model.SalesPerson;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class SalesPersonConverter implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        SalesPerson salesPerson = (SalesPerson) o;

        hierarchicalStreamWriter.startNode("name");
        hierarchicalStreamWriter.setValue(salesPerson.getName());
        hierarchicalStreamWriter.endNode();

        hierarchicalStreamWriter.startNode("split");
        hierarchicalStreamWriter.setValue(Double.toString(salesPerson.getSplitPCT()));
        hierarchicalStreamWriter.endNode();

        hierarchicalStreamWriter.startNode("commission");
        hierarchicalStreamWriter.setValue(salesPerson.getCommission().toString());
        hierarchicalStreamWriter.endNode();

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return null;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(SalesPerson.class);
    }
}
