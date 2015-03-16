package ObjectFramework.RL_Terrain;

import ObjectFramework.General.Entity.GameEntity;
import ObjectFramework.General.Entity.ReactionComponent;
import ObjectFramework.RL_Actors.Actions.Action;
import ObjectFramework.RL_Actors.Actions.ChangeMapAction;

/**
 * Created by Gallanoth on 3/16/2015.
 */
public class DownStairsReactionComponent implements ReactionComponent{

    private Action reaction;

    public DownStairsReactionComponent() {
        this.reaction = new ChangeMapAction("down");
    }

    public void defaultAction(GameEntity entity) {
        this.reaction.perform(entity);
    }

    public void react(GameEntity entity) {

    }
}
