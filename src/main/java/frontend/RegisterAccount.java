package frontend;

import core.SuperPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Browser;


public class RegisterAccount extends SuperPage {
    @FindBy(id = "input-firstname")
    private static WebElement firstNameField;

    @FindBy(id = "input-lastname")
    private static WebElement lastNameField;

    @FindBy(id = "input-email")
    private static WebElement emailField;

    @FindBy(id = "input-telephone")
    private static WebElement phoneNumberField;

    @FindBy(id = "input-password")
    private static WebElement passwordField;

    @FindBy(id = "input-confirm")
    private static WebElement passwordConfirmField;

    @FindBy(xpath = "//input[@value='0']")
    private static WebElement noNewsletterRadioButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    private static WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement continueButton;

    @FindBy(xpath = "//div[@id='content']/h1")
    private static WebElement createAccountField;




    static {
        PageFactory.initElements(Browser.driver, RegisterAccount.class);
    }


    public static void writeInFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public static void writeInLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public static void writeInEmailField() {
        String randomText = RandomStringUtils.randomAlphanumeric(8);
        String randomMail = randomText + "@abv.bg";
        emailField.sendKeys(randomMail);
    }

    public static void writeInPhoneNumberField() {
        String randomPhoneNumber = RandomStringUtils.randomNumeric(10);
        phoneNumberField.sendKeys(randomPhoneNumber);
    }

    public static void writeInPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public static void writeInPasswordConfirmField(String passwordConfirm) {
        passwordConfirmField.sendKeys(passwordConfirm);
    }

    public static void checkNoNewsletterRadioButton() {
        if (!noNewsletterRadioButton.isSelected()) {
            noNewsletterRadioButton.click();
        }
    }

    public static void checkPrivacyPolicyCheckbox() {
        if(!privacyPolicyCheckbox.isSelected()){
            privacyPolicyCheckbox.click();
        }
    }


    public static void clickContinueButton() {
        String passwordText = passwordField.getText();
        String passwordConfirmFieldText = passwordConfirmField.getText();
        if(passwordConfirmFieldText.equals(passwordText)){
            continueButton.click();
        }
    }

    public static void verifyMakeNewRegistration(String newAccountCreated) {
        String createAccountFieldText = createAccountField.getText();
        Assert.assertTrue(createAccountFieldText.contains(newAccountCreated));
        System.out.println(createAccountFieldText);
        System.out.println(newAccountCreated);

    }



}
