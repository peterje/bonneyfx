package com.edmointel.bonneyfx.serializer;

import com.edmointel.bonneyfx.model.Sale;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFBuilder {
    private Sale sale;

    public PDFBuilder(Sale sale) {
        this.sale = sale;
    }

    private void buildPDF() throws Exception {
        Document doc = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("test.pdf"));
            doc.open();
            Table table = new Table(150, 150);


            doc.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
