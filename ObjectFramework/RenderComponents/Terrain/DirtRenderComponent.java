package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 * Created by bcoll_000 on 3/12/2015.
 */
public class DirtRenderComponent extends RenderComponent
{
    public DirtRenderComponent()
    {
        super('.', ConsoleSystemInterface.BLACK, ConsoleSystemInterface.BROWN);
    }
}
