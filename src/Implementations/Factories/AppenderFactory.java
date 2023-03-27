package Implementations.Factories;

import Enums.ReportLevel;
import Implementations.Appenders.ConsoleAppender;
import Implementations.Appenders.FileAppender;
import Interfaces.Appender;
import Interfaces.Factory;
import Interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {

    private final LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }

    @Override
    public Appender produce(String inputData) {
        String[] tokens = inputData.split("\\s+");
        String appenderType = tokens[0];
        String layoutType = tokens[1];

        Layout layout = this.layoutFactory.produce(layoutType);
        Appender appender;
        switch (appenderType) {
            case "ConsoleAppender" -> appender = new ConsoleAppender(layout);
            case "FileAppender" -> appender =  new FileAppender(layout);
            default -> throw new IllegalStateException("Invalid type of appender for " + appenderType + " param.");
        }
        if (tokens.length > 2) {
            appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }
        return appender;
    }
}
