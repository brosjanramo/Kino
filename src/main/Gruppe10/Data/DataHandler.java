package Gruppe10.Data;

import Gruppe10.Json.ReadJson;
import Gruppe10.Model.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class DataHandler {
    private final static ObservableList<Event> eventList = FXCollections.observableArrayList();

    public static ObservableList<Event> getEventData() {
        if (eventList.isEmpty()) {
            eventList.addAll(ReadJson.getList());
        }
        return eventList;
    }
}
