package units;

import java.util.ArrayList;

public class Spearman extends Infantryman{
    public Spearman(ArrayList<BaseHero> gang, String name, int x, int y){
        super(gang, name, "Spearman",4, 5, new int[] {1, 3}, 10, 4, x, y);
    }
}
