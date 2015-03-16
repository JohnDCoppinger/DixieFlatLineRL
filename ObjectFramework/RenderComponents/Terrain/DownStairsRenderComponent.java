package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class DownStairsRenderComponent extends RenderComponent
{
    public DownStairsRenderComponent()
    {
        super('<', CSIColor.WHITE, CSIColor.BLACK);
    }
}
