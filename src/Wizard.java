public class Wizard extends BaseHero{
    int mana;
    public Wizard(String name, int attack, int defence, int[] damage, int health, int speed, int mana) {
        super(name, attack, defence, damage, health, speed);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana";
    }
}
