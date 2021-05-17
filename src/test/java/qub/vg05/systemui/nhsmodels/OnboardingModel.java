package qub.vg05.systemui.nhsmodels;

import nhs.HomePage;
import nhs.Navigation;
import nhs.onboarding.*;
import org.graphwalker.java.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.adb.AdbCommands;
import qub.vg05.appium.AppiumServer;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.tests.TestLogOutputConfiguration;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.AndroidCommonMethods;
import qub.vg05.utilities.ReadProperties;
import qub.vg05.utilities.UIActionHelper;

import java.io.IOException;

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage60,start = "v_Start_NHS", groups= "nhs")
public class OnboardingModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Onboarding {

    String appPackage;
    String appLaunchActivity;
    AppiumServer appiumServer = new AppiumServer();
    ReadProperties readProperties = new ReadProperties();
    private static final Logger logger = LoggerFactory.getLogger(OnboardingModel.class);
    ExcelMapData excelMapData = new ExcelMapData();

    public OnboardingModel(){
    }

    @BeforeExecution
    public void setup() throws IOException, InterruptedException {

        appiumServer.startServer();
        appPackage = readProperties.getProp("nhsAppPackage");
        appLaunchActivity = readProperties.getProp("nhsAppActivity");

        initiateDriver("systemPort", appPackage, appLaunchActivity, true);
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
    public void v_Verify_Age_Check_Popup() {
        WelcomePage_1 welcomePage1 = new WelcomePage_1(driver);
        welcomePage1.checkAgeAlert();

    }

    @Override
    public void e_Click_Continue() {
        WelcomePage_1 welcomePage1 = new WelcomePage_1(driver);
        welcomePage1.clickContinue();

    }

    @Override
    public void e_Go_Onboarding() {

    }

    @Override
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        navigation.clickBackArrow();

    }

    @Override
    public void e_Click_I_Am_Over_16() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickConfirm();


    }

    @Override
    public void v_Verify_In_Privacy_Notice_Page() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        PrivacyNoticePage_2 privacyNoticePage_2 = new PrivacyNoticePage_2(driver);
        uiActionHelper.navigateToTopOfPage();
        privacyNoticePage_2.privacyProtectionPage();
        uiActionHelper.navigateToTopOfPage();

    }

    @Override
    public void v_Verify_In_Get_Notified_Page() {
        WelcomePage_1 welcomePage1 = new WelcomePage_1(driver);
        welcomePage1.checkIconNotification();

    }

    @Override
    public void e_Click_Privacy_Notice_Link() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        PrivacyNoticePage_2 privacyNoticePage_2 = new PrivacyNoticePage_2(driver);
        privacyNoticePage_2.clickPrivacyNoticeLink();

    }

    @Override
    public void e_Click_Close_Chrome() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseWebButton();

    }

    @Override
    public void v_Verify_Chrome_Web_View() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeWebBrowser();

    }

    @Override
    public void e_Click_Terms_Of_Use_Link() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        PrivacyNoticePage_2 privacyNoticePage_2 = new PrivacyNoticePage_2(driver);
        privacyNoticePage_2.clickTermsOfUseLink();

    }

    @Override
    public void e_Click_Enable_Exposure_Notifications() {
        ContactTracingPermissionsPage_5 contactTracingPermissionsPage_5 = new ContactTracingPermissionsPage_5(driver);
        contactTracingPermissionsPage_5.clickEnableExposureNotifications();

    }

    @Override
    public void v_In_Home_Page_SHARED() {
        HomePage homePage = new HomePage(driver);
        homePage.checkInHomePage();

    }

    @Override
    public void e_Click_Continue_Permissions() {
        ContactTracingPermissionsPage_5 contactTracingPermissionsPage_5 = new ContactTracingPermissionsPage_5(driver);
        contactTracingPermissionsPage_5.clickConfirmButtonPermissions();

    }

    @Override
    public void v_Verify_Enable_Exposure_Notifications_Page() {
        ContactTracingPermissionsPage_5 contactTracingPermissionsPage_5 = new ContactTracingPermissionsPage_5(driver);
        contactTracingPermissionsPage_5.checkEdgeCaseContainer();

    }

    @Override
    public void e_Click_Confirm() {
        LocalAuthorityPage_4 localAuthorityPage_4 = new LocalAuthorityPage_4(driver);
        localAuthorityPage_4.clickConfirmButton();

    }

    @Override
    public void e_Click_Turn_On() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickTurnOn();


    }

    @Override
    public void e_Click_Cancel() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickCancel();


    }

    @Override
    public void v_Verify_In_Turn_On_Covid_Notifications_Page() {
        ContactTracingPermissionsPage_5 contactTracingPermissionsPage_5 = new ContactTracingPermissionsPage_5(driver);
        contactTracingPermissionsPage_5.checkTurnOnExposurePopupContainer();

    }

    @Override
    public void v_Verify_In_Permissions_Page() {
        ContactTracingPermissionsPage_5 contactTracingPermissionsPage_5 = new ContactTracingPermissionsPage_5(driver);
        contactTracingPermissionsPage_5.checkPermissionsContainer();

    }

    @Override
    public void v_Start_NHS() {

    }

    @Override
    public void e_Click_No_Thanks() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        uiActionHelper.navigateToBottomOfPage();
        androidCommonMethods.waitByMilliSeconds(500);
        PrivacyNoticePage_2 privacyNoticePage_2 = new PrivacyNoticePage_2(driver);
        privacyNoticePage_2.clickNoThanks();

    }

    @Override
    public void v_Verify_In_Your_Local_Authority_Page() {
        LocalAuthorityPage_4 localAuthorityPage_4 = new LocalAuthorityPage_4(driver);
        localAuthorityPage_4.checkLocalAuthorityContainer();



    }

    @Override
    public void e_Click_I_Agree() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        uiActionHelper.navigateToBottomOfPage();
        androidCommonMethods.waitByMilliSeconds(500);
        PrivacyNoticePage_2 privacyNoticePage_2 = new PrivacyNoticePage_2(driver);
        privacyNoticePage_2.clickIAgree();

    }

    @Override
    public void v_Verify_Invalid_Postcode() {
        PostcodePage_3 postcodePage_3 = new PostcodePage_3(driver);
        postcodePage_3.checkPostcodeErrorMessage();

    }

    @Override
    public void v_Verify_In_Enter_Postcode_Page() {
        PostcodePage_3 postcodePage_3 = new PostcodePage_3(driver);
        postcodePage_3.checkPostcodeContainer();

    }

    @Override
    public void e_Invalid_Postcode_District_Code() {
        PostcodePage_3 postcodePage_3 = new PostcodePage_3(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        postcodePage_3.enterInvalidPostcode();
        postcodePage_3.clickContinuePostcode();


    }

    @Override
    public void e_Valid_Postcode() {
        PostcodePage_3 postcodePage_3 = new PostcodePage_3(driver);

        postcodePage_3.enterValidPostcode();
        postcodePage_3.clickContinuePostcode();

    }

}
