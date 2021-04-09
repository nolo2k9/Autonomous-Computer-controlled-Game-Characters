package ie.gmit.sw.ai.Player;

import ie.gmit.sw.ai.Ghosts.Ghosts;

public class Player {

    public double health = 100;
    private double sword = 0;
    private double gun = 0;
    private int weaponDurablity = 0;
    private double weapon = 0;

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        System.out.println("In health");
        System.out.println("Health: " + getHealth());
        if (health <= 0) {
            System.out.println("You are dead :(");
            System.exit(0);
        }
        this.health = health;
    }

    public double getSword() {
        return sword;
    }

    public void setSword(double sword) {
        this.sword = sword;
        // Picking up a sword
        if(sword == 1){
            weaponDurablity = 3;
            setWeapon(weapon+= 1);
        }
        else if(sword ==0){
            setWeapon(weapon+= 0);
        }

    }

    public double getGun() {
        return gun;
    }

    public void setGun(double gun) {
        this.gun = gun;
        // Picking up a sword
        if(gun == 1){
            weaponDurablity = 3;
            setWeapon(weapon+= 1);
        }
        else if(gun ==0){
            setWeapon(weapon+= 0);
        }

    }

   public void Attack() {
        System.out.println("Player Attacking");
        if (sword == 1) {

            Ghosts.setHealth(Ghosts.getHealth() - 60);

            if (weaponDurablity <= 0) {
                sword = 0;
            }
        } else if (gun == 1) {

            weaponDurablity--;
            Ghosts.setHealth(Ghosts.getHealth() - 70);

            if (weaponDurablity <= 0) {
                gun = 0;
            }
        } else {
            Ghosts.setHealth(Ghosts.getHealth() - 40);
        }
    }

    public int getWeaponDurablity() {
        return weaponDurablity;
    }

    public void setWeaponDurablity(int weaponDurablity) {
        this.weaponDurablity = weaponDurablity;
    }

    public double getWeapon() {
        return weapon;
    }

    public void setWeapon(double weapon) {
        this.weapon = weapon;
    }
}
