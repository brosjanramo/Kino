package Gruppe10.Json;

import Gruppe10.MainJavaFX;
import Gruppe10.Model.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class WriteJson {

    @SuppressWarnings("unchecked")
    public static void main (String[] args){
        ArrayList<Event> eventArrayList = new ArrayList<>();
        //eventArrayList.add(new Event("Test title", LocalDate.now(), MainJavaFX.getCurrentPassword(), 18, "test sted", 200, 2, 2,2, "beskrivelse"));
        //eventArrayList.add(new Event("Test title", LocalDate.now(), MainJavaFX.getCurrentPassword(), 18, "test sted", 200, 2, 2,2, "beskrivelse"));
        //eventArrayList.add(new Event("Test title", LocalDate.now(), MainJavaFX.getCurrentPassword(), 18, "test sted", 200, 2, 2,2, "beskrivelse"));
        addToJson(eventArrayList);
    }

    public static void addToJson(ArrayList<Event> event){
        // initiate Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonEvent = gson.toJson(event);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(EventPath.eventPath))) {
            bufferedWriter.write(jsonEvent);
        } catch (IOException ioexc) {
            System.out.println(ioexc.getMessage());
        }
    }
}
