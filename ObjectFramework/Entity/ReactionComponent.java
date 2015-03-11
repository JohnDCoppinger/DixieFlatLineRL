package ObjectFramework.Entity;

import java.util.Observer;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public interface ReactionComponent {

    public void reaction(GameEntity triggerer); //should be used to set the state?

    public void defaultAction(GameEntity triggerer);

}
