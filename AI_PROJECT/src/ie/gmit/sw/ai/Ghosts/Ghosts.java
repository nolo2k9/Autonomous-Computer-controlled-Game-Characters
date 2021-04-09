package ie.gmit.sw.ai.Ghosts;


public abstract class Ghosts {
    private static double health = 100;
    private static double energy = 100;
    public static boolean isRunning = false;

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

    public void Rejuvenate() {
    }
    public void Run() {
    }

    public void Attack() {
    }


}




