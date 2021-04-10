package ie.gmit.sw.ai.Ghosts;


import ie.gmit.sw.ai.Command;
import ie.gmit.sw.ai.Player.Player;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.util.Random;

/**
 * <h1>Concrete class FuzzyGhosts</h1>
 * @author keithnolan
 *
 * @version 1.0
 *
 * @see Ghosts NNGhosts Command
 *
 * @since JDK 15
 *
 * <h1>This class extends its base close and implements the Command interface
 * This class controls all of the fuzzy logic controlled ghost types</h1>
 */
public class FuzzyGhosts extends Ghosts implements Command {
    //Load in fcl file
    private static final String FCL_FILE = "./fcl/action.fcl";
    // upper limit of randomly generated number for pickups
    private static int upperbound = 101;
    //Boolean to control whether enemy runs
    public static boolean isRunning = false;
    //Access player elements
    static Player player = new Player();
    //is the ghost dead
    private static boolean isDead = false;
    //random number
    private static int int_random;




    /**
     * Rejuvenate()
     * <p>
     * Rejuvenate the ghosts energy.
     * </p>
     */
    public void Rejuvenate() {
        System.out.println("Fuzzy Rejuvenating...");
        setEnergy(getEnergy() + 100);
    }
    /**
     * Run()
     * <p>
     * Run away and replenish enrgy if the fuzzy value is below 50
     * </p>
     */
    public void Run() {
        if (!isDead) {
            System.out.println("Fuzzy Running away...");
            isRunning = true;
            if (getEnergy() <= 50) {
                Rejuvenate();
            }
        }
    }
    /**
     * <p>
     * Attack()
     * Attack the player if the energy is right and the player is alive
     * Take 10 health from the player
     * take 25 energy
     * </p>
     */
    public void Attack() {
        if (getEnergy() > 0 && !isDead) {
            System.out.println("Fuzzy Attacking..");

            player.setHealth(player.getHealth() - 10);
            setEnergy(getEnergy() - 25);
            System.out.println("Player health: " + player.getHealth()
                    + ", Spider health: " + getHealth() + ", Ghosts energy: " + getEnergy());
        } else {
            System.out.println("This ghost is dead and cannot hurt you ;)");
        }
    }
    //pass in the fuzzified values
    double executes = execute(getHealth(), getEnergy());

    /**
     * executing(double health, double energy)
     * <p>
     * Return the value of executes
     * </p>
     *
     * @param health energy.
     *
     * @return The value of <code>executes</code> .
     */
    public double executing(double health, double energy) {
        System.out.println("In FuzzyGhosts Execute");
        return executes;
    }


    /**
     * <p>
     * execute()
     * Overrides the interface commands execute method
     * Takes in a fuzzy ghosts energy and health.
     * Checks the fuzzy fcl file.
     * Outputs a value based on fuzzy rules.
     * </p>
     * @param health, energy.

     * @return The fuzzified value <code>execute.getValue()</code>
     */
    @Override
    public double execute(double health, double energy) {
        System.out.println("in execute");
        FIS fis = FIS.load(FCL_FILE, true);
        fis.getFunctionBlock("action");
        // Set inputs
        fis.setVariable("energy", getEnergy());
        fis.setVariable("health", getHealth());
        // Show output variable's chart
        Variable execute = fis.getVariable("action");
        fis.evaluate();
        return execute.getValue();

    }

    /**
     * lifeSpan()
     * <p>
     * Control the ghosts lifespan.
     * Sets is dead to true if the ghost is dead
     * calls GeneratePickup();
     * </p>
     */
    public static void lifeSpan() {
        //subtracting damage amount from health variable
        if (FuzzyGhosts.getHealth() == 0 && count < 1) {
            isDead = true;
            GeneratePickup();
            count++;
        }
    }
    /**
     * GeneratePickup()
     * <p>
     * Generate a pickup for the player to use based on a randomised value.
     * If the number is <= 33 player gets health
     * If the number is >33 && < 66 player gets a sword
     * If the number is >66 player gets a gun
     * </p>
     */
    public static void GeneratePickup() {
        Random rand = new Random(); //instance of random class
        //101 because the last number is excluded
        int_random = rand.nextInt(upperbound);
        System.out.println("Number: " + int_random);
        if (int_random < 33) {
            if (player.getHealth() < 100) {
                double topup = 100 - player.getHealth();
                player.setHealth(player.getHealth() + topup / 2);
                System.out.println("You have generated an extra " + topup / 2 + " health");
                System.out.println("Player health: " + player.getHealth());
            } else {
                System.out.println("You have full health <3");
                count = 0;
            }
        } else if (int_random > 33 && int_random < 66) {

            if (player.getWeapon() == 0) {
                player.setSword(1);
                System.out.println("You have picked up a sword");
                System.out.println("Weapons: " + player.getWeapon());
                System.out.println("Swords: " + player.getSword());
            } else {
                System.out.println("You are over encumbered and can't carry anymore swords");
                count = 0;
            }
        } else if (int_random > 66) {

            if (player.getWeapon() == 0) {
                player.setGun(1);
                System.out.println("You have picked up a gun");
                System.out.println("Weapons: " + player.getWeapon());
                System.out.println("Guns: " + player.getGun());
            } else {
                System.out.println("You are over encumbered and can't carry anymore guns");
                count = 0;
            }
        }
    }

}//FuzzyGhosts