package nhs;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.utilities.UIActionHelper;
import qub.vg05.webdriver.WebDriverWaits;

public class Settings {
    AndroidDriver<WebElement> driver;

    public Settings(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By settingsContainer = MobileBy.id("uk.nhs.covid19.production:id/settingsContainer");
    private final By languageContainer = MobileBy.id("uk.nhs.covid19.production:id/languagesContainer");
    private final By changeLanguagePopup = MobileBy.id("uk.nhs.covid19.production:id/parentPanel");
    private final By languageOptionButton = MobileBy.id("uk.nhs.covid19.production:id/languageOption");

    // language options
    private final By systemLanguageOption = MobileBy.id("uk.nhs.covid19.production:id/systemLanguage");
    private final By arabicOption = new UIActionHelper(driver).findElementText("Arabic");
    private final By bengaliOption = new UIActionHelper(driver).findElementText("Bengali");
    private final By chineseOption = new UIActionHelper(driver).findElementText("Chinese");
    private final By gujaratiOption = new UIActionHelper(driver).findElementText("Gujarati");
    private final By polishOption = new UIActionHelper(driver).findElementText("Polish");
    private final By punjabiOption = new UIActionHelper(driver).findElementText("Punjabi");
    private final By romanianOption = new UIActionHelper(driver).findElementText("Romanian");
    private final By somaliOption = new UIActionHelper(driver).findElementText("Somali");
    private final By turkishOption = new UIActionHelper(driver).findElementText("Turkish");
    private final By urduOption = new UIActionHelper(driver).findElementText("Urdu");
    private final By welshOption = new UIActionHelper(driver).findElementText("Welsh");


    public void checkInSettingsPage () {
        System.out.println("Check In Settings Page");
        new WebDriverWaits(driver).checkElementVisible(settingsContainer, 10);
    }

    public void checkInLanguagePage () {
        System.out.println("Check In Language Page");
        new WebDriverWaits(driver).checkElementVisible(languageContainer, 10);
    }

    public void checkForChangeLanguagePopup () {
        System.out.println("Check For change language popup");
        new WebDriverWaits(driver).checkElementVisible(changeLanguagePopup, 10);
    }

    public void clickLanguageOption() {
        System.out.println("Click language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(languageOptionButton, 10);
        driver.findElement(languageOptionButton).click();
    }

    public void clickSystemLanguageOption() {
        System.out.println("Click System language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(systemLanguageOption, 10);
        driver.findElement(systemLanguageOption).click();
    }

    public void clickArabicLanguageOption() {
        System.out.println("Click Arabic language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(arabicOption, 10);
        driver.findElement(arabicOption).click();
    }

    public void clickBengaliLanguageOption() {
        System.out.println("Click Bengali language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(bengaliOption, 10);
        driver.findElement(bengaliOption).click();
    }

    public void clickChineseLanguageOption() {
        System.out.println("Click Chinese language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(chineseOption, 10);
        driver.findElement(chineseOption).click();
    }

    public void clickGujaratiLanguageOption() {
        System.out.println("Click Gujarati language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(gujaratiOption, 10);
        driver.findElement(gujaratiOption).click();
    }

    public void clickPolishLanguageOption() {
        System.out.println("Click Polish language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(polishOption, 10);
        driver.findElement(polishOption).click();
    }

    public void clickPunjabiLanguageOption() {
        System.out.println("Click Punjabi language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(punjabiOption, 10);
        driver.findElement(punjabiOption).click();
    }

    public void clickRomanianLanguageOption() {
        System.out.println("Click Romanian language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(romanianOption, 10);
        driver.findElement(romanianOption).click();
    }

    public void clickSomaliLanguageOption() {
        System.out.println("Click Somali language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(somaliOption, 10);
        driver.findElement(somaliOption).click();
    }

    public void clickTurkishLanguageOption() {
        System.out.println("Click Turkish language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(turkishOption, 10);
        driver.findElement(turkishOption).click();
    }

    public void clickUrduLanguageOption() {
        System.out.println("Click Urdu language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(urduOption, 10);
        driver.findElement(urduOption).click();
    }

    public void clickWelshLanguageOption() {
        System.out.println("Click Welsh language Option");
        new WebDriverWaits(driver).waitForElementToBeClickable(welshOption, 10);
        driver.findElement(welshOption).click();
    }
}
