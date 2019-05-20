package com.edmointel.bonneyfx.model;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

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

        final Recipient recipientPostOneYear = Mockito.mock(Recipient.class);
        Mockito.when(recipientPostOneYear.diedOverOneYearAgo()).thenReturn(true);

        final Recipient recipientPreOneYear = Mockito.mock(Recipient.class);
        Mockito.when(recipientPreOneYear.diedOverOneYearAgo()).thenReturn(false);

        final Sale salePostOneYear = Mockito.mock(Sale.class);
        Mockito.when(salePostOneYear.getRecipient()).thenReturn(recipientPostOneYear);

        final Sale salePreOneYear = Mockito.mock(Sale.class);
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
    public void getCommissionRate1() {
        assertEquals(0.19, plotCremationPostYear.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate2() {
        assertEquals(0.19, plotCremationPreYear.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate3() {
        assertEquals(0.15, plotGroundPostYear.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate4() {
        assertEquals(0.08, plotGroundPreYear.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate5() {
        assertEquals(0.05, merchandisePostYear.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate6() {
        assertEquals(0.05, merchandisePreYear.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate7() {
        assertEquals(0.0, interment.getCommissionRate(), 0.001);
    }


    @Test
    public void getFlatCommission() {
    }

    @Test
    public void getFlatCommission1() {
        assertEquals(Money.zero(CurrencyUnit.USD), plotCremationPostYear.getFlatCommission());
    }

    @Test
    public void getFlatCommission2() {
        assertEquals(Money.zero(CurrencyUnit.USD), plotCremationPreYear.getFlatCommission());
    }

    @Test
    public void getFlatCommission3() {
        assertEquals(Money.zero(CurrencyUnit.USD), plotGroundPostYear.getFlatCommission());
    }

    @Test
    public void getFlatCommission4() {
        assertEquals(Money.zero(CurrencyUnit.USD), plotGroundPreYear.getFlatCommission());
    }

    @Test
    public void getFlatCommission5() {
        assertEquals(Money.zero(CurrencyUnit.USD), merchandisePostYear.getFlatCommission());
    }

    @Test
    public void getFlatCommission6() {
        assertEquals(Money.zero(CurrencyUnit.USD), merchandisePreYear.getFlatCommission());
    }

    @Test
    public void getFlatCommission7() {
        assertEquals(Money.zero(CurrencyUnit.USD), interment.getFlatCommission());
    }

}