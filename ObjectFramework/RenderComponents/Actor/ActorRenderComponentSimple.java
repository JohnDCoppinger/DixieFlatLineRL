package ObjectFramework.RenderComponents.Actor;
import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 * Created by durandal on 3/15/15.
 */
public class ActorRenderComponentSimple extends RenderComponent{

    public ActorRenderComponentSimple()
    {
        super('@', CSIColor.GREEN, CSIColor.LIGHT_GRAY);
    }
}
