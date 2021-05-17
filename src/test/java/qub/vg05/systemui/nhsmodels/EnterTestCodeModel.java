package qub.vg05.systemui.nhsmodels;

import nhs.EnterTestResult;
import nhs.HomePage;
import nhs.Navigation;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.ExcelMapData;

@GraphWalker(value = "random(edge_coverage(100))",groups= "nhs" )
public class EnterTestCodeModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Enter_Test_Code {

    private static final Logger logger = LoggerFactory.getLogger(EnterTestCodeModel.class);
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
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        navigation.clickBackArrow();

    }

    @Override
    public void v_Verify_Invalid_Test_Code() {
        EnterTestResult enterTestResult = new EnterTestResult(driver);
        enterTestResult.checkTestCodeErrorMessage();

    }

    @Override
    public void e_Invalid_Test_Code() {
        EnterTestResult enterTestResult = new EnterTestResult(driver);
        enterTestResult.enterInvalidTestCode();
        enterTestResult.clickContinueTestCode();

    }
}
