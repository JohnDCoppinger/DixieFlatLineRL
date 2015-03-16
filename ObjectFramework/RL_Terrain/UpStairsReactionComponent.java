package ObjectFramework.RL_Terrain;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.Entity.ReactionComponent;
import ObjectFramework.RL_Actors.Actions.Action;
import ObjectFramework.RL_Actors.Actions.ChangeMapAction;

/**
 * Created by Gallanoth on 3/16/2015.
 */
public class UpStairsReactionComponent implements ReactionComponent{

    private Action reaction;

    public UpStairsReactionComponent() {
        this.reaction = new ChangeMapAction("up");
    }


    public void defaultAction(GameEntity entity) {

    }

    public void react(GameEntity entity) {
        reaction.perform(entity);
    }
}
