package com.blueyleader.adventofcode;

import java.io.File;
import java.util.Scanner;
import org.json.*;

public class Day12_2 {
	
    public static void main(String[] args) throws Exception {
		String input;
		File file = new File("day12.txt");
		Scanner scan = new Scanner(file);
		input=scan.nextLine();
		input="["+input+"]";
		
        JSONArray obj = new JSONArray(input);
        System.out.println(getValue(obj));
    }
    
    public static int getValue(Object object) throws Exception {
        if (object instanceof Integer){
        	return (int) object;
        }
        if (object instanceof String){
        	return 0;
        }

        int total = 0;
        if (object instanceof JSONArray) {
            for (int i = 0; i < ((JSONArray)object).length(); ++i) {
                try {
                    int v1 = getValue(((JSONArray)object).get(i));
                    total += v1;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return total;
        }

        if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            JSONArray names = jsonObject.names();
            for (int i = 0; i < names.length(); ++i) {
                String name = (String) names.get(i);
                if (jsonObject.get(name).equals("red")) {
                    return 0;
                } else {
                    total += getValue(jsonObject.get(name));
                }
            }
            return total;
        }

        return 0;
    }


}