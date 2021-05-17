package nhs;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class HomePage {
    AndroidDriver<WebElement> driver;

    public HomePage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By contactTracingActiveView = MobileBy.id("uk.nhs.covid19.production:id/contactTracingActiveView");
    private final By contactTracingStoppedView = MobileBy.id("uk.nhs.covid19.production:id/contactTracingStoppedView");
    private final By enterTestResultButton = MobileBy.id("uk.nhs.covid19.production:id/optionLinkTestResult");
    private final By riskAreaButton = MobileBy.id("uk.nhs.covid19.production:id/riskAreaView");
    private final By venueCheckInButton = MobileBy.id("uk.nhs.covid19.production:id/optionVenueCheckIn");
    private final By checkSymptomsButton = MobileBy.id("uk.nhs.covid19.production:id/optionReportSymptoms");
    private final By readAdviceButton = MobileBy.id("uk.nhs.covid19.production:id/optionReadAdvice");
    private final By settingsButton = MobileBy.id("uk.nhs.covid19.production:id/optionSettings");
    private final By aboutThisAppButton = MobileBy.id("uk.nhs.covid19.production:id/optionAboutTheApp");
    private final By contactingOnOFFButton = MobileBy.id("uk.nhs.covid19.production:id/optionContactTracing");
    private final By bookTestButton = MobileBy.id("uk.nhs.covid19.production:id/optionOrderTest");

    private final By statusBanner = MobileBy.id("uk.nhs.covid19.production:id/statusBanner");
    private final By exposureNotificationReminderContainer =
            MobileBy.id("uk.nhs.covid19.production:id/exposure_notification_reminder_container");

    private final By exposureNotificationReminderConfirmationMessage =
            MobileBy.id("uk.nhs.covid19.production:id/parentPanel");

    private final By touchOutSide = MobileBy.id("uk.nhs.covid19.production:id/touch_outside");
    private final By fourHourButton = MobileBy.id("uk.nhs.covid19.production:id/hours_4");
    private final By eightHourButton = MobileBy.id("uk.nhs.covid19.production:id/hours_8");
    private final By twelveHourButton = MobileBy.id("uk.nhs.covid19.production:id/hours_12");
    private final By dontRemindMeButton = MobileBy.id("uk.nhs.covid19.production:id/dont_remind");

    public void checkContactTracingActiveView () {
        System.out.println("Check in Home Page - Tracing Active");
        new WebDriverWaits(driver).checkElementVisible(contactTracingActiveView, 10);
    }

    public void checkContactTracingStoppedView () {
        System.out.println("Check in Home Pag - Tracing Stopped");
        new WebDriverWaits(driver).checkElementVisible(contactTracingActiveView, 10);
    }

    public void checkInHomePage () {
        System.out.println("Check in Home Page");
        new WebDriverWaits(driver).checkElementVisible(venueCheckInButton, 10);
        new WebDriverWaits(driver).checkElementVisible(readAdviceButton, 10);
        new WebDriverWaits(driver).checkElementVisible(statusBanner, 10);
    }

    public void checkForExposureNotificationReminder () {
        System.out.println("Check For Exposure Notification Reminder");
        new WebDriverWaits(driver).checkElementVisible(exposureNotificationReminderContainer, 10);
    }

    public void checkForExposureNotificationReminderConfirmationMessage () {
        System.out.println("Check For Exposure Notification Reminder Confirmation Message");
        new WebDriverWaits(driver).checkElementVisible(exposureNotificationReminderConfirmationMessage, 10);
    }

    public void clickEnterTestResult() {
        System.out.println("Click Enter Test Result");
        new WebDriverWaits(driver).waitForElementToBeClickable(enterTestResultButton, 10);
        driver.findElement(enterTestResultButton).click();
    }
    public void clickRiskArea() {
        System.out.println("Click Risk Area");
        new WebDriverWaits(driver).waitForElementToBeClickable(riskAreaButton, 10);
        driver.findElement(riskAreaButton).click();
    }

    public void clickVenueCheckIn() {
        System.out.println("Click Venue Check In");
        new WebDriverWaits(driver).waitForElementToBeClickable(venueCheckInButton, 10);
        driver.findElement(venueCheckInButton).click();
    }

    public void clickCheckSymptoms() {
        System.out.println("Click Check Symptoms");
        new WebDriverWaits(driver).waitForElementToBeClickable(checkSymptomsButton, 10);
        driver.findElement(checkSymptomsButton).click();
    }

    public void clickReadAdvice() {
        System.out.println("Click Read Advice");
        new WebDriverWaits(driver).waitForElementToBeClickable(readAdviceButton, 10);
        driver.findElement(readAdviceButton).click();
    }

    public void clickSettings() {
        System.out.println("Click Settings");
        new WebDriverWaits(driver).waitForElementToBeClickable(settingsButton, 10);
        driver.findElement(settingsButton).click();
    }

    public void clickAboutThisApp() {
        System.out.println("Click About This App");
        new WebDriverWaits(driver).waitForElementToBeClickable(aboutThisAppButton, 10);
        driver.findElement(aboutThisAppButton).click();
    }

    public void clickContactTracingToggle() {
        System.out.println("Click Contact Tracing toggle");
        new WebDriverWaits(driver).waitForElementToBeClickable(contactingOnOFFButton, 10);
        driver.findElement(contactingOnOFFButton).click();
    }

    public void clickDontRemindMe() {
        System.out.println("Click Don't Remind Me");
        new WebDriverWaits(driver).waitForElementToBeClickable(dontRemindMeButton, 10);
        driver.findElement(dontRemindMeButton).click();
    }

    public void clickTouchOutside() {
        System.out.println("Click Outside Exposure reminder");
        new WebDriverWaits(driver).waitForElementToBeClickable(touchOutSide, 10);
        driver.findElement(touchOutSide).click();
    }

    public void click4Hours() {
        System.out.println("Click 4 hours");
        new WebDriverWaits(driver).waitForElementToBeClickable(fourHourButton, 10);
        driver.findElement(fourHourButton).click();
    }

    public void click8Hours() {
        System.out.println("Click 8 hours");
        new WebDriverWaits(driver).waitForElementToBeClickable(eightHourButton, 10);
        driver.findElement(eightHourButton).click();
    }

    public void click12Hours() {
        System.out.println("Click 12 hours");
        new WebDriverWaits(driver).waitForElementToBeClickable(twelveHourButton, 10);
        driver.findElement(twelveHourButton).click();
    }

    public void clickBookFreeTest() {
        System.out.println("Click book free test");
        new WebDriverWaits(driver).waitForElementToBeClickable(bookTestButton, 10);
        driver.findElement(bookTestButton).click();
    }








}
