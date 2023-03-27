package Implementations.Appenders;

import Enums.ReportLevel;
import Implementations.File.LogFile;
import Interfaces.File;
import Interfaces.Layout;

public class FileAppender extends AppenderImpl {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, String fileName) {
        super(layout);
        this.file = new LogFile(fileName);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if (this.canAppend(reportLevel)) {
            String output = this.layout.format(dateTime, reportLevel, message);
            file.append(output);
            increaseMessageCount();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
