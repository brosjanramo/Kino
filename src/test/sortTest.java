
import Gruppe10.Data.DataHandler;
import Gruppe10.Model.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




public class sortTest {


    ObservableList<Event> testListWithEvents = FXCollections.observableArrayList();



    @Test
    public void addEventsToListTest(){


        Assertions.assertEquals(3, DataHandler.getEventData().size());

    }


    @Test
    public void sortByAlfabetical(){




    }

    @Test
    public void sortByDate(){



    }

    @Test
    public void sortByPrice(){



    }

    @Test
    public void sortByCapacity(){



    }

}
