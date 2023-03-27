package Implementations.Logger;

import Enums.ReportLevel;
import Interfaces.Appender;
import Interfaces.Logger;
import java.util.Arrays;

public class MessageLogger implements Logger {

    private final Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        this.logMessage(dateTime, ReportLevel.FATAL, message);
    }


    private void logMessage(String dateTime, ReportLevel reportLevel, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(dateTime, reportLevel, message));
    }

    @Override
    public String toString() {
        StringBuilder logInfo = new StringBuilder("Logger info");
        logInfo.append(System.lineSeparator());

        for (Appender appender : this.appenders) {
            logInfo.append(appender).append(System.lineSeparator());
        }
        return logInfo.toString();
    }
}
