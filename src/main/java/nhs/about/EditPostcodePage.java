package nhs.about;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class EditPostcodePage {
    AndroidDriver<WebElement> driver;

    public EditPostcodePage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }


    // edit postcode page
    private final By editPostalDistrictScrollView = MobileBy.id("uk.nhs.covid19.production:id/editPostalDistrictScrollView");
    private final By invalidPostcodeErrorMessageTitle = MobileBy.id("uk.nhs.covid19.production:id/errorTextTitle");
    private final By invalidPostcodeErrorMessageContainer = MobileBy.id("uk.nhs.covid19.production:id/errorInfoContainer");
    private final By localAuthorityContainer = MobileBy.id("uk.nhs.covid19.production:id/localAuthorityContainer");

    private final By postCodeEditTextButton = MobileBy.id("uk.nhs.covid19.production:id/postCodeEditText");
    private final By postCodeContinueButton = MobileBy.id("uk.nhs.covid19.production:id/continuePostCode");
    private final By confirmLinkButton = MobileBy.id("uk.nhs.covid19.production:id/buttonConfirmLink");


    public void checkForEditPostcodeView() {
        System.out.println("Check For edit Postcode view");
        new WebDriverWaits(driver).waitForElementToBeClickable(editPostalDistrictScrollView, 10);
        driver.findElement(editPostalDistrictScrollView).click();
    }

    public void checkForInvalidPostcodeTitle() {
        System.out.println("Check For Invalid Postcode Title");
        new WebDriverWaits(driver).checkElementVisible(invalidPostcodeErrorMessageTitle, 10);
    }

    public void checkForInvalidPostcodeContainer() {
        System.out.println("Check For Invalid Postcode Container");
        new WebDriverWaits(driver).checkElementVisible(invalidPostcodeErrorMessageContainer, 10);
    }

    public void checkForLocalAuthorityContainer() {
        System.out.println("Check For Local Authority Container");
        new WebDriverWaits(driver).checkElementVisible(localAuthorityContainer, 10);
    }

    public void enterInvalidPostcode() {

        System.out.println("Enter Invalid Postcode");
        new WebDriverWaits(driver).waitForElementToBeClickable(postCodeEditTextButton, 10);
        driver.findElement(postCodeEditTextButton).clear();
        driver.findElement(postCodeEditTextButton).sendKeys("33");
    }

    public void enterValidPostcode() {

        System.out.println("Enter Valid Postcode");
        new WebDriverWaits(driver).waitForElementToBeClickable(postCodeEditTextButton, 10);
        driver.findElement(postCodeEditTextButton).clear();
        driver.findElement(postCodeEditTextButton).sendKeys("L4");
    }


    public void clickConfirmLinkButton() {
        System.out.println("Click Confirm Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(confirmLinkButton, 10);
        driver.findElement(confirmLinkButton).click();
    }

    public void clickContinuePostcode() {
        System.out.println("Click Continue When Adding Postcode");
        new WebDriverWaits(driver).waitForElementToBeClickable(postCodeContinueButton, 10);
        driver.findElement(postCodeContinueButton).click();
    }
}
