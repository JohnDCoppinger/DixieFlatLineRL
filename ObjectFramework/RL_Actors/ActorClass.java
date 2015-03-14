package ObjectFramework.RL_Actors;

import ObjectFramework.Entity.ReactionComponent;
import ObjectFramework.RL_Actors.Actions.Action;

/**
 * Created by Gallanoth on 1/29/2015.
 */
public interface ActorClass extends ReactionComponent{

    public Action[] listAbilities();
    public Action selectAbility(int abilityNo);
    public int getActionPool();
}
