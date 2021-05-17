package qub.vg05.systemui.protectscotlandmodels;

import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import protectscotland.AboutThisApp;
import protectscotland.Navigation;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.utilities.UIActionHelper;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups = "protectScotland")
public class AboutThisAppModel extends AndroidBaseTestClass implements qub.vg05.protectscotland.About_This_App {

    private static final Logger logger = LoggerFactory.getLogger(AboutThisAppModel.class);
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
    public void e_Click_Avoid_Scams() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Avoiding scams");
        AboutThisApp aboutThisApp = new AboutThisApp(driver);
        aboutThisApp.clickAvoidingScam();

    }

    @Override
    public void e_Click_Privacy_Notice() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.scrollToFindElementText("Privacy Notice");
        AboutThisApp aboutThisApp = new AboutThisApp(driver);
        aboutThisApp.clickPrivacyNotice();

    }

    @Override
    public void e_Click_Read_More() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToBottomOfPage();
        AboutThisApp aboutThisApp = new AboutThisApp(driver);
        aboutThisApp.clickMoreAppThisApp();

    }

    @Override
    public void e_Click_Close_Chrome() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseWebButton();

    }

    @Override
    public void v_Verify_In_About_App_Page_SHARED() {
        UIActionHelper uiActionHelper = new UIActionHelper(driver);
        uiActionHelper.navigateToTopOfPage();
        AboutThisApp aboutThisApp = new AboutThisApp(driver);
        aboutThisApp.checkABoutThisAppPageVisibility();

    }

    @Override
    public void v_Verify_Chrome_Web_View() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeWebBrowser();

    }

}
