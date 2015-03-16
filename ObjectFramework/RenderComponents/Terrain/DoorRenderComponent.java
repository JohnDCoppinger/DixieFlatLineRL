package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class DoorRenderComponent extends RenderComponent
{
    public DoorRenderComponent()
    {
        super('D', CSIColor.ALICE_BLUE,CSIColor.GRAY);
    }
}
