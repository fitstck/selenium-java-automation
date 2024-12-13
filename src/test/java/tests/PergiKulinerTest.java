package tests;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PergiKulinerPage;

public class PergiKulinerTest extends BaseClass {
    private WebDriver driver;
    private PergiKulinerPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = initializeDriver();
        driver.get("https://pergikuliner.com");
    }

    @Test
    public void testLogin() {
        // Perform login
        loginPage.clickLoginButton();
        loginPage.enterUsername("test_user"); // Replace with valid username
        loginPage.enterPassword("test_password"); // Replace with valid password
        loginPage.clickSubmitButton();

        // Add an assertion to verify login success
        String expectedUrl = "https://pergikuliner.com/dashboard"; // Update with the expected URL
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
