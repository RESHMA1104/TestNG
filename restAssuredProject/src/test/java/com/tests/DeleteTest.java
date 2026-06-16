package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTest {
    @Test
    public void deletePostTest() {
        int postIdToDelete = 1;

        Response response = RestAssured.given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/" + postIdToDelete);

        System.out.println("Status: " + response.getStatusCode());
        response.prettyPrint();   
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}