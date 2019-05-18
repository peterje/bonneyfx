package com.edmointel.bonneyfx.model;

import org.joda.money.Money;

import java.math.RoundingMode;

public abstract class Item {

    private Money boardValue;
    private String product;

    public Item(String product, Money boardValue) {
        this.boardValue = boardValue;
        this.product = product;
    }

    public abstract double getCommissionRate();

    public abstract Money getFlatCommission();

    public Money getCommission() {
        return getBoardValue().multipliedBy(getCommissionRate(), RoundingMode.UP).plus(getFlatCommission());
    }

    public Money getBoardValue() {
        return boardValue;
    }

    public void setBoardValue(Money boardValue) {
        this.boardValue = boardValue;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

}
