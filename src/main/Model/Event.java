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
        return "Event: " + getTitle() + " Dato: " + getDate() + " Place: "+ getPlace();/*"Event{" +
                "EventId=" + eventId +
                ", ManagerId=" + managerId +
                ", Title=" + title +
                ", Date=" + date +
                ", Agerestrict=" + ageRestrict +
                ", place='" + place + '\'' +
                ", Capacity=" + capacity +
                ", Price=" + price +
                '}';*/
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAgeRestrict() {
        return ageRestrict;
    }

    public void setAgeRestrict(int ageRestrict) {
        this.ageRestrict = ageRestrict;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
