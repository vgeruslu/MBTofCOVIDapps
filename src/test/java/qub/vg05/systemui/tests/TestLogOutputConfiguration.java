package qub.vg05.systemui.tests;

import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.utils.ExcelMapData;
import qub.vg05.systemui.utils.FindOS;
import java.util.concurrent.ConcurrentHashMap;



public class TestLogOutputConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(TestLogOutputConfiguration.class);
    public static Result result;
    public static String testResult = "";
    public static ConcurrentHashMap<String,Object> TestMap;
    public static ConcurrentHashMap<String,Object> ModelDurationMap;
    public static Integer stepCount;
    public static String excelLocation;
    public static String osName = FindOS.getOperationSystemName();
    public static String slash = FindOS.getOperationSystemName().equals("WINDOWS") ? "\\": "/";
    public static String TestClassName = "";
    public static String TestCaseName = "";
    public static String deviceName;
    public static String appName;
    public static int androidVersion;
    public static String appVersion;
    public static boolean excelActive = false;
    public static String userDir = System.getProperty("user.dir");


    public void setExcel(Executor executor){

        excelActive = true;
        new ExcelMapData().createMapData(executor.getMachine());
    }

    public void errorControl(){

        ExcelMapData excelMapData = new ExcelMapData();

        if (result.hasErrors()) {

            excelMapData.setTestResult("Failed");
            logger.error("Done: [" + "\r\n" + "  \"totalFailedNumberOfModels\"" + result.getResults().toString(2).split("\"totalFailedNumberOfModels\"")[1] + "]");
            Assert.fail(result.getErrors().toString());
        }

        excelMapData.setTestResult("Successful");
        logger.info("Done: [" + result.getResults().toString(2) + "]");
    }



}
