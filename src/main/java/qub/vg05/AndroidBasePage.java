package qub.vg05;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class AndroidBasePage {

    protected static AndroidDriver driver;

    public void setWebDriver(WebDriver driver){
        AndroidBasePage.driver = (AndroidDriver) driver;
    }
}
