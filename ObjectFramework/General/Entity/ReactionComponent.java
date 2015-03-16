package ObjectFramework.General.Entity;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public interface ReactionComponent {

    public void react(GameEntity triggerer); //should be used to set the state?

    public void defaultAction(GameEntity triggerer);

}
