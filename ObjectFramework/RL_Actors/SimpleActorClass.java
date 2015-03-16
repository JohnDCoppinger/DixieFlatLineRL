package ObjectFramework.RL_Actors;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.RL_Actors.Actions.Action;
import ObjectFramework.RL_Actors.Actions.BasicAttackAction;

/**
 * Created by Gallanoth on 3/14/2015.
 */
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

        return null;
    }

    public Action selectAbility(int abilityNo) {
        return null;
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
