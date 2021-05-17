package qub.vg05.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {
    private static AppiumDriverLocalService service;

    public AppiumServiceBuilder appServiceBuilder(){
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withArgument(GeneralServerFlag.RELAXED_SECURITY);
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        return appiumServiceBuilder;
    }


    public void startServer(){

        service = AppiumDriverLocalService.buildService(appServiceBuilder());
        service.start();
    }

    public void stopServer(){
        System.out.println("Stop Appium Server");
        service.stop();
    }
}
