package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.Navigation;
import protectscotland.ShareAndProtect;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.UIActionHelper;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups= "protectScotland")
public class ShareAndProtectModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.Share_Protect {

    private static final Logger logger = LoggerFactory.getLogger(ShareAndProtectModel.class);
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
    public void e_Click_Close_Chrome() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseWebButton();

    }

    @Override
    public void v_Verify_In_Share_And_Protect_Page_SHARED() {
        ShareAndProtect shareAndProtect = new ShareAndProtect(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToTopOfPage();
        shareAndProtect.checkInShareAndProtectPageVisibility();

    }

    @Override
    public void v_Verify_Chrome_Web_View() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeWebBrowser();

    }

    @Override
    public void e_Click_Restrictions_In_Your_Area() {
        ShareAndProtect shareAndProtect = new ShareAndProtect(driver);
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        shareAndProtect.clickRestrictionsInYourArea();

    }
}

