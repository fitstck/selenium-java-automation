package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BusTicketOnlinePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By headerHomepage = By.id("main-header");
    private By OriginBox = By.id("txtOrigin");
    private By DestinationBox = By.id("txtDestination");
    private By Container = By.className("container");
    private By dateInput = By.id("txtDepartDate");
    private By nextMonthArrow = By.xpath("//a[@class='ui-datepicker-next ui-corner-all' and @data-handler='next' and @title='Next']\n");
    private By monthLabel = By.className("ui-datepicker-month");
    private By yearLabel = By.className("ui-datepicker-year");
    private By selectDate = By.xpath("//a[text()='31']");
    private By ScrollDate = By.xpath("//ui-icon.ui-icon-circle-triangle-e");
    private By ChooseDate = By.xpath("//a.ui-state-default.ui-state-highlight.ui-state-active");
    private By SubmitButton = By.xpath("//[@class=btn-btn-orange-w-100]");
    private By selectOrigin = By.name("Cameron Highlands");
    private By selectDestination = By.name("Kuala Lumpur)");
    private By selectSchedule = By.xpath("//td[@style='Tanah Rata Bus Station (Terminal Freesia)']");

    public BusTicketOnlinePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void someMethod() {
        try {
            Thread.sleep(10000); // Replace with your sleep duration
        } catch (InterruptedException e) {
            System.out.println("Thread sleep interrupted: " + e.getMessage());
        }
    }

    public void validateHomePage() {
        // Explicit wait for the search button to become clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerHomepage));
        driver.findElement(headerHomepage);
        System.out.println("Homepage validated.");
    }

    public void enterOrigin(String origin) {
        // Explicit wait for the search button to become clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(OriginBox));
        driver.findElement(OriginBox).click();
        driver.findElement(OriginBox).sendKeys(origin);
        System.out.println("Origin entered: " + origin);
    }

    public void enterDestination(String destination) {
        driver.findElement(DestinationBox).sendKeys(destination);
        driver.findElement(Container).click();
        System.out.println("Destination entered: " + destination);
        someMethod();
    }

    public void selectDate(String year, String month, String day) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the date picker
        WebElement dateInputElement = wait.until(ExpectedConditions.elementToBeClickable(dateInput));
        dateInputElement.click();

        // Wait for the date picker to load and loop until the desired month and year are displayed
        while (true) {
            String displayedMonth = driver.findElement(monthLabel).getText();
            String displayedYear = driver.findElement(yearLabel).getText();

            if (displayedMonth.equals(month) && displayedYear.equals(year)) {
                break;
            }

            // Click the "Next Month" arrow
            WebElement nextArrow = wait.until(ExpectedConditions.elementToBeClickable(nextMonthArrow));

            // Use Actions to ensure the click works
            Actions actions = new Actions(driver);
            actions.moveToElement(nextArrow).click().perform();
        }
        someMethod();

        // Wait for the specific date to be clickable
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ui-state-default' and text()='" + day + "']")));
        // Click on the date
        dateElement.click();
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
