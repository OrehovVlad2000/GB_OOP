package units;

import java.util.ArrayList;

public class Sniper extends Archer {
    public Sniper(ArrayList<BaseHero> gang, String name, int x, int y){
        super(gang, name, "Sniper",12, 10, new int[] {8, 10}, 15, 9, x, y, 32);
    }
}
