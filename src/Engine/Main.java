package Engine;

import Enums.ReportLevel;
import Implementations.Factories.LoggerFactory;
import Interfaces.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        run();

    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);

        InputParser inputParser = new InputParser();

        LoggerFactory loggerFactory = new LoggerFactory();

        String appendrsInfo = inputParser.readLoggerInfo(scanner);

        Logger logger = loggerFactory.produce(appendrsInfo);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\|");
            String level = tokens[0];
            String time = tokens[1];
            String message = tokens[2];

            messageExtractor(logger, level, time, message);

            input = scanner.nextLine();
        }
        System.out.print(logger);
    }

    private static void messageExtractor(Logger logger, String level, String time, String message) {

        ReportLevel reportLevel = ReportLevel.valueOf(level);

        switch (reportLevel) {
            case INFO -> logger.logInfo(time, message);
            case WARNING -> logger.logWarning(time, message);
            case ERROR -> logger.logError(time, message);
            case CRITICAL -> logger.logCritical(time, message);
            case FATAL -> logger.logFatal(time, message);
            default -> throw new IllegalStateException("Unknown enum value for " + reportLevel + ".");
        }
    }

}
