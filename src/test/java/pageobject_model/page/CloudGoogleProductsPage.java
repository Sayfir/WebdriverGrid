package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGoogleProductsPage extends BasePage {

    @FindBy(xpath = "//*[@id='top_of_page']/div[1]/div[1]//nav/ul/li[4]/a")
    private WebElement productsTab;

    @FindBy(xpath = "//a[@track-metadata-eventdetail='seeAllProducts']")
    private WebElement seeAllProductsLink;

    public CloudGoogleProductsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    protected CloudGoogleProductsPage initElements() {
        PageFactory.initElements(driver, this);
        return null;
    }

    public CloudGoogleProductsPage openPage() throws InterruptedException {
        productsTab.click();
        seeAllProductsLink.click();
        return this;
    }
}
