package qub.vg05.systemui.tests;

import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.TestExecutor;
import org.graphwalker.websocket.WebSocketServer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.protectscotlandmodels.*;
import qub.vg05.systemui.protectscotlandmodels.AboutThisAppModel;
import qub.vg05.systemui.protectscotlandmodels.HomeModel;
import qub.vg05.utilities.ReadProperties;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

public class GraphWalkerProtectScotlandTest extends TestLogOutputConfiguration {
    int webSocketPortNumber;
    String appDirectory = "protect-scotland";
    String fileName = "ProtectScotlandMBTTestPath_";
    String directoryPath = "results" + slash + appDirectory + slash;
    private static final Logger logger = LoggerFactory.getLogger(GraphWalkerProtectScotlandTest.class);

    @Rule
    public TestWatcher testWatcher = new TestResultJunit();

    @Before
    public void setup() {
        ReadProperties readProperties = new ReadProperties();
        webSocketPortNumber = Integer.parseInt(readProperties.getProp("webSocketServerPort"));
        appName = "Protect Scotland";

        logger.info("_________________________________________________________________________" + "\r\n");
        logger.info("------------------------SCENARIO-------------------------");

        TestMap = new ConcurrentHashMap<>();
        ModelDurationMap = new ConcurrentHashMap<>();
        stepCount = 0;
        testResult = "";
        excelLocation = userDir + slash + directoryPath  + fileName + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm")) + ".xlsx";
        excelActive = false;

        try{
            File file = new File(excelLocation);
            if(file.exists()){
                file.delete();
                logger.info("Excel file is deleted");
            }else
                logger.info("Excel file is not found");
        }catch (Exception e){
            logger.info("Excel file is not deleted.");
        }

    }

    @Test
    public void protectScotlandAppAll() throws IOException {

        Executor executor = new TestExecutor(ShareAndProtectModel.class,
                HomeModel.class,
                HomeTourModel.class,
                qub.vg05.systemui.protectscotlandmodels.OnboardingModel.class,
                qub.vg05.systemui.protectscotlandmodels.SettingsModel.class,
                AgeConfirmationModel.class,
                LocationConfirmationModel.class,
                AboutThisAppModel.class,
                AddTestCodeModel.class,
                qub.vg05.systemui.protectscotlandmodels.EnterTestCodeModel.class,
                TracingModel.class
        );
        WebSocketServer server = new WebSocketServer(webSocketPortNumber, executor.getMachine());
        server.start();

        setExcel(executor);
        result = executor.execute(true);
        errorControl();

    }

    @Test
    public void protectScotlandAppPermissions() throws IOException {
        Executor executor = new TestExecutor(
                AgeConfirmationModel.class,
                LocationConfirmationModel.class
        );
        WebSocketServer server = new WebSocketServer(webSocketPortNumber, executor.getMachine());
        server.start();

        setExcel(executor);
        result = executor.execute(true);
        errorControl();

    }

    @Test
    public void protectScotlandOnboarding() throws IOException {
        Executor executor = new TestExecutor(
                AgeConfirmationModel.class,
                LocationConfirmationModel.class,
                OnboardingModel.class

        );
        WebSocketServer server = new WebSocketServer(webSocketPortNumber, executor.getMachine());
        server.start();

        setExcel(executor);
        result = executor.execute(true);
        errorControl();

    }
}
