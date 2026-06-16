package com.jsondbTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
  @Test
  public void Get() {
	  Response response = RestAssured.given().when().get("http://localhost:3000/Trainees/1");
	  System.out.println("Status : "+response.getStatusCode());
	  response.prettyPrint();
	  //Assert.assertEquals(response.getStatusCode(), 200);
	  String name = response.jsonPath().getString("name");
	  Assert.assertEquals(name, "Reshma K");
  }
}
