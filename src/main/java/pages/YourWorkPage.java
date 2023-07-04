package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourWorkPage extends BasePage {

    private static final String RESIDENTIAL_ROOFING_BTN = "//div[contains(@style,'residential-roofing.svg')]";
    private static final String CONTRACTOR = "//div[contains(text(),'%s')]";
    private static final String OK_BTN = "//button[@class='btn-sumo-primary mt-2 v-btn v-btn--has-bg theme--light elevation-0 v-size--default']";
    private static final String COMMERCIAL_ROOFING_BTN = "//div[contains(@style,'commercial-roofing.svg')]";
    private static final String WORK_TYPE_LABEL = "//div[contains(text(),'%s')]/.././/span[@class='v-chip__content']";
    private static final String FINISH_BTN = "//button[@class='btn-sumo-primary float-right v-btn v-btn--has-bg theme--light elevation-0 v-size--default']";
    private static final String LETS_GO_BTN = "//button[@class='btn btn-sumo-primary v-btn v-btn--has-bg theme--light elevation-0 v-size--default']";

    public YourWorkPage(WebDriver driver) {
        super(driver);
    }

    public void residentialRoofingButtonClick() {
        jsExecutorClick(driver.findElement(By.xpath(RESIDENTIAL_ROOFING_BTN)));
    }

    public void contractorSelect(String contractor) {
        jsExecutorClick(driver.findElement(By.xpath(String.format(CONTRACTOR, contractor))));
    }

    public void okButtonClick() {
        jsExecutorClick(driver.findElement(By.xpath(OK_BTN)));
    }

    public void commercialRoofingButtonClick() {
        jsExecutorClick(driver.findElement(By.xpath(COMMERCIAL_ROOFING_BTN)));
    }

    public boolean isWorkTypeLabelDisplayed(String workType) {
        return driver.findElement(By.xpath(String.format(WORK_TYPE_LABEL, workType))).isDisplayed();
    }

    public String getWorkTypeLabelText(String workType) {
        return driver.findElement(By.xpath(String.format(WORK_TYPE_LABEL, workType))).getText();
    }

    public void finishButtonClick() {
        jsExecutorClick(driver.findElement(By.xpath(FINISH_BTN)));
    }

    public void letsGoButtonClick() {
        jsExecutorClick(driver.findElement(By.xpath(LETS_GO_BTN)));
    }
}
