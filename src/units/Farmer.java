package units;

import java.util.ArrayList;

public class Farmer extends BaseHero {
    boolean supply;
    public Farmer(ArrayList<BaseHero> gang, String name, String role, int attack, int defence, int[] damage, int health,
                  int speed, int x, int y, String team, boolean supply) {
        super(gang, name, role, attack, defence, damage, health, speed, x, y, team);
        this.supply = supply;
    }

    public Farmer(ArrayList<BaseHero> gang, String name, int x, int y, String team){
        super(gang, name, "Farmer", 1, 1, new int[] {1, 1}, 1, 3, x, y, team);
        this.supply = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", Supply: " + supply;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        supply = true;
    }
}
