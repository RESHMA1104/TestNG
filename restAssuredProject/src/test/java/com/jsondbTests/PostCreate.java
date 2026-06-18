package com.jsondbTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostCreate {
  @Test
  public void post() {
	  Map<String, Object> payload = new HashMap<>();
	  payload.put("name", "Vidhubala");
	  payload.put("email", "vidhubala123@gmail.com");
	  payload.put("company", "Google");
	  Response response  = RestAssured
			  .given()
			  .contentType(ContentType.JSON)
	  		  .body(payload)
	  		  .when()
	  		  .post("http://localhost:3000/Trainees");
	  System.out.println("Status : " +response.getStatusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.getStatusCode(), 201);
	  
  }
}
