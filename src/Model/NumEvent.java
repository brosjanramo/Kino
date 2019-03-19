package Model;

import java.time.LocalDate;

public class NumEvent extends Event {
    private String TribuneSal;
    private int Rad, Plass;

    public NumEvent(int EventId, int ManagerId, int Title, LocalDate Date, LocalDate Agerestrict,
                    String place, int Capacity, int Price, String tribuneSal, int rad, int plass) {
        super(EventId, ManagerId, Title, Date, Agerestrict, place, Capacity, Price);
        TribuneSal = tribuneSal;
        Rad = rad;
        Plass = plass;
    }

    void PrintBillett(){

    }
}
