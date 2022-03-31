package frontend;

import core.SuperPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ElementsInHomePage extends SuperPage {

    @FindBy(xpath = "//div[@id='top-links']//span[text()='My Account']")
    private static WebElement myAccountField;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
    private  static WebElement registerField;





    static {
        PageFactory.initElements(Browser.driver, ElementsInHomePage.class);
    }




    public static void clickmyAccountField() {
        myAccountField.click();
    }

    public static void clickregisterField() {
        registerField.click();
    }

}
