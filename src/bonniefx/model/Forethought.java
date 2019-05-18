package bonniefx.model;

import org.joda.money.Money;

public class Forethought extends Item {

    private int payPlan;

    public Forethought(String product, Money faceValue, int payPlan) {
        super(product, faceValue);
        this.payPlan = payPlan;
    }

    public int getPayPlan() {
        return payPlan;
    }

    public void setPayPlan(int payPlan) {
        this.payPlan = payPlan;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + "Object {" + NL);
        result.append("Product: " + getProduct() + NL);
        result.append("Face Amount: " + getBoardValue() + NL);
        result.append("Payment Plan: " + payPlan + " years" + NL);
        result.append("}");

        return result.toString();
    }

    @Override
    public double getCommissionRate() {
        double rate = 0.0;
        if (getProduct().equals("Insurance"))
            rate = getInsuranceRate();
        else if (getProduct().equals("Trust"))
            rate = 0.03;
        else if (getProduct().equals("Travel"))
            rate = 0.0;
        else
            System.err.println("invalid product");
        return rate;
    }

    @Override
    public Money getFlatCommission() {

        if (getProduct().equals("Travel"))
            return Utils.toUSD("85.00");
        else
            return Utils.toUSD("0.00");
    }

    private double getInsuranceRate() {
        int recipientAge = Sale.getInstance().getRecipient().getAge();

        double rate = 0.0;
        int payIndex = 0;
        int ageIndex;
        double[][] rates = {
                {0.070, 0.065, 0.060, 0.040},
                {0.055, 0.050, 0.040, 0.030},
                {0.040, 0.040, 0.0, 0.0},
        };

        if (payPlan == 1)
            payIndex = 0;
        else if (payPlan > 1 && payPlan <= 5)
            payIndex = 1;
        else if (payPlan > 5 && payPlan <= 10)
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
