package Gruppe10;

import Gruppe10.Json.ReadJson;
import Gruppe10.Json.WriteJson;
import Gruppe10.Model.Event;
import com.google.gson.stream.JsonReader;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddEventTest {
    public static void main(String[] args) {
        ArrayList<Event> arrayList = ReadJson.getList();
        Event event = new Event("Title", LocalDate.now(), 18, "Sted",120, 2,2,2,"Be");
        arrayList.add(event);
        WriteJson.addToJson(arrayList);

        System.out.println("Event Created!");
    }
}
