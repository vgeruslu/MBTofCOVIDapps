package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.AgeConfirmation;
import protectscotland.Navigation;
import protectscotland.SettingsPage;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.AndroidCommonMethods;

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage100, groups= "protectScotland")
public class SettingsModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Settings {

    private static final Logger logger = LoggerFactory.getLogger(SettingsModel.class);
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
    public void v_Verify_Settings_Page() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.checkSettingPageVisibility();

    }

    @Override
    public void e_No_Action_Home() {
        // no action
    }


    @Override
    public void e_Click_Data_Privacy_Notice() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.clickDatPrivacy();

    }

    @Override
    public void e_No_Action_Home_Back() {
        // no action
    }



    @Override
    public void e_Click_Leave() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.clickLeave();


    }


    @Override
    public void v_Verify_Data_Privacy_Page() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.checkDataPrivacyPageVisibility();

    }

    @Override
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        navigation.clickBackArrow();

    }

    @Override
    public void e_Click_Confirm() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickConfirm();

    }

    @Override
    public void v_Verify_In_Settings_Home_Tour_Page_SHARED() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.checkSettingPageVisibility();

    }

    @Override
    public void e_Click_Terms_Conditions() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.clickTermsAndConditions();

    }

    @Override
    public void v_Verify_In_Terms_And_Conditions_Page() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.checkTermsAndConditionsPageVisibility();

    }

    @Override
    public void v_Verify_In_Settings_Home_Page_SHARED() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.checkSettingPageVisibility();

    }

    @Override
    public void e_No_Action_Tour_Back() {
        // no action
    }

    @Override
    public void v_Leave_Conformation_Message() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.checkAndroidAlertMessageVisibility();

    }

    @Override
    public void e_No_Action_Tour() {
        // no action

    }

    @Override
    public void v_Verify_In_Age_Page_SHARED() {
        AgeConfirmation ageConfirmation = new AgeConfirmation(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        ageConfirmation.checkUnder12ButtonVisibility();

    }

    @Override
    public void e_Click_Cancel() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickCancel();

    }

    @Override
    public void e_Click_I_Want_To_Leave() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.clickIWantToLeave();

    }

    @Override
    public void v_Verify_In_Leave_Page() {
        SettingsPage settingsPage = new SettingsPage(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        settingsPage.checkLeavePageVisibility();

    }
}
