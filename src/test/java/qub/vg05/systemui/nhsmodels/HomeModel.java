package qub.vg05.systemui.nhsmodels;

import nhs.BookTestPage;
import nhs.about.AboutThisAppPage;
import nhs.EnterTestResult;
import nhs.HomePage;
import nhs.Navigation;
import nhs.onboarding.ContactTracingPermissionsPage_5;
import nhs.symptoms.ReviewSymptomsPage;
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

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage100, groups= "nhs")
public class HomeModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Home {

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
    public void v_In_Home_Page_SHARED() {
        HomePage homePage = new HomePage(driver);
        homePage.checkInHomePage();

    }

    @Override
    public void v_Verify_In_Enter_Test_Code_Page_SHARED() {
        EnterTestResult enterTestResult = new EnterTestResult(driver);
        enterTestResult.checkTestResultPageView();

    }

    @Override
    public void e_Click_Enter_Test_Code() {
        HomePage homePage = new HomePage(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        homePage.clickEnterTestResult();

    }

    @Override
    public void e_Click_Venue_Check_In() {
        HomePage homePage = new HomePage(driver);
        homePage.clickVenueCheckIn();

    }

    @Override
    public void v_Verify_In_Venue_Check_In_Page_SHARED() {

    }

    @Override
    public void v_Verify_In_Risk_Area_Page_SHARED() {
        nhs.RiskArea riskArea = new nhs.RiskArea(driver);
        riskArea.checkRiskLevelAreaPage();

    }

    @Override
    public void e_Click_Local_Area_Button() {
        HomePage homePage = new HomePage(driver);
        homePage.clickRiskArea();

    }

    @Override
    public void e_Click_Close_Chrome() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseWebButton();

    }

    @Override
    public void v_Verify_In_Chrome_Gov_UK() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeWebBrowser();

    }

    @Override
    public void e_Click_Read_Latest_Advice() {
        HomePage homePage = new HomePage(driver);
        homePage.clickReadAdvice();

    }

    @Override
    public void e_Click_Outside_Message() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTouchOutside();

    }

    @Override
    public void v_Verify_In_Select_Symptoms_Page_SHARED() {
        SelectSymptomsPage selectSymptomsPage = new SelectSymptomsPage(driver);
        selectSymptomsPage.checkInSelectSymptomsPage();

    }

    @Override
    public void e_Click_Dont_Remind_Me() {
        HomePage homePage = new HomePage(driver);
        homePage.clickDontRemindMe();

    }

    @Override
    public void e_Click_8_Hours() {
        HomePage homePage = new HomePage(driver);
        homePage.click8Hours();

    }

    @Override
    public void e_Click_12_Hours() {
        HomePage homePage = new HomePage(driver);
        homePage.click12Hours();

    }

    @Override
    public void e_Click_Ok() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickOkay();


    }

    @Override
    public void e_Click_Contact_Tracing_Turn_OFF() {
        HomePage homePage = new HomePage(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        homePage.clickContactTracingToggle();

    }

    @Override
    public void v_Verify_In_Turn_On_Tracing_Reminder() {
        HomePage homePage = new HomePage(driver);
        homePage.checkForExposureNotificationReminder();

    }

    @Override
    public void e_Click_Check_Symptoms() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCheckSymptoms();

    }

    @Override
    public void e_Click_Contact_Tracing_Turn_On() {
        HomePage homePage = new HomePage(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        homePage.clickContactTracingToggle();

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
    public void e_Click_4_Hours() {
        HomePage homePage = new HomePage(driver);
        homePage.click4Hours();

    }

    @Override
    public void v_Verify_In_Turn_On_Covid_Notifications_Page() {
        ContactTracingPermissionsPage_5 contactTracingPermissionsPage_5 = new ContactTracingPermissionsPage_5(driver);
        contactTracingPermissionsPage_5.checkTurnOnExposurePopupContainer();

    }

    @Override
    public void v_Verify_In_Turn_On_Tracing_Reminder_Confirmation() {
        HomePage homePage = new HomePage(driver);
        homePage.checkForExposureNotificationReminderConfirmationMessage();

    }

    @Override
    public void v_Verify_In_Self_Isolate_Notification_Page_SHARED() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        uiActionHelper.navigateToTopOfPage();
        reviewSymptomsPage.checkForSelfIsolateRemainder();
    }

    @Override
    public void e_Click_Book_Free_Test() {
        HomePage homePage = new HomePage(driver);
        homePage.clickBookFreeTest();
    }

    @Override
    public void v_Verify_In_Book_Test_Page_SHARED() {
        BookTestPage bookTestPage = new BookTestPage(driver);
        bookTestPage.checkForBookTestPageContainer();

    }

    @Override
    public void e_Click_Book_Test_For_Yourself() {
        BookTestPage bookTestPage = new BookTestPage(driver);
        bookTestPage.clickBookTestForYourselfLink();
    }

    @Override
    public void e_Click_Settings() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        HomePage homePage = new HomePage(driver);
        uiActionHelper.navigateToBottomOfPage();
        homePage.clickSettings();

    }

    @Override
    public void v_Verify_In_Settings_Page_SHARED() {
        nhs.Settings settings = new nhs.Settings(driver);
        settings.checkInSettingsPage();

    }

    @Override
    public void v_Verify_In_About_This_App_Page_SHARED() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToTopOfPage();
        AboutThisAppPage aboutThisAppPage = new AboutThisAppPage(driver);
        aboutThisAppPage.checkForHowAppWorksView();


    }

    @Override
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        navigation.clickBackArrow();

    }

    @Override
    public void e_Click_Close() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseX();

    }

    @Override
    public void e_Click_About_This_app() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        HomePage homePage = new HomePage(driver);
        uiActionHelper.navigateToBottomOfPage();
        homePage.clickAboutThisApp();

    }
}
