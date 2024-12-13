package tests;

import base.BaseClass;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TodoistHomePage;

import static io.restassured.RestAssured.given;

public class CombinedAutomationTest extends BaseClass {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = initializeDriver();
        driver.get("https://todoist.com/login");
        // Add login automation here
    }

    @Test
    public void createAndVerifyProject() {
        // Step 1: Create Project via API
        Response response = given()
                .header("Authorization", "Bearer YOUR_API_TOKEN")
                .header("Content-Type", "application/json")
                .body("{\"name\": \"Test Project\"}")
                .post("https://api.todoist.com/rest/v1/projects");

        Assert.assertEquals(response.getStatusCode(), 200);

        // Step 2: Verify in Web App
        TodoistHomePage homePage = new TodoistHomePage(driver);
        Assert.assertTrue(homePage.isProjectVisible("Test Project"), "Project not found on the web!");
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
