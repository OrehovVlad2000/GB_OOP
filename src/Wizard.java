import java.util.ArrayList;

public class Wizard extends BaseHero{
    int mana;
    public Wizard(String name, String role, int attack, int defence, int[] damage, int health, int speed, int mana) {
        super(name, role, attack, defence, damage, health, speed);
        this.mana = mana;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
//        int minHealth = 100;
//        int minIndex = 0;
//        for (int i = 0; i < heroList.size(); i++) {
//            String[] params = heroList.get(i).getInfo().split(" ");
//            if (Integer.parseInt(params[1]) < 100) {
//                int temp = Integer.parseInt(params[1]);
//                if (temp < minHealth) {
//                    minHealth = temp;
//                    minIndex = i;
//                }
//            }
//        }
//        heroList.get(minIndex).health -= damage[0];
//        System.out.println();
//        System.out.println("Вылечен:\n" + heroList.get(minIndex));
        int max = 100;
        int maxi = 0;
        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i).health == 0) {
                continue;
            }
            int currentHealth = heroList.get(i).getHealth();
            if (currentHealth < 100) {
                if (currentHealth < max) {
                    max = currentHealth;
                    maxi = i;
                }
            }
        }
        heroList.get(maxi).health -= damage[0];
        System.out.println();
        System.out.println("Вылечен:\n" + heroList.get(maxi));
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana";
    }

}
