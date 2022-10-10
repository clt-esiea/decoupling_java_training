package fr.lernejo.guessgame;

import java.util.Scanner;
import fr.lernejo.logger.LoggerFactory;
import fr.lernejo.logger.Logger;

public class HumanPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        Scanner scanner = new Scanner(System.in);
        logger.log("Enter a number : ");

        long askUserNumber = scanner.nextLong();
        logger.log(String.valueOf(askUserNumber));
        return askUserNumber;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) {
            this.logger.log("lower");
        } else {
            this.logger.log("greater");
        }
    }
}
