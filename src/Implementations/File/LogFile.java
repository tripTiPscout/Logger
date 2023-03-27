package Implementations.File;

import Interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {

    private static final String DEFAULT_FILE_NAME = "default.txt";

    private final String fileName;
    private final StringBuilder logMessage;
    private int size;

    public LogFile() {
        this(DEFAULT_FILE_NAME);
    }

    public LogFile(String fileName) {
        this.fileName = fileName;
        this.logMessage = new StringBuilder();
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.calculateSize();
    }

    private int calculateSize() {
        for (char current : this.logMessage.toString().toCharArray()) {
            if (Character.isAlphabetic(current)) {
                this.size += current;
            }
        }
        return this.size;
    }

    @Override
    public void write(String message) {
        try {
            Files.write(Paths.get(this.fileName), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void append(String message) {
        message += System.lineSeparator();
        this.logMessage.append(message);
        this.write(message);
    }
}
