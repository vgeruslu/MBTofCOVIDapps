package qub.vg05.webdriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

    public DesiredCapabilities androidCapabilities(String deviceName, String udid, String systemPort, String appPackage,
                                                   String appActivity, Boolean noReset){

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("newCommandTimeout", 720000);//
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("noReset", noReset);

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);


        if(! systemPort.equalsIgnoreCase("systemPort")){
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Integer.valueOf(systemPort));
        }

        return desiredCapabilities;
    }

}
