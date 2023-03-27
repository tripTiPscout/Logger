package Interfaces;

import Enums.ReportLevel;

public interface Layout {

    String format(String dateTime, ReportLevel reportLevel, String message);
}
