package qub.vg05.systemui;


import org.openqa.selenium.WebElement;
import qub.vg05.AndroidBasePage;
import qub.vg05.utilities.LinuxCommands;
import qub.vg05.webdriver.DriverSetup;
import io.appium.java_client.android.AndroidDriver;
import org.graphwalker.core.machine.ExecutionContext;

import java.io.IOException;

public class AndroidBaseTestClass extends ExecutionContext {

    protected static AndroidBasePage basePage;
    public static AndroidDriver<WebElement> driver;

    DriverSetup driverSetup = new DriverSetup();

    String udid;

    public void initiateDriver(String systemPort, String appPackage, String appLaunchActivity, Boolean noReset) throws IOException, InterruptedException {

        udid = new LinuxCommands().executeCommands("adb shell getprop ro.serialno");

        driver = driverSetup.getAndroidDriver(udid, udid, systemPort, appPackage, appLaunchActivity, noReset);

        basePage = new AndroidBasePage();
        basePage.setWebDriver(driver);
    }
}
