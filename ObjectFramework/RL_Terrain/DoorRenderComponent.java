package ObjectFramework.RL_Terrain;

import ObjectFramework.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 * Created by bcoll_000 on 3/12/2015.
 */
public class DoorRenderComponent extends RenderComponent
{
    public DoorRenderComponent()
    {
        super('D',ConsoleSystemInterface.BROWN,ConsoleSystemInterface.GRAY);
    }
}
