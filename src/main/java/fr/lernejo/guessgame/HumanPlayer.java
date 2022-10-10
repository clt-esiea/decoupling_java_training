package fr.lernejo.guessgame;

import java.util.Scanner;
import fr.lernejo.logger.LoggerFactory;
import fr.lernejo.logger.Logger;

public class HumanPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        System.out.println("Enter a number : ");
        Scanner scanner = new Scanner(System.in);
        int askUserNumber = scanner.nextInt();
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
