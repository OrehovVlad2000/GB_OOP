import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> farmer = new ArrayList<>();
        String[] farmerNames = {"Хельм", "Галт", "Петро", "Ривон", "Манфред"};
        for(String name: farmerNames){
            farmer.add(new Farmer(name));
        }
        for(BaseHero character: farmer){
            System.out.println(character);
        }
        System.out.println("=============================");

        ArrayList<BaseHero> rogue = new ArrayList<>();
        String[] rogueNames = {"Дарлигал", "Роигром", "Бакоум", "Кратарк", "Гортааг"};
        for(String name: rogueNames){
            rogue.add(new Rogue(name));
        }
        for(BaseHero character: rogue){
            System.out.println(character);
        }
        System.out.println("=============================");

        ArrayList<BaseHero> sniper = new ArrayList<>();
        String[] sniperNames = {"Лаэлрас", "Корнитис", "Филсугил", "Волнагорн", "Илратар"};
        for(String name: sniperNames){
            sniper.add(new Sniper(name));
        }
        for(BaseHero character: sniper){
            System.out.println(character);
        }
        System.out.println("=============================");

        ArrayList<BaseHero> mage = new ArrayList<>();
        String[] mageNames = {"Гамальхид", "Радагаст", "Ксальтотун", "Саурон", "Альбус"};
        for(String name: mageNames){
            mage.add(new Mage(name));
        }
        for(BaseHero character: mage){
            System.out.println(character);
        }
        System.out.println("=============================");

        ArrayList<BaseHero> spearman = new ArrayList<>();
        String[] spearmanNames = {"Бингабер", "Финвос", "Масливис", "Матокин", "Тикласвист"};
        for(String name: spearmanNames){
            spearman.add(new Spearman(name));
        }
        for(BaseHero character: spearman){
            System.out.println(character);
        }
        System.out.println("=============================");

        ArrayList<BaseHero> crossbowman = new ArrayList<>();
        String[] crossbowmanNames = {"Вилбетус", "Рартелин", "Деналок", "Тейродон", "Дарелат"};
        for(String name: crossbowmanNames){
            crossbowman.add(new Crossbowman(name));
        }
        for(BaseHero character: crossbowman){
            System.out.println(character);
        }
        System.out.println("=============================");

        ArrayList<BaseHero> monk = new ArrayList<>();
        String[] monkNames = {"Альэльтан", "Ксианфан", "Лонгджин", "Фангфей", "Гухэй"};
        for(String name: monkNames){
            monk.add(new Monk(name));
        }
        for(BaseHero character: monk){
            System.out.println(character);
        }
        System.out.println("=============================");
    }
}
