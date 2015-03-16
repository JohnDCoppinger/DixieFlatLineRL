package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class CorridorRenderComponent extends RenderComponent
{
    public CorridorRenderComponent()
    {
        super('=', ConsoleSystemInterface.BROWN, ConsoleSystemInterface.BLACK);
    }
}
