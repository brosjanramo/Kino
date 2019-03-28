
import Gruppe10.Model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class testEvent {
    @Test
    public void GetTitleKino(){
        Event test = new Event("Kino", LocalDate.now(), 18, "Her", 120,99);
        Assertions.assertEquals("Kino",test.getTitle());
    }
}