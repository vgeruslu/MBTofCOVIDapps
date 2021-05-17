package nhs.symptoms;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qub.vg05.webdriver.WebDriverWaits;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class ReviewSymptomsPage {
    AndroidDriver<WebElement> driver;

    public ReviewSymptomsPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    private final By reviewSymptomsScrollView = MobileBy.id("uk.nhs.covid19.production:id/scrollViewReviewSymptoms");
    private final By changeFeverButton = MobileBy.AccessibilityId("Change symptom A high temperature (fever)");
    private final By changeCoughButton = MobileBy.AccessibilityId("Change symptom A new continuous cough");
    private final By changeTasteButton = MobileBy.AccessibilityId("Change symptom A change to your sense of smell or taste");

    private final By noDateCheckbox = MobileBy.id("uk.nhs.covid19.production:id/checkboxNoDate");
    private final By submitSymptomsButton = MobileBy.id("uk.nhs.covid19.production:id/buttonConfirmSymptoms");
    private final By selfIsolateRemainder = MobileBy.id("uk.nhs.covid19.production:id/daysToIsolateContainer");
    private final By reviewSymptomsErrorContainer = MobileBy.id("uk.nhs.covid19.production:id/reviewSymptomsErrorContainer");

    // calendar
    private final By selectDateContainer = MobileBy.id("uk.nhs.covid19.production:id/selectDateContainer");
    private final By clickCancelButton = MobileBy.id("uk.nhs.covid19.production:id/cancel_button");
    private final By clickOkButton = MobileBy.id("uk.nhs.covid19.production:id/confirm_button");
    private final By calendarMainPane = MobileBy.id("uk.nhs.covid19.production:id/mtrl_calendar_main_pane");
    private final By calendarTextInputPane = MobileBy.id("uk.nhs.covid19.production:id/mtrl_calendar_text_input_frame");
    private final By calenderErrorMessage = MobileBy.id("uk.nhs.covid19.production:id/textinput_error");
    private final By editDateButton = MobileBy.id("uk.nhs.covid19.production:id/mtrl_picker_header_toggle");
    private final By editText = MobileBy.className("android.widget.EditText");

    private final By bookAFreeTest = MobileBy.id("uk.nhs.covid19.production:id/stateActionButton");

    public void checkInSelectSymptomsPage() {
        System.out.println("Check In Review Symptoms Page");
        new WebDriverWaits(driver).checkElementVisible(reviewSymptomsScrollView, 10);
    }

    public void checkIDontRememberDate() {
        System.out.println("Check I dont remember date");
        new WebDriverWaits(driver).checkElementVisible(noDateCheckbox, 10);
    }

    public void checkForSelfIsolateRemainder() {
        System.out.println("Check for self isolate remainder container");
        new WebDriverWaits(driver).checkElementVisible(selfIsolateRemainder, 10);
    }

    public void checkForErrorMessageNoDateSelected() {
        System.out.println("Check for Error container");
        new WebDriverWaits(driver).checkElementVisible(reviewSymptomsErrorContainer, 10);
    }

    public void checkInCalendarView() {
        System.out.println("Check In calendar view");
        new WebDriverWaits(driver).checkElementVisible(calendarMainPane, 10);
    }

    public void checkInCalendarTextInputView() {
        System.out.println("Check In calendar text input view");
        new WebDriverWaits(driver).checkElementVisible(calendarTextInputPane, 10);
    }

    public void checkForErrorMessageForInvalidDate() {
        System.out.println("Check for error message for invalid date");
        new WebDriverWaits(driver).checkElementVisible(calenderErrorMessage, 10);
    }

    public void clickChangeFeverAnswerButton() {
        System.out.println("Click change fever answer");
        new WebDriverWaits(driver).waitForElementToBeClickable(changeFeverButton, 10);
        driver.findElement(changeFeverButton).click();
    }

    public void clickChangeCoughAnswerButton() {
        System.out.println("Click change cough answer");
        new WebDriverWaits(driver).waitForElementToBeClickable(changeCoughButton, 10);
        driver.findElement(changeCoughButton).click();
    }

    public void clickChangeTasteAnswerButton() {
        System.out.println("Click change taste answer");
        new WebDriverWaits(driver).waitForElementToBeClickable(changeTasteButton, 10);
        driver.findElement(changeTasteButton).click();
    }

    public void clickNoDateCheckbox() {
        System.out.println("Click no date checkbox");
        new WebDriverWaits(driver).waitForElementToBeClickable(noDateCheckbox, 10);
        driver.findElement(noDateCheckbox).click();
    }

    public void clickSelectDate() {
        System.out.println("Click select date");
        new WebDriverWaits(driver).waitForElementToBeClickable(selectDateContainer, 10);
        driver.findElement(selectDateContainer).click();
    }

    public void clickCancelButton() {
        System.out.println("Click cancel Button");
        new WebDriverWaits(driver).waitForElementToBeClickable(clickCancelButton, 10);
        driver.findElement(clickCancelButton).click();
    }

    public void clickOkButton() {
        System.out.println("Click Ok Button");
        new WebDriverWaits(driver).waitForElementToBeClickable(clickOkButton, 10);
        driver.findElement(clickOkButton).click();
    }

    public void clickEditDateIcon() {
        System.out.println("Click edit date Icon");
        new WebDriverWaits(driver).waitForElementToBeClickable(editDateButton, 10);
        driver.findElement(editDateButton).click();
    }

    public void enterOutOfRangeDate() {
        System.out.println("Enter Out of range date");
        new WebDriverWaits(driver).waitForElementToBeClickable(editText, 10);
        driver.findElement(editText).click();
        String tenDaysPreviously = LocalDate.now().minusDays(10).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        driver.findElement(editText).sendKeys(tenDaysPreviously);
    }

    public void enterInvalidDateFormat() {
        System.out.println("Enter Invalid Date format");
        new WebDriverWaits(driver).waitForElementToBeClickable(editText, 10);
        driver.findElement(editText).click();
        String invalidFormatDate = LocalDate.now().toString();
        driver.findElement(editText).sendKeys(invalidFormatDate);
    }

    public void enterValidDate() {
        System.out.println("Enter Valid Date");
        new WebDriverWaits(driver).waitForElementToBeClickable(editText, 10);
        driver.findElement(editText).click();
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        driver.findElement(editText).sendKeys(currentDate);
    }

    public void clearTextBox() {
        System.out.println("Enter Invalid Test code");
        new WebDriverWaits(driver).waitForElementToBeClickable(editText, 10);
        driver.findElement(editText).clear();
    }

    public void clickSubmitSymptomsButton() {
        System.out.println("Click submit symptoms button");
        new WebDriverWaits(driver).waitForElementToBeClickable(submitSymptomsButton, 10);
        driver.findElement(submitSymptomsButton).click();
    }

    public void clickBookAFreeTestButton() {
        System.out.println("Click book free test button");
        new WebDriverWaits(driver).waitForElementToBeClickable(bookAFreeTest, 10);
        driver.findElement(bookAFreeTest).click();
    }



}
