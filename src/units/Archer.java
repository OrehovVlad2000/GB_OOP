package units;

import java.util.ArrayList;

public class Archer extends BaseHero {
    int shoots;
    public Archer(String name, String role, int attack, int defence, int[] damage, int health, int speed, int shoots) {
        super(name, role, attack, defence, damage, health, speed);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        return super.toString() + ", Shoots: " + shoots;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        for (int i = 0; i < heroList.size(); i++) {
            if(heroList.get(i).getRole().equals("Farmer")) {
                if(((Farmer) heroList.get(i)).supply){
                    ((Farmer) heroList.get(i)).supply = false;
                    System.out.println("\nБоец: " + this.getRole() + " по имени: " + name + " делает один выстрел");
                    System.out.println("Оставшееся кол-во выстрелов: " + shoots);
                    return;
                }else {
                    continue;
                }
            }
        }
        shoots --;
        System.out.println("\nБоец: " + this.getRole() + " по имени: " + name + " делает один выстрел");
        System.out.println("Оставшееся кол-во выстрелов: " + shoots);
    }
}
