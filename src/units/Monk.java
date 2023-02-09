package units;

import java.util.ArrayList;

public class Monk extends Wizard{
    public Monk(ArrayList<BaseHero> gang, String name, int x, int y, String team){
        super(gang, name, "Monk", 12, 7, new int[] {-4, -4}, 30, 5, x, y, team, 1);
    }
}
