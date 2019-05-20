package com.edmointel.bonneyfx.model;

import java.util.ArrayList;

public class SalesGroup {
    private SalesPerson primaryServiceDirector;
    private ArrayList<SalesPerson> secondaryServiceDirectors;

    public SalesGroup(SalesPerson primaryServiceDirector, ArrayList<SalesPerson> salesPeople) {
        this.primaryServiceDirector = primaryServiceDirector;
        this.secondaryServiceDirectors = salesPeople;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NL);
        result.append("Primary Service Director: " + primaryServiceDirector + NL);
        for (SalesPerson s : secondaryServiceDirectors)
            result.append("Service Director: " + s + NL);

        return result.toString();
    }

}
