package ObjectFramework.RL_Actors;

import ObjectFramework.Commands.KillCommand;
import ObjectFramework.Entity.CombatComponent;
import ObjectFramework.Entity.GameEntity;

/**
 * Created by Gallanoth on 3/13/2015.
 */
public class SimpleActorCombat implements CombatComponent {

    private int baseHP, currentHP;
    private int baseArmor, currentArmor;
    private double baseMagicResist, magicResist;

    private GameEntity owner;

    private SimpleActorCombat() {}

    public SimpleActorCombat(GameEntity owner, int currentHP, int currentArmor, int magicResist) {

        this.baseHP = currentHP;
        this.currentHP = currentHP;
        this.baseArmor = currentArmor;
        this.currentArmor = currentArmor;
        this.baseMagicResist = magicResist;
        this.magicResist = magicResist;
        this.owner = owner;
    }

    public void takeDamage(int damage) {

        this.decreaseHP(damage - currentArmor);

        if (this.currentHP <= 0) {
            KillCommand kill = new KillCommand(owner);
            kill.execute();
        }
    }

    public void takeMagicDamage(int damage) {
        this.decreaseHP((int)(damage * magicResist));
    }

    public void increaseHP(int value) {
        this.currentHP += value;
    }

    public void decreaseHP(int value) {
        this.currentHP -= value;
    }

    public void increaseArmor(int value) {
        this.currentArmor += value;
    }

    public void decreaseArmor(int value) {
        this.currentArmor -= value;
    }

    public void increaseMagicResist(double value) {
        this.magicResist += value;
    }

    public void decreaseMagicResist(double value) {
        this.magicResist -= value;
    }

    public int getHP(int value) {
        return this.currentHP;
    }

    public void setHP(int value) {
        this.currentHP = value;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getCurrentArmor() {
        return this.currentArmor;
    }

    public void setCurrentArmor(int value) {
        this.currentArmor = value;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }

    public double getMagicResist() {
        return magicResist;
    }

    public void setMagicResist(double magicResist) {
        this.magicResist = magicResist;
    }

    public double getBaseMagicResist() {
        return baseMagicResist;
    }

    public void setBaseMagicResist(double baseMagicResist) {
        this.baseMagicResist = baseMagicResist;
    }

    private void applyStatus() {

        //use this to apply recurrent status effects
    }

    public void heal(int heal) {}
    public void reduceArmor(int reduction) {}
    public void reduceMagicResist(double reduction) {}
}
