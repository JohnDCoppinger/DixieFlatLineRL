package ObjectFramework.General.Entity;

/**
 * Created by Gallanoth on 3/4/2015.
 */
public interface CombatComponent {

    public void takeDamage(int damage);
    public void takeMagicDamage(int damage);
    public void heal(int heal);
    public void reduceArmor(int reduction);
    public void increaseArmor(int increase);
    public void reduceMagicResist(double reduction);
    public void increaseMagicResist(double increase);
}
