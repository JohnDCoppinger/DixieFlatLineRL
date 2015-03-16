package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class TownWallRenderComponent  extends RenderComponent
{
    public TownWallRenderComponent()
    {
        super('#', CSIColor.RED_VIOLET, CSIColor.BLACK);
    }
}
