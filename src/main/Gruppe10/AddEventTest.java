package Gruppe10;

import Gruppe10.Json.ReadJson;
import Gruppe10.Json.WriteJson;
import Gruppe10.Model.Event;
import Gruppe10.Model.Manager;
import com.google.gson.stream.JsonReader;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddEventTest {
    public static void main(String[] args) {
        ArrayList<Event> arrayList = ReadJson.getList();
        Event event = new Event("Title", LocalDate.now(), 123456,18,"Location",120, 2,2, 3,"Description", 120);
        arrayList.add(event);
        WriteJson.addToJson(arrayList);

        System.out.println("Event Created!");
    }
}
