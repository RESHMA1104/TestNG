package com.jsondbTests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class InvalidTest {

    @Test
    public void invalidGetTrainee() {

        RestAssured
            .given()
            .when()
            .get("http://localhost:3000/trainees/9999")
            .then()
            .statusCode(404)
            .log().all();
    }
}