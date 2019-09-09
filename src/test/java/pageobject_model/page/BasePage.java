package pageobject_model.page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage extends MainClass {

    public BasePage(WebDriver driver) {
        super.driver = driver;
    }
    protected abstract BasePage openPage() throws InterruptedException;
    protected abstract BasePage initElements();
}
