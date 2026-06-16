package com.tests;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchTest {
    @Test
    public void patchPostTest() {
        Map<String, Object> partialUpdate = new HashMap<>();
        partialUpdate.put("title", "My Second Post");   // only changing the title

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(partialUpdate)
                .when()
                .patch("https://jsonplaceholder.typicode.com/posts/1");  

        System.out.println("Status: " + response.getStatusCode());
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "My Second Post");
    }
}