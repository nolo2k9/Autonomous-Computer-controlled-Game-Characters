package ie.gmit.sw.ai.Ghosts;


import ie.gmit.sw.ai.Player.Player;
import ie.gmit.sw.ai.nn.EncogBuilder;

public class NNGhostsBrain extends NNGhosts{
    public double execute(double energy, double health) {
        EncogBuilder eg = new EncogBuilder();
        Player player = new Player();

        if (health<= 33) {
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

        return eg.ghostAction(energy,health, player.getWeapon());


    }


}


