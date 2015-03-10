package ObjectFramework.Entity;

/**
 * Created by Gallanoth on 3/4/2015.
 */
public class CombatComponent {

    int hp;
    int armor;

    public CombatComponent() {}

    public void setHP(int value) {

        this.hp = value;
    }

    public void increaseHP(int value) {

        this.hp += value;
    }

    public void decreaseHP(int value) {

        this.hp -= (value - armor);
    }

    public void setArmor(int value) {

        this.armor = value;
    }

    public void increaseArmor(int value) {

        this.armor += value;
    }

    public void decreaseArmor(int value) {

        this.armor -= value;
    }

    private void applyStatus() {

        //use this to apply recurrent status effects
    }
}
