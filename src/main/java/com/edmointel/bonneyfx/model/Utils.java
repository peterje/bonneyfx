package com.edmointel.bonneyfx.model;

import org.joda.money.Money;

public class Utils {

    public static Money toUSD(String usd) {
        return Money.parse("USD " + usd);
    }


}
