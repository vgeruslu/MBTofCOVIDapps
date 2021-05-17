package nhs.about;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class AboutThisAppPage {
    AndroidDriver<WebElement> driver;

    private final By howAppWorksContainer = MobileBy.id("uk.nhs.covid19.production:id/how_this_app_works_container");
    // External Links
    private final By howAppWorksLink = MobileBy.id("uk.nhs.covid19.production:id/linkHowTheAppWorks");
    private final By termsOfUseLink = MobileBy.id("uk.nhs.covid19.production:id/linkTermsOfUse");
    private final By privacyNoticeLink = MobileBy.id("uk.nhs.covid19.production:id/linkPrivacyNotice");
    private final By accessibilityStatementLink = MobileBy.id("uk.nhs.covid19.production:id/linkAccessibilityStatement");
    private final By commonQuestionsLink = MobileBy.id("uk.nhs.covid19.production:id/linkCommonQuestions");
    private final By feedbackInformationLink = MobileBy.id("uk.nhs.covid19.production:id/linkFeedbackInformation");

    private final By manageMyDataButton = MobileBy.id("uk.nhs.covid19.production:id/linkManageData");


    public AboutThisAppPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    public void checkForHowAppWorksView() {
        System.out.println("Check in About this App Page");
        new WebDriverWaits(driver).checkElementVisible(howAppWorksContainer, 10);
    }

    public void clickManageDataButton() {
        System.out.println("Click manage my data button");
        new WebDriverWaits(driver).waitForElementToBeClickable(manageMyDataButton, 10);
        driver.findElement(manageMyDataButton).click();
    }

    // External Links

    public void clickHowAppWorksLink() {
        System.out.println("Click How app Works Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(howAppWorksLink, 10);
        driver.findElement(howAppWorksLink).click();
    }

    public void clickTermsOfUseLink() {
        System.out.println("Click Terms of use Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(termsOfUseLink, 10);
        driver.findElement(termsOfUseLink).click();
    }

    public void clickPrivacyNoticeLink() {
        System.out.println("Click Privacy Notice Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(privacyNoticeLink, 10);
        driver.findElement(privacyNoticeLink).click();
    }

    public void clickAccessibilityStatementLink() {
        System.out.println("Click Accessibility Statement Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(accessibilityStatementLink, 10);
        driver.findElement(accessibilityStatementLink).click();
    }

    public void clickCommonQuestionsLink() {
        System.out.println("Click Common Questions Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(commonQuestionsLink, 10);
        driver.findElement(commonQuestionsLink).click();
    }

    public void clickFeedbackInformationLink() {
        System.out.println("Click Feedback Information Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(feedbackInformationLink, 10);
        driver.findElement(feedbackInformationLink).click();
    }



}
