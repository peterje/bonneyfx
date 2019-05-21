package com.edmointel.bonneyfx.model;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class PreNeedItemTest {
    PreNeedItem cremationPropertyCompanyFullPay;
    PreNeedItem cremationPropertyPersonalFullPay;
    PreNeedItem groundPropertyCompanyFullPay;
    PreNeedItem groundPropertyPersonalFullPay;
    PreNeedItem merchandiseCompanyFullPay;
    PreNeedItem intermentPersonalFullPay;
    PreNeedItem merchandisePersonalFullPay;
    PreNeedItem intermentCompanyFullPay;
    PreNeedItem cremationPropertyCompany;
    PreNeedItem cremationPropertyPersonal;
    PreNeedItem groundPropertyCompany;
    PreNeedItem groundPropertyPersonal;
    PreNeedItem merchandiseCompany;
    PreNeedItem intermentPersonal;
    PreNeedItem merchandisePersonal;
    PreNeedItem intermentCompany;


    @Before
    public void setUp() throws Exception
    {
        Sale sale = Mockito.mock(Sale.class);

        PlotCode cremation = PlotCode.TGM;
        PlotCode ground = PlotCode._6;
        LeadCode company = LeadCode.COMPANY;
        LeadCode personal = LeadCode.PERSONAL;

        cremationPropertyCompanyFullPay = new PreNeedItem(Product.PROPERTY, Utils.toUSD("1234.56"), sale, Utils.toUSD("1234.56"), company, cremation);
        cremationPropertyPersonalFullPay = new PreNeedItem(Product.PROPERTY, Utils.toUSD("1234.56"), sale, Utils.toUSD("1234.56"), personal, cremation);
        groundPropertyCompanyFullPay = new PreNeedItem(Product.PROPERTY, Utils.toUSD("1234.56"), sale, Utils.toUSD("1234.56"), company, ground);
        groundPropertyPersonalFullPay = new PreNeedItem(Product.PROPERTY, Utils.toUSD("1234.56"), sale, Utils.toUSD("1234.56"), personal, ground);
        merchandiseCompanyFullPay = new PreNeedItem(Product.MERCHANDISE, Utils.toUSD("1234.56"), sale, Utils.toUSD("1234.56"), company, cremation);
        merchandisePersonalFullPay = new PreNeedItem(Product.MERCHANDISE, Utils.toUSD("1234.56"), sale, Utils.toUSD("1234.56"), personal, cremation);
        intermentPersonalFullPay = new PreNeedItem(Product.INTERMENT, Utils.toUSD("1234.56"), sale, Utils.toUSD("1234.56"), personal, cremation);
        intermentCompanyFullPay = new PreNeedItem(Product.INTERMENT, Utils.toUSD("1234.56"), sale, Utils.toUSD("1234.56"), company, cremation);

        cremationPropertyCompany = new PreNeedItem(Product.PROPERTY, Utils.toUSD("1234.56"), sale, Utils.toUSD("345.67"), company, cremation);
        cremationPropertyPersonal = new PreNeedItem(Product.PROPERTY, Utils.toUSD("1234.56"), sale, Utils.toUSD("345.67"), personal, cremation);
        groundPropertyCompany = new PreNeedItem(Product.PROPERTY, Utils.toUSD("1234.56"), sale, Utils.toUSD("345.67"), company, ground);
        groundPropertyPersonal = new PreNeedItem(Product.PROPERTY, Utils.toUSD("1234.56"), sale, Utils.toUSD("345.67"), personal, ground);
        merchandiseCompany = new PreNeedItem(Product.MERCHANDISE, Utils.toUSD("1234.56"), sale, Utils.toUSD("345.67"), company, cremation);
        merchandisePersonal = new PreNeedItem(Product.MERCHANDISE, Utils.toUSD("1234.56"), sale, Utils.toUSD("345.67"), personal, cremation);
        intermentPersonal = new PreNeedItem(Product.INTERMENT, Utils.toUSD("1234.56"), sale, Utils.toUSD("345.67"), personal, cremation);
        intermentCompany = new PreNeedItem(Product.INTERMENT, Utils.toUSD("1234.56"), sale, Utils.toUSD("345.67"), company, cremation);

    }


    @Test
    public void getCommissionRate1() {
        assertEquals(0.19,cremationPropertyCompanyFullPay.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate2() {
        assertEquals(0.18,cremationPropertyCompany.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate3() {
        assertEquals(0.19,cremationPropertyPersonal.getCommissionRate(),  0.001);
    }

    @Test
    public void getCommissionRate4() {
        assertEquals(0.20,cremationPropertyPersonalFullPay.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate5() {
        assertEquals(0.15,groundPropertyPersonal.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate6() {
        assertEquals(0.14,groundPropertyCompany.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate7() {
        assertEquals(0.15,groundPropertyCompanyFullPay.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate8() {
        assertEquals(0.16,groundPropertyPersonalFullPay.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate9() {
        assertEquals(0.08,merchandisePersonal.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate10() {
        assertEquals(0.07,merchandiseCompany.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate11() {
        assertEquals(0.08,merchandiseCompanyFullPay.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate12() {
        assertEquals(0.09,merchandisePersonalFullPay.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate13() {
        assertEquals(0.02,intermentCompany.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate14() {
        assertEquals(0.03,intermentPersonal.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate15() {
        assertEquals(0.03,intermentCompanyFullPay.getCommissionRate(), 0.001);
    }

    @Test
    public void getCommissionRate16() {
        assertEquals(0.04,intermentPersonalFullPay.getCommissionRate(), 0.001);
    }


    @Test
    public void getFlatCommission1() {
        assertEquals(Money.zero(CurrencyUnit.USD), cremationPropertyCompanyFullPay.getFlatCommission());
    }

    @Test
    public void getFlatCommission2() {
        assertEquals(Money.zero(CurrencyUnit.USD), cremationPropertyCompany.getFlatCommission());
    }

    @Test
    public void getFlatCommission3() {
        assertEquals(Money.zero(CurrencyUnit.USD), cremationPropertyPersonal.getFlatCommission());
    }

    @Test
    public void getFlatCommission4() {
        assertEquals(Money.zero(CurrencyUnit.USD), cremationPropertyPersonalFullPay.getFlatCommission());
    }

    @Test
    public void getFlatCommission5() {
        assertEquals(Money.zero(CurrencyUnit.USD), groundPropertyPersonal.getFlatCommission());
    }

    @Test
    public void getFlatCommission6() {
        assertEquals(Money.zero(CurrencyUnit.USD), groundPropertyCompany.getFlatCommission());
    }

    @Test
    public void getFlatCommission7() {
        assertEquals(Money.zero(CurrencyUnit.USD), groundPropertyCompanyFullPay.getFlatCommission());
    }

    @Test
    public void getFlatCommission8() {
        assertEquals(Money.zero(CurrencyUnit.USD), groundPropertyPersonalFullPay.getFlatCommission());
    }

    @Test
    public void getFlatCommission9() {
        assertEquals(Money.zero(CurrencyUnit.USD), merchandisePersonal.getFlatCommission());
    }

    @Test
    public void getFlatCommission10() {
        assertEquals(Money.zero(CurrencyUnit.USD), merchandiseCompany.getFlatCommission());
    }

    @Test
    public void getFlatCommission11() {
        assertEquals(Money.zero(CurrencyUnit.USD), merchandiseCompanyFullPay.getFlatCommission());
    }

    @Test
    public void getFlatCommission12() {
        assertEquals(Money.zero(CurrencyUnit.USD), merchandisePersonalFullPay.getFlatCommission());
    }

    @Test
    public void getFlatCommission13() {
        assertEquals(Money.zero(CurrencyUnit.USD), intermentCompany.getFlatCommission());
    }

    @Test
    public void getFlatCommission14() {
        assertEquals(Money.zero(CurrencyUnit.USD), intermentPersonal.getFlatCommission());
    }

    @Test
    public void getFlatCommission15() {
        assertEquals(Money.zero(CurrencyUnit.USD), intermentCompanyFullPay.getFlatCommission());
    }

    @Test
    public void getFlatCommission16() {
        assertEquals(Money.zero(CurrencyUnit.USD), intermentPersonalFullPay.getFlatCommission());
    }

    @Test
    public void getCommission1() {
        assertEquals(Utils.toUSD("234.57"), cremationPropertyCompanyFullPay.getCommission());
    }

    @Test
    public void getCommission2() {
        assertEquals(Utils.toUSD("222.22"), cremationPropertyCompany.getCommission());
    }

    @Test
    public void getCommission3() {
        assertEquals(Utils.toUSD("234.57"), cremationPropertyPersonal.getCommission());
    }

    @Test
    public void getCommission4() {
        assertEquals(Utils.toUSD("246.91"), cremationPropertyPersonalFullPay.getCommission());
    }

    @Test
    public void getCommission5() {
        assertEquals(Utils.toUSD("185.18"), groundPropertyPersonal.getCommission());
    }

    @Test
    public void getCommission6() {
        assertEquals(Utils.toUSD("172.84"), groundPropertyCompany.getCommission());
    }

    @Test
    public void getCommission7() {
        assertEquals(Utils.toUSD("185.18"), groundPropertyCompanyFullPay.getCommission());
    }

    @Test
    public void getCommission8() {
        assertEquals(Utils.toUSD("197.53"), groundPropertyPersonalFullPay.getCommission());
    }

    @Test
    public void getCommission9() {
        assertEquals(Utils.toUSD("98.76"), merchandisePersonal.getCommission());
    }

    @Test
    public void getCommission10() {
        assertEquals(Utils.toUSD("86.42"), merchandiseCompany.getCommission());
    }

    @Test
    public void getCommission11() {
        assertEquals(Utils.toUSD("98.76"), merchandiseCompanyFullPay.getCommission());
    }

    @Test
    public void getCommission12() {
        assertEquals(Utils.toUSD("111.11"), merchandisePersonalFullPay.getCommission());
    }

    @Test
    public void getCommission13() {
        assertEquals(Utils.toUSD("24.69"), intermentCompany.getCommission());
    }

    @Test
    public void getCommission14() {
        assertEquals(Utils.toUSD("37.04"), intermentPersonal.getCommission());
    }

    @Test
    public void getCommission15() {
        assertEquals(Utils.toUSD("37.04"), intermentCompanyFullPay.getCommission());
    }

    @Test
    public void getCommission16() {
        assertEquals(Utils.toUSD("49.38"), intermentPersonalFullPay.getCommission());
    }

    @Test
    public void getDeferred() {
    }
}