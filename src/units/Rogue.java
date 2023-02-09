package units;

import java.util.ArrayList;

public class Rogue extends Infantryman{
    public Rogue(ArrayList<BaseHero> gang, String name, int x, int y, String team){
        super(gang, name, "Rogue",8, 3, new int[] {2, 4}, 10, 6, x, y, team);
    }
}
