package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.HomePage;
import protectscotland.Navigation;
import protectscotland.tracing.PauseTracing;
import protectscotland.tracing.Tracing;
import protectscotland.onboarding.BluetoothPermissionPage_7;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.AndroidCommonMethods;
import qub.vg05.utilities.UIActionHelper;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups= "protectScotland")
public class TracingModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Tracing {

    private static final Logger logger = LoggerFactory.getLogger(TracingModel.class);
    ExcelMapData excelMapData = new ExcelMapData();

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
    public void e_Click_Turn_On_Confirm() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickConfirm();

    }

    @Override
    public void e_Click_Turn_On_Popup() {
        HomePage homePage = new HomePage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        androidCommonMethods.waitByMilliSeconds(3000);
        uiActionHelper.scrollDown();
        homePage.clickTurnOn();

    }

    @Override
    public void v_Verify_In_Tracing_Inactive_Page_SHARED() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        Tracing tracing = new Tracing(driver);
        uiActionHelper.navigateToTopOfPage();
        tracing.checkForTracingPageInfo();
        uiActionHelper.navigateToBottomOfPage();
        tracing.checkInTracingActivePage();
        uiActionHelper.navigateToTopOfPage();

    }

    @Override
    public void v_Verify_In_Tracing_Page_SHARED() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        Tracing tracing = new Tracing(driver);
        uiActionHelper.navigateToTopOfPage();
        tracing.checkForTracingPageInfo();
        uiActionHelper.navigateToBottomOfPage();
        tracing.checkInTracingActivePage();
        uiActionHelper.navigateToTopOfPage();

    }

    @Override
    public void v_Verify_In_Tracing_Paused_Page() {
        PauseTracing pauseTracing = new PauseTracing(driver);
        pauseTracing.checkForRestartTracingButton();

    }

    @Override
    public void e_Click_Turn_On() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        Tracing tracing = new Tracing(driver);
        uiActionHelper.navigateToBottomOfPage();
        tracing.clickTurnOnTracing();


    }

    @Override
    public void e_Click_Cancel() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickCancel();

    }

    @Override
    public void v_Verify_In_Turn_On_Covid_Notifications_Page() {
        BluetoothPermissionPage_7 bluetoothPermissionPage_7 = new BluetoothPermissionPage_7(driver);
        bluetoothPermissionPage_7.checkForTurnONExposureNotificationsPopup();

    }

    @Override
    public void e_Click_Restart_Tracing() {
        PauseTracing pauseTracing = new PauseTracing(driver);
        pauseTracing.clickRestartTracing();
    }

    @Override
    public void v_Verify_In_Pause_Tracing_Page() {
        PauseTracing pauseTracing = new PauseTracing(driver);
        pauseTracing.checkForPauseTracingPageTitle();

    }

    @Override
    public void e_Click_Close() {
        Navigation navigation = new Navigation(driver);
        navigation.clickClose();

    }

    @Override
    public void e_Click_I_Want_To_Pause_Tracing() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        Tracing tracing = new Tracing(driver);
        uiActionHelper.navigateToBottomOfPage();
        tracing.clickPauseTracing();

    }

    @Override
    public void e_Click_Cancel_Paused() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickCancel();
    }

    @Override
    public void v_Exposure_Notifications_Required_Popup() {
        HomePage homePage = new HomePage(driver);
        homePage.checkForExposureNotifications();

    }

    @Override
    public void v_Verify_Chrome_Web_External_Browser_View() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeExternalWebBrowser();
    }

    @Override
    public void e_Click_FAQs() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        Tracing tracing = new Tracing(driver);
        uiActionHelper.scrollToFindElementText("FAQs");
        tracing.clickFAQS();

    }

    @Override
    public void e_Click_Pause_Now() {
        PauseTracing pauseTracing = new PauseTracing(driver);
        pauseTracing.clickPauseTracingNow();

    }

    @Override
    public void e_Click_Close_Notification() {
        HomePage homePage = new HomePage(driver);
        homePage.clickClose();
    }

    @Override
    public void e_Click_Close_Chrome() {
        driver.navigate().back();
    }
}
