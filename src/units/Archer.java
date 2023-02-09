package units;

import java.util.ArrayList;

public class Archer extends BaseHero {
    int shoots;
    public Archer(ArrayList<BaseHero> gang, String name, String role, int attack, int defence, int[] damage, int health,
                  int speed, int x, int y, String team, int shoots) {
        super(gang, name, role, attack, defence, damage, health, speed, x, y, team);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoots: " + shoots;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (health == 0){
            return;
        }
        Vector2 target = getTarget(heroList);
        float constMin = 12;
        float constMax = 4;

        float attackPower;
        if (target.x <= constMax) {
            attackPower = damage[1];
        }else if(target.x >= constMin) {
            attackPower = damage[0];
        }else {
            attackPower = damage[0] + ((target.x - constMax) / (constMin - constMax)) * (damage[1] - damage[0]);
        }

        boolean doShoot = true;
        for (BaseHero hero: gang){
            if (hero.role.equals("Farmer")){
                if (((Farmer) hero).supply){
                    heroList.get((int) target.y).getDamage(attackPower);
                    System.out.printf("\nБоец %s %s совершает выстрел в бойца %s %s нанес урон %d ед. и тратит 0 стрел. " +
                            "Оставшееся кол-во стрел: %d", role, name, heroList.get((int) target.y).role,
                            heroList.get((int) target.y).name, (int) attackPower, shoots);
                    ((Farmer) hero).supply = false;
                    doShoot = false;
                    break;
                }
            }
        }
        if (doShoot) {
            if (shoots > 0) {
                heroList.get((int) target.y).getDamage(attackPower);
                shoots--;
                System.out.printf("\nБоец %s %s совершает выстрел в бойца %s %s нанес урон %d ед. и тратит 1 стрелу. " +
                        "Оставшееся кол-во стрел: %d", role, name, heroList.get((int) target.y).role,
                        heroList.get((int) target.y).name, (int) attackPower, shoots);
            } else {
                System.out.println("\nУ бойца: " + this.getRole() + " по имени: " + name + " закончились стрелы!!!!!");
            }
        }
    }
}
