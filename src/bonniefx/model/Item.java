package bonniefx.model;

import org.joda.money.Money;

import java.math.RoundingMode;

public abstract class Item {

    private Money boardValue;
    private Product product;
    private Recipient recipient;

    public Item() {
    }


    public Item(Product product) {
        this.product = product;
    }

    public abstract double getCommissionRate();

    public abstract Money getFlatCommission();

    public Money getCommission() {
        return getBoardValue().multipliedBy(getCommissionRate(), RoundingMode.UP).plus(getFlatCommission());
    }

    public Money getBoardValue() {
        return boardValue;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public void setBoardValue(Money boardValue) {
        this.boardValue = boardValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
