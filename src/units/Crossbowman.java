package units;

import java.util.ArrayList;

public class Crossbowman extends Archer {
    public Crossbowman(ArrayList<BaseHero> gang, String name, int x, int y){
        super(gang, name, "Crossbowman",6, 3, new int[] {2, 3}, 10, 4, x, y, 16);
    }
}
