package main;

import java.io.FileReader;
import org.json.simple.JSONObject; 
import org.json.simple.JSONArray;
import org.json.simple.parser.*; 

public class FileRead {
	
	public static void reader() throws Exception {	
       Object obj = new JSONParser().parse(new FileReader("src/data/events.json")); 
       JSONObject jo = (JSONObject) obj; 
       
       JSONArray jsonArray = (JSONArray) jo.get("weatherEvents");
       
       
       for (int i = 0; i < jsonArray.size(); i++) {
           JSONObject jsonElement = (JSONObject) jsonArray.get(i);
           JSONObject jsonDetails = (JSONObject) jsonElement.get("details");
          
           WeatherEvent event = new WeatherEvent((String) jsonElement.get("name"), (String) jsonDetails.get("description"), (long) jsonDetails.get("frequencyMin"), (long) jsonDetails.get("frequencyMax"));
           GameDisplay.weatherEvents.add(event);
       }

	}

}
