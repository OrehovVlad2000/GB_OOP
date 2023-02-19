import units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;

    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);
        while (true){
            ArrayList<BaseHero> units = new ArrayList<>();
            units.addAll(whiteSide);
            units.addAll(darkSide);
            Comparator<BaseHero> comparator = Comparator.comparing(BaseHero::getSpeed);
            units.sort(comparator);
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();

            units.forEach(n -> n.step(units));
            scanner.nextLine();
        }
    }

    private static void init(){
        String[] namesList = {"Хельм", "Галт", "Петро", "Ривон", "Манфред", "Дарлигал", "Роигром", "Бакоум", "Кратарк",
                "Гортааг", "Лаэлрас", "Корнитис", "Филсугил", "Волнагорн", "Илратар", "Гамальхид", "Радагаст",
                "Ксальтотун", "Саурон", "Альбус", "Бингабер", "Финвос", "Масливис", "Матокин", "Тикласвист", "Вилбетус",
                "Рартелин", "Деналок", "Тейродон", "Дарелат", "Альэльтан", "Ксианфан", "Лонгджин", "Фангфей", "Гухэй",
                "Ксандентос", "Грюлеструм", "Гендемор", "Авинхан", "Ашеин", "Фероэл", "Иэлдрис", "Гарденхилл",
                "Аклогорн", "Хепиас", "Тайэлрус", "Воулен", "Борзораш", "Галмортук", "Гортагар", "Верестий", "Биверсул",
                "Себдакс", "Аклифон", "Фредданус", "Мизатар", "Мизас", "Темнаган"};
        int namesSize = namesList.length;

        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();
        ArrayList<BaseHero> whiteFarmer = new ArrayList<>();
        ArrayList<BaseHero> darkFarmer = new ArrayList<>();

        Random random = new Random();
        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (random.nextInt(4)) {
                case 0 -> whiteFarmer.add(new Farmer(whiteSide, namesList[random.nextInt(namesSize)], x, y++, "white"));
                case 1 -> whiteSide.add(new Rogue(whiteSide, namesList[random.nextInt(namesSize)], x, y++, "white"));
                case 2 -> whiteSide.add(new Mage(whiteSide, namesList[random.nextInt(namesSize)], x, y++, "white"));
                case 3 -> whiteSide.add(new Sniper(whiteSide, namesList[random.nextInt(namesSize)], x, y++, "white"));
            }
        }
        whiteSide.addAll(whiteFarmer);

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {

            switch (random.nextInt(4)) {
                case 0 -> darkFarmer.add(new Farmer(darkSide, namesList[random.nextInt(namesSize)], x, y++, "dark"));
                case 1 -> darkSide.add(new Spearman(darkSide, namesList[random.nextInt(namesSize)], x, y++, "dark"));
                case 2 -> darkSide.add(new Monk(darkSide, namesList[random.nextInt(namesSize)], x, y++, "dark"));
                case 3 -> darkSide.add(new Crossbowman(darkSide, namesList[random.nextInt(namesSize)], x, y++, "dark"));
            }
        }
        darkSide.addAll(darkFarmer);
    }
}






























