package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class WallRenderComponent extends RenderComponent
{
    public WallRenderComponent()
    {
        super('-', ConsoleSystemInterface.BLACK,ConsoleSystemInterface.BROWN);
    }
}
