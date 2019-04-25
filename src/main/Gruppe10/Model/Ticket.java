package Gruppe10.Model;

public class Ticket {
    Event event;
    Customer customer;
    int seat, row, stand;

    public Ticket(Event event, Customer customer, int seat, int row, int stand) {
        this.event = event;
        this.customer = customer;
        this.seat = seat;
        this.row = row;
        this.stand = stand;

        event.setSeats(seat, row);
    }
}
