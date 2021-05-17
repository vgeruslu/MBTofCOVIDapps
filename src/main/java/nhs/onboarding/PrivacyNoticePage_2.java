package nhs.onboarding;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class PrivacyNoticePage_2 {
    AndroidDriver<WebElement> driver;

    public PrivacyNoticePage_2(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By privacyProtection = MobileBy.AndroidUIAutomator("new UiSelector()" +
            ".className(\"android.widget.TextView\")." + "text(\"Protecting your privacy\")");
    private final By noThanksButton = MobileBy.id("uk.nhs.covid19.production:id/textNoThanks");
    private final By iAgreeButton = MobileBy.id("uk.nhs.covid19.production:id/buttonAgree");

    // external links
    private final By privacyNoticeButton = MobileBy.id("uk.nhs.covid19.production:id/privacyNoticeLink");
    private final By termsOfUseButton = MobileBy.id("uk.nhs.covid19.production:id/termsOfUseLink");

    // page 3
    public void privacyProtectionPage() {
        System.out.println("Check for Privacy Protection Element");
        new WebDriverWaits(driver).checkElementVisible(privacyProtection, 10);
    }

    public void clickNoThanks() {
        System.out.println("Click No Thanks");
        new WebDriverWaits(driver).waitForElementToBeClickable(noThanksButton, 10);
        driver.findElement(noThanksButton).click();
    }

    public void clickIAgree() {
        System.out.println("Click I Agree");
        new WebDriverWaits(driver).waitForElementToBeClickable(iAgreeButton, 10);
        driver.findElement(iAgreeButton).click();
    }

    public void clickPrivacyNoticeLink() {
        System.out.println("Click Privacy notice link");
        new WebDriverWaits(driver).waitForElementToBeClickable(privacyNoticeButton, 10);
        driver.findElement(privacyNoticeButton).click();
    }

    public void clickTermsOfUseLink() {
        System.out.println("Click Terms of Use Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(termsOfUseButton, 10);
        driver.findElement(termsOfUseButton).click();
    }
}
