package ie.gmit.sw.ai.Ghosts;


import ie.gmit.sw.ai.CharacterTask;
import ie.gmit.sw.ai.Command;
import ie.gmit.sw.ai.Player.Player;

import java.util.Random;

public abstract class Ghosts implements Command {
    private static double health = 100;
    private static double energy = 100;
    private int upperbound = 101;
    private int int_random;
    protected char ghostType;
    public static boolean isRunning = false;

    public Ghosts(char ghostType) {

        this.ghostType = ghostType;
        // Ghosts.player = player;
    }

    Player player = new Player();


    public static double getHealth() {
        return health;
    }

    public static void setHealth(double health) {
        Ghosts.health = health;
    }

    public static double getEnergy() {
        return energy;
    }

    public static void setEnergy(double energy) {
        Ghosts.energy = energy;
    }

    public char getGhostType() {
        return ghostType;
    }

    public void setGhostType(char ghostType) {
        this.ghostType = ghostType;
    }


    public void Rejuvenate() {
        System.out.println("Rejuvenating...");
        energy += 100;
    }

    public void Run() {
        System.out.println("Running away...");
        isRunning = true;
        if (getEnergy() < 1) {
            Rejuvenate();
        }

    }


    public void Attack() {
        if (this.energy > 0) {
            System.out.println("\n Attacking..");

            player.setHealth(player.getHealth() - 1);
            setEnergy(getEnergy() - 25);
            System.out.println("Player health: " + player.getHealth()
                    + ", Spider health: " + this.health + ", Spider energy: " + this.energy);
        }


    }

    double execute = execute(getHealth(), getEnergy());
    //@Override
    public double executee(double health, double energy) {
        System.out.println("In run");
        if (this.getClass() == FuzzyGhost.class && CharacterTask.inPosition) {
            // Engage 1 - 100
            if (execute > 50) {
                System.out.println("Fuzzy Ghost attacks");
                System.out.println("In attack");

                // Fight
               Attack();
            } else if(execute < 50) {
                System.out.println("Fuzzy Ghost runs");
               Run();
            }
        } else {
            // Engage 1 - 2 (1 - Attack, 2 - Run)
            if (execute == 1) {
                System.out.println("NN Ghost attacks");
                // Attack
                Attack();

            } else {
                System.out.println("NN spider runs");
                Run();

            }


        }
        return execute;
    }


    /*public void LifeSpan() {
        //subtracting damage amount from health variable
        health -= damageAmount;
        if (health <= 0) {
            GeneratePickup();
        }
    }*/

}


