package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class CorridorRenderComponent extends RenderComponent
{
    public CorridorRenderComponent()
    {
        super('=', CSIColor.BROWN, CSIColor.BLACK);
    }
}
