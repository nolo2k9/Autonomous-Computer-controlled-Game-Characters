package ie.gmit.sw.ai.Ghosts;

/**
 * @author keithnolan
 *
 * @version 1.0
 *
 * @see FuzzyGhosts  NNGhosts
 *
 * @since JDK 15
 *
 *
 * <h1>This abstract base Ghost class is what all ghost types derive from</h1>
 */
public abstract class Ghosts {
    private static double health = 100;
    private static double energy = 0;
    public static boolean isRunning = false;
    public static int count = 0;

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

    public void Rejuvenate() {}

    public void Run() {}

    public void Attack() {}

    public static void lifeSpan(){};

    public static void GeneratePickup(){}

}




