package com.edmointel.bonneyfx.model;

import org.joda.money.Money;

public class PreNeedItem extends Item {
    private LeadCode leadCode;
    private Money downPayment;
    private PlotCode plotCode;


    public PreNeedItem(String product, Money boardValue, Money downPayment, LeadCode leadCode, PlotCode plotCode) {
        super(product, boardValue);
        this.downPayment = downPayment;
        this.leadCode = leadCode;
        this.plotCode = plotCode;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + "Object {" + NL);
        result.append("Product: " + getProduct() + NL);
        result.append("Value: " + getBoardValue() + NL);
        result.append("Down Payment: " + downPayment + NL);
        result.append("LeadCode: " + leadCode + NL);
        result.append("PlotCode: " + plotCode + NL);
        result.append("}");

        return result.toString();
    }

    @Override
    public double getCommissionRate() {
        double rate = 0.0;

        if (getProduct().equals("Property"))
            if (plotCode.isCremation())
                rate = 0.19;
            else
                rate = 0.15;
        else if (getProduct().equals("Merchandise"))
            rate = 0.08;
        else if (getProduct().equals("Interment"))
            rate = 0.03;

        if (!leadCode.isCompany())
            rate += 0.01;
        if (downPayment.equals(getBoardValue()))
            rate += 0.01;

        return rate;
    }

    @Override
    public Money getFlatCommission() {
        return Utils.toUSD("0.00");
    }

    public Money getDeferred() {
        if (downPayment.isLessThan(getCommission()))
            return getCommission().minus(downPayment);
        else
            return Utils.toUSD("0.00");

    }

    public LeadCode getLeadCode() {
        return leadCode;
    }

    public void setLeadCode(LeadCode leadCode) {
        this.leadCode = leadCode;
    }

    public Money getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(Money downPayment) {
        this.downPayment = downPayment;
    }
}
