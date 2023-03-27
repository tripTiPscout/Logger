package Implementations.Appenders;

import Enums.ReportLevel;
import Interfaces.Appender;
import Interfaces.Layout;

public abstract class AppenderImpl implements Appender {

    private static final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private ReportLevel reportLevel;

    private int messagesCount;

    Layout layout;

    public AppenderImpl(Layout layout) {
        this(layout, DEFAULT_REPORT_LEVEL);
    }

    public AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this.layout = layout;
        this.reportLevel = reportLevel;
        this.messagesCount = 0;
    }

    public boolean canAppend(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public void increaseMessageCount() {
        this.messagesCount++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(),
                this.reportLevel, this.messagesCount);
    }
}
