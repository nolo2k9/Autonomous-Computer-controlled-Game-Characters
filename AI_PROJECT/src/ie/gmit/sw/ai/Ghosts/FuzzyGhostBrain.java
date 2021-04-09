package ie.gmit.sw.ai.Ghosts;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyGhostBrain extends FuzzyGhosts {

    private static final String FCL_FILE = "./fcl/action.fcl";

    /*public FuzzyGhostBrain(char ghostType) {
        super(ghostType);
    }*/
    @Override
    public double execute(double health, double energy) {

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