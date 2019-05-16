package bonniefx.model;

import java.time.format.DateTimeFormatter;

public class SaleCreator {
    private final static SaleCreator instance = new SaleCreator();

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    Sale sale = new Sale(dateFormat);

    public static SaleCreator getInstance() {
        return instance;
    }

    public Sale getSale() {
        return sale;
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }
}
