package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoistHomePage {
    private WebDriver driver;

    public TodoistHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProjectVisible(String projectName) {
        // Example logic to locate a project
        return driver.findElements(By.xpath("//span[text()='" + projectName + "']")).size() > 0;
    }
}
