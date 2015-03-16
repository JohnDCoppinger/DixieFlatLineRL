package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class VertWallRenderComponent extends RenderComponent
{
    public VertWallRenderComponent()
    {
        super('|', ConsoleSystemInterface.BLACK, ConsoleSystemInterface.BROWN);
    }
}
