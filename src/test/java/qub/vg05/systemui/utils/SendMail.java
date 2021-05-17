package qub.vg05.systemui.utils;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.graphwalker.java.test.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qub.vg05.systemui.tests.TestLogOutputConfiguration;
import qub.vg05.utilities.ReadProperties;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class SendMail {

    private static final Logger logger = LoggerFactory.getLogger(SendMail.class);
    ReadProperties readProperties = new ReadProperties();

    String slash;
    String testPlatform;
    String sendMailActive;
    String senderMail;
    String senderPassword;
    String sendMailProjectName;
    String userDir;

    public SendMail(){

        slash = TestLogOutputConfiguration.osName.equals("WINDOWS") ? "\\" : "/";
        testPlatform = "Local";
        sendMailActive = readProperties.getProp("sendMailActive");
        senderMail = readProperties.getProp("senderMail");
        senderPassword = readProperties.getProp("senderPassword");
        sendMailProjectName = "MBT of " + TestLogOutputConfiguration.appName;
        userDir = System.getProperty("user.dir");
    }

    private void sendMail(String toMail, String testResultInfo, String testFailInfo, String testResultTxt, String excelPath) {

        if(!sendMailActive.equals("true") || toMail.equals("") || senderMail.equals("") || senderPassword.equals("")){

            System.out.println(!sendMailActive.equals("true") ? "Send Mail is not activated" : "toMail, SenderMail ve SenderPassword is not blank");
        }else {
            Properties props = new Properties();
            props.put("mail.user", senderMail);
            props.put("mail.password", senderPassword);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderMail, senderPassword);
                }
            });

            try {
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(senderMail));

                InternetAddress[] address = InternetAddress.parse(toMail,true);

                msg.setRecipients(Message.RecipientType.TO, address);
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss XXX").format(new Date());
                msg.setSubject(sendMailProjectName + ": " + timeStamp + "  " + testPlatform);
                MimeMultipart multipart = new MimeMultipart();
                MimeBodyPart bodyPart = new MimeBodyPart();
                String b = "Device : " + TestLogOutputConfiguration.deviceName + "\r\n\r\n"
                        + "Android Version: " + TestLogOutputConfiguration.androidVersion + "\r\n\r\n"
                        + "App Version: " + TestLogOutputConfiguration.appVersion + "\r\n\r\n"
                        + "Class Name: " + TestLogOutputConfiguration.TestClassName + "\r\n\r\n"
                        + "Test Case:  " + TestLogOutputConfiguration.TestCaseName + "\r\n\r\n"
                        + "Test Result:  " + testResultInfo;
                bodyPart.setText(b, "utf-8");
                multipart.addBodyPart(bodyPart);
                if (testResultInfo.equals("Test Failed")) {
                    MimeBodyPart attachPart = new MimeBodyPart();
                    try {
                        attachPart.attachFile(userDir + slash + testFailInfo);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    multipart.addBodyPart(attachPart);
                }

                MimeBodyPart attachPart2 = new MimeBodyPart();

                try {
                    attachPart2.attachFile(userDir + slash + testResultTxt);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                multipart.addBodyPart(attachPart2);

                MimeBodyPart attachPart3 = new MimeBodyPart();

                try {
                    attachPart3.attachFile(excelPath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                multipart.addBodyPart(attachPart3);
                msg.setContent(multipart);
                Transport.send(msg);
                System.out.println("Mail has been sent successfully");
            } catch (MessagingException exception) {
                System.out.println("Unable to send an email");
                exception.printStackTrace();
            }
        }

    }

    public void sendMailTestResult(Result testResult, String mail, String excelPath){

        try {
            String testResultInfo = "Test Successful";
            List<String> list = new ArrayList<>();
            if (testResult.hasErrors()) {
                testResultInfo = "Test Failed";
                BufferedWriter writer3 = createWriter("testFailInfo.txt",false);
                for (int i=0; i < testResult.getErrors().size() ; i++){
                    writer3.append(testResult.getErrors().get(i));
                    writer3.newLine();
                }
                Thread.sleep(1000);
                writer3.close();
            }
            list.add("Done: [" + "\r\n" + "  \"totalFailedNumberOfModels\"" + testResult.getResults()
                    .toString(2).split("\"totalFailedNumberOfModels\"")[1] + "]");

            Thread.sleep(2000);
            BufferedWriter writer2 = createWriter("testResult.txt",false);
            for (String s : list) {
                writer2.append(s);
                writer2.newLine();
            }
            Thread.sleep(1000);
            writer2.close();
            Thread.sleep(2000);
            sendMail(mail,testResultInfo,"testFailInfo.txt","testResult.txt", excelPath);
        }catch (Exception e){
            logger.info("Could not send mail");
        }
    }

    public BufferedWriter createWriter(String dir, boolean appendCondition) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriterWithEncoding(userDir + slash + dir, StandardCharsets.UTF_8, appendCondition));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }

}