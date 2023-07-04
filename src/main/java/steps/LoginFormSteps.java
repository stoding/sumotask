package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginFormPage;

public class LoginFormSteps {

    WebDriver driver;
    LoginFormPage loginFormPage;

    public LoginFormSteps(WebDriver driver) {
        this.driver = driver;
        loginFormPage = new LoginFormPage(driver);
    }

    public void navigateToLoginPage(String loginPage) {
        loginFormPage.navigateToLoginPage(loginPage);
    }

    public void loginWithValidUserCredentials(String clientEmail, String clientPassword) {
        loginFormPage.fillLoginField(clientEmail);
        loginFormPage.fillPasswordField(clientPassword);
        loginFormPage.loginButtonClick();
    }
}
