package units;

import java.util.ArrayList;

public class Infantryman extends BaseHero {
    public Infantryman(ArrayList<BaseHero> gang, String name, String role, int attack, int defence, int[] damage, int health, int speed, int x, int y) {
        super(gang, name, role, attack, defence, damage, health, speed, x, y);
    }
}
