package pageobject_model.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject_model.page.MainClass;

import java.util.concurrent.TimeUnit;

public class Helpers extends MainClass {

    public static void waitUntilClickable(String locator, WebDriver driver) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(locator)));
    }

    public static void choosingElementFromDropdown(WebDriver driver, String dropDownLocator, WebElement dropdownWebElement1,
                                                   String dropDownElementLocator,
                                                   WebElement dropDownWebElement2) {
        waitUntilClickable(dropDownLocator, driver);
        dropdownWebElement1.click();
        waitUntilClickable(dropDownElementLocator, driver);
        dropDownWebElement2.click();
    }

    public static void switchToFrame(WebDriver driver, int frameNumber) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().
                frame(frameNumber);
    }

    public static void fillTextField(WebDriver driver, String locator, WebElement textField, String text) {
        waitUntilClickable(locator, driver);
        textField.click();
        textField.sendKeys(text);
    }
}
