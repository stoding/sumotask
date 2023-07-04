package steps;

import org.openqa.selenium.WebDriver;
import pages.YourWorkPage;

public class YourWorkPageSteps {
    WebDriver driver;
    YourWorkPage yourWorkPage;

    public YourWorkPageSteps(WebDriver driver) {
        this.driver = driver;
        yourWorkPage = new YourWorkPage(driver);
    }

    public void selectResidentialRoofingContractor(String[] residentialRoofingContractorsList) {
        yourWorkPage.residentialRoofingButtonClick();
        for (String contractor : residentialRoofingContractorsList
        ) {
            yourWorkPage.contractorSelect(contractor);
        }
        yourWorkPage.okButtonClick();

    }

    public void selectCommercialRoofingContractor(String[] commercialRoofingContractorsList) {
        yourWorkPage.commercialRoofingButtonClick();
        for (String contractor : commercialRoofingContractorsList
        ) {
            yourWorkPage.contractorSelect(contractor);
        }
        yourWorkPage.okButtonClick();
    }

    public boolean isWorkTypeLabelDisplayed(String workType) {
        return yourWorkPage.isWorkTypeLabelDisplayed(workType);
    }

    public String getWorkTypeLabelText(String workType) {
        return yourWorkPage.getWorkTypeLabelText(workType);
    }

    public void finishButtonClick() {
        yourWorkPage.finishButtonClick();
    }

    public void letsGoButtonClick() {
        yourWorkPage.letsGoButtonClick();
    }
}
