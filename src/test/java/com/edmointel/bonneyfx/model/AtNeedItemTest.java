package com.edmointel.bonneyfx.model;

import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AtNeedItemTest {
    AtNeedItem plotCremationPostYear;
    AtNeedItem plotCremationPreYear;
    AtNeedItem plotGroundPostYear;
    AtNeedItem plotGroundPreYear;
    AtNeedItem merchandisePreYear;
    AtNeedItem merchandisePostYear;
    AtNeedItem interment;
    @Before
    public void setUp() throws Exception {

        Recipient recipientPostOneYear = Mockito.mock(Recipient.class);
        Mockito.when(recipientPostOneYear.diedOverOneYearAgo()).thenReturn(true);

        Recipient recipientPreOneYear = Mockito.mock(Recipient.class);
        Mockito.when(recipientPreOneYear.diedOverOneYearAgo()).thenReturn(false);

        Sale salePostOneYear = Mockito.mock(Sale.class);
        Mockito.when(salePostOneYear.getRecipient()).thenReturn(recipientPostOneYear);

        Sale salePreOneYear = Mockito.mock(Sale.class);
        Mockito.when(salePreOneYear.getRecipient()).thenReturn(recipientPreOneYear);


        plotCremationPostYear = new AtNeedItem(Product.PROPERTY, Utils.toUSD("100.0"), salePostOneYear, PlotCode.TGM);
        plotCremationPreYear = new AtNeedItem(Product.PROPERTY, Utils.toUSD("100.0"), salePostOneYear, PlotCode.TGM);

        plotGroundPostYear = new AtNeedItem(Product.PROPERTY, Utils.toUSD("100.0"), salePostOneYear, PlotCode._6);
        plotGroundPreYear = new AtNeedItem(Product.PROPERTY, Utils.toUSD("100.0"), salePreOneYear, PlotCode._6);

        merchandisePreYear = new AtNeedItem(Product.MERCHANDISE, Utils.toUSD("100.0"), salePreOneYear, null);
        merchandisePostYear = new AtNeedItem(Product.MERCHANDISE, Utils.toUSD("100.0"), salePostOneYear, null);

        interment = new AtNeedItem(Product.INTERMENT, Utils.toUSD("100.0"), salePostOneYear, null);

    }

    @Test
    public void getCommissionRate() {
        assertEquals(plotCremationPostYear.getCommissionRate(), 0.19, 0.0);
        assertEquals(plotCremationPreYear.getCommissionRate(), 0.19, 0.0);
        assertEquals(plotGroundPostYear.getCommissionRate(), 0.15, 0.0);
        assertEquals(plotGroundPreYear.getCommissionRate(), 0.08, 0.0);
        assertEquals(merchandisePostYear.getCommissionRate(), 0.05, 0.0);
        assertEquals(merchandisePreYear.getCommissionRate(), 0.05, 0.0);
        assertEquals(interment.getCommissionRate(), 0.0, 0.0);
    }

    @Test
    public void getFlatCommission()
    {

    }
}