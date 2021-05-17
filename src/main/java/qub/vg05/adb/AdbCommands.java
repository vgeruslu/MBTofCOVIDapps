package qub.vg05.adb;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AdbCommands {

    AndroidDriver<WebElement> driver;

    public AdbCommands(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    public void clearAppCache(String appPackage, Boolean clearAppCache) {
        if (clearAppCache) {
            String[] args = {"clear", appPackage};
            adbExecuteCommand("pm", args, "Clearing App cache");
        }
        else{
            System.out.println(appPackage + " App Cache has not been cleared");
        }
    }

    public String adbExecuteCommand(String command, String[] key, String eventName) {

        List<String> commandArgs = Arrays.asList(key);

        Map<String, Object> shellCommand = ImmutableMap.of(
                "command", command,
                "args", commandArgs
        );

        System.out.println(eventName);
        String commandOutput = (String) driver.executeScript("mobile: shell", shellCommand);
        return commandOutput.trim();
    }

    public int getDeviceVersion() {
        String[] args = {"ro.build.version.release"};

        String[] versionNumber = adbExecuteCommand("getprop", args, "Get Device Version").split("\\.");

        return Integer.parseInt(versionNumber[0].trim());//adbExecuteCommand("getprop", args, "Get Device Version");
    }

    public String getAppVersion(String appPackage) {
        String[] args = {"package", appPackage, "|", "grep", "versionName", "|", "head", "-n1"};

        String appVersion = adbExecuteCommand("dumpsys", args, "Get App Version");

        return appVersion.substring(appVersion.indexOf("=") + 1);
    }

    public String getDeviceManufacturer() {
        String[] args = {"ro.product.manufacturer"};

        return adbExecuteCommand("getprop", args, "Get Device Manufacturer");
    }

    public String getDeviceModel() {
        String[] args = {"ro.product.model"};

        return adbExecuteCommand("getprop", args, "Get Device Model");
    }
}
