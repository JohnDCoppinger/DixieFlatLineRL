package ObjectFramework.RL_Actors.Player;

import ObjectFramework.General.MapView;
import ObjectFramework.RL_Actors.ActionManager;
import ObjectFramework.RL_Actors.Actor;

import java.util.Observable;

/**
 * Created by Gallanoth on 3/9/2015.
 */
public class PlayerActionManager extends Observable implements ActionManager {

    private Actor client;
    private MapView view;
    private PlayerState currentState;
    private PlayerState menu;
    private PlayerState setup;
    private PlayerState combat;

    private PlayerActionManager() {}

    public PlayerActionManager(Actor client) {
        this.client = client;
    }

    public void performActions() {

        int currentPool = client.getActorClass().getActionPool();

        while (currentPool > 0) {


        }
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

    public void setMenuState() {
        this.currentState = menu;
    }

    public void setCombatState() {
        this.currentState = combat;
    }

    public void setSetupState() {
        this.currentState = setup;
    }
}
