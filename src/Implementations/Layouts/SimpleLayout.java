package Implementations.Layouts;

import Enums.ReportLevel;
import Interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String dateTime, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", dateTime, reportLevel.toString(), message);
    }
}
