package nhs.onboarding;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class ContactTracingPermissionsPage_5 {
    AndroidDriver<WebElement> driver;

    public ContactTracingPermissionsPage_5(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By continuePermissions = MobileBy.id("uk.nhs.covid19.production:id/permissionContinue");
    private final By permissionsContainer = MobileBy.id("uk.nhs.covid19.production:id/permissionContainer");

    private final By turnOnExposurePopUp = MobileBy.id("com.google.android.gms:id/alertTitle");

    private final By edgeCaseContainer = MobileBy.id("uk.nhs.covid19.production:id/edgeCaseContainer");
    private final By enableExposureNotificationButton = MobileBy.id("uk.nhs.covid19.production:id/takeActionButton");


    public void checkPermissionsContainer() {
        System.out.println("Check in Permission Page");
        new WebDriverWaits(driver).checkElementVisible(permissionsContainer, 10);
    }

    public void clickConfirmButtonPermissions() {
        System.out.println("Click Continue");
        new WebDriverWaits(driver).waitForElementToBeClickable(continuePermissions, 10);
        driver.findElement(continuePermissions).click();
    }

    public void checkTurnOnExposurePopupContainer() {
        System.out.println("Check For Exposure Popup");
        new WebDriverWaits(driver).checkElementVisible(turnOnExposurePopUp, 10);
    }



    public void checkEdgeCaseContainer() {
        System.out.println("Check in Allow Exposure Notifications Page");
        new WebDriverWaits(driver).checkElementVisible(edgeCaseContainer, 10);
    }

    public void clickEnableExposureNotifications() {
        System.out.println("Click Continue");
        new WebDriverWaits(driver).waitForElementToBeClickable(enableExposureNotificationButton, 10);
        driver.findElement(enableExposureNotificationButton).click();
    }
}
