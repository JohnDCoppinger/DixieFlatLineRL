package ObjectFramework.RL_Terrain;

import ObjectFramework.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 * Created by bcoll_000 on 3/12/2015.
 */
public class TownWallRenderComponent  extends RenderComponent
{
    public TownWallRenderComponent()
    {
        super('#', ConsoleSystemInterface.BLACK, ConsoleSystemInterface.RED);
    }
}
