package ObjectFramework.Entity;

/**
 * Created by Gallanoth on 3/4/2015.
 */
public class CombatManager {

    private class Statistics {

        public int hp;
        public int armor;

        public Statistics() {}

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }
    }

    private Statistics stats;

    public CombatManager() {}
}
