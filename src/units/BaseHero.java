package units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements BaseInterface {
    protected String name, role;
    protected int attack, defence, health, maxHealth, speed, x, y;
    protected int[] damage;
    protected Vector2 position;
    protected ArrayList<BaseHero> gang;

    public BaseHero(ArrayList<BaseHero> gang, String name, String role, int attack, int defence, int[] damage, int health, int speed, int x, int y) {
        this.gang = gang;
        this.name = name;
        this.role = role;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = health;
        this.health = maxHealth - new Random().nextInt(maxHealth);
        this.speed = speed;
        this.position = new Vector2(x, y);
        this.x = x;
        this.y = y;
    }

    public int getHealth() {
        return (int) health / maxHealth * 100;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {

    }

    @Override
    public String getInfo() {
//        return role + ": " + health + " " + maxHealth + " " + (health * 100 / maxHealth) + "" + "%";
        return String.format("%s:\t%s\t⚔ %d\t\uD83D\uDEE1 %d\t♥%d\t☠%d",role, name, attack,defence,health,(damage[0] + damage[1])/2,speed);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Role: " + role + ", Attack: " + attack + ", Defence: " + defence + ", Damage: " +
                Arrays.toString(damage) + ", Health: " + health + ", Speed: " + speed;
    }

    @Override
    public String getRole() {
        return role;
    }

    public Vector2 getPosition() {
        return position;
    }
}
