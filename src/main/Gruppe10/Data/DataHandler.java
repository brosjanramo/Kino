package Gruppe10.Data;

import Gruppe10.Model.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class DataHandler {
    private final static ObservableList<Event> eventList = FXCollections.observableArrayList();

    public static ObservableList<Event> getEventData() {
        if (eventList.isEmpty()) {
            generateEventData();
        }
        return eventList;
    }

    private static void generateEventData() {
        eventList.add(new Event("Test title", LocalDate.now(), 18, "test sted", 200, 100, 100,100, "beskrivelse"));
    }

}
