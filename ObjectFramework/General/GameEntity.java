package ObjectFramework.General;

/**
 * Created by Gallanoth on 1/29/2015.
 */
public abstract class GameEntity implements Renderable {

    private int entityId;
    private boolean pathable;
    private Renderable top;

    private static int nextId = 1;

    public GameEntity() {

        this.entityId = this.assignId();
    }

    public boolean isPathable() {
        return pathable;
    }

    protected void setPathable() {

        this.pathable = true;
    }

    protected void setNonpathable() {

        this.pathable = false;
    }

    protected void setTop(Renderable newTop) {

        this.top = newTop;
    }

    protected void removeTop() {
        this.top = null;
    }

    public Renderable returnTop() {

        return this.top;
    }

    private static int assignId() {

        return nextId++;
    }
}
