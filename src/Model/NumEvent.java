package Model;

public class NumEvent extends Event {
    private String TribuneSal;
    private int Rad, Plass;

    public NumEvent(String tribuneSal, int rad, int plass) {
        super();
        TribuneSal = tribuneSal;
        Rad = rad;
        Plass = plass;
    }

    void PrintBillett(){

    }
}
