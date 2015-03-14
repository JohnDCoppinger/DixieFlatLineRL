package ObjectFramework.RL_Actors;

import ObjectFramework.General.MapView;

import java.util.Observable;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class PlayerActionManager extends Observable implements ActionManager{

    private Actor client;
    private MapView view;
    private PlayerState playerState;

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

    public void register(MapView view) {
        this.view = view;
    }
}
