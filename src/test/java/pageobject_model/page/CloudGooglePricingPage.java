package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Helpers;

public class CloudGooglePricingPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://cloud.google.com/pricing/' and @track-name='seePricing']")
    private WebElement seePricingLink;

    public CloudGooglePricingPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    public CloudGooglePricingPage openPage() {
        Helpers.waitUntilClickable("//a[@href='https://cloud.google.com/pricing/' and @track-name='seePricing']", driver);
        new Actions(driver).click(seePricingLink).build().perform();
        return this;
    }

    protected BasePage initElements() {
        PageFactory.initElements(driver, this);
        return null;
    }
}
