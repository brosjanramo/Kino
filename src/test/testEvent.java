
import Gruppe10.Model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class testEvent {
    static Event test;

    @BeforeAll
    static void init(){
        test = new Event("Kino", LocalDate.now(), 18, "Her", 120,20, 20,2, "beskrivelse");
    }
    @Test
    public void GetTitleKino(){
        Assertions.assertEquals("Kino",test.getTitle());
    }
    @Test
    public void GetCapacity400(){
        Assertions.assertEquals(400,test.getCapacity());
    }
}