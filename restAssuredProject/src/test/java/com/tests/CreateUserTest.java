package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUserTest {
  @Test
  public void f() {
	  Map<String,Object> payload=new HashMap<>();
	  payload.put("title","My First Post");
	  payload.put("body","Learning RestAssured");
	  payload.put("userId",1);
	  
	  Response response=RestAssured.given().contentType(ContentType.JSON)
			  .body(payload).when().post("https://jsonplaceholder.typicode.com/posts");
	  System.out.println("Statuscode:"+response.statusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.getStatusCode(), 201);
	  Assert.assertEquals(response.jsonPath().getString("title"), "My First Post");
  }
}