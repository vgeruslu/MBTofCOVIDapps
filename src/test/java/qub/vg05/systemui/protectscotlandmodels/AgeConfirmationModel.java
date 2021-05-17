package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.AgeConfirmation;
import protectscotland.LocationConfirmation;
import protectscotland.Navigation;
import qub.vg05.adb.AdbCommands;
import qub.vg05.appium.AppiumServer;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.tests.TestLogOutputConfiguration;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.AndroidCommonMethods;
import qub.vg05.utilities.ReadProperties;

import java.io.IOException;

@GraphWalker(value = "weighted_random(edge_coverage(20))",start = "v_Start", groups= "protectScotland")
public class AgeConfirmationModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Age_Confirmation {
    String appPackage;
    String appLaunchActivity;
    AppiumServer appiumServer = new AppiumServer();
    ReadProperties readProperties = new ReadProperties();
    private static final Logger logger = LoggerFactory.getLogger(AgeConfirmationModel.class);
    ExcelMapData excelMapData = new ExcelMapData();


    @BeforeExecution
    public void setup() throws IOException, InterruptedException {

        appiumServer.startServer();
        appPackage = readProperties.getProp("protectScotlandAppPackage");
        appLaunchActivity = readProperties.getProp("protectScotlandAppActivity");
        AndroidBaseTestClass androidBaseTestClass = new AndroidBaseTestClass();

        androidBaseTestClass.initiateDriver("systemPort", appPackage, appLaunchActivity, true);
        new AdbCommands(driver).clearAppCache(appPackage, true);
        TestLogOutputConfiguration.appVersion = new AdbCommands(driver).getAppVersion(appPackage);
        TestLogOutputConfiguration.androidVersion = new AdbCommands(driver).getDeviceVersion();
        TestLogOutputConfiguration.deviceName = new AdbCommands(driver).getDeviceManufacturer() + "| " + new AdbCommands(driver).getDeviceModel();

        driver.activateApp(appPackage);


    }

    @AfterExecution
    public void cleanup() {
        appiumServer.stopServer();
    }
    
    @BeforeElement
    public void beforeElement() {

        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
        excelMapData.setBeforeElementData(getModel(), getCurrentElement());
    }

    @AfterElement
    public void afterElement() {

        logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    @Override
    public void e_Click_Yes() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickYesYes();

    }

    @Override
    public void e_Go_To_Age_Check_Page() {

    }

    @Override
    public void v_Verify_In_Age_Page_SHARED() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        ageConfirmation.checkUnder12ButtonVisibility();
        ageConfirmation.checkAgeConformation();

    }

    @Override
    public void e_Click_Back_Arrow() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        Navigation navigation = new Navigation(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        navigation.clickBackArrow();

    }

    @Override
    public void e_Click_Ok() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        ageConfirmation.clickOkToWarningMessage();
    }

    @Override
    public void v_Start() {

    }

    @Override
    public void e_Click_Over_16() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        ageConfirmation.clickOver16();
    }

    @Override
    public void e_Click_No() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickNoNo();


    }

    @Override
    public void v_Verify_Secondary_School_Warning_Message() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        ageConfirmation.checkForAgeConfirmationPopup();

    }

    @Override
    public void v_Verify_In_Parent_Required_Check_Page() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        ageConfirmation.checkIfInParentRequiredPage();

    }

    @Override
    public void v_Verify_In_Parent_Optional_Check_Page() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        ageConfirmation.checkIfInParentsOptionalPage();

    }

    @Override
    public void v_Verify_In_Location_Page_SHARED() {
        LocationConfirmation locationConfirmation = new LocationConfirmation(driver);
        locationConfirmation.checkLocationPageVisibility();

    }

    @Override
    public void e_Click_Under_12() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        ageConfirmation.clickUnder12();

    }

    @Override
    public void v_Over_16_Age_Confirmation_Message() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        ageConfirmation.checkForAgeConfirmationPopup();

    }

    @Override
    public void v_Verify_Secondary_School_Check() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        ageConfirmation.checkForSecondarySchoolConfirmationContainer();


    }

    @Override
    public void e_Click_To_Confirm_Am_12_15() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickConfirm();

    }

    @Override
    public void e_Click_Am_12_15() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        ageConfirmation.clickAgeBetween12And15();

    }

    @Override
    public void e_Click_Back_Button() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickCancel();

    }

    @Override
    public void e_Click_Confirm_Over_16() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickConfirm();

    }

    @Override
    public void v_12_15_Age_Confirmation_Message() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        ageConfirmation.checkForAgeConfirmationPopup();

    }

    @Override
    public void e_Click_Continue_Button() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickContinueAccessibilityId();

    }


}
