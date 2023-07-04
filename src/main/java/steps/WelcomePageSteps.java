package steps;

import org.openqa.selenium.WebDriver;
import pages.WelcomePage;

public class WelcomePageSteps {

    WebDriver driver;
    WelcomePage welcomePage;

    public WelcomePageSteps(WebDriver driver) {
        this.driver = driver;
        welcomePage = new WelcomePage(driver);
    }

    public void clickGetStartedButton() {
        welcomePage.clickGetStartedButton();
    }

    public boolean isWelcomePageLoaded(String welcomePageURL) {
        return welcomePage.isWelcomePageLoaded(welcomePageURL);
    }
}
