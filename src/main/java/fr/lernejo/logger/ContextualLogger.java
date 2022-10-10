package fr.lernejo.logger;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class ContextualLogger implements Logger{
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private Logger delegateLogger;
    private String callerClass;
    public ContextualLogger(String name, Logger logger) {
        this.callerClass = name;
        this.delegateLogger = logger;
    }

    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + callerClass + " " + message);
    }
}
