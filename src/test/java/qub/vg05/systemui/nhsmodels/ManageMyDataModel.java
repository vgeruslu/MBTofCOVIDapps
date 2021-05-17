package qub.vg05.systemui.nhsmodels;

import nhs.about.EditPostcodePage;
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
import qub.vg05.utilities.AndroidCommonMethods;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups= "nhs")
public class ManageMyDataModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Manage_My_Data {

    private static final Logger logger = LoggerFactory.getLogger(ManageMyDataModel.class);
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
    public void e_Click_Edit_Button() {
        ManageMyDataPage manageMyDataPage = new ManageMyDataPage(driver);
        manageMyDataPage.clickEditButton();

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
    public void v_Verify_Delete_All_Data_Warning_Message() {
        ManageMyDataPage manageMyDataPage = new ManageMyDataPage(driver);
        manageMyDataPage.checkForDeleteAllDatConfirmationMessage();

    }

    @Override
    public void e_Click_Delete_All_My_Data() {
        ManageMyDataPage manageMyDataPage = new ManageMyDataPage(driver);
        manageMyDataPage.clickDeleteAllMyDataButton();

    }

    @Override
    public void e_Click_Cancel() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        androidCommonMethods.clickCancel();

    }

    @Override
    public void v_Verify_In_Edit_Postcode_Page_SHARED() {
        EditPostcodePage editPostcodePage = new EditPostcodePage(driver);
        editPostcodePage.checkForEditPostcodeView();

    }

}
