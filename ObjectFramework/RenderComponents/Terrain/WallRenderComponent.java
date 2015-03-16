package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class WallRenderComponent extends RenderComponent
{
    public WallRenderComponent()
    {
        super('-', CSIColor.BROWN, CSIColor.BLACK);
    }
}
