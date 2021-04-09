package ie.gmit.sw.ai.Ghosts;

import ie.gmit.sw.ai.Command;
import ie.gmit.sw.ai.Player.Player;
import ie.gmit.sw.ai.nn.EncogBuilder;


public class NNGhosts extends Ghosts implements Command {
    private static double health = 100;
    private static double energy = 100;
    private int upperbound = 101;
    private int int_random;
    protected char ghostType;
    public static boolean isRunning = false;
    Player player = new Player();

    public static double getHealth() {
        return health;
    }

    public static void setHealth(double health) {
        NNGhosts.health = health;
    }

    public static double getEnergy() {
        return energy;
    }

    public static void setEnergy(double energy) {
        NNGhosts.energy = energy;
    }



    public void Rejuvenate() {
        System.out.println("NN Rejuvenating...");
        energy += 100;
    }

    public void Run() {
        System.out.println("NN Running away...");
        isRunning = true;
        if (getEnergy() <= 50) {
            Rejuvenate();
        }
    }
    public void Attack() {
        if (this.energy > 0) {
            System.out.println("NN Attacking..");

            player.setHealth(player.getHealth() - 1);
            setEnergy(getEnergy() - 25);
            System.out.println("Player health: " + player.getHealth()
                    + ", Spider health: " + this.health + ", Spider energy: " + this.energy);
        }
    }
    double execut = execute(getHealth(), getEnergy());

    public double executing(double health, double energy) {
        System.out.println("In NN Execute small ");
        return execut;
    }

    @Override
    public double execute(double health, double energy) {
        System.out.println("in NN execute main ");
            EncogBuilder eg = new EncogBuilder();
            Player player = new Player();

            if (health <= 33) {
                health = 0;
            } else if (health <= 66) {
                health = 1;
            } else {
                health = 2;
            }
            if (energy <= 33) {
                energy = 0;
            } else if (energy <= 66) {
                energy = 1;
            } else {
                energy = 2;
            }

            return eg.ghostAction(energy, health, player.getWeapon());

        }
    }
