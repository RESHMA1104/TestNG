package com.jsondbTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OptionsTest {

  @Test
  public void checkOptions() {

      Response response = RestAssured.given()
              .when()
              .options("http://localhost:3000/trainees");

      System.out.println("Status : " + response.getStatusCode());
      response.prettyPrint();

      Assert.assertEquals(response.getStatusCode(), 204);
  }
}