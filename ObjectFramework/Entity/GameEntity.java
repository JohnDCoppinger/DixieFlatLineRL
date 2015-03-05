package ObjectFramework.Entity;

/**
 * Created by Gallanoth on 1/29/2015.
 */
public class GameEntity {

    private int entityId;
    private GameEntity beneath;
    private int x;
    private int y;
    private int level;

    private InventoryManager inventory;
    private CombatManager combat;
    private ReactionManager reaction;
    private RenderManager render;

    private static int nextId = 1;

    public GameEntity() {

        this.entityId = this.assignId();
    }

    public GameEntity getBeneath() {

        return this.beneath;
    }

    public int getEntityId() {

        return this.entityId;
    }

    private static int assignId() {

        return nextId++;
    }

    public InventoryManager getInventory() {
        return inventory;
    }

    public ReactionManager getReaction() {
        return reaction;
    }

    public RenderManager getRender() {
        return render;
    }

    public void setBeneath(GameEntity beneath) {

        this.beneath = beneath;
    }

    public void setRender(RenderManager render) {
        this.render = render;
    }

    public void setReaction(ReactionManager reaction) {
        this.reaction = reaction;
    }

    public void setInventory(InventoryManager inventory) {
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

    public CombatManager getCombat() {
        return combat;
    }

    public void setCombat(CombatManager combat) {
        this.combat = combat;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
