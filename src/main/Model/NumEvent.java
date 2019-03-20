package Model;

import java.time.LocalDate;

public class NumEvent extends Event {
    private String TribuneSal;
    private int Rad, Plass;

    public NumEvent(int EventId, int ManagerId, String Title, LocalDate Date, int ageRestrict,
                    String place, int Capacity, int Price, String tribuneSal, int rad, int plass) {
        super(Title, Date, ageRestrict, place, Capacity, Price);
        TribuneSal = tribuneSal;
        Rad = rad;
        Plass = plass;
    }

    void PrintBillett(){

    }
}
