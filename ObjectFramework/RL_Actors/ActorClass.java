package ObjectFramework.RL_Actors;

import ObjectFramework.Entity.ReactionComponent;
import ObjectFramework.RL_Actors.Behaviors.*;
/**
 * Created by Gallanoth on 1/29/2015.
 */
public interface ActorClass extends ReactionComponent{

    public Ability[] listAbilities();
    public Ability selectAbility(int abilityNo);
}
