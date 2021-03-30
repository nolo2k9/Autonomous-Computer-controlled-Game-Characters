package ie.gmit.sw.ai.Player;

import ie.gmit.sw.ai.Ghosts.Ghosts;

public class Player {

    private double health = 100;
    private double sword = 0;
    private double gun = 0;
    private int weaponDurablity = 0;
    private int chanceOfHitting = 0;
    Ghosts g;

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
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

    public int getDurablity() {
        return weaponDurablity;
    }

    public void setDurablity(int durablity) {
        this.weaponDurablity = durablity;
    }

    public void Attack() {
        System.out.println("Attacking");
        if (sword == 1) {
            chanceOfHitting = 75;
            weaponDurablity--;
            Ghosts.setDamageAmount(60);

            if (weaponDurablity <= 0) {
                sword = 0;
            }
        } else if (gun == 1) {
            chanceOfHitting = 85;
            weaponDurablity--;
            Ghosts.setDamageAmount(70);

            if (weaponDurablity <= 0) {
                gun = 0;
            }
        } else {
            chanceOfHitting = 50;
            Ghosts.setDamageAmount(40);
        }

    }


    public void PickUp() {
    }




}
