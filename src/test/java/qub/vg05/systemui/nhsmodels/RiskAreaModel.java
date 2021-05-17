package qub.vg05.systemui.nhsmodels;

import nhs.Navigation;
import nhs.RiskArea;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.UIActionHelper;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups= "nhs")
public class RiskAreaModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Risk_Area {

    private static final Logger logger = LoggerFactory.getLogger(RiskAreaModel.class);
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
    public void v_Verify_In_Risk_Area_Page_SHARED() {
        RiskArea riskArea = new RiskArea(driver);
        riskArea.checkRiskLevelAreaPage();


    }

    @Override
    public void e_Click_Read_Latest_Advice() {
        RiskArea riskArea = new RiskArea(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        riskArea.clickReadLatestAdviceButton();

    }

    @Override
    public void v_Verify_Chrome_Web_View() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeWebBrowser();

    }

    @Override
    public void e_Click_Close_Chrome() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseWebButton();


    }

}
