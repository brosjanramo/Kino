package Gruppe10.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

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
    }
}
