package Implementations.Factories;

import Implementations.Logger.MessageLogger;
import Interfaces.Appender;
import Interfaces.Factory;
import Interfaces.Logger;

public class LoggerFactory implements Factory<Logger> {

    AppenderFactory appenderFactory;

    public LoggerFactory() {
        this.appenderFactory = new AppenderFactory();
    }

    @Override
    public Logger produce(String inputData) {
        String[] tokens = inputData.split(System.lineSeparator());
        Appender[] appenders = new Appender[tokens.length];

        for (int i = 0; i < appenders.length; i++) {
            appenders[i] = this.appenderFactory.produce(tokens[i]);
        }
        return new MessageLogger(appenders);
    }
}
