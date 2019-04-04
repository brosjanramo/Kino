package Gruppe10.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;

// Hvis koden er rød gå inn på linken
// https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1
// Last ned bundle, gå tilbake til intellij, trykk på file, procjekt structure, libaries og trykk på grønn pluss knapp og legg til filen

public class ReadJson {

    public static void main(String[] args){
        //ClassLoader classLoader = new ReadJson().getClass().getClassLoader();

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("write.json")) {

            Object obj = parser.parse(reader);
            JSONArray jsonObj = (JSONArray) obj;

            //Skriver ut all informasjon
            //JSONObject personDetails = (JSONObject) jsonObj.get("eventId");
            //System.out.println("personDetails :" +personDetails.toJSONString());

            jsonObj.forEach( event -> parseEventObject( (JSONObject) event) );

            //Skriver ut hver enkelt hver for seg
            //String Name = (String)personDetails.get("title");
            //System.out.println("Name :"+ Name);
/*
            String personID = (String)personDetails.get("id");
            System.out.println("PersonID :"+ personID);

            String Birth = (String)personDetails.get("birthdate");
            System.out.println("Birth :"+ Birth);

            String Mail = (String)personDetails.get("email");
            System.out.println("Mail :"+ Mail);

            String Number = (String)personDetails.get("phonenumber");
            System.out.println("Number :"+ Number);*/

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parseEventObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("eventId");

        //Get employee first name
        String firstName = (String) employeeObject.get("title");
        System.out.println(firstName);
    }
}
