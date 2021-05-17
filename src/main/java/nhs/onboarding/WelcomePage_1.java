package nhs.onboarding;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class WelcomePage_1 {

    AndroidDriver<WebElement> driver;

    public WelcomePage_1(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By continueToConfirmOnboardingButton = MobileBy.id("uk.nhs.covid19.production:id/confirmOnboarding");
    private final By notificationIcon = MobileBy.id("uk.nhs.covid19.production:id/iconNotification");
    private final By alertTitle = MobileBy.id("uk.nhs.covid19.production:id/parentPanel");

    private final By continuePermissions = MobileBy.id("uk.nhs.covid19.production:id/permissionContinue");
    private final By permissionsContainer = MobileBy.id("uk.nhs.covid19.production:id/permissionContainer");



    // page 1
    public void clickContinue() {
        System.out.println("Click Continue");
        new WebDriverWaits(driver).waitForElementToBeClickable(continueToConfirmOnboardingButton, 10);
        driver.findElement(continueToConfirmOnboardingButton).click();
    }

    public void checkIconNotification() {
        System.out.println("Check notification Icon is visible ");
        new WebDriverWaits(driver).checkElementVisible(notificationIcon, 10);
    }

    // popup
    public void checkAgeAlert() {
        System.out.println("Check Age Alert Button is visible");
        new WebDriverWaits(driver).checkElementVisible(alertTitle, 10);
    }

}
