package ObjectFramework.RL_Actors;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class PlayerActionManager implements ActionManager{

    private Actor client;

    private PlayerActionManager() {}

    public PlayerActionManager(Actor client) {
        this.client = client;
    }

    public void performActions() {

    }

    public int getInitiative() {
        return client.getInitiative();
    }
    
    public int compareTo(ActionManager manager) {
        return client.getInitiative() - manager.getInitiative();
    }
}
