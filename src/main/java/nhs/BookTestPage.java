package nhs;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class BookTestPage {
    AndroidDriver<WebElement> driver;

    private final By testOrderingContainer = MobileBy.id("uk.nhs.covid19.production:id/testOrderingContainer");
    // External Links
    private final By appPrivacyNoticeLink = MobileBy.id("uk.nhs.covid19.production:id/appPrivacyNoticeLink");
    private final By testPrivacyNoticeLink = MobileBy.id("uk.nhs.covid19.production:id/orderTestPrivacyNoticeLink");
    private final By bookTestForSomeoneElseLink = MobileBy.id("uk.nhs.covid19.production:id/bookTestForSomeoneElseLink");
    private final By bookTestForYourselfLink = MobileBy.id("uk.nhs.covid19.production:id/orderTest");


    public BookTestPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    public void checkForBookTestPageContainer() {
        System.out.println("Check for book test container");
        new WebDriverWaits(driver).checkElementVisible(testOrderingContainer, 10);
    }

    public void clickAppPrivacyNoticeLink() {
        System.out.println("Click app privacy Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(appPrivacyNoticeLink, 10);
        driver.findElement(appPrivacyNoticeLink).click();
    }

    public void clickTestPrivacyNoticeLink() {
        System.out.println("Click tes privacy Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(testPrivacyNoticeLink, 10);
        driver.findElement(testPrivacyNoticeLink).click();
    }

    public void clickBookTestForSomeoneElseLink() {
        System.out.println("Click book test for someone else link");
        new WebDriverWaits(driver).waitForElementToBeClickable(bookTestForSomeoneElseLink, 10);
        driver.findElement(bookTestForSomeoneElseLink).click();
    }

    public void clickBookTestForYourselfLink() {
        System.out.println("Click book test for yourself link");
        new WebDriverWaits(driver).waitForElementToBeClickable(bookTestForYourselfLink, 10);
        driver.findElement(bookTestForYourselfLink).click();
    }

}
