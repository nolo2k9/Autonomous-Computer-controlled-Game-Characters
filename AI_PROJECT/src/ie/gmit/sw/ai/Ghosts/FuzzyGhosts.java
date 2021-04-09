package ie.gmit.sw.ai.Ghosts;


import ie.gmit.sw.ai.Command;
import ie.gmit.sw.ai.Player.Player;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class FuzzyGhosts extends Ghosts implements Command {

    private int upperbound = 101;
    public static boolean isRunning = false;
    Player player = new Player();
    private static final String FCL_FILE = "./fcl/action.fcl";

    public void Rejuvenate() {
        System.out.println("Fuzzy Rejuvenating...");
        setEnergy(getEnergy() + 100);
    }

    public void Run() {
        System.out.println("Fuzzy Running away...");
        isRunning = true;
        if (getEnergy() <= 50) {
            Rejuvenate();
        }

    }
    public void Attack() {
        if (getEnergy() > 0) {
            System.out.println("Fuzzy Attacking..");

            player.setHealth(player.getHealth() - 1);
            setEnergy(getEnergy() - 25);
            System.out.println("Player health: " + player.getHealth()
                    + ", Spider health: " + getHealth() + ", Ghosts energy: " + getEnergy());
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
        fis.setVariable("energy", getEnergy());
        fis.setVariable("health", getHealth());
        // Show output variable's chart
        Variable execute = fis.getVariable("action");
        fis.evaluate();
        return execute.getValue();

    }
}