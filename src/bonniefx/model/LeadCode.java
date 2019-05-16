package bonniefx.model;

public enum LeadCode {
    PERSONAL(false), COMPANY(true);
    private final boolean isCompany;

    LeadCode(boolean isCompany) {
        this.isCompany = isCompany;
    }

    public boolean isCompany() {
        return this.isCompany;
    }

}
