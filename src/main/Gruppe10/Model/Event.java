package Gruppe10.Model;

import Gruppe10.Json.ReadJson;

import java.time.LocalDate;


public class Event {

    private static int eventId;
    private String description;
    private int managerId;
    private String title;
    private LocalDate date;
    private int ageRestrict;
    private String place;
    private int capacity;
    private int price;
    private int seat;
    private int row;
    private int seats[][];
    private int stand;



    public Event() {

    }

    public Event(String title, LocalDate date, int agerestrict, String place, int price, int seat, int row,int stand, String description) {
        this.title = title;
        this.date = date;
        this.ageRestrict = agerestrict;
        this.place = place;
        this.capacity = seat*row;
        this.price = price;
        this.seat = seat;
        this.row = row;
        this.seats = new int[seat][row];
        this.description = description;
        this.stand=stand;
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

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
