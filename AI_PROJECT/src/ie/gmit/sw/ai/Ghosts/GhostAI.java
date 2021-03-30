package ie.gmit.sw.ai.Ghosts;

import ie.gmit.sw.ai.nn.BackpropagationTrainer;
import ie.gmit.sw.ai.nn.NeuralNetwork;
import ie.gmit.sw.ai.nn.Utils;
import ie.gmit.sw.ai.nn.activator.Activator;

public class GhostAI {


    public static void main(String[] args) throws Exception {
        new GhostAI().go();
    }

    public void go() throws Exception {
        //Ai stuff goes into go method
        NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 4, 3, 4);
        BackpropagationTrainer trainer = new BackpropagationTrainer(nn);
        trainer.train(data, expected, 0.6, 10000);

        double[] arr = {0, 1, 1, 0};
        double[] result = nn.process(arr);
        int classification = Utils.getMaxIndex(result) + 1;

        if (classification == 1) {
            panic();

        } else if (classification == 2) {
            attack();

        } else if (classification == 3) {
            hide();

        } else {
            run();
        }

    }


    //Standard code
    public void panic() throws Exception {
        System.out.println("panic...");

    }


    public void attack() throws Exception {
        System.out.println("attack...");

    }


    public void hide() throws Exception {
        System.out.println("Hide...");
    }


    public void run() throws Exception {
        System.out.println("Run...");
    }

    /*
     * 	------------------------------------------------------------------------
     * 	B.Sc. (Hons) in Software Development - Artificial Intelligence
     * 	------------------------------------------------------------------------
     *
     *  Data set for the Neural Network Game Action Lab
     *
     *  Inputs
     *  -------------
     *  1) Health (2 = Healthy, 1 = Minor Injuries, 0 = Serious Injuries)
     *  2) Has a Sword (1 = yes, 0 = no)
     *  3) Has a Gun (1 = yes, 0 = no)
     *  4) Number of Enemies (This value may need to be normalized)
     *
     *  Outputs
     *  -------------
     *  1) Panic
     *  2) Attack
     *  3) Hide
     *  4) Run
     *
     */

    private double[][] data = { //Health, Sword, Gun, Enemies
            {2, 0, 0, 0}, {2, 0, 0, 1}, {2, 0, 1, 1}, {2, 0, 1, 2}, {2, 1, 0, 2},
            {2, 1, 0, 1}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 0, 1, 1}, {1, 0, 1, 2},
            {1, 1, 0, 2}, {1, 1, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 1},
            {0, 0, 1, 2}, {0, 1, 0, 2}, {0, 1, 0, 1}};

    private double[][] expected = { //Panic, Attack, Hide, Run
            {0.0, 0.0, 1.0, 0.0}, {0.0, 0.0, 1.0, 0.0}, {1.0, 0.0, 0.0, 0.0}, {1.0, 0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0, 1.0}, {1.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 1.0, 0.0}, {0.0, 0.0, 0.0, 1.0},
            {1.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 1.0}, {0.0, 0.0, 0.0, 1.0}, {0.0, 0.0, 0.0, 1.0},
            {0.0, 0.0, 1.0, 0.0}, {0.0, 0.0, 0.0, 1.0}, {0.0, 0.0, 0.0, 1.0}, {0.0, 1.0, 0.0, 0.0},
            {0.0, 1.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 1.0}};


}


