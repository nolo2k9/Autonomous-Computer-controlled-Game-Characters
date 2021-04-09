package ie.gmit.sw.ai.Ghosts;


import ie.gmit.sw.ai.Command;
import ie.gmit.sw.ai.Player.Player;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class FuzzyGhosts extends Ghosts implements Command {
    private static double health = 100;
    private static double energy = 100;
    private int upperbound = 101;
    public static boolean isRunning = false;
    Player player = new Player();
    private static final String FCL_FILE = "./fcl/action.fcl";

    public static double getHealth() {
        return health;
    }

    public static void setHealth(double health) {
        FuzzyGhosts.health = health;
    }

    public static double getEnergy() {
        return energy;
    }

    public static void setEnergy(double energy) {
        FuzzyGhosts.energy = energy;
    }


    public void Rejuvenate() {
        System.out.println("Fuzzy Rejuvenating...");
        energy += 100;
    }

    public void Run() {
        System.out.println("Fuzzy Running away...");
        isRunning = true;
        if (getEnergy() <= 50) {
            Rejuvenate();
        }

    }
    public void Attack() {
        if (this.energy > 0) {
            System.out.println("Fuzzy Attacking..");

            player.setHealth(player.getHealth() - 1);
            setEnergy(getEnergy() - 25);
            System.out.println("Player health: " + player.getHealth()
                    + ", Spider health: " + this.health + ", Spider energy: " + this.energy);
        }
    }

    double execut = execute(getHealth(), getEnergy());

    public double executing(double health, double energy) {
        System.out.println("In FuzzyGhosts Execute");
        return execut;
    }

    @Override
    public double execute(double health, double energy) {
        System.out.println("in execute");
        FIS fis = FIS.load(FCL_FILE, true);
        fis.getFunctionBlock("action");
        // Set inputs
        fis.setVariable("energy", FuzzyGhosts.getEnergy());
        fis.setVariable("health", FuzzyGhosts.getHealth());
        // Show output variable's chart
        Variable execute = fis.getVariable("action");
        fis.evaluate();
        return execute.getValue();

    }
}