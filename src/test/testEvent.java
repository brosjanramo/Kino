
import Gruppe10.Controller.HovedLayoutController;
import Gruppe10.Model.Customer;
import Gruppe10.Model.Event;
import Gruppe10.Model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class testEvent {
    private static Event event;
    private static Customer testson;
    private static ArrayList<Event> eventList = new ArrayList<>();

    @BeforeEach
    void init() {
        event = new Event("Movie", LocalDate.now(), 123456, 11, "Location", 120, 5, 6, 1, "Description", 120);
        Event concertEvent = new Event("Concert", LocalDate.now(), 123456, 18, "Location", 220, 20, 20, 3, "Description", 360);
        eventList.clear();
        eventList.add(event);
        eventList.add(concertEvent);
        testson = new Customer("First Testson", LocalDate.now(), "test@test.com", 12345678, "Here");

    }

    @Test
    public void GetTitleMovie() {
        Assertions.assertEquals("Movie", event.getTitle());
    }

    @Test
    public void GetCapacity30() {
        Assertions.assertEquals(30, event.getCapacity());
    }

    @Test
    public void GetEventListLength() {
        Assertions.assertEquals(2, eventList.size());
    }

    @Test
    public void GetTitleAfterEdit() {
        event.setTitle("Title");
        Assertions.assertEquals("Title", eventList.get(0).getTitle());
    }

    @Test
    public void GetAvailableSeat() {
        Assertions.assertEquals(0, event.getSeats(2, 1));
    }

    @Test
    public void GetCorrectSeat() {
        new Ticket(event, testson, 1, 1, 1);
        Assertions.assertEquals(1, event.getSeats(1, 1));
    }

    @Test
    public void GetTakenSeat() {
        new Ticket(event, testson, 2, 2, 1);
        Assertions.assertEquals(1, event.getSeats(2, 2));
    }

    @Test
    public void DeleteEvent() {
        eventList.remove(event);
        Assertions.assertEquals(1, eventList.size());
    }

    @Test
    public void ConcertIsLeft() {
        eventList.remove(event);
        Assertions.assertEquals("Concert", eventList.get(0).getTitle());
    }

}