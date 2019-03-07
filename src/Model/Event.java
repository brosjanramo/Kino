package Model;

import java.time.LocalDate;


public class Event {

    private int EventId;
    private int ManagerId;
    private int Title;
    private LocalDate Date;
    private LocalDate Agerestrict;
    private String place;
    private int Capacity;
    private int Price;

    public int getEventId() {
        return EventId;
    }

    public void setEventId(int eventId) {
        EventId = eventId;
    }

    public int getManagerId() {
        return ManagerId;
    }

    public void setManagerId(int managerId) {
        ManagerId = managerId;
    }

    public int getTitle() {
        return Title;
    }

    public void setTitle(int title) {
        Title = title;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public LocalDate getAgerestrict() {
        return Agerestrict;
    }

    public void setAgerestrict(LocalDate agerestrict) {
        Agerestrict = agerestrict;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
