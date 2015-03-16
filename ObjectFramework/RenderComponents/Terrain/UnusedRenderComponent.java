package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class UnusedRenderComponent extends RenderComponent
{
    public UnusedRenderComponent()
    {
        super(' ', CSIColor.BLACK, CSIColor.BLACK);
    }
}
