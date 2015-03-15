package ObjectFramework.RL_Actors.Player;

import ObjectFramework.RL_Actors.Actions.Action;
import ObjectFramework.RL_Actors.Actor;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public interface PlayerState {

    public Action getAction(Actor client);
}
