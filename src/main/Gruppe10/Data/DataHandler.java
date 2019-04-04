package Gruppe10.Data;

import Gruppe10.Json.ReadJson;
import Gruppe10.Model.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private final static ObservableList<Event> eventList = FXCollections.observableArrayList();

    public static ObservableList<Event> getEventData() {
            eventList.clear();
            eventList.addAll(ReadJson.getList());
        return eventList;
    }

    public static ArrayList<Event> getEventList(){
        ArrayList<Event> eventArrayList = new ArrayList<>();
        eventArrayList.addAll(eventList);
        return eventArrayList;
    }

}
