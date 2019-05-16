package bonniefx.model;

import org.joda.money.Money;

public class AtNeedItem extends Item {

    public AtNeedItem() {
    }

    public AtNeedItem(Product product, Recipient recipient) {
        super(product);
        setRecipient(recipient);
    }

    @Override
    public double getCommissionRate() {
        Recipient recipient = getRecipient();
        double rate = 0.0;

        if (getProduct() == Product.PROPERTY) {
            if (recipient.getPlotCode().isCremation())
                rate = 0.19;
            else // non cremation
                if (recipient.diedOverOneYearAgo())
                    rate = 0.15;
                else
                    rate = 0.08;
        } else if (getProduct() == Product.MERCHANDISE)
            rate = 0.05;
        else if (getProduct() == Product.INTERMENT)
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
