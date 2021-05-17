package qub.vg05.utilities;

import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class UIActionHelper  {

    AndroidDriver<WebElement> driver;

    public UIActionHelper(AndroidDriver<WebElement> driver){
        this.driver = driver;
    }

    private final By scrollToBottom = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." +
            "scrollable(true).instance(0)).flingToEnd(6);");
    private final By scrollToTop = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." +
            "scrollable(true).instance(0)).flingToBeginning(6);");

    private final By scrollToTopOneFling = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." +
            "scrollable(true).instance(0)).flingToBeginning(1);");

    public void tapCenter(){
        int height = driver.manage().window().getSize().getHeight() / 2;
        int width = driver.manage().window().getSize().getWidth() / 2;
        new TouchAction((PerformsTouchActions) driver).tap(PointOption.point(width, height)).perform();
    }

    public void scrollDown(){
        int scrollStart = (int) (driver.manage().window().getSize().getHeight() * 0.7);
        int scrollEnd = (int) (driver.manage().window().getSize().getHeight() * 0.1);

        int x = (int) (driver.manage().window().getSize().getWidth() / 2.2);

        new TouchAction((AndroidDriver)driver).press(PointOption.point(x, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1300)))
                .moveTo(PointOption.point(x, scrollEnd)).release().perform();
    }


    public void navigateToBottomOfPage(){
        try {
            driver.findElement(scrollToBottom);
        }catch (Exception ignore){}
    }

    public void navigateToTopOfPage(){
        try {
            driver.findElement(scrollToTop);
        }catch (Exception ignore){}
    }

    public void navigateToTopOfPageOneFling(){
        try {
            driver.findElement(scrollToTopOneFling);
        }catch (Exception ignore){}
    }

    public boolean isScrollable(By element) {
        try {
            new WebDriverWaits(driver).waitForElementToBeClickable(element, 5);
            return Boolean.parseBoolean(driver.findElement(element).getAttribute("SCROllABLE"));
        }catch (Exception ignore){
            return false;
        }

    }


    public void scrollToFindElementText(String text){
        By locator = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
        driver.findElement(locator);
    }

    public void scrollToFindElementBySelector(String selector){
        By locator = MobileBy.AndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(resourceId(\"" + selector +"\"))");
        driver.findElement(locator);
    }

    public By findElementText(String text){
        return MobileBy.AndroidUIAutomator("new UiSelector().textContains(\""+text+"\").instance(0)");
    }

    public By findElementTextExact(String text){
        return MobileBy.AndroidUIAutomator("new UiSelector().text(\""+text+"\").instance(0)");
    }




}
