package Gruppe10.Json;

import Gruppe10.Model.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class WriteJson {

    @SuppressWarnings("unchecked")
    public static void main (String[] args){
        JSONObject obj = new JSONObject();
        obj.put("name", "Test1");
        obj.put("Mail", "Test@hiof.pk");

        JSONArray list = new JSONArray();
        list.add("sopptur");
        list.add("konsert");

        obj.put("Events", list);

        try{
            FileWriter file = new FileWriter("json/write.json");
            file.write(obj.toString());
            file.flush();
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(obj);

        ArrayList<Event> eventArrayList = new ArrayList<>();
        eventArrayList.add(new Event("Test title", LocalDate.now(), 18, "test sted", 200, 2, 2,2, "beskrivelse"));
        eventArrayList.add(new Event("Test title", LocalDate.now(), 18, "test sted", 200, 2, 2,2, "beskrivelse"));
        eventArrayList.add(new Event("Test title", LocalDate.now(), 18, "test sted", 200, 2, 2,2, "beskrivelse"));
        addToJson(eventArrayList);
    }

    public static void addToJson(Event event){
        // initiate Gson
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String jsonEvent = gson.toJson(event);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("res/write.json"))) {
            bufferedWriter.write(jsonEvent);
        } catch (IOException ioexc) {
            System.out.println(ioexc.getMessage());
        }
    }
}
