package nhs.about;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class ManageMyDataPage {
    AndroidDriver<WebElement> driver;

    public ManageMyDataPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By localAuthorityTitle = MobileBy.id("uk.nhs.covid19.production:id/localAuthorityTitle");
    private final By editButton = MobileBy.id("uk.nhs.covid19.production:id/editLocalAuthority");
    private final By deleteAllMyDataButton = MobileBy.id("uk.nhs.covid19.production:id/actionDeleteAllData");

    private final By deleteAllDataWarningPopUp = MobileBy.id("uk.nhs.covid19.production:id/parentPanel");

    public void checkForLocalAuthorityTitle () {
        System.out.println("Check in Manage My Data Page Page");
        new WebDriverWaits(driver).checkElementVisible(localAuthorityTitle, 10);
    }

    public void checkForDeleteAllDatConfirmationMessage () {
        System.out.println("Check FOr Delete All Data Confirmation Popup");
        new WebDriverWaits(driver).checkElementVisible(deleteAllDataWarningPopUp, 10);
    }

    public void clickEditButton() {
        System.out.println("Click Edit Button");
        new WebDriverWaits(driver).waitForElementToBeClickable(editButton, 10);
        driver.findElement(editButton).click();
    }

    public void clickDeleteAllMyDataButton() {
        System.out.println("Click Delete All My Data Button");
        new WebDriverWaits(driver).waitForElementToBeClickable(deleteAllMyDataButton, 10);
        driver.findElement(deleteAllMyDataButton).click();
    }

}
