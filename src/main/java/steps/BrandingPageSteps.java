package steps;

import org.openqa.selenium.WebDriver;
import pages.BrandingPage;

public class BrandingPageSteps {
    WebDriver driver;
    BrandingPage brandingPage;

    public BrandingPageSteps(WebDriver driver) {
        this.driver = driver;
        brandingPage = new BrandingPage(driver);
    }

    public void chooseQuoteTemplate(String quoteTemplateName) {
        brandingPage.chooseQuoteTemplate(quoteTemplateName);
        brandingPage.confirmButtonClick();
    }

    public void fillBrandingPage(String pathToBrandLogoFile, String capabilities1, String capabilities2) {
        brandingPage.uploadBrandLogo(pathToBrandLogoFile);
        brandingPage.fillCapabilities1Field(capabilities1);
        brandingPage.fillCapabilities2Field(capabilities2);
        brandingPage.clickSeeMyBrandButton();
    }
}
