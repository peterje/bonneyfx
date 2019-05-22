package com.edmointel.bonneyfx.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.joda.money.Money;

import java.math.RoundingMode;

public abstract class Item {

    protected Money boardValue;
    protected Product product;

    @XStreamOmitField
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

    public Money getBoardValue() {
        return boardValue;
    }

    public Product getProduct() {
        return product;
    }

}
