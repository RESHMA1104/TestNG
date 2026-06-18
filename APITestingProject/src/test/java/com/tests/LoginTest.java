package com.tests;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class LoginTest {
	String token;
  @Test
  public void login() {
	  Map<String, Object> payload = new HashMap<>();
	  payload.put("email", "sam@gmail.com");
	  payload.put("password", "123");
	  Response response = RestAssured
			  .given()
			  .contentType(ContentType.JSON)
			  .body(payload)
			  .when()
			  .post("https://lms-server-3-wedg.onrender.com/user/login")
			  .then()
			  .statusCode(201)
			  .log().all()
			  .extract().response();
	  System.out.println("Status : "+ response.prettyPrint());
	  System.out.println("TOKEN : "+response.jsonPath().getString("token"));
  }
}