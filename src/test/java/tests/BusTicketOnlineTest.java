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
        System.out.println("Navigated to Bus Online Ticket homepage.");
        homePage = new BusTicketOnlinePage(driver); // Initialize homePage here
    }

    @Test
    public void testBookingSearch() throws InterruptedException {
        // Select origin
        homePage.validateHomePage();
        homePage.enterOrigin("Cameron Highlands");
        homePage.enterDestination("Kuala Lumpur");
        homePage.selectDate("2025", "January", "31");
        System.out.println("Selected date: January 31, 2025.");
//        homePage.clickSubmit();

        // Add assertion (example: check the title of the next page)
        Assert.assertTrue(driver.getTitle().contains("Expected Title"),
                "The page title after form submission is incorrect.");
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
        System.out.println("Browser closed.");
    }
}
