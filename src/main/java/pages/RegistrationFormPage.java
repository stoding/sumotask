package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationFormPage extends BasePage {

    private static final String ACCOUNT_NAME_TB = "accountName";
    private static final String FIRST_NAME_TB = "firstName";
    private static final String LAST_NAME_TB = "lastName";
    private static final String EMAIL_ADDRESS_TB = "emailAddress";
    private static final String PHONE_NUMBER_TB = "phoneNumber";
    private static final String PASSWORD_TB = "Password";
    private static final String REPEAT_PASSWORD_TB = "repeatPassword";
    private static final String HOW_HEARD_DD = "howHeard";
    private static final String DISCLAIMER_AGREE_CHECKBOX = "disclaimerAgree";
    private static final String SAVE_BTN = "(//div[@class='v-card__text']//button)[1]";
    private static final String HOW_HEARD_ABOUT_US = "//div[contains(text(),'%s')]";

    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRegistrationForm(String registrationPage) {
        driver.get(registrationPage);

    }

    public void fillAccountNameField(String companyName) {
        driver.findElement(By.id(ACCOUNT_NAME_TB)).sendKeys(companyName);
    }

    public void fillFirstNameField(String clientFirstName) {
        driver.findElement(By.id(FIRST_NAME_TB)).sendKeys(clientFirstName);
    }

    public void fillLastNameField(String clientLastName) {
        driver.findElement(By.id(LAST_NAME_TB)).sendKeys(clientLastName);
    }

    public void fillEmailAddressField(String clientEmail) {
        driver.findElement(By.id(EMAIL_ADDRESS_TB)).sendKeys(clientEmail);
    }

    public void fillPhoneNumberField(String clientPhoneNumber) {
        driver.findElement(By.id(PHONE_NUMBER_TB)).sendKeys(clientPhoneNumber);
    }

    public void fillPasswordField(String clientPassword) {
        driver.findElement(By.id(PASSWORD_TB)).sendKeys(clientPassword);
    }

    public void fillRepeatPasswordField(String repeatClientPassword) {
        driver.findElement(By.id(REPEAT_PASSWORD_TB)).sendKeys(repeatClientPassword);
    }

    public void howHeardField(String howHeardAboutSumo) {
        jsExecutorClick(driver.findElement(By.id(HOW_HEARD_DD)));
        jsExecutorClick(driver.findElement(By.xpath(String.format(HOW_HEARD_ABOUT_US, howHeardAboutSumo))));
    }

    public void disclaimerAgreeCheckBoxClick() {
        jsExecutorClick(driver.findElement(By.id(DISCLAIMER_AGREE_CHECKBOX)));
    }

    public void saveButtonClick() {
        jsExecutorClick(driver.findElement(By.xpath(SAVE_BTN)));
    }

    public boolean isAccountCreatedConfirmationPageLoaded(String accountCreatedConfirmationPage) {
        try {
            wait.until(ExpectedConditions.urlToBe(accountCreatedConfirmationPage));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
