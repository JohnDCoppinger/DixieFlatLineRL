package ObjectFramework.RL_Actors;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.Menu.InventoryMenu;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.General.Menu.MenuItem;
import ObjectFramework.RL_Actors.Actions.Action;
import ObjectFramework.RL_Actors.Actions.BasicAttackAction;

public class SimpleActorClass implements ActorClass {

    private static int basePower = 15;

    private Action currentDefault;
    private Action currentReaction;

    public SimpleActorClass() {

        this.currentDefault = new BasicAttackAction(basePower);
        this.currentReaction = new BasicAttackAction(basePower);
    }

    public void defaultAction(GameEntity entity) {

        if (entity.getCombat() != null)
            currentDefault.perform(entity);
    }

    public void react(GameEntity entity) {

        if (entity.getCombat() != null)
            currentReaction.perform(entity);
    }

    public Menu listAbilities() {

        //TODO create ability menu
        InventoryMenu menu = new InventoryMenu("Ability List");

        menu.addMenuItem(new MenuItem("Basic Attack", 1));

        return menu;
    }

    public Action selectAbility(int abilityNo) {

        return this.currentReaction;
    }

    public void setDefault(Action newDefault) {

        this.currentDefault = newDefault;
    }

    public void setReaction(Action newReaction) {
        this.currentReaction = newReaction;
    }

    public int getActionPool() {

        return 1;
    }
}
