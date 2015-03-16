package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class DirtRenderComponent extends RenderComponent
{
    public DirtRenderComponent()
    {
        super('.', CSIColor.BROWN, CSIColor.BLACK);
    }
}
