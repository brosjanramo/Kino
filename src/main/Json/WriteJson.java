package Json;

import Model.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class WriteJson {

    public static void main(String[] args){
        Event testEvent = new Event("Test", LocalDate.now(), 12, "Sted", 42, 120);
        WriteJson(testEvent);
    }


    public static void WriteJson(Event event){


        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        String jsonEvent = gson.toJson(event);

        try (FileWriter file = new FileWriter("write_example.json")) {

            file.write(jsonEvent);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertGson(Event event){
        Gson gson = new Gson();
        String eventJson = gson.toJson(event);
        return eventJson;
    }
}
