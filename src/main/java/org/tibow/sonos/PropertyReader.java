package org.tibow.sonos;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class PropertyReader {
  public static String getMvProperty(String propName) {
    JSONParser parser = new JSONParser();
    try {
      Object obj = parser.parse(new FileReader("settings.json"));
      //
      JSONObject jObj = (JSONObject) obj;
      return (String) jObj.get(propName);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
