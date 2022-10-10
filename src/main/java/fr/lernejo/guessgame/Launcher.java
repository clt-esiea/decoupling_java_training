package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;
public class Launcher {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger("launcher");
        long MAX_ITE = 1000;
        try {
            if (args[0].equals("-interactive")) {
                HumanPlayer humanPlayer = new HumanPlayer();
                Simulation simulation = new Simulation(humanPlayer);

                SecureRandom random = new SecureRandom();
                long randomNumber = random.nextInt(1000);
                System.out.println(randomNumber);

                simulation.initialize(randomNumber, Long.parseLong(args[1])+1);
                simulation.loopUntilPlayerSucceed(Long.parseLong(args[1])+1);
            }
            else if (args[0].equals("-auto")) {
                ComputerPlayer computerPlayer = new ComputerPlayer();
                Simulation simulation = new Simulation(computerPlayer);

                SecureRandom random = new SecureRandom();
                long randomNumber = random.nextLong(1000);
                System.out.println(randomNumber);

                simulation.initialize(randomNumber, Long.parseLong(args[1]));
                simulation.loopUntilPlayerSucceed(MAX_ITE);
            }
        }
        catch (IndexOutOfBoundsException e) {
            logger.log("-interactive -> Human Player");
            logger.log("-auto -> Computer Player");
        }
    }
}
