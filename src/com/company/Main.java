package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String scenarioFilename = args[0];

        Simulator simulator = new Simulator();
        try (BufferedReader br = new BufferedReader(new FileReader(scenarioFilename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArgs = line.split(",");
                String command = lineArgs[0];
                lineArgs = Arrays.copyOfRange(lineArgs, 1, lineArgs.length);
                simulator.runCommand(command, lineArgs);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        simulator.process();
    }
}
