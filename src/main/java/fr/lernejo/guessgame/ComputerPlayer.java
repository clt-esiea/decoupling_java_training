package fr.lernejo.guessgame;

import java.util.Scanner;
import fr.lernejo.logger.LoggerFactory;
import fr.lernejo.logger.Logger;
import java.security.SecureRandom;
public class ComputerPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");
    long min = Long.MIN_VALUE;
    long max = Long.MAX_VALUE;
    @Override
    public long askNextGuess() {
        SecureRandom secureRandom = new SecureRandom();
        //long randomChoiceComputer = secureRandom.nextLong(min, max);
        long randomChoiceComputer = ((this.min+this.max)/2);
        return randomChoiceComputer;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) {
            this.logger.log("lower");
            this.max=((this.min+this.max)/2);
        } else {
            this.logger.log("greater");
            this.min=((this.min+this.max)/2);
        }
    }
}
