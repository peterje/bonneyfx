package com.edmointel.bonneyfx.serializer;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;

public class PDFBuilderTest {
    @Before
    public void setup() throws Exception{
        PDFBuilder pdfBuilder = new PDFBuilder();
        URL xslPath = getClass().getClassLoader().getResource("view/fo.xsl");
        pdfBuilder.convertToPDF(new File("xmlFile.xml"), new File(xslPath.toURI()));
    }
}