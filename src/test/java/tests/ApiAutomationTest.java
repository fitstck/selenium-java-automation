package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiAutomationTest {

    @Test(groups = {"api"})
    public void createProjectApiTest() {
        RestAssured.baseURI = "https://api.todoist.com/rest/v1";

        Response response = given()
                .header("Authorization", "Bearer YOUR_API_TOKEN")
                .header("Content-Type", "application/json")
                .body("{\"name\": \"New Project\"}")
                .post("/projects");

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response: " + response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
    }
}
