package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginFormPage extends BasePage {

    private static final String SUBMIT_BTN = "//button[@type='submit']";
    private static final String PASSWORD_FIELD = "password";
    private static final String EMAIL_FIELD = "email";

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage(String loginPage) {
        driver.get(loginPage);

    }

    public void fillLoginField(String userLogin) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(EMAIL_FIELD)))).sendKeys(userLogin);
//    driver.findElement(By.name(EMAIL_FIELD)).sendKeys(userLogin);
    }

    public void fillPasswordField(String userPassword) {
        driver.findElement(By.name(PASSWORD_FIELD)).sendKeys(userPassword);
    }
//    public void fillLoginField(String userLogin) {
//        jsExecutorSendKeys(driver.findElement(By.name(EMAIL_FIELD)),userLogin);
////        jsExecutorClick(driver.findElement(By.name(EMAIL_FIELD)).sendKeys(userLogin)));
//
//    }
//
//    public void fillPasswordField(String userPassword) {
//        jsExecutorSendKeys(driver.findElement(By.name(PASSWORD_FIELD)),userPassword);
////        driver.findElement(By.name(PASSWORD_FIELD)).sendKeys(userPassword);
//    }

    public void loginButtonClick() {
        driver.findElement(By.xpath(SUBMIT_BTN)).click();
    }
}
