package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Browser;

public class BaseTest {
    @BeforeMethod
    public void setUpBrowser() {
        Browser.setUp();
    }

    @AfterMethod
    public void quitBrowser() {
        Browser.tearDown();
    }
}
