package com.edmointel.bonneyfx.serializer;

import com.edmointel.bonneyfx.model.*;
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

        if(item.getProduct().equals(Product.PROPERTY))
        {
            hierarchicalStreamWriter.startNode("plotcode");
            if(item instanceof AtNeedItem)
                hierarchicalStreamWriter.setValue(((AtNeedItem)(item)).getPlotCode().toString());
            else
                hierarchicalStreamWriter.setValue(((PreNeedItem)(item)).getPlotCode().toString());
            hierarchicalStreamWriter.endNode();
        }

        // leadcode
        if(item instanceof PreNeedItem){
            hierarchicalStreamWriter.startNode("leadCode");
            hierarchicalStreamWriter.setValue(((PreNeedItem)(item)).getLeadCode().toString());
            hierarchicalStreamWriter.endNode();
        }
        // fullpay
        if(item instanceof PreNeedItem){
            hierarchicalStreamWriter.startNode("fullPay");
            hierarchicalStreamWriter.setValue(Boolean.toString(((PreNeedItem)(item)).fullPay()));
            hierarchicalStreamWriter.endNode();
        }
        // age
        if(item.getProduct().equals(Product.INSURANCE))
        {
            hierarchicalStreamWriter.startNode("age");
            hierarchicalStreamWriter.setValue(Integer.toString(Sale.getInstance().getRecipient().getAge()));
            hierarchicalStreamWriter.endNode();
        }
        // payplan
        if(item.getProduct().equals(Product.INSURANCE))
        {
            hierarchicalStreamWriter.startNode("payPlan");
            hierarchicalStreamWriter.setValue(Integer.toString(((Forethought)(item)).getPayPlan()));
            hierarchicalStreamWriter.endNode();
        }

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
