package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.HomePage;
import protectscotland.Navigation;
import protectscotland.SettingsPage;
import protectscotland.hometour.AboutThisAbout;
import protectscotland.hometour.AddCode;
import protectscotland.hometour.ShareAndProtect;
import protectscotland.hometour.TracingActive;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.AndroidCommonMethods;

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage100, groups= "protectScotland")
public class HomeTourModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Home_Tour {

    private static final Logger logger = LoggerFactory.getLogger(HomeTourModel.class);
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
    public void e_Click_Next() {
        Navigation navigation = new Navigation(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        navigation.clickNext();

    }

    @Override
    public void v_Verify_In_Home_Tour_Inactive_Page_SHARED() {
        TracingActive tracingActive = new TracingActive(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        tracingActive.checkHomeTourStartTracingNotActive();
    }

    @Override
    public void e_No_Action_Inactive() {
        // no action
    }


    @Override
    public void e_Click_Ellipsis() {
        Navigation navigation = new Navigation(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        navigation.clickSettings();
    }

    @Override
    public void e_No_Action_Active() {
        // no action
    }


    @Override
    public void e_Click_Close() {
        Navigation navigation = new Navigation(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        navigation.clickClose();
    }

    @Override
    public void v_Verify_In_Settings_Home_Tour_Page_SHARED() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.checkSettingPageVisibility();


    }

    @Override
    public void v_Verify_In_Home_Page_SHARED() {
        HomePage homePage = new HomePage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        homePage.checkInHomePage();

    }


    @Override
    public void v_Verify_In_Home_Page_Inactive_SHARED() {
        HomePage homePage = new HomePage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        homePage.checkForExposureNotifications();


    }


    @Override
    public void v_Verify_In_Home_Tour_Page() {
        TracingActive tracingActive = new TracingActive(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        tracingActive.checkHomeTourStepOnePageVisibility();

    }

    @Override
    public void e_Go_To_Active_Home() {
        // no action
    }

    @Override
    public void v_Verify_In_Add_Code_Page() {
        AddCode addCode = new AddCode(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        addCode.checkHomeTourStepFourPageVisibility();

    }

    @Override
    public void v_Verify_In_Share_Protect_Page() {
        ShareAndProtect shareAndProtect = new ShareAndProtect(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        shareAndProtect.checkHomeTourStepTwoPageVisibility();

    }

    @Override
    public void e_Go_To_Inactive_Home() {
        // no action
    }

    @Override
    public void v_Verify_In_About_App_Page() {
        AboutThisAbout aboutThisAbout = new AboutThisAbout(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        aboutThisAbout.checkHomeTourStepThreePageVisibility();

    }

    @Override
    public void v_Verify_In_Home_Tour_Active_Page_SHARED() {
        TracingActive tracingActive = new TracingActive(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        tracingActive.checkHomeTourStartTracingActive();

    }

    @Override
    public void v_Verify_In_Home_Page() {



    }


}
