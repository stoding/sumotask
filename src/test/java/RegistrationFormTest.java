import model.RegistrationFormInfo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.RegistrationFormSteps;
import utility.data.*;

import static org.assertj.core.api.Assertions.assertThat;
import static utility.JsonUtils.jsonReader;
import static utility.SystemPropertyUtils.getSystemPropertyValue;

public class RegistrationFormTest extends BaseTest {

    RegistrationFormSteps registrationFormSteps;

    @BeforeClass
    public void initPagesSteps() {
        registrationFormSteps = new RegistrationFormSteps(driver);
    }

    @Test
    public void registrationFormPopulationTest() {
        registrationFormSteps.navigateToRegistrationForm(WebPageLink.REGISTRATION_PAGE_URL);
        RegistrationFormInfo registrationFormInfo = (RegistrationFormInfo) jsonReader("userRegistrationInfo.json", RegistrationFormInfo.class);
        registrationFormSteps.fillRegistrationForm(getSystemPropertyValue("email"), getSystemPropertyValue("password"), registrationFormInfo);
        assertThat(registrationFormSteps.isAccountCreatedConfirmationPageLoaded(WebPageLink.ACCOUNT_CREATED_PAGE_URL)).withFailMessage("User is already exist or field validation didn't pass").isTrue();
    }

}
