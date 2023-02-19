package units;

import java.util.ArrayList;
import java.util.Random;

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
                System.out.printf("\nПерсонаж %s %s воскресил персонажа %s %s В виде: ", name, role, gang.get(i).name,
                        gang.get(i).role);
                resurrect(i);
                return;
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

    private void resurrect(int index) {
        String[] namesList = {"Хельм", "Галт", "Петро", "Ривон", "Манфред", "Дарлигал", "Роигром", "Бакоум", "Кратарк",
                "Гортааг", "Лаэлрас", "Корнитис", "Филсугил", "Волнагорн", "Илратар", "Гамальхид", "Радагаст",
                "Ксальтотун", "Саурон", "Альбус", "Бингабер", "Финвос", "Масливис", "Матокин", "Тикласвист", "Вилбетус",
                "Рартелин", "Деналок", "Тейродон", "Дарелат", "Альэльтан", "Ксианфан", "Лонгджин", "Фангфей", "Гухэй",
                "Ксандентос", "Грюлеструм", "Гендемор", "Авинхан", "Ашеин", "Фероэл", "Иэлдрис", "Гарденхилл",
                "Аклогорн", "Хепиас", "Тайэлрус", "Воулен", "Борзораш", "Галмортук", "Гортагар", "Верестий", "Биверсул",
                "Себдакс", "Аклифон", "Фредданус", "Мизатар", "Мизас", "Темнаган"};
        int namesSize = namesList.length;
        int posX = (int) gang.get(index).getPosition().x;
        int posY = (int) gang.get(index).getPosition().y;
        String heroTeam = gang.get(index).getTeam();
        Random random = new Random();
        if (heroTeam.equals("white")) {
            switch (random.nextInt(4)) {
                case 0 ->
                        gang.set(index, new Farmer(gang, namesList[random.nextInt(namesSize)], posX, posY, "white"));
                case 1 ->
                        gang.set(index, new Rogue(gang, namesList[random.nextInt(namesSize)], posX, posY, "white"));
                case 2 ->
                        gang.set(index, new Sniper(gang, namesList[random.nextInt(namesSize)], posX, posY, "white"));
                case 3 ->
                        gang.set(index, new Mage(gang, namesList[random.nextInt(namesSize)], posX, posY, "white"));
            }
        } else {
            switch (random.nextInt(4)) {
                case 0 ->
                        gang.set(index, new Crossbowman(gang, namesList[random.nextInt(namesSize)], posX, posY, "dark"));
                case 1 ->
                        gang.set(index, new Monk(gang, namesList[random.nextInt(namesSize)], posX, posY, "dark"));
                case 2 ->
                        gang.set(index, new Spearman(gang, namesList[random.nextInt(namesSize)], posX, posY, "dark"));
                case 3 ->
                        gang.set(index, new Farmer(gang, namesList[random.nextInt(namesSize)], posX, posY, "dark"));
            }
        }
        System.out.printf("%s %s\n", gang.get(index).name, gang.get(index).role);
    }

}
