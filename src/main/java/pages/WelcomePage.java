package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WelcomePage extends BasePage {

    private static final String GET_STARTED_BTN = "//button[contains(@class,'btn-sumo-primary')]";

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public void clickGetStartedButton() {
        jsExecutorClick(driver.findElement(By.xpath(GET_STARTED_BTN)));
    }

    public boolean isWelcomePageLoaded(String welcomePageURL) {
        try {
            wait.until(ExpectedConditions.urlToBe(welcomePageURL));
        } catch (TimeoutException e) {
            return false;
        }
        return true;

    }
}
