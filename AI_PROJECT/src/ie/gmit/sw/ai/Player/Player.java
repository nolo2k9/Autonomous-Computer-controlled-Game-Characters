package ie.gmit.sw.ai.Player;

import ie.gmit.sw.ai.CharacterTask;
import ie.gmit.sw.ai.GameWindow;
import ie.gmit.sw.ai.Ghosts.FuzzyGhosts;
import ie.gmit.sw.ai.Ghosts.Ghosts;
import ie.gmit.sw.ai.Ghosts.NNGhosts;
import ie.gmit.sw.ai.nn.EncogGhost;

import static ie.gmit.sw.ai.CharacterTask.*;

/**
 * <h1>Concrete Player</h1>
 * This class <strong> controls </strong>. The players actions and stats
 *
 * @author Keith Nolan.
 * @version 1.0.
 * @since JDK15.
 */
public class Player {
    //Players health
    public static double health = 100;
    //Players current swords
    private static double sword = 0;
    //Players current guns
    private static double gun = 0;
    //Weapon durability
    private static int weaponDurablity = 0;
    //weapon count
    private static double weapon = 0;

    //Getters and setters
    public static double getHealth() {
        return health;
    }

    public static void setHealth(double health) {
        System.out.println("In health");
        System.out.println("Health: " + getHealth());
        if (health <= 0) {
            System.out.println("You are dead :(");
            System.exit(0);
        }
        Player.health = health;
    }

    public static int getWeaponDurablity() {
        return weaponDurablity;
    }

    public static void setWeaponDurablity(int weaponDurablity) {
        Player.weaponDurablity = weaponDurablity;
    }

    public double getWeapon() {
        return weapon;
    }

    public static void setWeapon(double weapon) {
        Player.weapon = weapon;
    }

    public static double getSword() {
        return sword;
    }

    public static void setSword(double sword) {
        Player.sword = sword;
        // Picking up a sword
        if (sword == 1) {
            weaponDurablity = 3;
            setWeapon(weapon += 1);
        } else if (sword == 0) {
            setWeapon(weapon += 0);
        }
    }

    public static double getGun() {
        return gun;
    }

    public static void setGun(double gun) {
        Player.gun = gun;
        if (gun == 1) {
            weaponDurablity = 3;
            setWeapon(weapon += 1);
        } else if (gun == 0) {
            setWeapon(weapon += 0);
        }
    }
    /**
     * Attack()
     * <p>
     * Takes health from Ghosts if they are in range.
     * If the player has weapons it will take more health than if they don't.
     * Weapons can only be used a few times before they are destroyed
     * </p>
     *
     * @see NNGhosts FuzzyGhosts

     */
    public void Attack() {
        //if in position
        if (GameWindow.playerPosition + 1 == ghostPosition
                || GameWindow.playerPosition - 1 == ghostPosition) {
            System.out.println("EnemyID " + CharacterTask.enemyID);
            System.out.println("Player Attacking");
            //Get current weapn stats
            System.out.println(getWeapon());
            System.out.println(getGun());
            System.out.println(getSword());
            //if player has a sword
            if (sword == 1) {
                //take 50 health
                Ghosts.setHealth(Ghosts.getHealth() - 50);
                //reduce the durability of the weapon
                weaponDurablity--;
                System.out.println("Ghost Health: " + Ghosts.getHealth());
                //if durability is 0 destroy weapon
                if (weaponDurablity <= 0) {
                    sword = 0;
                    System.out.println("Your sword has been destroyed from over-use");
                    Ghosts.count = 0;
                }
                //if player has a gun
            } else if (gun == 1) {
                //reduce the durability of the weapon
                weaponDurablity--;
                //take 100 health
                Ghosts.setHealth(Ghosts.getHealth() - 100);
                System.out.println("Ghost Health: " + Ghosts.getHealth());
                //if durability is 0 destroy weapon
                if (weaponDurablity <= 0) {
                    gun = 0;
                    System.out.println("Your gun has been destroyed from over-use");
                    Ghosts.count = 0;
                }
                //Otherwise use fists
            } else {
                //take 25 health
                Ghosts.setHealth(Ghosts.getHealth() - 25);
                System.out.println("Ghost Health: " + Ghosts.getHealth());
            }
        } else {
            System.out.println("You are not in range to attack");
        }

    }

}//Player
