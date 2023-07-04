package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrandingPage extends BasePage {

    private static final String BRAND_LOGO_IMAGE = "//div[@class='v-image__image v-image__image--cover']";
    private static final String DELETE_BRAND_LOGO_BTN = "(//button[@class='btn btn-sumo-default v-btn v-btn--outlined theme--light v-size--default'])[2]";
    private static final String CONFIRM_DELETE_BRAND_LOGO_BUTTON = "//button[contains(@class,'btn-sumo-danger')]";
    private static final String BRAND_LOGO_IMAGE_UPLOAD = "//input[@type='file']";
    private static final String CAPABILITIES = "capabilities";
    private static final String CAPABILITIES_2 = "capabilities2";
    private static final String BRAND_LOGO = "//div[contains(@class,'v-image__image')]";
    private static final String SEE_MY_BRAND_BTN = "//button[@class='btn-sumo-primary mt-8 v-btn v-btn--has-bg theme--light elevation-0 v-size--default']";
    private static final String LOADER = "//div[contains(@class,'v-progress-linear__indeterminate--active')]";
    private static final String QUOTE_TEMPLATE = "//img[contains(@src,'%s')]";
    private static final String CONFIRM_BTN = "//button[@class='btn-sumo-primary mb-5 mt-0 v-btn v-btn--has-bg theme--light elevation-0 v-size--default']";

    public BrandingPage(WebDriver driver) {
        super(driver);
    }

    public void uploadBrandLogo(String pathToBrandLogoFile) {

        if (isDisplayed(BRAND_LOGO_IMAGE)) {
            jsExecutorClick(driver.findElement(By.xpath(DELETE_BRAND_LOGO_BTN)));
            jsExecutorClick(driver.findElement(By.xpath(CONFIRM_DELETE_BRAND_LOGO_BUTTON)));
        }
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(BRAND_LOGO_IMAGE_UPLOAD)))).sendKeys(pathToBrandLogoFile);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BRAND_LOGO_IMAGE)));
    }


    public void fillCapabilities1Field(String jobType) {
        driver.findElement(By.id(CAPABILITIES)).sendKeys(Keys.chord(Keys.CONTROL, "a"), jobType);
    }

    public void fillCapabilities2Field(String propertyType) {
        driver.findElement(By.id(CAPABILITIES_2)).sendKeys(Keys.chord(Keys.CONTROL, "a"), propertyType);
    }

    public void clickSeeMyBrandButton() {
        jsExecutorClick(driver.findElement(By.xpath(SEE_MY_BRAND_BTN)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADER)));
    }

    public void chooseQuoteTemplate(String quoteTemplateName) {
        jsExecutorClick(driver.findElement(By.xpath(String.format(QUOTE_TEMPLATE, quoteTemplateName))));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADER)));
    }

    public void confirmButtonClick() {
        jsExecutorClick(driver.findElement(By.xpath(CONFIRM_BTN)));
    }
}
