package nhs;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class VenueCheckIn {
    AndroidDriver<WebElement> driver;

    public VenueCheckIn(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By permissionIcon = MobileBy.id("com.android.permissioncontroller:id/permission_icon");
    private final By resultIcon = MobileBy.id("uk.nhs.covid19.production:id/resultIcon");
    private final By scannerSurfaceView = MobileBy.id("uk.nhs.covid19.production:id/scannerSurfaceView");

    private final By allowWhileUsingAppButton = MobileBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private final By denyButton = MobileBy.id("com.android.permissioncontroller:id/permission_deny_button");
    private final By denyDontAskAgain = MobileBy.id("com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button");

    private final By moreInfoButton = MobileBy.id("uk.nhs.covid19.production:id/textMoreInfo");
    private final By moreInfoQRHelpTitle = MobileBy.id("uk.nhs.covid19.production:id/qrCodeHelpTitle");

    public void checkForCameraPermissionMessage () {
        System.out.println("Check For Camera Permission Check");
        new WebDriverWaits(driver).checkElementVisible(permissionIcon, 10);
    }

    public void checkInPleaseAllowCameraPermissionsPage () {
        System.out.println("Check For Camera Icon");
        new WebDriverWaits(driver).checkElementVisible(resultIcon, 10);
    }

    public void checkForQRScannerView () {
        System.out.println("Check QR Scanner View");
        new WebDriverWaits(driver).checkElementVisible(scannerSurfaceView, 10);
    }

    public void checkInQRMoreInfoPage () {
        System.out.println("Check in QR more Info Page");
        new WebDriverWaits(driver).checkElementVisible(moreInfoQRHelpTitle, 10);
    }

    public void clickMoreInfo() {
        System.out.println("Click More Info");
        new WebDriverWaits(driver).waitForElementToBeClickable(moreInfoButton, 10);
        driver.findElement(moreInfoButton).click();
    }


    public void clickAllowCameraPermissionButton() {
        System.out.println("Click Allow Camera Permission Button");
        new WebDriverWaits(driver).waitForElementToBeClickable(allowWhileUsingAppButton, 10);
        driver.findElement(allowWhileUsingAppButton).click();
    }

    public void clickDenyCameraPermissionButton() {
        System.out.println("Click Deny Camera Permission Button");
        new WebDriverWaits(driver).waitForElementToBeClickable(denyButton, 10);
        driver.findElement(denyButton).click();
    }
}
