package com.edmointel.bonneyfx.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SalesPersonTest {
    SalesPerson sp1;
    SalesPerson sp2;
    SalesPerson sp3;
    SalesPerson sp4;
    SalesPerson sp5;

    @Before
    public void setUp() {
        Sale sale = Mockito.mock(Sale.class);
        Mockito.when(sale.getCommission()).thenReturn(Utils.toUSD("1000.0"));

        sp1 = new SalesPerson("John Doe", sale, 1.0);
        sp2 = new SalesPerson("John Doe", sale, 0.75);
        sp3 = new SalesPerson("John Doe", sale, 0.5);
        sp4 = new SalesPerson("John Doe", sale, 0.25);
        sp5 = new SalesPerson("John Doe", sale, 0.10);
    }

    @Test
    public void getCommission1() {
        Assert.assertEquals(Utils.toUSD("1000.0"), sp1.getCommission());
    }

    @Test
    public void getCommission2() {
        Assert.assertEquals(Utils.toUSD("750.0"), sp2.getCommission());
    }

    @Test
    public void getCommission3() {
        Assert.assertEquals(Utils.toUSD("500.0"), sp3.getCommission());
    }

    @Test
    public void getCommission4() {
        Assert.assertEquals(Utils.toUSD("250.0"), sp4.getCommission());
    }

    @Test
    public void getCommission5() {
        Assert.assertEquals(Utils.toUSD("100.0"), sp5.getCommission());
    }

}