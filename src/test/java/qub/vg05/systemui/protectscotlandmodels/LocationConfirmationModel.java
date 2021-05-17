package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.LocationConfirmation;
import protectscotland.Navigation;
import protectscotland.onboarding.HelpOthersPage_1;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage100, groups= "protectScotland")
public class LocationConfirmationModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Location_Confirmation {

    private static final Logger logger = LoggerFactory.getLogger(LocationConfirmationModel.class);
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
    public void v_Verify_In_Location_Page_SHARED() {
        LocationConfirmation locationConfirmation = new LocationConfirmation(driver);
        locationConfirmation.checkLocationPageVisibility();

    }

    @Override
    public void e_Click_No() {
        LocationConfirmation locationConfirmation = new LocationConfirmation(driver);
        locationConfirmation.clickNo();

    }

    @Override
    public void v_Verify_In_Helping_Others_Page_SHARED() {
        HelpOthersPage_1 helpOthersPage_1 = new HelpOthersPage_1(driver);
        helpOthersPage_1.checkInHelpOtherPage();

    }

    @Override
    public void e_Click_Yes() {
        LocationConfirmation locationConfirmation = new LocationConfirmation(driver);
        locationConfirmation.clickYes();

    }

    @Override
    public void v_Invalid_Location_Warning_Message() {
        LocationConfirmation locationConfirmation = new LocationConfirmation(driver);
        locationConfirmation.checkForInvalidLocationPopup();

    }

    @Override
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        navigation.clickBackArrow();

    }

    @Override
    public void e_Click_Ok() {
        LocationConfirmation locationConfirmation = new LocationConfirmation(driver);
        locationConfirmation.clickOkToWarningMessage();

    }
}
