package ie.gmit.sw.ai.Ghosts;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyGhost extends Ghosts{

        private static final String FCL_FILE = "./fcl/action.fcl";

        public FuzzyGhost(char ghostType)
        {
            super(ghostType);
        }


        public float action(int energy, int health) {

            FIS fis = FIS.load(FCL_FILE, true);

            FunctionBlock functionBlock = fis.getFunctionBlock("action");
            // Show
            JFuzzyChart.get().chart(functionBlock);

            // Set inputs
            fis.setVariable("energy", Ghosts.getEnergy());
            fis.setVariable("health", Ghosts.getHealth());
            fis.evaluate();
            // Show output variable's chart
            Variable action = functionBlock.getVariable("action");

            return (float) action.getValue();


        }

    }
