package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 * Created by bcoll_000 on 3/12/2015.
 */
public class UpStairsRenderComponent extends RenderComponent
{
    public UpStairsRenderComponent()
    {
        super('>', ConsoleSystemInterface.WHITE, ConsoleSystemInterface.BLACK);
    }
}
