import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateUsersTest {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Irena\\QAQ24\\BrouzersDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 6);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void createUser() {
        driver.get("http://shop.pragmatic.bg");
        WebElement myAccountField = driver.findElement(By.xpath("//div[@id='top-links']//span[text()='My Account']"));
        myAccountField.click();
        WebElement registerField = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']"));
        registerField.click();

        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
        firstNameField.sendKeys("Irena");
        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
        lastNameField.sendKeys("Petkova-Bozhinova");

        String randomText = RandomStringUtils.randomAlphanumeric(8);
        String randomMail = randomText + "@abv.bg";
        WebElement emailField = driver.findElement(By.id("input-email"));
        emailField.sendKeys(randomMail);

        WebElement phoneNumberField = driver.findElement(By.id("input-telephone"));
        String randomPhoneNumber = RandomStringUtils.randomNumeric(10);
        phoneNumberField.sendKeys(randomPhoneNumber);

        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys("parola123");

        WebElement passwordConfirmField = driver.findElement(By.id("input-confirm"));
        passwordConfirmField.sendKeys("parola123");

        WebElement noNewsletterRadioButton = driver.findElement(By.xpath("//input[@value='0']"));
        if(!noNewsletterRadioButton.isSelected()){
            noNewsletterRadioButton.click();
        }

        WebElement privacyPolicyCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if(!privacyPolicyCheckbox.isSelected()){
            privacyPolicyCheckbox.click();
        }

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        String passwordText = passwordField.getText();
        String passwordConfirmFieldText = passwordConfirmField.getText();
        if(passwordConfirmFieldText.equals(passwordText)){
            continueButton.click();
        }

        WebElement createAccountField = driver.findElement(By.xpath("//div[@id='content']/h1"));
        String createAccountFieldText = createAccountField.getText();
        Assert.assertEquals(createAccountFieldText,"Your Account Has Been Created!");


    }
}
