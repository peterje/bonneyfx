package com.edmointel.bonneyfx.serializer;

import com.edmointel.bonneyfx.model.AtNeedItem;
import com.edmointel.bonneyfx.model.Forethought;
import com.edmointel.bonneyfx.model.Item;
import com.edmointel.bonneyfx.model.PreNeedItem;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ItemConverter implements Converter {
    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Item item = (Item) o;
        hierarchicalStreamWriter.startNode("product");
        hierarchicalStreamWriter.setValue(item.getProduct().toString());
        hierarchicalStreamWriter.endNode();

        hierarchicalStreamWriter.startNode("boardValue");
        hierarchicalStreamWriter.setValue(item.getBoardValue().toString());
        hierarchicalStreamWriter.endNode();

        hierarchicalStreamWriter.startNode("commissionRate");
        hierarchicalStreamWriter.setValue(Double.toString(item.getCommissionRate()));
        hierarchicalStreamWriter.endNode();


        hierarchicalStreamWriter.startNode("commission");
        hierarchicalStreamWriter.setValue(item.getCommission().toString());
        hierarchicalStreamWriter.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return null;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(AtNeedItem.class) || aClass.equals(PreNeedItem.class) || aClass.equals(Forethought.class);
    }
}
