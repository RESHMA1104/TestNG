package com.jsondbTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTest {
  @Test
  public void Delete() {
	  Response response  = RestAssured.given()
	  		  .when()
	  		  .delete("http://localhost:3000/Trainees/3");
	  System.out.println("Status : " +response.getStatusCode());
	  response.prettyPrint();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
  }
}
