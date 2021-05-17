package qub.vg05.systemui.nhsmodels;

import nhs.about.AboutThisAppPage;
import nhs.about.ManageMyDataPage;
import nhs.Navigation;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.UIActionHelper;

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage100, groups= "nhs")
public class AboutThisAppModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_About_This_App {

    private static final Logger logger = LoggerFactory.getLogger(AboutThisAppModel.class);
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
    public void v_Verify_In_About_This_App_Page_SHARED() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToTopOfPage();
        AboutThisAppPage aboutThisAppPage = new AboutThisAppPage(driver);
        aboutThisAppPage.checkForHowAppWorksView();

    }

    @Override
    public void e_Click_Manage_My_Data() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AboutThisAppPage aboutThisAppPage = new AboutThisAppPage(driver);
        uiActionHelper.scrollToFindElementText("Manage my data");
        aboutThisAppPage.clickManageDataButton();

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
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        navigation.clickBackArrow();


    }

    @Override
    public void v_Verify_In_Manage_My_Data_Page_SHARED() {
        ManageMyDataPage manageMyDataPage = new ManageMyDataPage(driver);
        manageMyDataPage.checkForLocalAuthorityTitle();

    }

    @Override
    public void e_Click_How_App_Works() {
        AboutThisAppPage aboutThisAppPage = new AboutThisAppPage(driver);
        aboutThisAppPage.clickHowAppWorksLink();

    }

    @Override
    public void e_Click_Terms_Of_Use() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AboutThisAppPage aboutThisAppPage = new AboutThisAppPage(driver);
        uiActionHelper.scrollToFindElementBySelector("uk.nhs.covid19.production:id/linkTermsOfUse");
        aboutThisAppPage.clickTermsOfUseLink();

    }

    @Override
    public void e_Click_Privacy_Notice() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AboutThisAppPage aboutThisAppPage = new AboutThisAppPage(driver);
        uiActionHelper.scrollToFindElementBySelector("uk.nhs.covid19.production:id/linkPrivacyNotice");
        aboutThisAppPage.clickPrivacyNoticeLink();

    }

    @Override
    public void e_Click_Accessibility_Statement() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AboutThisAppPage aboutThisAppPage = new AboutThisAppPage(driver);
        uiActionHelper.scrollToFindElementBySelector("uk.nhs.covid19.production:id/linkAccessibilityStatement");
        aboutThisAppPage.clickAccessibilityStatementLink();

    }

    @Override
    public void e_Click_Common_Questions() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AboutThisAppPage aboutThisAppPage = new AboutThisAppPage(driver);
        uiActionHelper.scrollToFindElementBySelector("uk.nhs.covid19.production:id/linkCommonQuestions");
        aboutThisAppPage.clickCommonQuestionsLink();

    }

    @Override
    public void e_Click_Feedback_Information() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AboutThisAppPage aboutThisAppPage = new AboutThisAppPage(driver);
        uiActionHelper.navigateToBottomOfPage();
        aboutThisAppPage.clickFeedbackInformationLink();

    }
}
