package Json;

import Model.Event;
import com.google.gson.Gson;
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

        JSONArray employeeList = new JSONArray();
        employeeList.add(convertGson(event));
        employeeList.add(convertGson(event));

        try (FileWriter file = new FileWriter("resource/write_example.json")) {

            file.write(employeeList.toJSONString());
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
