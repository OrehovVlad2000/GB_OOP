package units;

import java.util.ArrayList;

public class Mage extends Wizard{
    public Mage(ArrayList<BaseHero> gang, String name, int x, int y, String team){
        super(gang, name, "Mage",17, 12, new int[] {-5, -5}, 30, 9, x, y, team, 1);
    }
}
