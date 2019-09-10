package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobject_model.test.Helpers;


public class CloudGoogleCalculatorPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://cloud.google.com/pricing/calculators']")
    private WebElement calculatorsTab;

    @FindBy(xpath = "//input[@id='input_52']")
    private WebElement instancesNumberField;

    @FindBy(xpath = "//md-select[@id='select_75']")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineTypeDropdownElement;

    @FindBy(css = "md-input-container > [aria-label='Add GPUs']")
    private WebElement addGpuCheckbox;

    @FindBy(xpath = "//input[@id='input_52']")
    private WebElement instancesNumberFieldText;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']/md-select-value")
    private WebElement gpuNumberDropdown;

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    private WebElement gpuNumberDropdownElement;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']/md-select-value")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//*[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuTypeDropdownElement;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']/md-select-value")
    private WebElement localSsdDropdown;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='2']")
    private WebElement getLocalSsdDropdownElement;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']/md-select-value")
    private WebElement dataCenterDropdown;

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//*[@value='europe-west3']")
    private WebElement dataCenterDropdownElement;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']/md-select-value")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//*[@value='1']")
    private WebElement committedUsageDropdownElement;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement submitButton;

    public CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    protected BasePage initElements() {
        PageFactory.initElements(driver, this);
        return null;
    }

    public CloudGoogleCalculatorPage openPage() {
        Helpers.waitUntilClickable("//a[@href='https://cloud.google.com/pricing/calculators']", driver);
        calculatorsTab.click();
        return this;
    }

    public CloudGoogleCalculatorPage fillForm() throws InterruptedException {
        switchToCalculatorPageFrame().fillInstancesNumberField()
                .chooseMachineType().activateGpuCheckbox()
                .chooseGpuNumber().chooseGpuType().chooseLocalSsd()
                .chooseDataCenter().chooseCommittedUsage().submitButton.click();
        return this;
    }

    public CloudGoogleCalculatorPage switchToCalculatorPageFrame() {
        Helpers.switchToFrame(driver, 0);
        return this;
    }

    public CloudGoogleCalculatorPage fillInstancesNumberField() {
        Helpers.fillTextField(driver, "//input[@id='input_52']", instancesNumberField, "4");
        return this;
    }

    public CloudGoogleCalculatorPage activateGpuCheckbox() {
        addGpuCheckbox.click();
        return this;
    }

    public CloudGoogleCalculatorPage chooseMachineType() {
        Helpers.choosingElementFromDropdown(driver, "//md-select[@id='select_75']", machineTypeDropdown,
                "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']", machineTypeDropdownElement);
        return this;
    }

    public CloudGoogleCalculatorPage chooseGpuNumber() {
        Helpers.choosingElementFromDropdown(driver, "//md-select[@placeholder='Number of GPUs']/md-select-value",
                gpuNumberDropdown, "//*[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']",
                gpuNumberDropdownElement);
        return this;
    }

    public CloudGoogleCalculatorPage chooseGpuType() {
        Helpers.choosingElementFromDropdown(driver, "//md-select[@placeholder='GPU type']/md-select-value", gpuTypeDropdown,
                "//*[@value='NVIDIA_TESLA_V100']", gpuTypeDropdownElement);
        return this;
    }

    public CloudGoogleCalculatorPage chooseLocalSsd() {
        Helpers.choosingElementFromDropdown(driver, "//md-select[@placeholder='Local SSD']/md-select-value", localSsdDropdown,
                "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='2']",
                getLocalSsdDropdownElement);
        return this;
    }

    public CloudGoogleCalculatorPage chooseDataCenter() {
        Helpers.choosingElementFromDropdown(driver, "//md-select[@placeholder='Datacenter location']/md-select-value",
                dataCenterDropdown, "//*[@class='md-select-menu-container md-active md-clickable']//*[@value='europe-west3']",
                dataCenterDropdownElement);
        return this;
    }

    public CloudGoogleCalculatorPage chooseCommittedUsage() {
        Helpers.choosingElementFromDropdown(driver, "//md-select[@placeholder='Committed usage']/md-select-value",
                committedUsageDropdown, "//*[@class='md-select-menu-container md-active md-clickable']//*[@value='1']",
                committedUsageDropdownElement);
        return this;
    }

    public String getEstimatedResult() {
        String estimateResult = driver.findElement(By.xpath("//*[@id='resultBlock']//*[@class='md-title']/b")).getText();
        return estimateResult;
    }

    public String getInstanceType() {
        String instanceType = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[3]/div")).getText();
        return instanceType;
    }

    public String getRegion() {
        String region = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[4]/div")).getText();
        return region;
    }

    public String getLocalSsd() {
        String localSsd = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[5]/div")).getText();
        return localSsd;
    }
}
