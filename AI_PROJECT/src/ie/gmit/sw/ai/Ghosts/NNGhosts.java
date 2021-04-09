package ie.gmit.sw.ai.Ghosts;

import ie.gmit.sw.ai.Command;
import ie.gmit.sw.ai.Player.Player;
import ie.gmit.sw.ai.nn.EncogBuilder;


public class NNGhosts extends Ghosts implements Command {
    private int upperbound = 101;
    public static boolean isRunning = false;
    Player player = new Player();



    public void Rejuvenate() {
        System.out.println("NN Rejuvenating...");
        setEnergy(getEnergy() + 100);
    }

    public void Run() {
        System.out.println("NN Running away...");
        isRunning = true;
        if (getEnergy() <= 50) {
            Rejuvenate();
        }
    }
    public void Attack() {
        System.out.println("Get Energy: " + getEnergy());
        if (getEnergy() > 0) {
            System.out.println("NN Attacking..");

            player.setHealth(player.getHealth() - 1);
            setEnergy(getEnergy() - 25);
            System.out.println("Player health: " + player.getHealth()
                    + ", Spider health: " + getHealth() + ", Spider energy: " + getEnergy());
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

            if (getHealth() <= 33) {
                health = 0;
            } else if (getHealth() <= 66) {
                health = 1;
            } else {
                health = 2;
            }
            if (getEnergy() <= 33) {
                energy = 0;
            } else if (getEnergy() <= 66) {
                energy = 1;
            } else {
                energy = 2;
            }

            return eg.ghostAction(health, energy,player.getWeapon());

        }
    }
