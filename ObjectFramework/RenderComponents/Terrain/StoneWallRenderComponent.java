package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class StoneWallRenderComponent  extends RenderComponent
{
    public StoneWallRenderComponent()
    {
        super('O', CSIColor.GRAY, CSIColor.BLACK);
    }
}
