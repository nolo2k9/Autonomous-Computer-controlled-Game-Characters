package ie.gmit.sw.ai.Ghosts;


import ie.gmit.sw.ai.CharacterTask;
import ie.gmit.sw.ai.GameWindow;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyGhost extends Ghosts {

    private static final String FCL_FILE = "./fcl/action.fcl";

    public FuzzyGhost(char ghostType) {
        super(ghostType);
    }

    @Override
    public double execute(double health, double energy) {

        FIS fis = FIS.load(FCL_FILE, true);
        fis.getFunctionBlock("action");

        // Set inputs
        fis.setVariable("energy", Ghosts.getEnergy());
        fis.setVariable("health", Ghosts.getHealth());
        // Show output variable's chart
        Variable execute = fis.getVariable("action");
        fis.evaluate();
        if(GameWindow.playerPosition -1 == CharacterTask.ghostPosition
                || GameWindow.playerPosition +1 == CharacterTask.ghostPosition)
        {
            if (energy > 0 && health >= 20) {
                super.Attack();
            } else if (energy <= 0) {
                super.Run();
            }
            if (health < 20) {
                super.Run();
            } else if (health > 20 && energy < 0) {
                super.Attack();
            }
        }

        return execute.getValue();

    }




    /*public static void main(String[] args) {
        FuzzyGhost s = new FuzzyGhost();
        double d = s.action(60, 14);
        System.out.println(d);
    }*/

}
