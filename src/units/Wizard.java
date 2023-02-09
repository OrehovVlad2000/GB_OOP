package units;

import java.util.ArrayList;

public class Wizard extends BaseHero {
    int mana;
    public Wizard(ArrayList<BaseHero> gang, String name, String role, int attack, int defence, int[] damage, int health,
                  int speed, int x, int y, String team, int mana) {
        super(gang, name, role, attack, defence, damage, health, speed, x, y, team);
        this.mana = mana;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (health == 0){
            return;
        }
        int max = 100;
        int maxi = 0;
        for (int i = 0; i < gang.size(); i++) {
            if (gang.get(i).health == 0) {
                continue;
            }
            int currentHealth = gang.get(i).getHealth();
            if (currentHealth < 100) {
                if (currentHealth < max) {
                    max = currentHealth;
                    maxi = i;
                }
            }
        }
        if (max < 100){
            treatment(gang.get(maxi));
        }
    }

    private void treatment(BaseHero wounded){
        float healingPower = damage[0];
        wounded.getDamage(healingPower);
        if (wounded.health == wounded.maxHealth){
            System.out.printf("\nПерсонаж %s %s полностью вылечил персонажа %s %s. Текущее здоровье: %d/%d",
                    role, name, wounded.role, wounded.name, (int) wounded.health, wounded.maxHealth);
        }else {
            System.out.printf("\nПерсонаж %s %s вылечил персонажа %s %s на %d ед. здоровья. Текущее здоровье: %d/%d",
                    role, name, wounded.role, wounded.name, (int) Math.abs(healingPower), (int) wounded.health,
                    wounded.maxHealth);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana";
    }

}
