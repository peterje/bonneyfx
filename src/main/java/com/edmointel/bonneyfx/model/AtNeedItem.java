package com.edmointel.bonneyfx.model;

import org.joda.money.Money;

public class AtNeedItem extends Item {

    private PlotCode plotCode;

    public AtNeedItem(Product product, Money boardValue, Sale sale, PlotCode plotCode) {
        super(product, boardValue, sale);
        this.plotCode = plotCode;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + "Object {" + NL);
        result.append("Product: " + getProduct() + NL);
        result.append("Value: " + getBoardValue() + NL);
        result.append("PlotCode: " + plotCode + NL);
        result.append("}");

        return result.toString();
    }

    public double getCommissionRate() {
        Recipient recipient = sale.getRecipient();
        double rate = 0.0;
        if (getProduct().equals(Product.PROPERTY)) {
            if (plotCode.isCremation())
                rate = 0.19;
            else // non cremation
                if (recipient.diedOverOneYearAgo())
                    rate = 0.15;
                else
                    rate = 0.08;
        } else if (getProduct().equals(Product.MERCHANDISE))
            rate = 0.05;
        else if (getProduct().equals(Product.INTERMENT))
            rate = 0.0;
        return rate;
    }

    @Override
    public Money getFlatCommission() {
        return Utils.toUSD("0.00");
    }
}
