package Model;

import java.time.LocalDate;

public class UnumEvent extends Event {

    public UnumEvent(int EventId, int MangagerId, String Title, LocalDate Date, int Agerestrict, String place, int Capacity, int Price) {
        super(Title, Date, Agerestrict, place, Capacity, Price);
    }

    void PrintBillett(){

    }
}
