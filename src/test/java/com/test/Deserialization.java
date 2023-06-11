package com.test;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class Deserialization {

	@Test
	public void JsonToPojo()
	{
		File file = new File("D:\\MyAutomation\\TestAutomation\\APIAutomation\\test-output\\JsonFile\\JsonDemo.json");
		JsonPath path = new JsonPath(file);
		
		String id = path.getString("id");
		String firstName = path.getString("name");
		String age = path.getString("age");
		
		System.out.println("Employee ID: "+id);
		System.out.println("Employee Name: "+firstName);
		System.out.println("Employee Email: "+age);
	}
}
