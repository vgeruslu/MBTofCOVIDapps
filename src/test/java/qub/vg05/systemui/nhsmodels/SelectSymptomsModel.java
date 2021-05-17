package qub.vg05.systemui.nhsmodels;

import nhs.HomePage;
import nhs.Navigation;
import nhs.symptoms.SelectSymptomsPage;
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

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage60, groups= "nhs")
public class SelectSymptomsModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Select_Symptoms {

    private static final Logger logger = LoggerFactory.getLogger(SelectSymptomsModel.class);
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
    public void v_Verify_In_Select_Symptoms_Page_SHARED() {
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.checkInSelectSymptomsPage();

    }

    @Override
    public void e_Click_I_Dont_Have_Symptoms() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        uiActionHelper.navigateToBottomOfPage();
        selectSymptomsPage.clickIDontHaveSymptoms();

    }

    @Override
    public void e_Click_Cancel() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickCancel();


    }

    @Override
    public void v_Verify_In_Confirm_No_Symptoms_Message() {
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.checkForNoSymptomsMessage();


    }

    @Override
    public void v_Verify_In_Unlikely_To_Have_covid_Page() {
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.checkInUnlikelyToHaveCovidPage();
    }

    @Override
    public void v_In_Home_Page_SHARED() {
        HomePage homePage = new HomePage(driver);
        homePage.checkInHomePage();

    }

    @Override
    public void e_Click_Close_Chrome() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseWebButton();

    }

    @Override
    public void e_Click_Back_To_Home() {
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.clickBackToHome();

    }

    @Override
    public void v_Verify_In_Review_Symptoms_Page_SHARED() {

    }

    @Override
    public void e_Click_NHS_111_Online() {
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.clickNHS11onlineLink();

    }

    @Override
    public void v_Verify_Chrome_Web_View() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeWebBrowser();

    }

    @Override
    public void e_Click_Confirm() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickConfirm();

    }

    @Override
    public void e_Select_Fever_Box() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("A high temperature (fever)");
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.clickFeverCheckBox();

    }

    @Override
    public void e_Click_Continue() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.clickContinue();

    }

    @Override
    public void e_No_Action() {
        // no action
    }

    @Override
    public void v_Check_Box_Unselected() {
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.checkInSelectSymptomsPage();
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToTopOfPage();

    }

    @Override
    public void e_Unselect_Fever_Box() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("A high temperature (fever)");
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.clickFeverCheckBox();

    }

    @Override
    public void v_Check_Box_Selected() {
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.checkInSelectSymptomsPage();
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToTopOfPage();

    }

    @Override
    public void e_Select_Change_Taste() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("A change to your sense of smell or taste");
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.clickTasteCheckbox();

    }

    @Override
    public void e_Select_Cough_Box() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("A new continuous cough");
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.clickCoughCheckBox();

    }

    @Override
    public void e_Unselect_Cough_Box() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("A new continuous cough");
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.clickCoughCheckBox();

    }

    @Override
    public void e_Unselect_Change_Taste() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("A change to your sense of smell or taste");
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.clickTasteCheckbox();

    }

    @Override
    public void v_Verify_Error_Please_Select_An_Option_Message() {
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.checkErrorMessageNoOptionsSelected();
    }

    @Override
    public void e_Click_Close() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseX();
    }
}
