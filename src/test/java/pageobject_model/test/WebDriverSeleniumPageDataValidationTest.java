package pageobject_model.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject_model.page.CloudGoogleCalculatorPage;

public class WebDriverSeleniumPageDataValidationTest extends BaseTest {

    @Test
    public void testGetCorrectEstimationValue() throws InterruptedException {
        String estimateResult = new CloudGoogleCalculatorPage(driver)
                .getEstimatedResult();
        Assert.assertEquals("Total Estimated Cost: USD 1,187.77 per 1 month", estimateResult);
    }

    @Test
    public void testGetInstanceTypeCorrectValue() throws InterruptedException {
        String instanceValue = new CloudGoogleCalculatorPage(driver)
                .getInstanceType();
        Assert.assertEquals("Instance type: n1-standard-8", instanceValue);
    }

    @Test
    public void testGetRegionCorrectValue() {
        String regionValue = new CloudGoogleCalculatorPage(driver)
                .getRegion();
        Assert.assertEquals("Region: Frankfurt", regionValue);
    }

    @Test
    public void testGetLocalSsdCorrectValue() {
    String ssdValue = new CloudGoogleCalculatorPage(driver)
            .getLocalSsd();
        Assert.assertEquals("Total available local SSD space 2x375 GB", ssdValue);
    }
}

