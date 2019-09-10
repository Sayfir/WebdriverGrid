package pageobject_model.test;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobject_model.page.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest extends MainClass {

    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // FirefoxOptions options = new FirefoxOptions();
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        String hubUrl = "http://localhost:4444/wd/hub";
        try {
            super.driver = new RemoteWebDriver(new URL(hubUrl), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new CloudGoogleHomePage(driver).openPage();
        new CloudGoogleProductsPage(driver).openPage();
        new CloudGooglePricingPage(driver).openPage();
        new CloudGoogleCalculatorPage(driver).openPage().fillForm();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
