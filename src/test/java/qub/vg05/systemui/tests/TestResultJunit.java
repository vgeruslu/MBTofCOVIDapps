package qub.vg05.systemui.tests;

import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.systemui.utils.SendMail;
import qub.vg05.utilities.ReadProperties;

public class TestResultJunit extends TestWatcher {

    private static final Logger logger = LoggerFactory.getLogger(TestResultJunit.class);

    protected void starting(Description description) {
        logger.info("=========================================================================");
        String[] classNameArray = description.getClassName().split("\\.");
        TestLogOutputConfiguration.TestClassName = classNameArray[classNameArray.length-1];
        String testCaseName = description.getMethodName();
        logger.info("Starting Test: " + testCaseName);
        TestLogOutputConfiguration.TestCaseName = testCaseName;
        logger.info("If The Test fails, The Faulty Step is the last step");
    }

    protected void succeeded(Description description) {
        logger.info("Test Class: " + TestLogOutputConfiguration.TestClassName
                + " Test Case: " + TestLogOutputConfiguration.TestCaseName);
        logger.info("Test Result: " + "TEST SUCCESSFUL");
    }

    public void failed(Throwable e, Description description) {
        logger.error("Test Class: " + TestLogOutputConfiguration.TestClassName
                + " Test Case: " + TestLogOutputConfiguration.TestCaseName);
        logger.error("Test Result: " + "TEST FAILED");
        logger.error("Error: ", e);

    }

    protected void skipped(AssumptionViolatedException e, Description description) {
        logger.info("Test Class: " + TestLogOutputConfiguration.TestClassName
                + " Test Case: " + TestLogOutputConfiguration.TestCaseName);
        logger.info("Test Result: " + "TEST SKIPPED");
    }

    protected void finished(Description description) {
        if(TestLogOutputConfiguration.excelActive
                && Integer.parseInt(TestLogOutputConfiguration.ModelDurationMap.get("TotalStepCount").toString()) > 1) {
            try {
                new ExcelMapData().createExcel();
            }catch (Exception e){
                logger.info("Excel was not created.");
                e.printStackTrace();
                TestLogOutputConfiguration.excelActive = false;
            }
            if(TestLogOutputConfiguration.excelActive) {
                String toMail = new ReadProperties().getProp("toMail");
                new SendMail().sendMailTestResult(TestLogOutputConfiguration.result, toMail, TestLogOutputConfiguration.excelLocation);
            }else {
                logger.info("Excel was not created so Mail was not sent.");
            }
        }
        logger.info("=========================================================================");

    }

}
