package ObjectFramework.RL_Actors.Player;

import ObjectFramework.Commands.Command;
import ObjectFramework.RL_Actors.Actor;

/**
 * Created by Gallanoth on 3/14/2015.
 */
public interface PlayerState {

    public Command getAction(Actor client);
}
