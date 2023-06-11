package com.test;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {

	@Test
	public void post()
	{
		File file = new File("D:\\MyAutomation\\TestAutomation\\APIAutomation\\test-output\\JsonFile\\Post.json");
		  Response resp = RestAssured.given()
				  .body(file).contentType(ContentType.JSON)
				  .when()
				  .post("https://reqres.in/api/users/");
		  
		  System.out.println(resp.getStatusCode());
		  System.out.println(resp.getStatusLine());
	}
}
