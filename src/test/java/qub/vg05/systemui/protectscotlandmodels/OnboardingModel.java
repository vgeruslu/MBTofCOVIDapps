package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.Navigation;
import protectscotland.hometour.TracingActive;
import protectscotland.onboarding.*;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.AndroidCommonMethods;
import qub.vg05.utilities.UIActionHelper;


@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage100, groups= "protectScotland")
public class OnboardingModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Onboarding {

    private static final Logger logger = LoggerFactory.getLogger(OnboardingModel.class);
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
    public void v_Verify_In_Be_First_To_Know_Page() {
        BeFirstToKnowPage_2 beFirstToKnowPage_2 = new BeFirstToKnowPage_2(driver);
        beFirstToKnowPage_2.checkBeFirstToKnowPage();

    }

    @Override
    public void e_Click_Next() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        Navigation navigation = new Navigation(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        uiActionHelper.navigateToBottomOfPage();
        androidCommonMethods.waitByMilliSeconds(500);
        navigation.clickNext();

    }

    @Override
    public void v_Verify_In_Home_Tour_Inactive_Page_SHARED() {
        TracingActive tracingActive = new TracingActive(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        tracingActive.checkHomeTourStepOnePageVisibility();

    }

    /*@Override
    public void v_Verify_Turn_On_Automated_Processing_Message() {

    }*/

    @Override
    public void v_verify_In_How_Do_I_Add_Result_Page() {
        GettingATestResultPage_3 gettingATestResultPage_3 = new GettingATestResultPage_3(driver);
        gettingATestResultPage_3.checkForForPositiveTestResultImage();

    }

    @Override
    public void e_Click_Yes() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        ConsentAutomatedProcessingPage_5 consentAutomatedProcessingPage_5 = new ConsentAutomatedProcessingPage_5(driver);

        uiActionHelper.navigateToBottomOfPage();
        androidCommonMethods.waitByMilliSeconds(500);
        consentAutomatedProcessingPage_5.clickYes();

    }

    @Override
    public void e_Click_What_Is_Close_Contact()  {
        // TODO check if element is updated
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        uiActionHelper.navigateToBottomOfPage();
        androidCommonMethods.waitByMilliSeconds(500);
        driver.findElementByXPath("//android.widget.TextView[@text='What is close contact?']").click();

    }

    @Override
    public void e_Click_Add_My_Result() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        GettingATestResultPage_3 gettingATestResultPage_3 = new GettingATestResultPage_3(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        uiActionHelper.navigateToBottomOfPage();
        androidCommonMethods.waitByMilliSeconds(500);
        gettingATestResultPage_3.clickHowToAddMyTestResult();

    }

    @Override
    public void v_Verify_In_T_C_Page() {
        T_CPage_6 t_cPage_6 = new T_CPage_6(driver);
        t_cPage_6.checkIfInTCPage();

    }

    @Override
    public void e_Click_Next_Long()  {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        Navigation navigation = new Navigation(driver);

        androidCommonMethods.waitByMilliSeconds(500);
        uiActionHelper.scrollDown();
        uiActionHelper.scrollDown();
        androidCommonMethods.waitByMilliSeconds(500);
        navigation.clickNext();

    }

    @Override
    public void v_Verify_In_Permission_Page() {
        BluetoothPermissionPage_7 bluetoothPermissionPage_7 = new BluetoothPermissionPage_7(driver);
        bluetoothPermissionPage_7.checkIfInBluetoothPermissionsPage();

    }

    @Override
    public void e_Click_Back_Arrow() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        Navigation navigation = new Navigation(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        navigation.clickBackArrow();

    }

    @Override
    public void v_Verify_Privacy_Page() {
        PrivacyInfoPage_4 privacyInfoPage_4 = new PrivacyInfoPage_4(driver);
        privacyInfoPage_4.checkIfInPrivacyInfoPage();

    }

   /* @Override
    public void v_Verify_T_C_Warning_Message() {

    }*/

    @Override
    public void e_Click_Close() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        Navigation navigation = new Navigation(driver);
        navigation.clickClose();

    }

    @Override
    public void v_Verify_Close_Contact_Page() {
        BeFirstToKnowPage_2 beFirstToKnowPage_2 = new BeFirstToKnowPage_2(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
       // uiActionHelper.navigateToBottomOfPage();
        beFirstToKnowPage_2.checkForCloseContactText();

    }

   /* @Override
    public void e_Click_Close() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickClose();

    }*/

    @Override
    public void v_Verify_In_Automated_Processing_Page() {
        ConsentAutomatedProcessingPage_5 consentAutomatedProcessingPage_5 = new ConsentAutomatedProcessingPage_5(driver);
        consentAutomatedProcessingPage_5.checkIfInAutomatedProcessingPage();

    }

    @Override
    public void e_Click_Turn_On() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickConfirm();

    }

    /*@Override
    public void e_Click_No_New() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        OnboardingPages onboardingPages = new OnboardingPages(driver);

        uiActionHelper.navigateToBottomOfPage();
        androidCommonMethods.waitByMilliSeconds(1000);
        onboardingPages.clickNo();


    }*/

    @Override
    public void v_Verify_In_Helping_Others_Page_SHARED() {
        HelpOthersPage_1 helpOthersPage_1 = new HelpOthersPage_1(driver);
        helpOthersPage_1.checkInHelpOtherPage();

    }

    @Override
    public void e_Click_Cancel() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        androidCommonMethods.clickCancel();

    }

    @Override
    public void v_Test_In_Result_Page() {
        GettingATestResultPage_3 gettingATestResultPage_3 = new GettingATestResultPage_3(driver);
        gettingATestResultPage_3.checkIfInGettingATestResultPage();

    }

    @Override
    public void v_Verify_In_Home_Tour_Active_Page_SHARED() {
        TracingActive tracingActive = new TracingActive(driver);
        tracingActive.checkHomeTourStepOnePageVisibility();

    }

    @Override
    public void v_Verify_In_Turn_On_Covid_Notifications_Page() {
        BluetoothPermissionPage_7 bluetoothPermissionPage_7 = new BluetoothPermissionPage_7(driver);
        bluetoothPermissionPage_7.checkForTurnONExposureNotificationsPopup();

    }


}
