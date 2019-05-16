package bonniefx.model;

public class SalesPerson extends Person {
    private double splitPCT;

    public double getSplitPCT() {
        return splitPCT;
    }

    public void setSplitPCT(double splitPCT) {
        this.splitPCT = splitPCT;
    }

    public SalesPerson() {
        this.splitPCT = 100.0;
    }

    public SalesPerson(String name) {
        super(name);
    }

    public SalesPerson(String name, double splitPCT) {
        super(name);
        this.splitPCT = splitPCT;
    }

}
