package nhs.symptoms;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.utilities.UIActionHelper;
import qub.vg05.webdriver.WebDriverWaits;

public class SelectSymptomsPage {
    AndroidDriver<WebElement> driver;

    public SelectSymptomsPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By questionnaireMainContainer = MobileBy.id("uk.nhs.covid19.production:id/questionnaireMainContainer");
    private final By noSymptomsButton = MobileBy.id("uk.nhs.covid19.production:id/textNoSymptoms");
    private final By continueSymptomsButton = MobileBy.id("uk.nhs.covid19.production:id/buttonReviewSymptoms");

    private final By confirmNoSymptomsMessage  = MobileBy.id("uk.nhs.covid19.production:id/parentPanel");

    private final By nhs111OnlineLink  = MobileBy.id("uk.nhs.covid19.production:id/noSymptomsOnlineServiceLink");
    private final By backToHomeButton  = MobileBy.id("uk.nhs.covid19.production:id/buttonReturnToHomeScreen");

    private final By noSymptomsImage  = MobileBy.id("uk.nhs.covid19.production:id/imageNoSymptom");
    private final By errorPanel  = MobileBy.id("uk.nhs.covid19.production:id/errorPanel");

    // select check boxes
    private final By feverCheckbox = new UIActionHelper(driver).findElementText("A high temperature (fever)");
    private final By coughCheckbox = new UIActionHelper(driver).findElementText("A new continuous cough");
    private final By tasteCheckbox = new UIActionHelper(driver).findElementText("A change to your sense of smell or taste");



    public void checkInSelectSymptomsPage() {
        System.out.println("Check In Select Symptoms Page");
        new WebDriverWaits(driver).checkElementVisible(questionnaireMainContainer, 10);
    }

    public void checkForNoSymptomsMessage() {
        System.out.println("Check For No Symptoms Message");
        new WebDriverWaits(driver).checkElementVisible(confirmNoSymptomsMessage, 10);
    }


    public void clickIDontHaveSymptoms() {
        System.out.println("Click I dont Have Symptoms");
        new WebDriverWaits(driver).waitForElementToBeClickable(noSymptomsButton, 10);
        driver.findElement(noSymptomsButton).click();
    }

    public void clickContinue() {
        System.out.println("Click Continue to step 2");
        new WebDriverWaits(driver).waitForElementToBeClickable(continueSymptomsButton, 10);
        driver.findElement(continueSymptomsButton).click();
    }

    public void clickNHS11onlineLink() {
        System.out.println("Click NHS 111 online Link");
        new WebDriverWaits(driver).waitForElementToBeClickable(nhs111OnlineLink, 10);
        driver.findElement(nhs111OnlineLink).click();
    }

    public void clickBackToHome() {
        System.out.println("Click back to home");
        new WebDriverWaits(driver).waitForElementToBeClickable(backToHomeButton, 10);
        driver.findElement(backToHomeButton).click();
    }

    public void clickFeverCheckBox() {
        System.out.println("Click Fever checkbox");
        new WebDriverWaits(driver).waitForElementToBeClickable(feverCheckbox, 10);
        driver.findElement(feverCheckbox).click();
    }

    public void clickCoughCheckBox() {
        System.out.println("Click cough checkbox");
        new WebDriverWaits(driver).waitForElementToBeClickable(coughCheckbox, 10);
        driver.findElement(coughCheckbox).click();
    }

    public void clickTasteCheckbox() {
        System.out.println("Click taste checkbox");
        new WebDriverWaits(driver).waitForElementToBeClickable(tasteCheckbox, 10);
        driver.findElement(tasteCheckbox).click();
    }

    public void checkInUnlikelyToHaveCovidPage() {
        System.out.println("Check in Unlikely To have Covid Page");
        new WebDriverWaits(driver).checkElementVisible(noSymptomsImage, 10);
    }

    public void checkErrorMessageNoOptionsSelected() {
        System.out.println("Check for error message as not option was selected");
        new WebDriverWaits(driver).checkElementVisible(errorPanel, 10);
    }
}
