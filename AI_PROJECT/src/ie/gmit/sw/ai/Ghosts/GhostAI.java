package ie.gmit.sw.ai.Ghosts;


import ie.gmit.sw.ai.Player.Player;
import ie.gmit.sw.ai.nn.EncogGhost;

public class GhostAI extends Ghosts {

    public GhostAI(char ghostType) {
        super(ghostType);
    }

    public double execute(double health, double energy) {
        EncogGhost eg = new EncogGhost();
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
        System.out.println("Ai controller health: " + health);
        System.out.println("Ai controller energy: " + energy);
        System.out.println(player.getWeapon());
       // super.execute(health, energy);
        return eg.ghostAction(getHealth(), getEnergy(), player.getWeapon());

    }


}


