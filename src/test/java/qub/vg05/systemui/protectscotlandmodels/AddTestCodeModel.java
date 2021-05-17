package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.testcode.AddTestCode;
import protectscotland.Navigation;
import protectscotland.testcode.EnterTestCode;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.AndroidCommonMethods;
import qub.vg05.utilities.UIActionHelper;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups= "protectScotland")
public class AddTestCodeModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Add_Test_Code {

    private static final Logger logger = LoggerFactory.getLogger(AddTestCodeModel.class);
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
    public void e_Click_Close() {
        Navigation navigation = new Navigation(driver);
        navigation.clickClose();

    }

    @Override
    public void v_In_Enter_Test_Result_Code_Page_SHARED() {
        EnterTestCode enterTestCode = new EnterTestCode(driver);
        enterTestCode.checkInEnterTestCodePage();

    }

    @Override
    public void e_Click_Close_Chrome() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseWebButton();

    }

    @Override
    public void e_Click_More_Info_About_Positive_Case() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Tell me more");
        AddTestCode addTestCode = new AddTestCode(driver);
        addTestCode.clickTellMeMoreAboutSelfIsolation();

    }

    @Override
    public void v_Verify_Chrome_Web_View() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeWebBrowser();

    }

    @Override
    public void e_Click_Back_Arrow() {
        AndroidCommonMethods androidCommonMethods = new AndroidCommonMethods(driver);
        Navigation navigation = new Navigation(driver);
        androidCommonMethods.waitByMilliSeconds(500);
        navigation.clickBackArrow();

    }

    @Override
    public void v_Verify_In_Add_Test_Code_Page_SHARED() {
        AddTestCode addTestCode = new AddTestCode(driver);
        addTestCode.checkInAddTestCodePage();

    }

    @Override
    public void e_Click_Add_Test_Code() {
        AddTestCode addTestCode = new AddTestCode(driver);
        addTestCode.clickAddATestCode();

    }

    @Override
    public void e_Click_Book_A_Test() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Book a Test");
        AddTestCode addTestCode = new AddTestCode(driver);
        addTestCode.clickBookATestButton();

    }


}
