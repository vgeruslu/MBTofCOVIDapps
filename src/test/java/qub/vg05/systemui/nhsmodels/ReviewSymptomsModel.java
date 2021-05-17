package qub.vg05.systemui.nhsmodels;

import nhs.BookTestPage;
import nhs.Navigation;
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
import qub.vg05.utilities.UIActionHelper;

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage60, groups= "nhs")
public class ReviewSymptomsModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Review_Symptoms {

    private static final Logger logger = LoggerFactory.getLogger(ReviewSymptomsModel.class);
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
    public void e_Click_Change_Cough() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.clickChangeCoughAnswerButton();

    }

    @Override
    public void e_Enter_Out_Of_Range_Date() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.enterOutOfRangeDate();

    }

    @Override
    public void e_Click_Change_Fever() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.clickChangeFeverAnswerButton();

    }

    @Override
    public void v_Verify_In_Review_Symptoms_Page_SHARED() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.checkInSelectSymptomsPage();

    }

    @Override
    public void e_Enter_Invalid_Format_Date() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.enterInvalidDateFormat();

    }

    @Override
    public void v_Verify_Text_Input_Error() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.checkForErrorMessageForInvalidDate();

    }

    @Override
    public void e_Click_Change_Taste() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.clickChangeTasteAnswerButton();

    }

    @Override
    public void v_Verify_Error_No_Date_Selected() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.checkForErrorMessageNoDateSelected();

    }

    @Override
    public void e_No_Action() {
        // no action
    }

    @Override
    public void v_Verify_Dont_Remember_Date_Unselected() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.checkIDontRememberDate();
        uiActionHelper.navigateToTopOfPage();

    }

    @Override
    public void e_Clear_Text_Box() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.clearTextBox();
    }

    @Override
    public void e_Click_Edit_Date_Icon() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.clickEditDateIcon();

    }

    @Override
    public void e_Click_Ok() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.clickOkButton();
    }

    @Override
    public void v_Verify_Dont_Remember_Date_Selected() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.checkIDontRememberDate();
        uiActionHelper.navigateToTopOfPage();

    }

    @Override
    public void e_Click_I_Dont_Remember_The_Date_Checkbox() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        uiActionHelper.navigateToBottomOfPage();
        reviewSymptomsPage.clickNoDateCheckbox();

    }

    @Override
    public void e_Click_Cancel() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.clickCancelButton();
    }

    @Override
    public void v_Verify_In_Calendar_Text_Input() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.checkInCalendarTextInputView();

    }

    @Override
    public void e_Click_Select_Date() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        uiActionHelper.navigateToBottomOfPage();
        reviewSymptomsPage.clickSelectDate();


    }

    @Override
    public void v_Verify_Calendar_Popup() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.checkInCalendarView();
    }


    @Override
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        navigation.clickBackArrow();
    }

    @Override
    public void e_Enter_Valid_Date() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.clearTextBox();
        reviewSymptomsPage.enterValidDate();

    }

    @Override
    public void e_Click_Submit_Symptoms() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        uiActionHelper.navigateToBottomOfPage();
        reviewSymptomsPage.clickSubmitSymptomsButton();

    }

    @Override
    public void v_Verify_Valid_Date() {
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        reviewSymptomsPage.checkInCalendarTextInputView();

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
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        ReviewSymptomsPage reviewSymptomsPage = new ReviewSymptomsPage(driver);
        uiActionHelper.navigateToBottomOfPage();
        reviewSymptomsPage.clickBookAFreeTestButton();

    }

    @Override
    public void v_Verify_Book_Free_Test_Page() {
        BookTestPage bookTestPage = new BookTestPage(driver);
        bookTestPage.checkForBookTestPageContainer();

    }

}
