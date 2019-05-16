package bonniefx.model;

import java.util.ArrayList;

public class SalesGroup {
    private SalesPerson primaryServiceDirector;
    private ArrayList<SalesPerson> secondaryServiceDirectors;

    public SalesGroup(SalesPerson primaryServiceDirector, ArrayList<SalesPerson> salesPeople) {
        this.primaryServiceDirector = primaryServiceDirector;
        this.secondaryServiceDirectors = salesPeople;
    }

    public void addServiceDirector(SalesPerson serviceDirector) {
        secondaryServiceDirectors.add(serviceDirector);
    }

    public SalesPerson getPrimaryServiceDirector() {
        return primaryServiceDirector;
    }

    public void setPrimaryServiceDirector(SalesPerson primaryServiceDirector) {
        this.primaryServiceDirector = primaryServiceDirector;
    }

    public ArrayList<SalesPerson> getSecondaryServiceDirectors() {
        return secondaryServiceDirectors;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Primary Service Director: " + primaryServiceDirector.getName() + " Split: " + primaryServiceDirector.getSplitPCT() + "\n";
        for (SalesPerson p : secondaryServiceDirectors)
            ret += "Service Director: " + p.getName() + " Split: " + p.getSplitPCT() + "\n";

        return ret;
    }

}
