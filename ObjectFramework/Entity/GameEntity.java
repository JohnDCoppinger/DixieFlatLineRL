package ObjectFramework.Entity;

/**
 * Created by Gallanoth on 1/29/2015.
 */
public class GameEntity {

    private int entityId;
    private GameEntity beneath;
    private boolean clippable;
    private int x;
    private int y;
    private int level;

    private InventoryComponent inventory;
    private CombatComponent combat;
    private ReactionComponent reaction;
    private RenderComponent render;

    private static int nextId = 1;

    public GameEntity() {
        this.entityId = this.assignId();
    }

    public GameEntity(boolean clippable)

    private static int assignId() {
        return nextId++;
    }

    public GameEntity getBeneath() {
        return this.beneath;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public InventoryComponent getInventory() {
        return inventory;
    }

    public ReactionComponent getReaction() {
        return reaction;
    }

    public RenderComponent getRender() {
        return render;
    }

    public void setBeneath(GameEntity beneath) {
        this.beneath = beneath;
    }

    public void setRender(RenderComponent render) {
        this.render = render;
    }

    public void setReaction(ReactionComponent reaction) {
        this.reaction = reaction;
    }

    public void setInventory(InventoryComponent inventory) {
        this.inventory = inventory;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CombatComponent getCombat() {
        return combat;
    }

    public void setCombat(CombatComponent combat) {
        this.combat = combat;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean clippable() {
        return this.clippable;
    }

    public void setClippable(boolean clippable) {
        this.clippable = clippable;
    }

}
