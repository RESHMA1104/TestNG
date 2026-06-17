package com.jsondbTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeadTest {

    @Test
    public void headTrainee() {

        Response response = RestAssured
                .given()
                .when()
                .head("http://localhost:3000/Trainees/1");

        System.out.println("Status Code: " + response.getStatusCode());

        System.out.println("Content-Type: "+ response.getHeader("Content-Type"));

        Assert.assertEquals(response.getStatusCode(),400);
    }
}