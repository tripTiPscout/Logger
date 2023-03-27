package Implementations.Appenders;

import Enums.ReportLevel;
import Interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if (super.canAppend(reportLevel)) {
            String logMessage = super.layout.format(dateTime, reportLevel, message);
            System.out.println(logMessage);
            super.increaseMessageCount();
        }
    }
}
