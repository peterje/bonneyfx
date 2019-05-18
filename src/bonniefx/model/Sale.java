package bonniefx.model;

import org.joda.money.Money;

public class Sale {
    private final static Sale instance = new Sale();
    private Item item;
    private Recipient recipient;
    private SalesGroup salesGroup;

    public static Sale getInstance() {
        return instance;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Money getComission() {
        return item.getCommission();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NL);
        result.append("Item: " + item + NL);
        result.append("Recipient: " + recipient + NL);
        result.append("Sales Group: " + salesGroup + NL);
        result.append("TOTAL COMMISSION: " + getComission() + NL);
        result.append("}");

        return result.toString();
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public SalesGroup getSalesGroup() {
        return salesGroup;
    }

    public void setSalesGroup(SalesGroup salesGroup) {
        this.salesGroup = salesGroup;
    }
}
