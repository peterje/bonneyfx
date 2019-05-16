package bonniefx.model;

import org.joda.money.Money;

public class PreNeedItem extends Item {
    private LeadCode leadCode;
    private boolean paidInFull;
    private Money downPayment;

    public PreNeedItem() {

    }

    public PreNeedItem(Product product, boolean paidInFull, Money downPayment, LeadCode leadCode) {
        super(product);
        this.paidInFull = paidInFull;
        this.downPayment = downPayment;
        this.leadCode = leadCode;
    }

    @Override
    public double getCommissionRate() {
        Recipient recipient = getRecipient();
        double rate = 0.0;

        if (getProduct() == Product.PROPERTY)
            if (recipient.getPlotCode().isCremation())
                rate = 0.19;
            else
                rate = 0.15;
        else if (getProduct() == Product.MERCHANDISE)
            rate = 0.08;
        else if (getProduct() == Product.INTERMENT)
            rate = 0.03;

        if (!leadCode.isCompany())
            rate += 0.01;
        if (paidInFull)
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

    public boolean isPaidInFull() {
        return paidInFull;
    }

    public void setPaidInFull(boolean paidInFull) {
        this.paidInFull = paidInFull;
    }

    public Money getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(Money downPayment) {
        this.downPayment = downPayment;
    }
}
