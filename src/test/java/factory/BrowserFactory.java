package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static utility.data.FilePath.BROWSER_PROPERTIES;

public class BrowserFactory {

    public static WebDriver getWebDriver() {
        WebDriver driver;

        try (InputStream input = new FileInputStream(String.format(BROWSER_PROPERTIES, "browser.properties"))) {
            Properties prop = new Properties();
            prop.load(input);
            String browserName = prop.getProperty("browser").toLowerCase();
            switch (browserName) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new RuntimeException("Current WebDriver not supported");
            }

        } catch (IOException ex) {
            throw new RuntimeException("Driver property file error");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
}
