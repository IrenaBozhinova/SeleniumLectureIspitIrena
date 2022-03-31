package frontend;

import core.BaseTest;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void newRegistration(){
        HomePage.goTo("http://shop.pragmatic.bg");
        ElementsInHomePage.clickmyAccountField();
        ElementsInHomePage.clickregisterField();
        RegisterAccount.writeInFirstNameField("Irena");
        RegisterAccount.writeInLastNameField("Petkova-Bozhinova");
        RegisterAccount.writeInEmailField();
        RegisterAccount.writeInPhoneNumberField();
        RegisterAccount.writeInPasswordField("parola123");
        RegisterAccount.writeInPasswordConfirmField("parola123");
        RegisterAccount.checkNoNewsletterRadioButton();
        RegisterAccount.checkPrivacyPolicyCheckbox();
        RegisterAccount.clickContinueButton();
        RegisterAccount.verifyMakeNewRegistration("Your Account Has Been Created!");

    }


}
