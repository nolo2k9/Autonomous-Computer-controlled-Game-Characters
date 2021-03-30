package ie.gmit.sw.ai.Ghosts;

import ie.gmit.sw.ai.Command;
import ie.gmit.sw.ai.Player.Player;

import java.util.Random;

public class Ghosts implements Command {
    private static double health = 100;
    private static double energy = 100;
    private int upperbound = 101;
    private int int_random;
    protected char ghostType;

    public Ghosts(char ghostType) {
        this.ghostType = ghostType;
    }

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

    Player p = new Player();
    public static int damageAmount;

    public static int getDamageAmount() {
        return damageAmount;
    }

    public static void setDamageAmount(int damageAmount) {
        Ghosts.damageAmount = damageAmount;
    }


    public void Rejuvinate() {
    }


    public void Run() {
    }


    public void Attack() {
    }


    public void Search() {
    }


    public void GeneratePickup() {
        Random rand = new Random(); //instance of random class
        //101 because the last number is excluded
        int_random = rand.nextInt(upperbound);
        if (int_random <= 33) {

            if (p.getHealth() <= 100) {
                p.setHealth(50);
                System.out.println("You have generated an extra 50 health");
            }

        } else if (int_random > 33 && int_random <= 66) {


            if (p.getSword() == 0) {
                p.setSword(1);
                System.out.println("You have picked up a sword");
            }

        } else if (int_random > 66) {

            if (p.getGun() == 0) {
                p.setGun(1);
                System.out.println("You have picked up a gun");
            } else {
                System.out.println("You have picked up have a gun");
            }

        }

    }


    public void LifeSpan() {
        //subtracting damage amount from health variable
        health -= damageAmount;
        if (health <= 0) {
            GeneratePickup();
        }
    }

    @Override
    public void execute() {

    }

    ;


}
