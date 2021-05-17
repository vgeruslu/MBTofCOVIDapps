package qub.vg05.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;

import static org.apache.commons.exec.OS.isFamilyWindows;

public class LinuxCommands {

    public void truncateFile(String pathToFile) throws IOException, InterruptedException {
        File fileToTruncate = new File(pathToFile);

        if (fileToTruncate.exists()) {
            executeShellCommand("truncate -s 0 " + pathToFile);
        }
    }

    public void executeShellCommand(String command) throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("/bin/sh", "-c", command);

        System.out.println("\"Execute shell command: " + processBuilder.command());
        Process process = processBuilder.start();

        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
        process.destroy();
    }

    public String executeCommands(String command) throws IOException, InterruptedException {
        Process process;

        if (isFamilyWindows()){
            Runtime rt = Runtime.getRuntime();
            process = rt.exec("cmd /c " + command);
        }
        else{
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("/bin/sh", "-c", command);

            System.out.println("\"Execute shell command: " + processBuilder.command());
            process = processBuilder.start();
        }

        BufferedReader commandOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String out = commandOutput.readLine();

        commandOutput.close();

        int exitCode = process.waitFor();
        assert exitCode == 0;
        process.destroy();
        return out;
    }
}
