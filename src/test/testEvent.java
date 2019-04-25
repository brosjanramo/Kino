
import Gruppe10.Model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class testEvent {
    private static Event event;
    private static ArrayList<Event> eventList = new ArrayList<>();

    @BeforeAll
    static void init(){
        event = new Event("Movie", LocalDate.now(), 123456,11,"Location",120, 5,6, 1,"Description", 120);
        Event concertEvent = new Event("Concert", LocalDate.now(), 123456,18,"Location",220, 20,20, 3,"Description", 360);
        eventList.add(event);
        eventList.add(concertEvent);

    }
    @Test
    public void GetTitleMovie(){
        Assertions.assertEquals("Movie",event.getTitle());
    }
    @Test
    public void GetCapacity30(){
        Assertions.assertEquals(30,event.getCapacity());
    }
    @Test
    public void GetEventListLength(){
        Assertions.assertEquals(2, eventList.size());
    }
    @Test
    public void GetTitleAfterEdit(){
        event.setTitle("Title");
        Assertions.assertEquals("Title",eventList.get(0).getTitle());
    }
}