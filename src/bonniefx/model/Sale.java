package bonniefx.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sale {
    private Item item;
    private Recipient recipient;

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    private SalesGroup salesGroup;
    private LocalDate dateOfPurchase;

    public Sale(DateTimeFormatter dateFormat) {
        DateTimeFormatter dateFormat1 = dateFormat;
        LocalDate currentDate = LocalDate.now();
    }

    @Override
    public String toString() {
        String ret = "";
        return ret;
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
