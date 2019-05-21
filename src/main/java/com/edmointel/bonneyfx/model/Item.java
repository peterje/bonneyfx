package com.edmointel.bonneyfx.model;

import org.joda.money.Money;

import java.math.RoundingMode;

public abstract class Item {

    protected Money boardValue;
    protected Product product;
    protected Sale sale;

    public Item(Product product, Money boardValue, Sale sale) {
        this.boardValue = boardValue;
        this.product = product;
        this.sale = sale;
    }

    public abstract double getCommissionRate();

    public abstract Money getFlatCommission();

    public Money getCommission() {
        return boardValue.multipliedBy(getCommissionRate(), RoundingMode.HALF_EVEN).plus(getFlatCommission());
    }

}
