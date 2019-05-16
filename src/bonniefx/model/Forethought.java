package bonniefx.model;

import org.joda.money.Money;

public class Forethought extends Item {

    private int payPlan;

    public Forethought() {

    }

    public Forethought(Product product) {
        super(product);
    }

    public int getPayPlan() {
        return payPlan;
    }

    public void setPayPlan(int payPlan) {
        this.payPlan = payPlan;
    }

    @Override
    public double getCommissionRate() {
        double rate = 0.0;
        if (getProduct() == Product.INSURANCE)
            rate = getInsuranceRate();
        else if (getProduct() == Product.TRUST)
            rate = 0.03;
        else if (getProduct() == Product.TRAVEL)
            rate = 0.0;
        else
            System.err.println("invalid product");

        return rate;
    }

    @Override
    public Money getFlatCommission() {
        if (getProduct() == Product.TRAVEL)
            return Utils.toUSD("85.00");
        else
            return Utils.toUSD("0.00");
    }

    private double getInsuranceRate() {
        double rate = 0.0;
        int payIndex = 0;
        int ageIndex;
        int age = getRecipient().getAge();
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

        if (age <= 70)
            ageIndex = 0;
        else if (age > 70 && age <= 80)
            ageIndex = 1;
        else if (age > 80 && age <= 90)
            ageIndex = 2;
        else
            ageIndex = 3;

        return rates[payIndex][ageIndex];
    }
}
