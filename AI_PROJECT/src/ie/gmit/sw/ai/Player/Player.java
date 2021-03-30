package ie.gmit.sw.ai.Player;

import ie.gmit.sw.ai.Ghosts.Ghosts;

public class Player {

    public double health = 100;
    private double sword = 0;
    private double gun = 0;
    private int weaponDurablity = 0;
    Ghosts g;

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
        }

    }

    public int getWeaponDurablity() {
        return weaponDurablity;
    }

    public void setWeaponDurablity(int weaponDurablity) {
        this.weaponDurablity = weaponDurablity;
    }



    public void Attack() {
        System.out.println("Player Attacking");
        if (sword == 1) {

            Ghosts.setDamageAmount(60);

            if (weaponDurablity <= 0) {
                sword = 0;
            }
        } else if (gun == 1) {

            weaponDurablity--;
            Ghosts.setDamageAmount(70);

            if (weaponDurablity <= 0) {
                gun = 0;
            }
        } else {

            Ghosts.setDamageAmount(40);
        }

    }




}
