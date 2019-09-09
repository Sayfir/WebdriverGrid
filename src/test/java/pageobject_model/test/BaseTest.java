package pageobject_model.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobject_model.page.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest extends MainClass {

    @BeforeClass(alwaysRun = true)
    public void setUp() throws InterruptedException {
        super.driver = new ChromeDriver();
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
