package bonniefx.model;

import org.joda.money.Money;

class Utils {

    static void appendString(StringBuilder builder, String value) {
        builder.append(value + System.lineSeparator());
    }

    static Money toUSD(String usd) {
        return Money.parse("USD " + usd);
    }


}
