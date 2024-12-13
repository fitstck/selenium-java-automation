package tests;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import org.testng.Assert;

public class GoogleSearchTest extends BaseClass {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = initializeDriver();
        driver.get("https://www.google.com");
    }

    @Test(groups = {"web"})
    public void searchTest() {
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.search("Selenium WebDriver");
        // Add assertions as needed
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
