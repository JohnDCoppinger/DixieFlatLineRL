package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 * Created by bcoll_000 on 3/12/2015.
 */
public class VertWallRenderComponent extends RenderComponent
{
    public VertWallRenderComponent()
    {
        super('|', ConsoleSystemInterface.BLACK, ConsoleSystemInterface.BROWN);
    }
}
