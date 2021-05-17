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
import qub.vg05.systemui.nhsmodels.*;
import qub.vg05.systemui.nhsmodels.EnterTestCodeModel;
import qub.vg05.systemui.nhsmodels.OnboardingModel;
import qub.vg05.systemui.nhsmodels.SettingsModel;
import qub.vg05.utilities.ReadProperties;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

public class GraphWalkerNHSCovid19Test extends TestLogOutputConfiguration {
    int webSocketPortNumber;
    String app = "nhs";
    String fileName = "NHSMBTTestPath_";
    String directoryPath = "results" + slash + app + slash;
    private static final Logger logger = LoggerFactory.getLogger(GraphWalkerNHSCovid19Test.class);

    @Rule
    public TestWatcher testWatcher = new TestResultJunit();

    @Before
    public void setup() {
        ReadProperties readProperties = new ReadProperties();
        webSocketPortNumber = Integer.parseInt(readProperties.getProp("webSocketServerPort"));
        appName = "NHS Covid-19";

        logger.info("_________________________________________________________________________" + "\r\n");
        logger.info("------------------------SCENARIO-------------------------");

        TestMap = new ConcurrentHashMap<>();
        ModelDurationMap = new ConcurrentHashMap<>();
        stepCount = 0;
        testResult = "";
        excelLocation = userDir + slash + directoryPath + fileName + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm")) + ".xlsx";
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
    public void nhsAppAll() throws IOException {

        Executor executor = new TestExecutor(OnboardingModel.class,
                EnterTestCodeModel.class,
                SelectSymptomsModel.class,
                ManageMyDataModel.class,
                SettingsModel.class,
                qub.vg05.systemui.nhsmodels.AboutThisAppModel.class,
                qub.vg05.systemui.nhsmodels.HomeModel.class,
                RiskAreaModel.class,
                EditPostCodeModel.class,
                VenueCheckInModel.class,
                ReviewSymptomsModel.class,
                BookTestModel.class
        );
        WebSocketServer server = new WebSocketServer(webSocketPortNumber, executor.getMachine());
        server.start();

        setExcel(executor);
        result = executor.execute(true);
        errorControl();

    }

    @Test
    public void nhsAppOnboarding() throws IOException {

        Executor executor = new TestExecutor(
                OnboardingModel.class
        );
        WebSocketServer server = new WebSocketServer(webSocketPortNumber, executor.getMachine());
        server.start();

        setExcel(executor);
        result = executor.execute(true);
        errorControl();

    }

}
