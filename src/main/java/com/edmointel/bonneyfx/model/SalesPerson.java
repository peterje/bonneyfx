package com.edmointel.bonneyfx.model;

import org.joda.money.Money;

import java.math.RoundingMode;

public class SalesPerson extends Person {
    private double splitPCT;
    private Sale sale;

    public SalesPerson(String name, Sale sale, double splitPCT) {
        super(name);
        this.sale = sale;
        this.splitPCT = splitPCT;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NL);
        result.append(super.toString() + NL);
        result.append("Split%: " + splitPCT + NL);

        return result.toString();
    }

    public Money getCommission()
    {
        return sale.getCommission().multipliedBy(splitPCT, RoundingMode.HALF_EVEN);
    }

}
