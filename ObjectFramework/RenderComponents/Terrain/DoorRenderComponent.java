package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class DoorRenderComponent extends RenderComponent
{
    public DoorRenderComponent()
    {
        super('D',ConsoleSystemInterface.BROWN,ConsoleSystemInterface.GRAY);
    }
}
