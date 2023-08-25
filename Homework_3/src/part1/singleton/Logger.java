package part1.singleton;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List<String> logMessages;

    private Logger() {
        logMessages = new ArrayList<>();
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logMessages.add(message);
        System.out.println("Logged: " + message);
    }

    public void printLog() {
        System.out.println("Log Messages:");
        for (String message : logMessages) {
            System.out.println(message);
        }
    }
}
