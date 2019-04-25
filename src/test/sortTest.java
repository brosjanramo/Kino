
import Gruppe10.Data.DataHandler;
import Gruppe10.Model.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Comparator;


public class sortTest {


    //Dette er testdata som jeg bruker til å teste om sorteringsmetodene mine fungerer
    ObservableList<Event> testListWithEvents = FXCollections.observableArrayList();
    

    Event event1= new Event("Ab", LocalDate.of(2019,05,05),1,16,"Oslo",199,10,5,0,"descriotion",2100);
    Event event2= new Event("Bc", LocalDate.of(2020,05,05),1,16,"Oslo",299,5,5,0,"descriotion",2100);
    Event event3= new Event("Cd", LocalDate.of(2021,05,05),1,16,"Oslo",399,20,5,0,"descriotion",2100);


    @Test
    public void sortByAlfabeticalAscending(){

        testListWithEvents.addAll(event1,event2,event3);

        Comparator<Event> comparator= Comparator.comparing(Event::getTitle);
        FXCollections.sort(testListWithEvents, comparator);

        Assertions.assertEquals("Ab",testListWithEvents.get(0).getTitle());
    }

    @Test
    public void sortByDateAscending(){

        testListWithEvents.addAll(event1,event2,event3);

        Comparator<Event> comparator= Comparator.comparing(Event::getDate);
        FXCollections.sort(testListWithEvents, comparator);

        Assertions.assertEquals(2021,testListWithEvents.get(2).getDate().getYear());
    }

    @Test
    public void sortByPriceDescending(){

        testListWithEvents.addAll(event1,event2,event3);

        Comparator<Event>comparator= Comparator.comparing(Event::getPrice);
        FXCollections.sort(testListWithEvents, comparator.reversed());

        Assertions.assertEquals(399,testListWithEvents.get(0).getPrice());
    }

    @Test
    public void sortByCapacityDescending(){

        testListWithEvents.addAll(event1,event2,event3);

        Comparator<Event>comparator= Comparator.comparingInt(Event::getCapacity);
        FXCollections.sort(testListWithEvents, comparator.reversed());

        Assertions.assertEquals(100,testListWithEvents.get(0).getCapacity());

    }

}
