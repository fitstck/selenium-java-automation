package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BusTicketOnlinePage {
    private WebDriver driver;
    private By headerHomepage = By.id("main-header");
    private By OriginBox = By.id("txtOrigin");
    private By DestinationBox = By.id("txtDestination");
    private By DepartDate = By.id("txtDepartDate");
    private By ScrollDate = By.xpath("//ui-icon.ui-icon-circle-triangle-e");
    private By ChooseDate = By.xpath("//a.ui-state-default.ui-state-highlight.ui-state-active");
    private By SubmitButton = By.xpath("//[@class=btn-btn-orange-w-100]");
    private By selectOrigin = By.name("Cameron Highlands");
    private By selectDestination = By.name("Kuala Lumpur)");
    private By selectSchedule = By.xpath("//td[@style='Tanah Rata Bus Station (Terminal Freesia)']");

    public BusTicketOnlinePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateHomePage() {
        // Explicit wait for the search button to become clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerHomepage));
//        Assert.assertTrue(driver.getTitle().contains("Bus Online Ticket"), "Home page validation failed");
        driver.findElement(headerHomepage);
    }

    public void enterOrigin() {
        // Explicit wait for the search button to become clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(OriginBox));
        driver.findElement(OriginBox).click();
//        driver.findElement(OriginBox).sendKeys(origin);
    }

    public void enterDestination(String destination) {
        driver.findElement(DestinationBox).sendKeys(destination);
    }

    public void enterDate(String date) {
        driver.findElement(DepartDate).click();
        driver.findElement(ScrollDate).click();
        driver.findElement(ChooseDate).sendKeys(date);
    }

    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
        if (submitButton.isDisplayed() && submitButton.isEnabled()) {
            System.out.println("Button is visible");
            submitButton.click();
        } else {
            System.out.println("Button not found");
        }
    }
}
