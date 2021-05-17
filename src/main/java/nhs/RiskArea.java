package nhs;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

public class RiskArea {
    AndroidDriver<WebElement> driver;

    public RiskArea(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By riskLevelContainer = MobileBy.id("uk.nhs.covid19.production:id/riskLevelContainer");
    private final By readLatestAdviceButton = MobileBy.id("uk.nhs.covid19.production:id/buttonRiskLevelLink");


    public void checkRiskLevelAreaPage () {
        System.out.println("Check in Risk Level Area Page");
        new WebDriverWaits(driver).checkElementVisible(riskLevelContainer, 10);
    }

    public void clickReadLatestAdviceButton() {
        System.out.println("Click Read Latest Advice Button");
        new WebDriverWaits(driver).waitForElementToBeClickable(readLatestAdviceButton, 10);
        driver.findElement(readLatestAdviceButton).click();
    }

}
