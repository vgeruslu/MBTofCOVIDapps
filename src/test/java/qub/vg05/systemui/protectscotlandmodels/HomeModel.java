package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.*;
import protectscotland.testcode.AddTestCode;
import protectscotland.tracing.Tracing;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.AndroidCommonMethods;
import qub.vg05.utilities.UIActionHelper;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups= "protectScotland")
public class HomeModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Home {

    private static final Logger logger = LoggerFactory.getLogger(HomeModel.class);
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
    public void e_Click_Close() {
        Navigation navigation = new Navigation(driver);
        navigation.clickClose();


    }


    @Override
    public void v_Verify_In_Home_Page_Inactive_SHARED() {
        HomePage homePage = new HomePage(driver);
        homePage.checkForExposureNotifications();

    }

    @Override
    public void e_Click_Turn_On() {
        HomePage homePage = new HomePage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        androidCommonMethods.waitByMilliSeconds(3000);
        uiActionHelper.scrollDown();
        homePage.clickTurnOn();

    }

    @Override
    public void e_Click_About_This_App() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAboutThisApp();

    }

    @Override
    public void v_Verify_In_Turn_On_Covid_Notifications_Page() {
        HomePage homePage = new HomePage(driver);
        homePage.checkForTurnONExposureNotificationsPopup();
    }

    @Override
    public void e_Click_Close_Notification() {
        HomePage homePage = new HomePage(driver);
        homePage.clickClose();

    }

    @Override
    public void v_Verify_In_Settings_Page_SHARED() {
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.checkSettingPageVisibility();

    }

    @Override
    public void v_Verify_In_About_App_Page_SHARED() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToTopOfPage();
        AboutThisApp aboutThisApp = new AboutThisApp(driver);
        aboutThisApp.checkABoutThisAppPageVisibility();

    }

    @Override
    public void v_Verify_In_Share_And_Protect_Page_SHARED() {
        ShareAndProtect shareAndProtect = new ShareAndProtect(driver);
        shareAndProtect.checkInShareAndProtectPageVisibility();

    }

    @Override
    public void e_Click_Ellipsis() {
        Navigation navigation = new Navigation(driver);
        navigation.clickSettings();

    }


    @Override
    public void e_Click_Confirm_Turn_On() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickConfirm();

    }

    @Override
    public void v_Verify_In_Add_Test_Code_Page_SHARED() {
        AddTestCode addTestCode = new AddTestCode(driver);
        addTestCode.checkInAddTestCodePage();

    }

    @Override
    public void e_Click_Share_And_Protect() {
        HomePage homePage = new HomePage(driver);
        homePage.clickShareAndProtect();

    }

    @Override
    public void e_Click_Add_Your_Test_Result_Code() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAddTestCode();

    }

    @Override
    public void e_Scroll_To_Close() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        uiActionHelper.navigateToTopOfPage();
    }

    @Override
    public void e_No_Action_Pop_Finished() {
        // no action
    }

    @Override
    public void e_Click_Not_Feeling_Well() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        HomePage homePage = new HomePage(driver);
        uiActionHelper.navigateToBottomOfPage();
        homePage.clickNotFeelingWellLink();


    }

    @Override
    public void e_Click_Close_Chrome() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseWebButton();


    }

    @Override
    public void e_Click_Cancel() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickCancel();

    }

    @Override
    public void v_Verify_Chrome_Web_View() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeWebBrowser();
    }

    @Override
    public void e_No_Action() {
        // no action
    }

    @Override
    public void v_Verify_Home_Page() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        HomePage homePage = new HomePage(driver);
        uiActionHelper.navigateToTopOfPage();
        homePage.checkInHomePage();

    }

    @Override
    public void v_Verify_Home_Page_Active_SHARED() {
        HomePage homePage = new HomePage(driver);
        homePage.checkForHomePageTracingActive();

    }

    @Override
    public void e_Click_Restrictions() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        HomePage homePage = new HomePage(driver);
        uiActionHelper.navigateToBottomOfPage();
        homePage.clickRestrictionsLink();

    }

    @Override
    public void v_Verify_In_Tracing_Inactive_Page_SHARED() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        Tracing tracing = new Tracing(driver);
        tracing.checkForTracingPageInfo();
        uiActionHelper.navigateToBottomOfPage();
        tracing.checkInTracingInactivePage();
        uiActionHelper.navigateToTopOfPage();

    }

    @Override
    public void e_Click_Tracing_Active() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTracingActive();

    }

    @Override
    public void e_Click_Tracing_Inactive() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTracingInactive();

    }

    @Override
    public void v_Verify_In_Tracing_Page_SHARED() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        Tracing tracing = new Tracing(driver);
        tracing.checkForTracingPageInfo();
        uiActionHelper.navigateToBottomOfPage();
        tracing.checkInTracingActivePage();
        uiActionHelper.navigateToTopOfPage();

    }

}