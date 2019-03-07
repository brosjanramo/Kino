package Model;

import java.time.LocalDate;

public class UnumEvent extends Event {

    public UnumEvent(int EventId, int MangagerId, int Title, LocalDate Date, LocalDate Agerestrict, String place, int Capacity, int Price) {
        super(EventId, MangagerId, Title, Date, Agerestrict, place, Capacity, Price);
    }

    void PrintBillett(){

    }
}
