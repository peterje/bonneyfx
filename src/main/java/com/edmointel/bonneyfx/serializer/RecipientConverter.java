package com.edmointel.bonneyfx.serializer;

import com.edmointel.bonneyfx.model.Recipient;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class RecipientConverter implements Converter {
    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Recipient recipient = (Recipient) o;
        hierarchicalStreamWriter.startNode("name");
        hierarchicalStreamWriter.setValue(recipient.getName());
        hierarchicalStreamWriter.endNode();

        hierarchicalStreamWriter.startNode("dob");
        hierarchicalStreamWriter.setValue(recipient.getDateOfBirth().toString());
        hierarchicalStreamWriter.endNode();

        hierarchicalStreamWriter.startNode("age");
        hierarchicalStreamWriter.setValue(Integer.toString(recipient.getAge()));
        hierarchicalStreamWriter.endNode();

        if(recipient.isDeceased())
        {
            hierarchicalStreamWriter.startNode("dod");
            hierarchicalStreamWriter.setValue(recipient.getDateOfDeath().toString());
            hierarchicalStreamWriter.endNode();
        }

        hierarchicalStreamWriter.startNode("isDeceased");
        hierarchicalStreamWriter.setValue(Boolean.toString(recipient.isDeceased()));
        hierarchicalStreamWriter.endNode();

        hierarchicalStreamWriter.startNode("deceasedForOneYear");
        hierarchicalStreamWriter.setValue(Boolean.toString(recipient.diedOverOneYearAgo()));
        hierarchicalStreamWriter.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return null;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Recipient.class);
    }
}
