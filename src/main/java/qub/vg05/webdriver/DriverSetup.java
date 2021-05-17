package qub.vg05.webdriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qub.vg05.utilities.ReadProperties;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    ReadProperties readProperties = new ReadProperties();
    String appiumServerIpAddress = readProperties.getProp("appiumServerIP");
    String appiumServerPort = readProperties.getProp("appiumServerPort");

    public AndroidDriver<WebElement> getAndroidDriver(String deviceName, String udid, String systemPort, String appPackage,
                                      String appLaunchActivity, Boolean noReset) throws MalformedURLException {

        Capabilities capabilities = new Capabilities();

        String url = "http://" +  appiumServerIpAddress + ":"
                + appiumServerPort + "/wd/hub";

        return new AndroidDriver<WebElement>(new URL(url),
                capabilities.androidCapabilities(deviceName, udid, systemPort, appPackage, appLaunchActivity, noReset));
    }

}
