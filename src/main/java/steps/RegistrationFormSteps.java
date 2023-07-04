package steps;

import model.RegistrationFormInfo;
import org.openqa.selenium.WebDriver;
import pages.RegistrationFormPage;

public class RegistrationFormSteps {


    WebDriver driver;
    RegistrationFormPage registrationFormPage;

    public RegistrationFormSteps(WebDriver driver) {
        this.driver = driver;
        registrationFormPage = new RegistrationFormPage(driver);
    }

    public void navigateToRegistrationForm(String registrationPage) {
        registrationFormPage.navigateToRegistrationForm(registrationPage);
    }

    public void fillRegistrationForm(String userEmail, String userPass, RegistrationFormInfo registrationFormInfo) {
        registrationFormPage.fillAccountNameField(registrationFormInfo.getCompany());
        registrationFormPage.fillFirstNameField(registrationFormInfo.getClientFirstName());
        registrationFormPage.fillLastNameField(registrationFormInfo.getClientLastName());
        registrationFormPage.fillEmailAddressField(userEmail);
        registrationFormPage.fillPhoneNumberField(registrationFormInfo.getClientPhoneNumber());
        registrationFormPage.fillPasswordField(userPass);
        registrationFormPage.fillRepeatPasswordField(userPass);
        registrationFormPage.howHeardField(registrationFormInfo.getHowHeardAboutSumo());
        registrationFormPage.disclaimerAgreeCheckBoxClick();
        registrationFormPage.saveButtonClick();

    }

    public boolean isAccountCreatedConfirmationPageLoaded(String accountCreatedConfirmationPageURL) {
        return registrationFormPage.isAccountCreatedConfirmationPageLoaded(accountCreatedConfirmationPageURL);
    }
}
