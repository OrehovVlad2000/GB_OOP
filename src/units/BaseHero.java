package units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements BaseInterface {
    protected String name, role, team;
    protected int attack, defence, maxHealth, speed, x, y;
    protected float health;
    protected int[] damage;
    protected Vector2 position;
    protected ArrayList<BaseHero> gang;

    public BaseHero(ArrayList<BaseHero> gang, String name, String role, int attack, int defence, int[] damage,
                    int health, int speed, int x, int y, String team) {
        this.gang = gang;
        this.name = name;
        this.role = role;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHealth = health;
        this.health = maxHealth;
        this.speed = speed;
        this.position = new Vector2(x, y);
        this.x = x;
        this.y = y;
        this.team = team;
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
//        return String.format("%-1s: %-2s ⚔️%-3d \uD83D\uDEE1️%-3d ❤️%-3d ☠%-3d",
//                role, name, attack,defence,(int) health,(damage[0] + damage[1])/2,speed);
        return String.format("%-10s %-13s %s: %-3d/ %-3d %s: %-5d |", name, role, "\uD83E\uDDE1",
                (int) health, maxHealth, "⚔", attack);
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

    protected void getDamage(float attackPower){
        this.health -= attackPower;
        if(this.health < 0){
            this.health = 0;
        }else if (this.health > maxHealth){
            this.health = maxHealth;
        }
    }

    public float heroHealth() {
        return health;
    }

    protected Vector2 getTarget(ArrayList<BaseHero> heroList){
        float minDistance = 100;
        int minIndex = 0;
        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i).getTeam().equals(getTeam())) {
                continue;
            }
            float temp = getPosition().getDistance(heroList.get(0).getPosition().x, heroList.get(0).getPosition().y);
            if (temp < minDistance && heroList.get(i).health > 0) {
                minDistance = temp;
                minIndex = i;
            }
        }
        return new Vector2(minDistance, minIndex);
    }

    public void setPosition(float x, float y) {
        this.position = new Vector2(x, y);
    }

    public String getTeam() {
        return team;
    }
}
