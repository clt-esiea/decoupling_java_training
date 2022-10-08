package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player=player;
        //TODO implement me
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess=numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound(int i) {

        System.out.println("("+i+") Enter a number : ");
        Scanner scanner = new Scanner(System.in);
        int askUserNumber = scanner.nextInt();
        logger.log(String.valueOf(askUserNumber));

        if(askUserNumber == numberToGuess) {
            logger.log("win");
            return true;
        }
        else {
            player.respond(askUserNumber > numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        boolean game;
        int count = 0;
        do {
            game = nextRound(count);
            count++;
        } while(!game);
    }
}
