package Gruppe10.Json;

import Gruppe10.Model.Event;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReadJson {
    private static ArrayList<Event> eventsList;

    public static void main(String[] args){

    }

    public static ArrayList<Event> getList() {
        readJson();
        return eventsList;
    }

    private static void readJson(){
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("eventgruppe10.json")) {
            Object obj = parser.parse(reader);
            JSONArray jsonObj = (JSONArray) obj;
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Event>>(){}.getType();
            eventsList = gson.fromJson(jsonObj.toJSONString(), type);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
