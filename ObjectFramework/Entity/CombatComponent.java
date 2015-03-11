package ObjectFramework.Entity;

import ObjectFramework.Commands.KillCommand;

/**
 * Created by Gallanoth on 3/4/2015.
 */
public class CombatComponent {

    int baseHP, hp;
    int baseArmor, armor;
    double baseMagicResist, magicResist;

    GameEntity owner;

    private CombatComponent() {}

    public CombatComponent(GameEntity owner, int hp, int armor, int magicResist) {

        this.baseHP = hp;
        this.hp = hp;
        this.baseArmor = armor;
        this.armor = armor;
        this.baseMagicResist = magicResist;
        this.magicResist = magicResist;
        this.owner = owner;
    }

    public void takeDamage(int damage) {

        this.decreaseHP(damage - armor);

        if (this.hp <= 0) {
            KillCommand kill = new KillCommand(owner);
            kill.execute();
        }
    }

    public void takeMagicDamage(int damage) {

        this.decreaseHP((int)(damage * magicResist));
    }

    public void increaseHP(int value) {
        this.hp += value;
    }

    public void decreaseHP(int value) {
        this.hp -= value;
    }

    public void increaseArmor(int value) {
        this.armor += value;
    }

    public void decreaseArmor(int value) {
        this.armor -= value;
    }

    public void increaseMagicResist(double value) {
        this.magicResist += value;
    }

    public void decreaseMagicResist(double value) {
        this.magicResist -= value;
    }

    public int getHP(int value) {
        return this.hp;
    }

    public void setHP(int value) {
        this.hp = value;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getArmor() {
        return this.armor;
    }

    public void setArmor(int value) {
        this.armor = value;
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
}
