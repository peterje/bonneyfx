package bonniefx.model;

public enum PlotCode {
    _6(false), _7(false), _8(false), _9(false),
    _10(false), _11(false), _12(false), _13(false),
    _14(false), _15(false), _16(false), _17(false),
    _18(false), _19(false), _20(false), _21(false),
    _23(false), _17S(false), CC(false), VERSES(false),
    VETS(false), VETS_N(false),

    CN(true), COH(true), ELN(true), GOM(true), MVC(true),
    RAD(true), SER(true), ELC(true), COM(true), ELM(true),
    GCM(true), TGM(true);

    private final boolean isCremation;

    PlotCode(boolean isCremation) {
        this.isCremation = isCremation;
    }

    public boolean isCremation() {
        return isCremation;
    }
}
