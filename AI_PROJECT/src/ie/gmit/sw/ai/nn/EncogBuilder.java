package ie.gmit.sw.ai.nn;

import org.encog.ml.data.MLData;
import org.encog.ml.data.basic.BasicMLData;

/**
 * <h1>Concrete EncogBuilder</h1>
 * This class has <strong> one responsibilty</strong>. To return a value based on the stats health, energy and weapon.
 * This is done by passing it an instance of EncogGhost's basicNetwork.
 * It then outputs a value between 0 and 1 to determine what the ghost will do.
 * @author Keith Nolan.
 *
 * @version 1.0.
 *
 * @see NeuralNetwork
 *
 * @since JDK15.
 *
 */
public class EncogBuilder extends NeuralNetwork {
    public double ghostAction(double health,double energy, double weapon) {
        double[] params = {health,energy,weapon};
        MLData data = new BasicMLData(params);
        System.out.println("Based on current circumstances I have decided to " + basicNetwork.classify(data));

        return basicNetwork.classify(data);
    }
}
