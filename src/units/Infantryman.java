package units;

import java.util.ArrayList;
import java.util.Random;

public class Infantryman extends BaseHero {
    public Infantryman(ArrayList<BaseHero> gang, String name, String role, int attack, int defence, int[] damage,
                       int health, int speed, int x, int y, String team) {
        super(gang, name, role, attack, defence, damage, health, speed, x, y, team);
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (health == 0) {
            return;
        }
        Vector2 target = getTarget(heroList);
        if (target.x == 100) {
            return;
        }
        // Нашли ближайшего врага.
        int targetX = (int) heroList.get((int) target.y).getPosition().x;
        int targetY = (int) heroList.get((int) target.y).getPosition().y;
        boolean targetLeft = targetX < getPosition().x;
        boolean targetRight = targetX > getPosition().x;
        boolean targetUp = targetY > getPosition().y;
        boolean targetDown = targetY < getPosition().y;
        float attackPower = new Random().nextInt(damage[0], damage[1] + 1);

        if (target.x < 2) {
            heroList.get((int) target.y).getDamage(attackPower);
        } else if (targetRight) {
            setPosition(++getPosition().x, getPosition().y);
        } else if (targetLeft) {
            setPosition(--getPosition().x, getPosition().y);
        } else if (targetX == getPosition().x) {
            if (targetUp) {
                setPosition(getPosition().x, ++getPosition().y);
            } else if (targetDown) {
                setPosition(getPosition().x, --getPosition().y);
            }
        }
    }
}
