package Implementations.Layouts;

import Enums.ReportLevel;
import Interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String dateTime, ReportLevel reportLevel, String message) {
        return String.format("<log>\n\t<date>%s</date>\n\t<level>%s</level>\n\t<message>%s</message>\n</log>",
                dateTime, reportLevel, message);
    }
}
