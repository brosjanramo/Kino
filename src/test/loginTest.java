import Gruppe10.MainJavaFX;
import Gruppe10.Model.Event;
import Gruppe10.Model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class loginTest {
    @Test //Denne testen viser at du kan hente en liste med Personer og bruke deres ID for å logge inn
    void loginTest() {
        MainJavaFX.setCurrentPassword(123456);
        int testID = 0;
        for (int i = 0; i < MainJavaFX.managerList().size(); i++) {
            if (MainJavaFX.managerList().get(i).getId() == MainJavaFX.getCurrentPassword()) {
                testID = MainJavaFX.managerList().get(i).getId();
            }
        }
        assertEquals(MainJavaFX.getCurrentPassword(), testID);
    }

    @Test //Denne testen skal feile fordi ID-en tasta inn ikke matcher ID til personen
    void wrongIdTest() {
        MainJavaFX.setCurrentPassword(111111);
        int testID = 0;
        for (int i = 0; i < MainJavaFX.managerList().size(); i++) {
            if (MainJavaFX.managerList().get(i).getId() == MainJavaFX.getCurrentPassword()) {
                testID = MainJavaFX.managerList().get(i).getId();
            }
        }
        assertEquals(MainJavaFX.getCurrentPassword(), testID);
    }

    @Test //Denne testen sjekker om en observable list kun tar med Events med riktig ID
    void observableListTest(){
        int listSize = 0;

        Event testEvent = new Event("Avengers: Endgame", LocalDate.of(2019,04,24), 123456, 12,
                "Fredrikstad", 100, 20, 5, 0, "The conclusion of Infinity War", 1700);
        Event testEvent2 = new Event("Avengers: Infinity War", LocalDate.of(2017,04,24), 123456, 12,
                "Fredrikstad", 100, 20, 5, 0, "The fourth Avengers movie", 1530);
        Event testEvent3 = new Event("Harry Potter", LocalDate.of(2012,06,20), 123123, 12,
                "Fredrikstad", 100, 20, 5, 0, "Wizard Gang", 1530);
        ArrayList<Event> testEventList = new ArrayList<>();
        testEventList.add(testEvent);
        testEventList.add(testEvent2);
        testEventList.add(testEvent3);

        MainJavaFX.setCurrentPassword(123456);

        for (int i = 0; i < testEventList.size(); i++){
            if (testEventList.get(i).getManagerId() == MainJavaFX.getCurrentPassword() && MainJavaFX.getCurrentPassword() != 0){
                listSize += 1;
            }
        }
        assertEquals(listSize, 2);
        }
    }
