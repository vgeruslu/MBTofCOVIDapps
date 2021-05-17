package qub.vg05.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.adb.AdbCommands;
import qub.vg05.webdriver.WebDriverWaits;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import java.util.concurrent.TimeUnit;

public class AndroidCommonMethods {

    AndroidDriver<WebElement> driver;

    public AndroidCommonMethods(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By AndroidAlertMessageTitle = MobileBy.id("android:id/alertTitle");
    private final By noButton = MobileBy.AccessibilityId("No");
    private final By noNoButton = MobileBy.AccessibilityId("No, No");
    private final By yesYesButton = MobileBy.AccessibilityId("Yes, Yes");
    private final By cancelButton = MobileBy.id("android:id/button2");
    private final By continueButton = MobileBy.id("android:id/button1");
    private final By continueButtonAccessibilityId = MobileBy.AccessibilityId("Continue");


    public String getElementText(MobileBy id) {
        String elementText;
        try {
            new WebDriverWaits(driver).waitForElementToBeClickable(id, 5);
            elementText = driver.findElement(id).getText();
        }
        catch (Exception ignore) {
            System.out.println("Failed To get text of: " + id);
            elementText = null;
        }
        return elementText;
    }

    public int getAndroidVersion(){

        AdbCommands adbCommands = new AdbCommands(driver);
        int androidVersion = adbCommands.getDeviceVersion();

        System.out.println("Device Version: " + androidVersion);
        return androidVersion;
    }

    public void checkAndroidAlertMessageVisibility() {
        System.out.println("Check for Alert Message");
        new WebDriverWaits(driver).checkElementVisible(AndroidAlertMessageTitle, 10);

    }

    public void clickTurnOn() {
        System.out.println("Click Turn On");
        new WebDriverWaits(driver).waitForElementToBeClickable(continueButton, 10);
        driver.findElement(continueButton).click();
    }

    public void clickOkay() {
        System.out.println("Click Okay");
        new WebDriverWaits(driver).waitForElementToBeClickable(continueButton, 10);
        driver.findElement(continueButton).click();
    }

    public void clickYesYes() {
        System.out.println("Click Yes");
        new WebDriverWaits(driver).waitForElementToBeClickable(yesYesButton, 10);
        driver.findElement(yesYesButton).click();

    }

    public void clickNo() {
        System.out.println("Click No");
        new WebDriverWaits(driver).waitForElementToBeClickable(noButton, 10);
        driver.findElement(noButton).click();

    }

    public void clickNoNo() {
        System.out.println("Click No");
        new WebDriverWaits(driver).waitForElementToBeClickable(noNoButton, 10);
        driver.findElement(noNoButton).click();

    }

    public void clickClose() {
        System.out.println("Click Close");
        new WebDriverWaits(driver).waitForElementToBeClickable(continueButton, 10);
        driver.findElement(continueButton).click();

    }

    public void clickCancel() {
        System.out.println("Click Cancel");
        new WebDriverWaits(driver).waitForElementToBeClickable(cancelButton, 10);
        driver.findElement(cancelButton).click();

    }

    public void clickBackPopUp() {
        System.out.println("Click Back on Pop Up");
        new WebDriverWaits(driver).waitForElementToBeClickable(cancelButton, 10);
        driver.findElement(cancelButton).click();

    }

    public void clickContinue() {
        System.out.println("Click Continue");
        new WebDriverWaits(driver).waitForElementToBeClickable(continueButton, 10);
        driver.findElement(continueButton).click();

    }

    public void clickContinueAccessibilityId() {
        System.out.println("Click Continue");
        new WebDriverWaits(driver).waitForElementToBeClickable(continueButtonAccessibilityId, 10);
        driver.findElement(continueButtonAccessibilityId).click();

    }

    public void clickConfirm() {
        System.out.println("Click Confirm");
        new WebDriverWaits(driver).waitForElementToBeClickable(continueButton, 10);
        driver.findElement(continueButton).click();

    }


    public void navigateToBottomOfPageNew(){
        try {
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).flingToEnd(6)");
        }catch (Exception ignore){}
    }

    public void navigateToBottomOfPageNot(){
        try {
            String locator = "UiScrollable(\"className(\"android.widget.ScrollView\")\").flingToEnd(6))";
            driver.findElement(MobileBy.AndroidUIAutomator(locator));

        }catch (Exception ignore){}
    }

    public void waitElementDisplayed(By element, int timeOutInSeconds ) {
        driver.manage().timeouts().pageLoadTimeout(timeOutInSeconds, TimeUnit.SECONDS);

        driver.findElement(element).isDisplayed();

    }

    public void waitByMilliSeconds(long milliSeconds){

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }







}
