package com.jsondbTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutTest {
  @Test
  public void put() {
	  Map<String, Object> payload = new HashMap<>();
	  payload.put("name", "Vithya");
	  payload.put("email", "vithya123@gmail.com");
	  payload.put("company", "Virtusa");
	  Response response  = RestAssured
			  .given()
			  .contentType(ContentType.JSON)
	  		  .body(payload)
	  		  .when()
	  		  .put("http://localhost:3000/Trainees/2");
	  System.out.println("Status : " +response.getStatusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
  }
}
