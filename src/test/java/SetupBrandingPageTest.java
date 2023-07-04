import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.*;
import utility.data.*;

import static org.assertj.core.api.Assertions.assertThat;
import static utility.SystemPropertyUtils.getSystemPropertyValue;

public class SetupBrandingPageTest extends BaseTest {

    LoginFormSteps loginFormSteps;
    WelcomePageSteps welcomePageSteps;
    BrandingPageSteps brandingPageSteps;
    YourWorkPageSteps yourWorkPageSteps;

    @BeforeTest
    public void initSteps() {
        loginFormSteps = new LoginFormSteps(driver);
        welcomePageSteps = new WelcomePageSteps(driver);
        brandingPageSteps = new BrandingPageSteps(driver);
        yourWorkPageSteps = new YourWorkPageSteps(driver);
    }

    @BeforeClass
    public void login() {
        loginFormSteps.navigateToLoginPage(WebPageLink.LOGIN_PAGE_URL);
        loginFormSteps.loginWithValidUserCredentials(getSystemPropertyValue("email"), getSystemPropertyValue("password"));
        assertThat(welcomePageSteps.isWelcomePageLoaded(WebPageLink.WELCOME_PAGE_URL)).isTrue();
    }

    @Test
    public void fillingProfileTest() {
        welcomePageSteps.clickGetStartedButton();
        brandingPageSteps.fillBrandingPage(String.format(FilePath.BRAND_LOGO_FILE, "logo.png"), TestData.BRAND_CAPABILITIES_1, TestData.BRAND_CAPABILITIES_2);
        brandingPageSteps.chooseQuoteTemplate(TestData.QUOTE_TEMPLATE_NAME);
        yourWorkPageSteps.selectResidentialRoofingContractor(TestData.RESIDENTIAL_ROOFING_CONTRACTORS_LIST);
        assertThat(yourWorkPageSteps.isWorkTypeLabelDisplayed("Residential Roofing")).isTrue();
        assertThat(yourWorkPageSteps.getWorkTypeLabelText("Residential Roofing")).contains(TestData.RESIDENTIAL_ROOFING_CONTRACTORS_LIST.length + " Product Lines");
        yourWorkPageSteps.selectCommercialRoofingContractor(TestData.COMMERCIAL_ROOFING_CONTRACTORS_LIST);
        assertThat(yourWorkPageSteps.isWorkTypeLabelDisplayed("Commercial Roofing")).isTrue();
        assertThat(yourWorkPageSteps.getWorkTypeLabelText("Commercial Roofing")).contains(TestData.COMMERCIAL_ROOFING_CONTRACTORS_LIST.length + " Product Lines");
        yourWorkPageSteps.finishButtonClick();
        yourWorkPageSteps.letsGoButtonClick();
    }
}
