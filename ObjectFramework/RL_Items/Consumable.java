package ObjectFramework.RL_Items;

public abstract class Consumable extends Item {

    protected int charges;

    private Consumable () {}

    public Consumable(int charges) {

        this.charges = charges;
    }

    public int consume() {

        return --charges;
    }
}
