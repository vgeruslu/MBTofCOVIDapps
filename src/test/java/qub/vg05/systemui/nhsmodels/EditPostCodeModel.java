package qub.vg05.systemui.nhsmodels;

import nhs.Navigation;
import nhs.about.EditPostcodePage;
import nhs.about.ManageMyDataPage;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups= "nhs")
public class EditPostCodeModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Edit_Postcode {

    private static final Logger logger = LoggerFactory.getLogger(EditPostCodeModel.class);
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
    public void v_Verify_In_Your_Local_Authority_Page() {
        EditPostcodePage editPostcodePage = new EditPostcodePage(driver);
        editPostcodePage.checkForLocalAuthorityContainer();
    }

    @Override
    public void e_Click_Continue() {
        EditPostcodePage editPostcodePage = new EditPostcodePage(driver);
        editPostcodePage.clickConfirmLinkButton();

    }

    @Override
    public void v_Verify_Invalid_Postcode() {
        EditPostcodePage editPostcodePage = new EditPostcodePage(driver);
        editPostcodePage.checkForInvalidPostcodeTitle();
        editPostcodePage.checkForInvalidPostcodeContainer();

    }

    @Override
    public void e_Invalid_Postcode_District_Code() {
        EditPostcodePage editPostcodePage = new EditPostcodePage(driver);
        editPostcodePage.enterInvalidPostcode();
        editPostcodePage.clickContinuePostcode();


    }

    @Override
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        navigation.clickBackArrow();

    }

    @Override
    public void v_Verify_In_Edit_Postcode_Page_SHARED() {
        EditPostcodePage editPostcodePage = new EditPostcodePage(driver);
        editPostcodePage.checkForEditPostcodeView();

    }

    @Override
    public void e_Valid_Postcode() {
        EditPostcodePage editPostcodePage = new EditPostcodePage(driver);
        editPostcodePage.enterValidPostcode();
        editPostcodePage.clickContinuePostcode();


    }

    @Override
    public void v_Verify_In_Manage_My_Data_Page_SHARED() {
        ManageMyDataPage manageMyDataPage = new ManageMyDataPage(driver);
        manageMyDataPage.checkForLocalAuthorityTitle();

    }
}
