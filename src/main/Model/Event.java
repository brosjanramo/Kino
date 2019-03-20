package Model;

import java.time.LocalDate;


public class Event {

    private int eventId;
    private int managerId;
    private String title;
    private LocalDate date;
    private int ageRestrict;
    private String place;
    private int capacity;
    private int price;


    public Event(String title, LocalDate date, int agerestrict, String place, int capacity, int price) {
        this.title = title;
        this.date = date;
        this.ageRestrict = agerestrict;
        this.place = place;
        this.capacity = capacity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Event{" +
                "EventId=" + eventId +
                ", ManagerId=" + managerId +
                ", Title=" + title +
                ", Date=" + date +
                ", Agerestrict=" + ageRestrict +
                ", place='" + place + '\'' +
                ", Capacity=" + capacity +
                ", Price=" + price +
                '}';
    }

}
