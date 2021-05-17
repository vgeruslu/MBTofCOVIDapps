package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.testcode.EnterTestCode;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups= "protectScotland")
public class EnterTestCodeModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Enter_Test_Code {

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
    public void v_In_Enter_Test_Code_Page_SHARED() {
        EnterTestCode enterTestCode = new EnterTestCode(driver);
        enterTestCode.checkInEnterTestCodePage();

    }

    @Override
    public void e_Enter_Invalid_Test_Code() {
        EnterTestCode enterTestCode = new EnterTestCode(driver);
        enterTestCode.enterTestCodeInvalid();


    }

    @Override
    public void e_Clear_Text_Box() {
        EnterTestCode enterTestCode = new EnterTestCode(driver);
        enterTestCode.clearTextBox();

    }

    @Override
    public void v_Invalid_Test_Code_Message() {
        EnterTestCode enterTestCode = new EnterTestCode(driver);
        enterTestCode.checkForInvalidCodeMessage();
    }
}
