package qub.vg05.systemui.nhsmodels;

import nhs.Navigation;
import nhs.Settings;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.AndroidCommonMethods;
import qub.vg05.utilities.UIActionHelper;

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage100, groups= "nhs")
public class SettingsModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Settings {

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
    public void v_Verify_In_Language_Page() {
        Settings settings = new Settings(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        settings.checkInLanguagePage();
        uiActionHelper.navigateToTopOfPage();

    }

    @Override
    public void e_Click_Language() {
        Settings settings = new Settings(driver);
        settings.clickLanguageOption();


    }

    @Override
    public void v_Verify_In_Settings_Page_SHARED() {
        Settings settings = new Settings(driver);
        settings.checkInSettingsPage();

    }

    @Override
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        navigation.clickBackArrow();

    }

    @Override
    public void e_Click_Arabic() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Arabic");
        Settings settings = new Settings(driver);
        settings.clickArabicLanguageOption();

    }

    @Override
    public void e_Click_Punjabi() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Punjabi");
        Settings settings = new Settings(driver);
        settings.clickPunjabiLanguageOption();

    }

    @Override
    public void e_Click_Romanian() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Romanian");
        Settings settings = new Settings(driver);
        settings.clickRomanianLanguageOption();

    }

    @Override
    public void e_Click_Welsh() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Welsh");
        Settings settings = new Settings(driver);
        settings.clickWelshLanguageOption();

    }

    @Override
    public void e_Click_System_Level_Language() {
        Settings settings = new Settings(driver);
        settings.clickSystemLanguageOption();

    }

    @Override
    public void e_Click_Gujarati() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Gujarati");
        Settings settings = new Settings(driver);
        settings.clickGujaratiLanguageOption();

    }

    @Override
    public void e_Click_Somali() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Somali");
        Settings settings = new Settings(driver);
        settings.clickSomaliLanguageOption();

    }

    @Override
    public void e_Click_Chinese() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Chinese");
        Settings settings = new Settings(driver);
        settings.clickChineseLanguageOption();

    }

    @Override
    public void e_Click_Polish() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Polish");
        Settings settings = new Settings(driver);
        settings.clickPolishLanguageOption();

    }

    @Override
    public void e_Click_Urdu() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Urdu");
        Settings settings = new Settings(driver);
        settings.clickUrduLanguageOption();

    }

    @Override
    public void e_Click_Cancel() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickCancel();

    }

    @Override
    public void e_Click_Turkish() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Turkish");
        Settings settings = new Settings(driver);
        settings.clickTurkishLanguageOption();

    }

    @Override
    public void e_Click_Bengali() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Bengali");
        Settings settings = new Settings(driver);
        settings.clickBengaliLanguageOption();

    }

    @Override
    public void v_Verify_In_Change_Language_Popup() {
        Settings settings = new Settings(driver);
        settings.checkForChangeLanguagePopup();


    }
}
