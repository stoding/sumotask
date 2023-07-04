package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jsExecutor;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        jsExecutor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected boolean isDisplayed(String elementXpath) {
        try {
            driver.findElement(By.xpath(elementXpath)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    protected void jsExecutorClick(WebElement webElement) {
        jsExecutor.executeScript("arguments[0].click();", webElement);
    }
    protected void jsExecutorSendKeys(WebElement webElement,String textToSend) {
        jsExecutor.executeScript(String.format("arguments[0].value='%s'",textToSend), webElement);
    }
}
