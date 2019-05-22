package com.edmointel.bonneyfx.model;

import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;


public class Sale {
    private final static Sale instance = new Sale();
    private Person purchaser;
    private Recipient recipient;
    private List<Item> itemsSold = new ArrayList<>();
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

    public Person getPurchaser()
    {
    	return purchaser;
    }
    
    public void setPurchaser(Person p)
    {
    	this.purchaser = p;
    }

    public Money getCommission() {
        Money total = Utils.toUSD("0.00");
        for(Item i : itemsSold)
        {
            total = total.plus(i.getCommission());
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NL);
        result.append("Recipient: " + recipient + NL);
        result.append("Sales Group: " + salesGroup + NL);
        result.append("TOTAL COMMISSION: " + getCommission() + NL);
        result.append("}");

        return result.toString();
    }

    public void addItem(Item item)
    {
        itemsSold.add(item);
    }

    public void setSalesGroup(SalesGroup salesGroup) {
        this.salesGroup = salesGroup;
    }

    public SalesGroup getSalesGroup() {
        return salesGroup;
    }
}
