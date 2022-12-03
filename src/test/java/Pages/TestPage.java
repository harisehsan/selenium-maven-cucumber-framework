package Pages;

import base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pageObject.TestPageObject;

import java.time.Duration;


public class TestPage extends Base {
    WebDriver driver;
    TestPageObject testPageObject = new TestPageObject();

    public TestPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, testPageObject);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void navigateToSite() throws InterruptedException {

        goToPage("https://www.mercedes-benz.co.uk/");
        waitUntilPageReady(Duration.ofMinutes(1));

    }
   }