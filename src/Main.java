import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> heroesOne = new ArrayList<>();
        ArrayList<BaseHero> heroesTwo = new ArrayList<>();
        Random random = new Random();
        generateHeroes(heroesOne, 10, random, 1);
        generateHeroes(heroesTwo, 10, random, 2);
        heroesOne.forEach(n -> System.out.print(n.getInfo() + ","));
        System.out.println("");
        heroesOne.forEach(n -> n.step(heroesOne));
    }

    public static void generateHeroes(ArrayList<BaseHero> heroesList, int quantity, Random rand, int mode) {
        String[] namesList = {"Хельм", "Галт", "Петро", "Ривон", "Манфред", "Дарлигал", "Роигром", "Бакоум", "Кратарк",
                "Гортааг", "Лаэлрас", "Корнитис", "Филсугил", "Волнагорн", "Илратар", "Гамальхид", "Радагаст",
                "Ксальтотун", "Саурон", "Альбус", "Бингабер", "Финвос", "Масливис", "Матокин", "Тикласвист", "Вилбетус",
                "Рартелин", "Деналок", "Тейродон", "Дарелат", "Альэльтан", "Ксианфан", "Лонгджин", "Фангфей", "Гухэй",
                "Ксандентос", "Грюлеструм", "Гендемор", "Авинхан", "Ашеин", "Фероэл", "Иэлдрис", "Гарденхилл",
                "Аклогорн", "Хепиас", "Тайэлрус", "Воулен", "Борзораш", "Галмортук", "Гортагар", "Верестий", "Биверсул",
                "Себдакс", "Аклифон", "Фредданус", "Мизатар", "Мизас", "Темнаган"};
        int namesSize = namesList.length;
        for (int i = 0; i < quantity; i++) {
            int type = rand.nextInt(4);
            if (mode == 1) {
                switch (type) {
                    case 0 -> heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroesList.add(new Rogue(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroesList.add(new Sniper(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroesList.add(new Mage(namesList[rand.nextInt(namesSize)]));
                }
            } else {
                switch (type) {
                    case 0 -> heroesList.add(new Farmer(namesList[rand.nextInt(namesSize)]));
                    case 1 -> heroesList.add(new Crossbowman(namesList[rand.nextInt(namesSize)]));
                    case 2 -> heroesList.add(new Spearman(namesList[rand.nextInt(namesSize)]));
                    case 3 -> heroesList.add(new Monk(namesList[rand.nextInt(namesSize)]));
                }
            }
        }
    }
}
