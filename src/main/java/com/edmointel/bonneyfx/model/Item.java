package com.edmointel.bonneyfx.model;

import org.joda.money.Money;

import java.math.RoundingMode;

public abstract class Item {

    private Money boardValue;
    private Product product;
    public Sale sale;

    public Item(Product product, Money boardValue, Sale sale) {
        this.boardValue = boardValue;
        this.product = product;
        this.sale = sale;
    }

    public abstract double getCommissionRate();

    public abstract Money getFlatCommission();

    public Money getCommission() {
        return getBoardValue().multipliedBy(getCommissionRate(), RoundingMode.UP).plus(getFlatCommission());
    }

    public Money getBoardValue() {
        return boardValue;
    }

    public Product getProduct() {
        return product;
    }

}
