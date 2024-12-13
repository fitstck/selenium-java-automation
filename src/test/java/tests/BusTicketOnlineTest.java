package tests;
import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BusTicketOnlinePage;

public class BusTicketOnlineTest extends BaseClass {
    private WebDriver driver;
    private BusTicketOnlinePage homePage;

    @BeforeMethod
    public void setup() {
        driver = initializeDriver();
        driver.get("https://www.busonlineticket.com/");
        homePage = new BusTicketOnlinePage(driver); // Initialize homePage here
    }

    @Test
    public void testBookingSearch() {
        // Select origin
        homePage.validateHomePage();
        homePage.enterOrigin();
//        homePage.enterDestination("Kuala Lumpur");
//        homePage.enterDate("2025-01-25");
//        homePage.clickSubmit();
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
