package com.tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
  @Test
  public void get() {
	  Response response = RestAssured
			  .given()
			  .when()
			  .get("https://lms-server-3-wedg.onrender.com/getAll/institution")
			  .then()
			  .log().all()
			  .extract().response();
	  System.out.println("Status : "+response.getStatusCode());
  }
}