package Engine;

import java.util.Scanner;

public class InputParser {

    public String readLoggerInfo(Scanner scanner) {
        int appendersCount = Integer.parseInt(scanner.nextLine());
        StringBuilder appendersInfo = new StringBuilder();
        while (appendersCount-- > 0) {
            appendersInfo.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return appendersInfo.toString();
    }
}
