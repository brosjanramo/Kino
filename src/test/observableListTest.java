import Gruppe10.Data.DataHandler;
import Gruppe10.Json.ReadJson;
import Gruppe10.MainJavaFX;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class observableListTest {
    @Test
    void managerIdSjekk(){
       for (int i = 0; i > DataHandler.getEventData().size(); i++){
           int managerID = 0;
           if (DataHandler.getEventData().get(i).getManagerId() == 123456){
               managerID = DataHandler.getEventData().get(i).getManagerId();
               assertEquals(123456, managerID);
           }
       }
    }
}
