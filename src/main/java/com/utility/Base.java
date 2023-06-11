package com.utility;

import java.util.HashMap;

import com.google.gson.JsonArray;

import io.restassured.path.json.JsonPath;

public class Base {

	public String getNestedJsonObject(String body, String parentObject, String childObject)
	{
		/*
		 * ObjectMapper map = new ObjectMapper(); JsonNode node = map.readTree(body);
		 * JsonNode parentJsonObject = node.get(parentObject); JsonNode childJsonObject
		 * = parentJsonObject.get(childObject);
		 */
		
		JsonPath path = new JsonPath(body);
		String childJsonObject = path.getString(parentObject+"."+childObject);
		
		return childJsonObject;
	}
	
	public HashMap<String, String> getJsonObjectFromArray(String body, String parentObject, String ChildObjValue)
	{
		JsonPath path = new JsonPath(body);
		int noOfArray = path.getInt(parentObject+".size()");
		
		int indexNo=-1;
		
		for(int i=0; i<noOfArray; i++)
		{
			if(path.getString(parentObject+"["+i+"]").contains(ChildObjValue))
				indexNo = i;
		}
		
		String[] reqDetails = path.getString(parentObject+"["+indexNo+"]").replaceAll("\\[","").replaceAll("\\]", "").split(",");
		
		HashMap<String, String> map = new HashMap<>();
		
		for(String i : reqDetails)
		{
			String[] parsing = i.split(":");
			map.put(parsing[0].trim(), parsing[1].trim());
		}
		
		return map;
	}
}
