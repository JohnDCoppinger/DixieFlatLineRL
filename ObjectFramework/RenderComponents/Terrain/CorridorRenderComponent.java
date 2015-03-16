package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 * Created by bcoll_000 on 3/12/2015.
 */
public class CorridorRenderComponent extends RenderComponent
{
    public CorridorRenderComponent()
    {
        super('=', ConsoleSystemInterface.BROWN, ConsoleSystemInterface.BLACK);
    }
}
