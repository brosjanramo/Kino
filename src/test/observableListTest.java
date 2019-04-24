import Gruppe10.Data.DataHandler;
import Gruppe10.Json.ReadJson;
import Gruppe10.MainJavaFX;
import Gruppe10.Model.Event;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class observableListTest {
    @Test
    void managerIdSjekk(){

        Event testEvent = new Event("Avengers: Endgame", LocalDate.of(2019,04,24), 123456, 12,
                "Fredrikstad", 100, 20, 5, 0, "The conclusion of Infinity War", 1700);
        Event testEvent2 = new Event("Avengers: Infinity War", LocalDate.of(2017,04,24), 123456, 12,
                "Fredrikstad", 100, 20, 5, 0, "The fourth Avengers movie", 1530);
        ArrayList<Event> testEventList = new ArrayList<>();
        testEventList.add(testEvent);
        testEventList.add(testEvent2);

       for (int i = 0; i < testEventList.size(); i++){
           int managerID = 0;
           if (testEventList.get(i).getManagerId() == 123456){
               managerID = testEventList.get(i).getManagerId();
               assertEquals(123456, managerID);
           }
       }
    }
}
