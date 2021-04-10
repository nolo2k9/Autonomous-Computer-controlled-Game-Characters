package ie.gmit.sw.ai.nn;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;
/**
 * <h1>EncogGhst</h1>
 * The purpose of this class is to create and train the neural network.
 * @author Keith Nolan.
 *
 * @version 1.0.
 *
 * @see EncogGhost
 *
 * @since JDK15.
 *
 */
public class EncogGhost {

    //static variable to access network
    public static BasicNetwork basicNetwork;

    /**
     *
     * @return
     */
    public BasicNetwork networkInit() {
        //Basic neural network
        BasicNetwork network = new BasicNetwork();
        //3 layer network
        //input layer
        network.addLayer(new BasicLayer(null, true, 3));
        //hidden layer
        network.addLayer(new BasicLayer(new ActivationSigmoid(), true, 3));
        //output layer
        network.addLayer(new BasicLayer(new ActivationSigmoid(), false, 2));

        network.getStructure().finalizeStructure();
        network.reset();

        return network;
    }

    public void neuralNetwork() {
        basicNetwork = networkInit();
        //Step 2 Create the training data set.
        MLDataSet trainingSet = new BasicMLDataSet(data, expected);
        //Step 3 Create the training data set.
        ResilientPropagation train = new ResilientPropagation(basicNetwork, trainingSet);
        double minError = 0.06; //Change and see the effect on the result... :) //make it longer to train
        int epoch = 1;
        System.out.println("[INFO] Training.....");
        do {
            //go to next iteration
            train.iteration();
            //add an epoch
            epoch++;
            //Keep training until the error reported is greater than the tolerated one.
        } while (train.getError() > minError);
        train.finishTraining();
        System.out.println("[INFO] Training Complete in " + epoch + " epochs with e= " + train.getError());
        double correct = 0;
        double total = 0;
        //Step 4: Test the NN
        for (MLDataPair pair : trainingSet) {
            total++;
            MLData output = basicNetwork.compute(pair.getInput());
            int y = (int) Math.round(output.getData(0));
            int yd = (int) pair.getIdeal().getData(0);
            if (y == yd) {
                correct++;
            }

        }
        System.out.println("[INFO] Testing Complete. Acc " + ((correct / total) * 100));
        Encog.getInstance().shutdown();
    }

    private static double[][] data = { //Health, Energy, Weapon
            {2, 2, 0}, {2, 1, 0}, {2, 0, 0}, {1, 2, 0},
            {1, 1, 0}, {0, 1, 0}, {2, 2, 1}, {1, 1, 1},
            {0, 1, 1}, {0, 0, 1}, {1, 0, 1}};


    private static double[][] expected = { //Run, Attack
            {0.0, 1.0}, {0.0, 1.0}, {1.0, 0.0}, {0.0, 1.0},
            {0.0, 1.0}, {0.0, 1.0}, {0.0, 1.0}, {0.0, 1.0},
            {0.0, 1.0}, {1.0, 0.0}, {1.0, 0.0}};

}


