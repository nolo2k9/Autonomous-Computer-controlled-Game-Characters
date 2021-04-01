package ie.gmit.sw.ai.Ghosts;

import ie.gmit.sw.ai.CharacterTask;
import ie.gmit.sw.ai.Command;
import ie.gmit.sw.ai.GameWindow;
import ie.gmit.sw.ai.Player.Player;

import java.util.Random;

public abstract class Ghosts implements Command {
    private static double health = 100;
    private static double energy = 100;
    private int upperbound = 101;
    private int int_random;
    protected char ghostType;
    public static boolean isRunning = false;

    Player player = new Player();

    public Ghosts(char ghostType) {

        this.ghostType = ghostType;
       // Ghosts.player = player;
    }

    public void Rejuvenate() {
        System.out.println("Rejuvenating...");
        energy += 100;
    }


    public void Run() {
        System.out.println("Running away...");
        isRunning = true;
        Rejuvenate();
    }


    public void Attack() {
        if(this.energy > 0)
        {
            System.out.println("\n Attacking..");

            player.setHealth(player.getHealth() - 1 );
            setEnergy(getEnergy() - 25);
            System.out.println("Player health: " + player.getHealth()
                    + ", Spider health: " + this.health + ", Spider energy: " + this.energy);
        }


    }


    public void GeneratePickup() {
        Random rand = new Random(); //instance of random class
        //101 because the last number is excluded
        int_random = rand.nextInt(upperbound);
        if (int_random <= 33) {

            if (player.getHealth() <= 100) {
                player.setHealth(getHealth() + 50);
                System.out.println("You have generated an extra 50 health");
            }

        } else if (int_random > 33 && int_random <= 66) {


            if (player.getSword() == 0) {
                player.setSword(1);
                System.out.println("You have picked up a sword");
            }

        } else if (int_random > 66) {

            if (player.getGun() == 0) {
                player.setGun(1);
                System.out.println("You have picked up a gun");
            } else {
                System.out.println("You have picked up have a gun");
            }

        }

    }
    @Override
    public double execute(double health, double energy) {return 0;}

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
    /*public void LifeSpan() {
        //subtracting damage amount from health variable
        health -= damageAmount;
        if (health <= 0) {
            GeneratePickup();
        }
    }*/



}
