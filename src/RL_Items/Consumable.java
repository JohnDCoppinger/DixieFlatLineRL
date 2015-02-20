package RL_Items;

import RL_Items.Item;

/**
 * Created by Gallanoth on 1/29/2015.
 */

//Should this be an interface??

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
