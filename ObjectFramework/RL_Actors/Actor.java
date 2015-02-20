package ObjectFramework.RL_Actors;
import ObjectFramework.General.GameEntity;
/**
 * Created by Gallanoth on 1/29/2015.
 */
public abstract class Actor extends GameEntity {

    char renderChar;
    Inventory inventory;
    ActorClass aClass;


    public Actor(){}

    public void setRenderChar(char renderChar) {

        this.renderChar = renderChar;
    }

    public abstract void render();
    public String name;
}
