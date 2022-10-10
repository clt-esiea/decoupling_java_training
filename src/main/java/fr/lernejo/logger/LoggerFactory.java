package fr.lernejo.logger;

import java.awt.*;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Logger logger = new ContextualLogger(name, new FileLogger("log.txt"));
        return logger;
    }
}
