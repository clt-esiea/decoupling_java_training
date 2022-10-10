package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    private Logger parameter1;
    private Logger parameter2;

    public CompositeLogger(Logger parameter1, Logger parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }
    @Override
    public void log(String message) {
        parameter1.log(message);
        parameter2.log(message);
    }
}
