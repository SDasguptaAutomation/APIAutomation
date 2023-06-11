package com.test;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Employeee;

public class Serialization {

	@Test
	public void pojoToJson() throws JsonProcessingException
	{
		Employeee emp = new Employeee();
		emp.setEmployeeId(706977);
		emp.setName("Sayan");
		emp.setAge(25);

		ObjectMapper map = new ObjectMapper();
		String jsonObject = map.writeValueAsString(emp);

		System.out.println(jsonObject);
	}
}
