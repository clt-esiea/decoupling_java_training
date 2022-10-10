package fr.lernejo.logger;

import java.awt.*;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Logger logger = new ContextualLogger(name, new FileLogger("log.txt"));
        Logger compositeLogger = new CompositeLogger(logger, new ConsoleLogger());
        Logger filteredLogger = new FilteredLogger(new FileLogger("log.txt"), message -> message.contains("Simulation"));
        return compositeLogger;
    }
}
