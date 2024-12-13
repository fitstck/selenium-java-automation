package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class PergiKulinerPage {
    private WebDriver driver;

    // Locators for the Login elements
    private By loginButton = By.id("login-nav-btn");
    private By usernameField = By.id("user_email"); // Update ID based on actual field
    private By passwordField = By.id("user_password"); // Update ID based on actual field
    private By submitButton = By.id("login-btn"); // Update ID based on actual button

    // Constructor
    public PergiKulinerPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions for the page
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}
