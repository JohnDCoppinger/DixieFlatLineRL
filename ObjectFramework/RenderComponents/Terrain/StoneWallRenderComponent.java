package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 * Created by bcoll_000 on 3/12/2015.
 */
public class StoneWallRenderComponent  extends RenderComponent
{
    public StoneWallRenderComponent()
    {
        super('O', ConsoleSystemInterface.BLACK, ConsoleSystemInterface.GRAY);
    }
}
