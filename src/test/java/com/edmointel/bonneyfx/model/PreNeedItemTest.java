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

        Money zero = Utils.toUSD("0.00");

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
    public void getCommissionRate() {
        assertEquals(cremationPropertyCompanyFullPay.getCommissionRate(), 0.19, 0.001);
        assertEquals(cremationPropertyCompany.getCommissionRate(), 0.18, 0.0);
        assertEquals(cremationPropertyPersonal.getCommissionRate(), 0.19, 0.0);
        assertEquals(cremationPropertyPersonalFullPay.getCommissionRate(), 0.20, 0.001);
        assertEquals(groundPropertyPersonal.getCommissionRate(), 0.15, 0.001);
        assertEquals(groundPropertyCompany.getCommissionRate(), 0.14, 0.001);
        assertEquals(groundPropertyCompanyFullPay.getCommissionRate(), 0.15, 0.001);
        assertEquals(groundPropertyPersonalFullPay.getCommissionRate(), 0.16, 0.001);
        assertEquals(merchandisePersonal.getCommissionRate(), 0.08, 0.001);
        assertEquals(merchandiseCompany.getCommissionRate(), 0.07, 0.001);
        assertEquals(merchandiseCompanyFullPay.getCommissionRate(), 0.08, 0.001);
        assertEquals(merchandisePersonalFullPay.getCommissionRate(), 0.09, 0.001);
        assertEquals(intermentCompany.getCommissionRate(), 0.02, 0.001);
        assertEquals(intermentPersonal.getCommissionRate(), 0.03, 0.001);
        assertEquals(intermentCompanyFullPay.getCommissionRate(), 0.03, 0.001);
        assertEquals(intermentPersonalFullPay.getCommissionRate(), 0.04, 0.001);
    }

    @Test
    public void getFlatCommission() {
        assertEquals(cremationPropertyCompanyFullPay.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(cremationPropertyCompany.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(cremationPropertyPersonal.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(cremationPropertyPersonalFullPay.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(groundPropertyPersonal.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(groundPropertyCompany.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(groundPropertyCompanyFullPay.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(groundPropertyPersonalFullPay.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(merchandisePersonal.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(merchandiseCompany.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(merchandiseCompanyFullPay.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(merchandisePersonalFullPay.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(intermentCompany.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(intermentPersonal.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(intermentCompanyFullPay.getFlatCommission(), Money.zero(CurrencyUnit.USD));
        assertEquals(intermentPersonalFullPay.getFlatCommission(), Money.zero(CurrencyUnit.USD));
    }

    @Test
    public void getDeferred() {
    }
}