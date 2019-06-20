package com.edmointel.bonneyfx.serializer;


import com.edmointel.bonneyfx.model.AtNeedItem;
import com.edmointel.bonneyfx.model.Forethought;
import com.edmointel.bonneyfx.model.PreNeedItem;
import com.edmointel.bonneyfx.model.Sale;
import com.thoughtworks.xstream.XStream;
import org.apache.fop.apps.FOPException;

import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

public class XMLBuilder {
    public void generate() throws IOException, URISyntaxException, FOPException, TransformerException {
        File xmlFile = new File("xmlFile.xml");
        XStream xStream = new XStream();
        xStream.alias("sale", Sale.class);
        xStream.alias("atNeed", AtNeedItem.class);
        xStream.alias("preNeed", PreNeedItem.class);
        xStream.alias("forethought", Forethought.class);
        xStream.registerConverter(new SalesPersonConverter());
        xStream.registerConverter(new ItemConverter());
        xStream.registerConverter(new RecipientConverter());
        Sale sale = Sale.getInstance();
        xStream.toXML(sale, new FileWriter(xmlFile));
        PDFBuilder pdfBuilder = new PDFBuilder();
//        URL xslPath = getClass().getClassLoader().getResource("view/fo.xsl");
        InputStream in = XMLBuilder.class.getClassLoader().getResourceAsStream("view/fo.xsl");
        StreamSource xslSrc = new StreamSource(in);
        pdfBuilder.convertToPDF(xmlFile, xslSrc);
    }

}
