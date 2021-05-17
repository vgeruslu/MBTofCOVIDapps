package qub.vg05.systemui.nhsmodels;

import nhs.HomePage;
import nhs.Navigation;
import nhs.VenueCheckIn;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;

@GraphWalker(value = CoverageValue.WeightedRandomEdgeCoverage60, groups= "nhs")
public class VenueCheckInModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Venue_Check_IN {

    private static final Logger logger = LoggerFactory.getLogger(VenueCheckInModel.class);
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
    public void e_Click_Allow() {
        VenueCheckIn venueCheckIn = new VenueCheckIn(driver);
        venueCheckIn.clickAllowCameraPermissionButton();

    }

    @Override
    public void v_In_Home_Page_SHARED() {
        HomePage homePage = new HomePage(driver);
        homePage.checkInHomePage();

    }

    @Override
    public void v_Verify_In_Venue_Check_In_Page_SHARED() {

    }

    @Override
    public void e_Click_Close() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseX();


    }

    @Override
    public void e_No_Action() {

    }

    @Override
    public void e_Click_More_Info() {
        VenueCheckIn venueCheckIn = new VenueCheckIn(driver);
        venueCheckIn.clickMoreInfo();

    }

    @Override
    public void v_Verify_In_Scanner_View() {
        VenueCheckIn venueCheckIn = new VenueCheckIn(driver);
        venueCheckIn.checkForQRScannerView();

    }

    @Override
    public void e_Click_Back_Arrow() {
        Navigation navigation = new Navigation(driver);
        navigation.clickBackArrow();

    }

    @Override
    public void v_Verify_In_Please_Allow_Permission_Page() {
        VenueCheckIn venueCheckIn = new VenueCheckIn(driver);
        venueCheckIn.checkInPleaseAllowCameraPermissionsPage();

    }

    @Override
    public void v_Verify_Camera_Permission_Message() {
        VenueCheckIn venueCheckIn = new VenueCheckIn(driver);
        venueCheckIn.checkForCameraPermissionMessage();

    }

    @Override
    public void e_No_Action_Bypass_Permissions() {

    }

    @Override
    public void e_Click_Deny() {
        VenueCheckIn venueCheckIn = new VenueCheckIn(driver);
        venueCheckIn.clickDenyCameraPermissionButton();

    }

    @Override
    public void v_Verify_In_More_Info_Page() {
        VenueCheckIn venueCheckIn = new VenueCheckIn(driver);
        venueCheckIn.checkInQRMoreInfoPage();


    }
}
