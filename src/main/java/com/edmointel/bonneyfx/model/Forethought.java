package com.edmointel.bonneyfx.model;

import org.joda.money.Money;

public class Forethought extends Item {

    private int payPlan;

    public Forethought(Product product, Money faceValue, Sale sale, int payPlan) {
        super(product, faceValue, sale);
        this.payPlan = payPlan;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + "Object {" + NL);
        result.append("Product: " + product + NL);
        result.append("Face Amount: " + boardValue + NL);
        result.append("Payment Plan: " + payPlan + " years" + NL);
        result.append("}");

        return result.toString();
    }

    @Override
    public double getCommissionRate() {
        double rate = 0.0;
        if (product.equals(Product.INSURANCE))
            rate = getInsuranceRate();
        else if (product.equals(Product.TRUST))
            rate = 0.03;
        else if (product.equals(Product.TRAVEL))
            rate = 0.0;
        return rate;
    }

    @Override
    public Money getFlatCommission() {

        if (product.equals(Product.TRAVEL))
            return Utils.toUSD("85.00");
        else
            return Utils.toUSD("0.00");
    }

    private double getInsuranceRate() {
        int recipientAge = sale.getRecipient().getAge();

        int payIndex = 0;
        int ageIndex;
        double[][] rates = {
                {0.070, 0.065, 0.060, 0.040},
                {0.055, 0.050, 0.040, 0.030},
                {0.040, 0.040, 0.0, 0.0},
        };

        if (payPlan == 1)
            payIndex = 0;
        else if (payPlan == 2 || payPlan == 3 || payPlan == 5)
            payIndex = 1;
        else if (payPlan == 8 || payPlan == 10)
            payIndex = 2;

        if (recipientAge <= 70)
            ageIndex = 0;
        else if (recipientAge > 70 && recipientAge <= 80)
            ageIndex = 1;
        else if (recipientAge > 80 && recipientAge <= 90)
            ageIndex = 2;
        else
            ageIndex = 3;

        return rates[payIndex][ageIndex];
    }

}
