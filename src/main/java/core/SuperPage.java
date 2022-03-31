package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

public class SuperPage {
    protected static WebElement waitForElementToBeClicable(WebElement element){
        WebDriverWait waitTree = new WebDriverWait(Browser.driver, 3);
        return waitTree.until(ExpectedConditions.elementToBeClickable(element));
    }

}
