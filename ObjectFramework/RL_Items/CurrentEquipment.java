package ObjectFramework.RL_Items;

import ObjectFramework.RL_Items.Interfaces.*;

public class CurrentEquipment {

    private class EmptyItemSlot implements ArmSlot, FootSlot, HandSlot, HeadSlot, LegSlot, TorsoSlot{

        public int getArmorValue() {
            return 0;
        }

        public double getMagicValue() {
            return 0;
        }

        public int getAttackValue() {
            return 0;
        }
    }

    private static EmptyItemSlot empty;

    private HeadSlot head;
    private TorsoSlot torso;
    private ArmSlot arms;
    private HandSlot hands;
    private LegSlot legs;
    private FootSlot feet;

    public CurrentEquipment() {

        if (empty == null)
            empty = new EmptyItemSlot();

        this.head = empty;
        this.torso = empty;
        this.arms = empty;
        this.hands = empty;
        this.legs = empty;
        this.feet = empty;
    }

    public int armorBonus() {
        return head.getArmorValue() + torso.getArmorValue() + arms.getArmorValue() + hands.getArmorValue() + legs.getArmorValue() + feet.getArmorValue();
    }

    public double magicBonus() {
        return head.getMagicValue()+ torso.getMagicValue() + arms.getMagicValue() + hands.getMagicValue() + legs.getMagicValue() + feet.getMagicValue();
    }

    public int attackBonus() {
        return head.getAttackValue() + torso.getAttackValue() + arms.getAttackValue() + hands.getAttackValue() + legs.getAttackValue() + feet.getAttackValue();
    }

    public void equip(HeadSlot head) {
        this.head = head;
    }

    public void equip(TorsoSlot torso) {
        this.torso = torso;
    }

    public void equip(ArmSlot arms) {
        this.arms = arms;
    }

    public void equip(HandSlot hands) {
        this.hands = hands;
    }

    public void equip(LegSlot legs) {
        this.legs = legs;
    }

    public void equip(FootSlot feet) {
        this.feet = feet;
    }

    public void equip(Item item) {
        //Catch for trying to equip unequippable items
    }

    public void unequip(HeadSlot head) {
        this.head = empty;
    }

    public void unequip(TorsoSlot torso) {
        this.torso = empty;
    }

    public void unequip(ArmSlot arms) {
        this.arms = empty;
    }

    public void unequip(HandSlot hands) {
        this.hands = empty;
    }

    public void unequip(LegSlot legs) {
        this.legs = empty;
    }

    public void unequip(FootSlot feet) {
        this.feet = empty;
    }

    public LegSlot getLegs() {
        return legs;
    }

    public FootSlot getFeet() {
        return feet;
    }

    public HandSlot getHands() {
        return hands;
    }

    public ArmSlot getArms() {
        return arms;
    }

    public TorsoSlot getTorso() {
        return torso;
    }

    public HeadSlot getHead() {
        return head;
    }
}
