package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;
    public static WebDriverWait waitSixSeconds;


    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Irena\\QAQ24\\BrouzersDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        waitSixSeconds = new WebDriverWait(driver, 6);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        driver.quit();
    }


}
