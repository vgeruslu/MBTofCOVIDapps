package qub.vg05.systemui.nhsmodels;

import nhs.BookTestPage;
import nhs.Navigation;
import org.graphwalker.java.annotation.AfterElement;
import org.graphwalker.java.annotation.BeforeElement;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.AndroidBaseTestClass;
import qub.vg05.systemui.utils.CoverageValue;
import qub.vg05.systemui.utils.ExcelMapData;

@GraphWalker(value = CoverageValue.RandomEdgeCoverage100, groups= "nhs")
public class BookTestModel extends AndroidBaseTestClass implements qub.vg05.nhs.NHS_Book_Test {

    private static final Logger logger = LoggerFactory.getLogger(BookTestModel.class);
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
    public void e_Click_Book_Test_For_Someone_Else() {
        BookTestPage bookTestPage = new BookTestPage(driver);
        bookTestPage.clickBookTestForSomeoneElseLink();

    }

    @Override
    public void e_Click_App_Privacy_Notice() {
        BookTestPage bookTestPage = new BookTestPage(driver);
        bookTestPage.clickAppPrivacyNoticeLink();

    }

    @Override
    public void e_Click_Close_Chrome() {
        Navigation navigation = new Navigation(driver);
        navigation.clickCloseWebButton();

    }

    @Override
    public void v_Verify_In_Book_Test_Page_SHARED() {
        BookTestPage bookTestPage = new BookTestPage(driver);
        bookTestPage.checkForBookTestPageContainer();

    }

    @Override
    public void v_Verify_Chrome_Web_View() {
        Navigation navigation = new Navigation(driver);
        navigation.checkInChromeWebBrowser();

    }

    @Override
    public void e_Click_Testing_Privacy_Notice() {
        BookTestPage bookTestPage = new BookTestPage(driver);
        bookTestPage.clickTestPrivacyNoticeLink();

    }
}
