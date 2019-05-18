package bonniefx.model;

import org.joda.money.Money;

public class Utils {

    public static void appendString(StringBuilder builder, String value) {
        builder.append(value + System.lineSeparator());
    }

    public static Money toUSD(String usd) {
        return Money.parse("USD " + usd);
    }


}
