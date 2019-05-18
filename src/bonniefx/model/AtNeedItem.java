package bonniefx.model;

import org.joda.money.Money;

public class AtNeedItem extends Item {

    private PlotCode plotCode;

    public AtNeedItem(String product, Money boardValue, PlotCode plotCode) {
        super(product, boardValue);
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
        Recipient recipient = Sale.getInstance().getRecipient();
        double rate = 0.0;
        if (getProduct().equals("Property")) {
            if (plotCode.isCremation())
                rate = 0.19;
            else // non cremation
                if (recipient.diedOverOneYearAgo())
                    rate = 0.15;
                else
                    rate = 0.08;
        } else if (getProduct().equals("Merchandise"))
            rate = 0.05;
        else if (getProduct().equals("Interment"))
            rate = 0.0;
        else
            System.err.println("bonniefx.model.AtNeedItem with non AtNeed product: " + getProduct());

        return rate;
    }

    @Override
    public Money getFlatCommission() {
        return Utils.toUSD("0.00");
    }

}
