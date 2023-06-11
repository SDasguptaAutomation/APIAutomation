package com.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.utility.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest extends Base{

	@Test
	public void get() throws JsonMappingException, JsonProcessingException
	{
		Response resp1 = RestAssured.given().when().get("https://reqres.in/api/users/2");
		
		Response resp2 = RestAssured.given()
				.queryParam("page", "2")
				.when()
				.get("https://reqres.in/api/users");
		
		int statusCode1 = resp1.getStatusCode();
		String statusLine1 = resp1.getStatusLine();
		String body1 = resp1.getBody().asPrettyString();
		
		int statusCode2 = resp2.getStatusCode();
		String statusLine2 = resp2.getStatusLine();
		String body2 = resp2.getBody().asPrettyString();
		
		//Fetching data from Nested JsonObject, return childValue for mentioned childKey on parameter
		String value = getNestedJsonObject(body1, "data", "id"); //responseBody, parentKey, childKey
		
		//Fetching Data from JsonArray, function returns JsonObjects for mentioned childValue on parameter.
		HashMap<String, String> empDetails = getJsonObjectFromArray(body2, "data", "Byron"); //responseBody, parentKey, childValue
	
		Assert.assertEquals(statusCode1, 200);
		Assert.assertTrue(statusLine1.contains("OK"));
		Assert.assertEquals(statusCode2, 200);
		Assert.assertTrue(statusLine2.contains("OK"));

		Assert.assertEquals(value, "2");
		Assert.assertEquals(empDetails.get("id"), "10");
	}
}
