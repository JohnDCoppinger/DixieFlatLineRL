package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class UpStairsRenderComponent extends RenderComponent
{
    public UpStairsRenderComponent()
    {
        super('>', CSIColor.WHITE, CSIColor.BLACK);
    }
}
