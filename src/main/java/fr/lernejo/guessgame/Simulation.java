package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
    long MAX_ITE = 1000;
    long max = Long.MAX_VALUE;
    private int count = 1;
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type
    private int tryNbr;

    public Simulation(Player player) {
        this.player=player;
    }

    public void initialize(long numberToGuess, long tryNbr) {
        this.numberToGuess=numberToGuess;
        this.tryNbr=count;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {

        /*
        System.out.println("Enter a number : ");
        Scanner scanner = new Scanner(System.in);
        int askUserNumber = scanner.nextInt();
        logger.log(String.valueOf(askUserNumber));
         */
        long computerChoice = player.askNextGuess();
        if(computerChoice == numberToGuess) {
            logger.log("win");
            return true;
        }
        else {
            player.respond(computerChoice > numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long maxValue) {
        SimpleDateFormat progDateForm = new SimpleDateFormat("mm:ss.SSS");
        boolean game = false;
        long timeExec = 0;
        long startT = System.currentTimeMillis();
        do {
            game = nextRound();
            count++;
        } while(!game && count<maxValue);
        long endT = System.currentTimeMillis();
        timeExec = endT - startT;
        Date timeExecValue = new Date(timeExec);
        logger.log("Time execution -> " + progDateForm.format(timeExecValue));
        //logger.log("Number of tries -> " + count);
    }
}
