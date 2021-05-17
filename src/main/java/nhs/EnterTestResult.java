package nhs;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class EnterTestResult {
    AndroidDriver<WebElement> driver;

    public EnterTestResult(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By linkTestResultEnterCodeView = MobileBy.id("uk.nhs.covid19.production:id/linkTestResultEnterCodeView");
    private final By invalidTestCodeErrorMessage = MobileBy.id("uk.nhs.covid19.production:id/enterCodeErrorText");
    private final By enterTestResultButton = MobileBy.id("uk.nhs.covid19.production:id/enterCodeEditText");
    private final By enterTestCodeContinueButton = MobileBy.id("uk.nhs.covid19.production:id/linkTestResultContinue");

    public void checkTestResultPageView() {
        System.out.println("Check in Enter Test Code Page");
        new WebDriverWaits(driver).checkElementVisible(linkTestResultEnterCodeView, 10);
    }

    public void checkTestCodeErrorMessage() {
        System.out.println("Check for invalid Test Code message");
        new WebDriverWaits(driver).checkElementVisible(invalidTestCodeErrorMessage, 10);
    }

    public void clickContinueTestCode() {
        System.out.println("Click Continue");
        new WebDriverWaits(driver).waitForElementToBeClickable(enterTestCodeContinueButton, 10);
        driver.findElement(enterTestCodeContinueButton).click();
    }

    public void enterInvalidTestCode() {

        System.out.println("Enter Invalid Test Code");
        new WebDriverWaits(driver).waitForElementToBeClickable(enterTestResultButton, 10);
        driver.findElement(enterTestResultButton).clear();
        driver.findElement(enterTestResultButton).sendKeys("55555");
    }

}
