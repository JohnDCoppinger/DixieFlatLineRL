package ObjectFramework.RL_Actors.Player;

import ObjectFramework.General.MapView;
import ObjectFramework.General.Menu.Menu;
import ObjectFramework.RL_Actors.ActionManager;
import ObjectFramework.RL_Actors.Actor;

import java.util.Observable;

public class PlayerActionManager extends Observable implements ActionManager {

    private Actor client;
    private MapView view;
    private PlayerState currentState;
    private PlayerState menuState;
    private PlayerState setupState;
    private PlayerState combatState;
    private Menu currentMenu;
    private int currentPool;

    private PlayerActionManager() {}

    public PlayerActionManager(Actor client) {
        this.client = client;
        this.menuState = new MenuState();
        this.setupState = new SetupState();
        this.combatState = new CombatState();
        this.currentState = this.combatState;
    }

    public void performActions() {

        int currentPool = client.getActorClass().getActionPool();

        while (currentPool > 0) {

            currentState.getAction(client).execute();
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
        this.currentState = menuState;
    }

    public void setCombatState() {
        this.currentState = combatState;
    }

    public void setSetupState() {
        this.currentState = setupState;
    }

    public void setCurrentMenu(Menu menu) {
        this.currentMenu = menu;
    }

    public Menu getCurrentMenu() {
        return this.currentMenu;
    }

    public void removeFromPool(int toRemove) {
        this.currentPool -= toRemove;
    }

    public int getCurrentPool() {
        return this.currentPool;
    }

    public Actor getClient() {
        return this.client;
    }
}
