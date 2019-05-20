package com.edmointel.bonneyfx.model;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

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

        cremationPropertyCompanyFullPay = new PreNeedItem(Product.PROPERTY,Utils.toUSD("100.0"),sale, Utils.toUSD("100"), company, cremation);
        cremationPropertyPersonalFullPay = new PreNeedItem(Product.PROPERTY,Utils.toUSD("100.0"),sale, Utils.toUSD("100"), personal, cremation);
        groundPropertyCompanyFullPay = new PreNeedItem(Product.PROPERTY,Utils.toUSD("100.0"),sale, Utils.toUSD("100"), company, ground);
        groundPropertyPersonalFullPay = new PreNeedItem(Product.PROPERTY,Utils.toUSD("100.0"),sale, Utils.toUSD("100"), personal, ground);
        merchandiseCompanyFullPay= new PreNeedItem(Product.MERCHANDISE,Utils.toUSD("100.0"),sale, Utils.toUSD("100"), company, cremation);
        merchandisePersonalFullPay = new PreNeedItem(Product.MERCHANDISE,Utils.toUSD("100.0"),sale, Utils.toUSD("100"), personal, cremation);
        intermentPersonalFullPay = new PreNeedItem(Product.INTERMENT,Utils.toUSD("100.0"),sale, Utils.toUSD("100"), personal, cremation);
        intermentCompanyFullPay = new PreNeedItem(Product.INTERMENT,Utils.toUSD("100.0"),sale, Utils.toUSD("100"), company, cremation);

        cremationPropertyCompany = new PreNeedItem(Product.PROPERTY,Utils.toUSD("100.0"),sale, Utils.toUSD("50.0"), company, cremation);
        cremationPropertyPersonal = new PreNeedItem(Product.PROPERTY,Utils.toUSD("100.0"),sale, Utils.toUSD("50.0"), personal, cremation);
        groundPropertyCompany = new PreNeedItem(Product.PROPERTY,Utils.toUSD("100.0"),sale, Utils.toUSD("50.0"), company, ground);
        groundPropertyPersonal = new PreNeedItem(Product.PROPERTY,Utils.toUSD("100.0"),sale, Utils.toUSD("50.0"), personal, ground);
        merchandiseCompany = new PreNeedItem(Product.MERCHANDISE,Utils.toUSD("100.0"),sale, Utils.toUSD("50.0"), company, cremation);
        merchandisePersonal = new PreNeedItem(Product.MERCHANDISE,Utils.toUSD("100.0"),sale, Utils.toUSD("50.0"), personal, cremation);
        intermentPersonal = new PreNeedItem(Product.INTERMENT,Utils.toUSD("100.0"),sale, Utils.toUSD("50.0"), personal, cremation);
        intermentCompany = new PreNeedItem(Product.INTERMENT,Utils.toUSD("100.0"),sale, Utils.toUSD("50.0"), company, cremation);

    }

    @Test
    public void getCommissionRateCompanyFullPay() {
        assertEquals(0.19,cremationPropertyCompanyFullPay.getCommissionRate(), 0.001);
        assertEquals(0.18,cremationPropertyCompany.getCommissionRate(), 0.001);
        assertEquals(0.19,cremationPropertyPersonal.getCommissionRate(),  0.001);
        assertEquals(0.20,cremationPropertyPersonalFullPay.getCommissionRate(), 0.001);
        assertEquals(0.15,groundPropertyPersonal.getCommissionRate(), 0.001);
        assertEquals(0.14,groundPropertyCompany.getCommissionRate(), 0.001);
        assertEquals(0.15,groundPropertyCompanyFullPay.getCommissionRate(), 0.001);
        assertEquals(0.16,groundPropertyPersonalFullPay.getCommissionRate(), 0.001);
        assertEquals(0.08,merchandisePersonal.getCommissionRate(), 0.001);
        assertEquals(0.07,merchandiseCompany.getCommissionRate(), 0.001);
        assertEquals(0.08,merchandiseCompanyFullPay.getCommissionRate(), 0.001);
        assertEquals(0.09,merchandisePersonalFullPay.getCommissionRate(), 0.001);
        assertEquals(0.02,intermentCompany.getCommissionRate(), 0.001);
        assertEquals(0.03,intermentPersonal.getCommissionRate(), 0.001);
        assertEquals(0.03,intermentCompanyFullPay.getCommissionRate(), 0.001);
        assertEquals(0.04,intermentPersonalFullPay.getCommissionRate(), 0.001);
    }

    @Test
    public void getFlatCommission() {
        assertEquals(Money.zero(CurrencyUnit.USD), cremationPropertyCompanyFullPay.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), cremationPropertyCompany.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), cremationPropertyPersonal.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), cremationPropertyPersonalFullPay.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), groundPropertyPersonal.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), groundPropertyCompany.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), groundPropertyCompanyFullPay.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), groundPropertyPersonalFullPay.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), merchandisePersonal.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), merchandiseCompany.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), merchandiseCompanyFullPay.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), merchandisePersonalFullPay.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), intermentCompany.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), intermentPersonal.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), intermentCompanyFullPay.getFlatCommission());
        assertEquals(Money.zero(CurrencyUnit.USD), intermentPersonalFullPay.getFlatCommission());
    }

    @Test
    public void getDeferred() {
    }
}