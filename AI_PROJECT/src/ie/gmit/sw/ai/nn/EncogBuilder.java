package ie.gmit.sw.ai.nn;

import org.encog.ml.data.MLData;
import org.encog.ml.data.basic.BasicMLData;

public class EncogBuilder extends EncogGhost {
    public double ghostAction(double energy,double health, double weapon) {
        double[] params = {energy, health, weapon};
        MLData data = new BasicMLData(params);
        System.out.println("I will " + basicNetwork.classify(data));

        return basicNetwork.classify(data);
    }
}
