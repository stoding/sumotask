import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        driver = BrowserFactory.getWebDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
