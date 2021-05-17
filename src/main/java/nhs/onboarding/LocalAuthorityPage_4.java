package nhs.onboarding;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class LocalAuthorityPage_4 {

    AndroidDriver<WebElement> driver;

    public LocalAuthorityPage_4(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By confirmButton = MobileBy.id("uk.nhs.covid19.production:id/buttonConfirmLink");
    private final By localAuthorityContainer = MobileBy.id("uk.nhs.covid19.production:id/localAuthorityContainer");

    // page 5 local Authority

    public void checkLocalAuthorityContainer() {
        System.out.println("Check in Local Authority Page");
        new WebDriverWaits(driver).checkElementVisible(localAuthorityContainer, 10);
    }

    public void clickConfirmButton() {
        System.out.println("Click Confirm");
        new WebDriverWaits(driver).waitForElementToBeClickable(confirmButton, 10);
        driver.findElement(confirmButton).click();
    }
}
