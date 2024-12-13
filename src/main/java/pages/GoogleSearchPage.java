package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;


public class GoogleSearchPage {
    private WebDriver driver;
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String query) {
        driver.findElement(searchBox).sendKeys(query);

        // Explicit wait for the search button to become clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        driver.findElement(searchButton).click();
    }

}
