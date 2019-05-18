package bonniefx.model;

public class SalesPerson extends Person {
    private double splitPCT;

    public SalesPerson(String name, double splitPCT) {
        super(name);
        this.splitPCT = splitPCT;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NL);
        result.append(super.toString() + NL);
        result.append("Split%: " + splitPCT + NL);

        return result.toString();
    }

    public double getSplitPCT() {
        return splitPCT;
    }

    public void setSplitPCT(double splitPCT) {
        this.splitPCT = splitPCT;
    }

}
