package ObjectFramework.RL_Actors;

import ObjectFramework.General.Entity.ReactionComponent;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.RL_Actors.Actions.Action;

public interface ActorClass extends ReactionComponent{

    public Menu listAbilities();
    public Action selectAbility(int abilityNo);
    public void setDefault(Action newDefault);
    public void setReaction(Action newReaction);
    public int getActionPool();
}
