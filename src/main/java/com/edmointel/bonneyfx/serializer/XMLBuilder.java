package com.edmointel.bonneyfx.serializer;


import com.edmointel.bonneyfx.model.Sale;
import com.thoughtworks.xstream.XStream;

public class XMLBuilder {
    public void generate() {
        XStream xStream = new XStream();
        xStream.registerConverter(new SalesPersonConverter());
        xStream.registerConverter(new ItemConverter());
        xStream.registerConverter(new RecipientConverter());
        Sale sale = Sale.getInstance();
        String xml = xStream.toXML(sale);
        System.out.println(xml);

    }

}
